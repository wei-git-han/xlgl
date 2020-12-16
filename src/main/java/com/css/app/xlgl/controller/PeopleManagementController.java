package com.css.app.xlgl.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgmapped.entity.BaseAppOrgMapped;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.constant.AppConstant;
import com.css.addbase.constant.AppInterfaceConstant;
import com.css.app.xlgl.dto.QXJPeopleManagementDto;
import com.css.app.xlgl.dto.TxlUserDto;
import com.css.app.xlgl.dto.TxlUserNEWDto;
import com.css.app.xlgl.entity.XlglAdminSet;
import com.css.app.xlgl.service.XlglAdminSetService;
import com.css.base.utils.CrossDomainUtil;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.RestTemplateUtil;
import com.css.base.utils.StringUtils;
import com.github.pagehelper.PageHelper;

/**
 * 
 * 日常管理-人员管理
 * 
 * @author 中软信息系统工程有限公司
 * @email
 * @date 2020-08-03 11:36:19
 * 
 */
@Controller
@RequestMapping("app/xlgl/peopleManagement")
public class PeopleManagementController {
	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private XlglAdminSetService adminSetService;

	@Value("${filePath}")
	private String filePath;
	@Value("${csse.mircoservice.zaiwei}")
	private String urls;

	/**
	 * 
	 * 各单位人员情况统计列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit) {
		Map<String, Object> map = new HashMap<>();
		map.put("parentId", "root");
		PageHelper.startPage(page, limit);
		List<BaseAppOrgan> queryList = baseAppOrganService.queryList(map);
		PageUtils pageUtil = new PageUtils(queryList);

		String userId = CurrentUser.getUserId();
		Map<String, Object> hashmap = new HashMap<>();
		hashmap.put("userId", userId);
		List<XlglAdminSet> queryList2 = adminSetService.queryList(hashmap);
		String status = "";
		// 0:超级管理员 ;1：部管理员；2：局管理员；3：即是部管理员又是局管理员;4:处管理员
		if (queryList2.size() > 0) {
			XlglAdminSet xlglAdminSet = queryList2.get(0);
			if (xlglAdminSet != null) {
				status = xlglAdminSet.getAdminType();
			}
		}
		List<String> list = getUserArray();
		boolean str = false;
		for (BaseAppOrgan baseAppOrgan : queryList) {
			LinkedMultiValueMap<String, Object> linkeMap = new LinkedMultiValueMap<String, Object>();
			if (StringUtils.isNotBlank(status)) {
				List<String> queryListByTREEPATH = baseAppOrganService.queryListByTREEPATH(baseAppOrgan.getId());
				if (status.equals("4") && queryListByTREEPATH.contains(CurrentUser.getSSOUser().getOrganId())) {// 4:处管理员权限
					baseAppOrgan.setStatus("1");
				} else if (status.equals("2")&& queryListByTREEPATH.contains(CurrentUser.getSSOUser().getOrganId())) {// 2：局管理员；
					baseAppOrgan.setStatus("1");
				} else if (status.equals("0") || status.equals("1") || status.equals("3")) {// 0:超级管理员
					str = true; // ;1：部管理员；3：即是部管理员又是局管理员;给予部管理全权限
				} else {
					baseAppOrgan.setStatus("0");
				}

			} else {
				baseAppOrgan.setStatus("0");
			}
			if (str) {
				baseAppOrgan.setStatus("1");
			}
			linkeMap.add("organId", baseAppOrgan.getId());
			JSONObject jsonData = this.getNumber(linkeMap);
			Integer yzwrs = 0;
			Integer qjrs = 0;
			Integer xjrs = 0;
			if (jsonData != null) {
				Object object = jsonData.get("yzwrs");
				Object object2 = jsonData.get("qjrs");
				Object object3 = jsonData.get("xjrs");
				if (object != null) {
					yzwrs = (Integer) object;
				}
				if (object2 != null) {
					qjrs = (Integer) object2;
				}
				if (object3 != null) {
					xjrs = (Integer) object3;
				}
			}

			int userIdList = this.userIdNumber(baseAppOrgan.getId(), list);// 实际在位人数
			if (userIdList == 0 || yzwrs == 0) {
				baseAppOrgan.setZwrate("0");
			} else {
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
				String zwRate = decimalFormat.format(((float) userIdList / yzwrs) * 100);
				// long zwr =((long)userIdList /(long)yzwrs);
				// float zwRate = zwr*100; //人员在位率
				baseAppOrgan.setZwrate(zwRate);
			}
			baseAppOrgan.setYzwrs(yzwrs);
			baseAppOrgan.setQjrs(qjrs);
			baseAppOrgan.setXjrs(xjrs);
			baseAppOrgan.setSjzwrs(userIdList);

		}
		Response.json("page", pageUtil);
	}

	private List<BaseAppOrgan> getBaseAppOrganList(List<BaseAppOrgan> queryList, List<XlglAdminSet> queryList2,
			Boolean status) {
		List<String> list = getUserArray();
		for (BaseAppOrgan baseAppOrgan : queryList) {
			LinkedMultiValueMap<String, Object> linkeMap = new LinkedMultiValueMap<String, Object>();
			linkeMap.add("organId", baseAppOrgan.getId());
			JSONObject jsonData = this.getNumber(linkeMap);
			Integer yzwrs = 0;
			Integer qjrs = 0;
			Integer xjrs = 0;
			if (jsonData != null) {
				Object object = jsonData.get("yzwrs");
				Object object2 = jsonData.get("qjrs");
				Object object3 = jsonData.get("xjrs");
				if (object != null) {
					yzwrs = (Integer) object;
				}
				if (object2 != null) {
					qjrs = (Integer) object2;
				}
				if (object3 != null) {
					xjrs = (Integer) object3;
				}
			}

			int userIdList = this.userIdNumber(baseAppOrgan.getId(), list);// 实际在位人数
			if (userIdList == 0 || yzwrs == 0) {
				baseAppOrgan.setZwrate("0");
			} else {
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
				String zwRate = decimalFormat.format(((float) userIdList / yzwrs) * 100);
				// long zwr =((long)userIdList /(long)yzwrs);
				// float zwRate = zwr*100; //人员在位率
				baseAppOrgan.setZwrate(zwRate);
			}
			baseAppOrgan.setYzwrs(yzwrs);
			baseAppOrgan.setQjrs(qjrs);
			baseAppOrgan.setXjrs(xjrs);
			baseAppOrgan.setSjzwrs(userIdList);

		}
		return queryList;
	}

	/**人员管理新需求
	 * 单位人员统计列表
	 * @param parentId 各局的id
	 * @param organId 查询条件-各处的id
	 * @param userName 人员名称
	 */
	@ResponseBody
	@RequestMapping("/qxjUserInfoList")
	public void qxjUserInfoList(String parentId,String organId,String userName) {
		List<String> userList = getUserArray();
		LinkedMultiValueMap<String, Object> hashmap = new LinkedMultiValueMap<String, Object>();
		HashMap<String,Object> hashMap2 = new HashMap<String, Object>();
		BaseAppOrgMapped orgMapped = (BaseAppOrgMapped)baseAppOrgMappedService.orgMappedByOrgId("","root",AppConstant.APP_QXJGL);
		// 获取清销假app的接口
		String elecPath = orgMapped.getUrl() + AppInterfaceConstant.WEB_INTERFACE_QXJ_USER_INFO_QJDAYS;
		hashMap2.put("parentId", parentId);
		hashMap2.put("organId", organId);
		hashMap2.put("userName", userName);
		List<BaseAppOrgan> organList = baseAppOrganService.findByParentIdAndIsinvalid(hashMap2);
		String[] array =new String[organList.size()];
		for (int i = 0; i < organList.size(); i++) {
			array[i] = organList.get(i).getId();
		}
		List<String> queryByOrgListUserID = baseAppUserService.queryByOrgListUserID(array);
		for (BaseAppOrgan baseAppOrgan : organList) {
			LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
			ArrayList<TxlUserNEWDto> arrayList = new ArrayList<>();
			Integer yzxrs = 0; //应在线人数 需等请销假开发完毕
			Integer userIdList=this.userIdNumber(baseAppOrgan.getId(), userList);// 在线人数
			baseAppOrgan.setZxrs(userIdList);
			baseAppOrgan.setYzwrs(yzxrs);
			map.add("orgid", baseAppOrgan.getId());
			JSONObject txl = getTXL(map);
			String jsonArray = txl.getJSONArray("rows").toString();
			List<TxlUserNEWDto> parseArray = JSONArray.parseArray(jsonArray, TxlUserNEWDto.class);
			for (TxlUserNEWDto txlUserDto : parseArray) {
				hashmap.add("userId", txlUserDto.getUserid());
				JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath, hashmap);
				String string = jsonData.toString();
				QXJPeopleManagementDto parseObject = JSONObject.parseObject(string, QXJPeopleManagementDto.class);
				txlUserDto.setQXJweixiujiaDays(parseObject.getWeixiujiaDays());
				txlUserDto.setQXJtotalDays(parseObject.getTotalDays());
				txlUserDto.setQXJxiuJiaDays(parseObject.getXiuJiaDays());
				if (parseObject.getType() != null) {
					txlUserDto.setQXJtype(parseObject.getType());
					txlUserDto.setQXJstartDate(parseObject.getStartDate());
					txlUserDto.setQXJendDate(parseObject.getEndDate());
				}
				//isShow 1： 在线 ， 2：请假 ，3：出差，4：异常
				if (userList.contains(txlUserDto.getAccount())) {
					txlUserDto.setIsShow("1");
				} else {
					txlUserDto.setIsShow("0");
				}
				if(txlUserDto.getOrganid().equals(baseAppOrgan.getId())) {
					if(queryByOrgListUserID.size()>0) {
						if(!queryByOrgListUserID.contains(txlUserDto.getUserid())) {
							arrayList.add(txlUserDto);
						}
					}else {
						arrayList.add(txlUserDto);
					}
				}
				
			}
			baseAppOrgan.setList(arrayList);
		}
		
		Response.json(organList);
	}

	/**
	 * 人员管理新需求 2020-12-11 修改接口
	 * 全局人员情况和当前用户所在局的人员情况统计 
	 * @param status
	 *            0:全部权限，1：当前用户所属局的权限
	 */
	@ResponseBody
	@RequestMapping("/statistics")
	public void statistics(String status,String organId) {
		int userAllYx = baseAppUserService.queryListAllYxCount(); //注册人数
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		if(status.equals("0") && StringUtils.isBlank(organId)) {
			organId = "root";
		}else if (status.equals("1") &&  StringUtils.isBlank(organId)) {
			if(StringUtils.isBlank(organId)) {
				organId = CurrentUser.getSSOUser().getOrganId();
				BaseAppOrgan queryObject3 = baseAppOrganService.queryObject(organId);
				if(StringUtils.isNotBlank(queryObject3.getTreePath())) {
					String[] split = queryObject3.getTreePath().split(",");
					List<BaseAppOrgan> queryListByIds = baseAppOrganService.queryListByIds(split);
					for (BaseAppOrgan baseAppOrgan : queryListByIds) {
						if(baseAppOrgan.getParentId().equals("root")) {
							organId = baseAppOrgan.getId();
							break;
						}
					}
				}
			}
			map.add("organId", organId);
		}else {
			
		}
		List<String> list = getUserArray();
		JSONObject jsonData = this.getNumber(map);
		int userIdList = 0;
		if(status.equals("1")) {
			userIdList=this.userIdNumber(organId, list);// 在线人数
		}else {
			userIdList=this.userIdNumber(null, list);// 在线人数
		}
		Integer userShouldNumber = 0; //应在线人数
		Integer qjNum = 0; //请假人数
		Integer evectionNum = 0; //出差人数
		Integer otherPlacesNum = 0 ; //京外人数

		if (jsonData != null) {
			qjNum =(Integer) jsonData.get("qjrs");
			evectionNum = 10; //现请销假无出差人数，等请销假开发完毕
			otherPlacesNum = 10; //现请销假京外人数，等请销假开发完毕
		}
		userShouldNumber = userAllYx -qjNum -evectionNum;

		if (userIdList == 0) {
			jsonData.put("zwlv", "0");//在线率
		} else {
			DecimalFormat decimalFormat = new DecimalFormat("0.00");
			if (userIdList > 0) {
					float zwRate = ((float) userIdList / (float) userAllYx) * 100;
					String format = decimalFormat.format(zwRate);
					if (zwRate > 0) {
						jsonData.put("zwlv", format);
					} else {
						jsonData.put("zwlv", "0");
					}
			} else {
				jsonData.put("zwlv", "0");
			}
		}
		jsonData.put("userAllYx", userAllYx);//注册人数
		jsonData.put("userShouldNumber", userShouldNumber);//应在线人数
		jsonData.put("userIdList", userIdList);// 在线人数
		jsonData.put("qjNum", qjNum);  //请假人数
		jsonData.put("otherPlacesNum", otherPlacesNum);//京外人数
		Response.json(jsonData);
	}

	/**
	 * 本局的单位人员情况-全局点击查看功能后
	 * 
	 */
	@ResponseBody
	@RequestMapping("/listByOrganid")
	public void listByOrganid(String organId) {
		LinkedMultiValueMap<String, Object> linkeMap = new LinkedMultiValueMap<String, Object>();
		BaseAppOrgan baseAppOrgan = baseAppOrganService.queryObject(organId);
		linkeMap.add("organId", baseAppOrgan.getId());
		JSONObject jsonData = this.getNumber(linkeMap);
		Integer yzwrs = (Integer) jsonData.get("yzwrs");
		Integer qjrs = (Integer) jsonData.get("qjrs");
		Integer xjrs = (Integer) jsonData.get("xjrs");
		List<String> list = getUserArray();
		int userIdList = this.userIdNumber(organId, list);// 实际在位人数
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		String zwRate = decimalFormat.format(((float) userIdList / yzwrs) * 100);
		// long zwr =((long)userIdList /(long)yzwrs);
		// float zwRate = zwr*100; //人员在位率
		baseAppOrgan.setZwrate(zwRate);
		baseAppOrgan.setYzwrs(yzwrs);
		baseAppOrgan.setQjrs(qjrs);
		baseAppOrgan.setXjrs(xjrs);
		baseAppOrgan.setSjzwrs(userIdList);
		Response.json("baseAppOrgan", baseAppOrgan);
	}

	private JSONObject getTXL(LinkedMultiValueMap<String, Object> map) {
		BaseAppOrgMapped orgMapped = (BaseAppOrgMapped)baseAppOrgMappedService.orgMappedByOrgId("","root",AppConstant.APP_TXL);
		// 获取清销假app的接口
		String elecPath = orgMapped.getUrl()+ AppInterfaceConstant.WEB_TXL;
		JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath, map);
		return jsonData;
	}

	private JSONObject getNumber(LinkedMultiValueMap<String, Object> map) {
		BaseAppOrgMapped orgMapped = (BaseAppOrgMapped)baseAppOrgMappedService.orgMappedByOrgId("","root",AppConstant.APP_QXJGL);
		
		// 获取清销假app的接口
		String elecPath = orgMapped.getUrl() + AppInterfaceConstant.WEB_INTERFACE_QXJ_statistics;
		JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath, map);
		return jsonData;
	}

	/**
	 * 在线人
	 */
	private int userIdNumber(String organId, List<String> list) {
		int i = 0;
		if (StringUtils.isNotBlank(organId)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("orgId", organId);
			map.put("departmentId", organId);
			List<BaseAppUser> queryListByOrganid = baseAppUserService.queryByOrganidTREEPATH(map);
			for (int j = 0; j < list.size(); j++) {
			for (BaseAppUser baseAppUser : queryListByOrganid) {
					String string = list.get(j);
					if(baseAppUser.getAccount().equals(list.get(j))) {
						i++;
					}
				}
			}
		} else {
			if (list.size() > 0) {
				i = list.size();
			}
		}

		return i;
	}

	/**
	 * 获得在位用户
	 */
	private List<String> getUserArray() {
		List<String> accountList = new ArrayList<String>();
		LinkedMultiValueMap<String, Object> infoMap = new LinkedMultiValueMap<String, Object>();
		infoMap.add("_content_type", "application/x-www-form-urlencoded");
		String url = urls + AppInterfaceConstant.WEB_INTERFACE_XLGLZXR;
		try {
			// 请假人数远程服务地址(获取在线人数)
			String reJson = RestTemplateUtil.postJSONString(url, infoMap);
			String accounts = reJson.substring(1, reJson.length() - 1).replace("\"", "").replace("]", "");
			String[] accountArray = accounts.split("\\s*,\\s*");
			accountList = new ArrayList<String>(Arrays.asList(accountArray));
		} catch (Exception e) {
			// logger.info("PersonManagementController在线人员ID-LIST");
			e.printStackTrace();
		}
		return accountList;

	}

	/**
	 * 单位人员详情-鼠标悬停显示 目前废弃不用
	 */
	@ResponseBody
	@RequestMapping("/qxjUserInto")
	public void list(String userId) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("userId", userId);
		// 获取办件开放的接口
		String elecPath = baseAppOrgMappedService.getWebUrl(AppConstant.APP_QXJGL,
				AppInterfaceConstant.WEB_INTERFACE_QXJ_USER_INFO_QJDAYS);
		JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath, map);
		Response.json(jsonData);
	}

	/**
	 * 各单位人员情况统计列表 导出功能
	 */
	@ResponseBody
	@RequestMapping("/export")
	public void export(String[] organIds, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<>();
		map.put("parentId", "root");
		List<BaseAppOrgan> queryList = baseAppOrganService.queryList(map);
		queryList = getBaseAppOrganList(queryList, null, null);
		List<BaseAppOrgan> list = new ArrayList<BaseAppOrgan>();
		if (organIds != null) {
			for (BaseAppOrgan baseAppOrgan : queryList) {
				for (String str : organIds) {
					if (baseAppOrgan.getId().equals(str)) {
						list.add(baseAppOrgan);
					}
				}
			}
		}
		String format = new SimpleDateFormat("yyyy-MM-ddHHmmss").format(new Date());
		String fileName = "人员管理-各单位人员情况统计表-" + format + ".xls";
		File tempFile = new File(filePath, fileName);
		if (tempFile.exists()) {
			tempFile.delete();
		} else {
			tempFile.getParentFile().mkdirs();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		InputStream is;
		String[] title = { "序号", "部门名称", "应在位人数", "实际在位人数", "人员在位率", "请假人数", "休假人数" };
		try {
			if (list.size() > 0) {
				is = createExcelList(list, title, tempFile.getAbsolutePath());
			} else {
				is = createExcelList(queryList, title, tempFile.getAbsolutePath());
			}
			String string = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			response.reset();
			response.setContentType("application/octet-stream");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + string);
			OutputStream os = response.getOutputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			byte[] buff = new byte[1024];
			int i = 0;
			try {
				while ((i = bis.read(buff)) != -1) {
					os.write(buff, 0, i);
					os.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				bis.close();
				os.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Response.json(resultMap);
	}

	/**
	 * 各单位人员情况统计列表导出
	 */
	private InputStream createExcelList(List<BaseAppOrgan> list, String[] title, String fileName) throws Exception {
		FileOutputStream fout = null;
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFRow row = sheet.createRow(0);
			for (int i = 0; i < title.length; i++) {
				HSSFCell createCell = row.createCell(i);
				createCell.setCellValue(title[i]);
			}
			for (int i = 1; i < list.size() + 1; i++) {
				HSSFRow rows = sheet.createRow(i);
				HSSFCell cell0 = rows.createCell(0);// 序号
				cell0.setCellValue(i);

				HSSFCell cell1 = rows.createCell(1);// 部门名称
				cell1.setCellValue(list.get(i - 1).getName());

				HSSFCell cell2 = rows.createCell(2);// 应在位人数
				cell2.setCellValue(list.get(i - 1).getYzwrs());

				HSSFCell cell3 = rows.createCell(3);// 实际在位人数
				cell3.setCellValue(list.get(i - 1).getSjzwrs());

				HSSFCell cell4 = rows.createCell(4);// 人员在未率
				cell4.setCellValue(list.get(i - 1).getZwrate());

				HSSFCell cell5 = rows.createCell(5);// 请假人数
				cell5.setCellValue(list.get(i - 1).getQjrs());

				HSSFCell cell6 = rows.createCell(6);// 休假人数
				cell6.setCellValue(list.get(i - 1).getXjrs());
			}
			fout = new FileOutputStream(fileName);
			wb.write(fout);
			fout.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fout.close();
		}
		return new FileInputStream(fileName);
	}

	/**
	 * 本局的单位人员情况-全局点击查看功能后 导出功能
	 */
	@ResponseBody
	@RequestMapping("/exportPeople")
	public void exportPeople(String organId, String[] ids, HttpServletResponse response) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("orgid", organId);
		JSONObject txl = getTXL(map);
		String jsonArray = txl.getJSONArray("rows").toString();
		ArrayList<TxlUserDto> arrayList = new ArrayList<TxlUserDto>();
		List<TxlUserDto> parseArray = JSONArray.parseArray(jsonArray, TxlUserDto.class);
		if (ids != null) {
			for (TxlUserDto txlUserDto : parseArray) {
				for (String str : ids) {
					if (txlUserDto.getUserid().equals(str)) {
						arrayList.add(txlUserDto);
					}
				}
			}
		}
		String format = new SimpleDateFormat("yyyy-MM-ddHHmmss").format(new Date());
		String fileName = "人员管理-本单位人员情况情况统计表-" + format + ".xls";
		File tempFile = new File(filePath, fileName);
		if (tempFile.exists()) {
			tempFile.delete();
		} else {
			tempFile.getParentFile().mkdirs();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		InputStream is;
		String[] title = { "用户名称", "职务", "座机", "手机号", "房间号", "部门名称", "在位情况" };
		try {
			if (arrayList.size() > 0) {
				is = createExcelInfoFlie(arrayList, title, tempFile.getAbsolutePath());
			} else {
				is = createExcelInfoFlie(parseArray, title, tempFile.getAbsolutePath());
			}

			String string = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			response.reset();
			response.setContentType("application/octet-stream");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + string);
			OutputStream os = response.getOutputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			byte[] buff = new byte[1024];
			int i = 0;
			try {
				while ((i = bis.read(buff)) != -1) {
					os.write(buff, 0, i);
					os.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				bis.close();
				os.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Response.json(resultMap);
	}

	/**
	 * 本局的单位人员情况-全局点击查看功能后导出
	 */
	private InputStream createExcelInfoFlie(List<TxlUserDto> list, String[] title, String fileName) throws Exception {
		FileOutputStream fout = null;
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFRow row = sheet.createRow(0);
			for (int i = 0; i < title.length; i++) {
				HSSFCell createCell = row.createCell(i);
				createCell.setCellValue(title[i]);
			}
			for (int i = 1; i < list.size() + 1; i++) {
				HSSFRow rows = sheet.createRow(i);
				HSSFCell cell0 = rows.createCell(0);// 用户名称
				cell0.setCellValue(list.get(i - 1).getFullname());

				HSSFCell cell1 = rows.createCell(1);// 职务
				cell1.setCellValue(list.get(i - 1).getPost());

				HSSFCell cell2 = rows.createCell(2);// 座机
				cell2.setCellValue(list.get(i - 1).getTelephone());

				HSSFCell cell3 = rows.createCell(3);// 手机号
				cell3.setCellValue(list.get(i - 1).getMobile());

				HSSFCell cell4 = rows.createCell(4);// 房间号
				cell4.setCellValue("");

				HSSFCell cell5 = rows.createCell(5);// 部门名称
				cell5.setCellValue(list.get(i - 1).getOrganName());

				HSSFCell cell6 = rows.createCell(6);// 在位情况
				if (StringUtils.isNotBlank(list.get(i - 1).getIsShow()) && list.get(i - 1).getIsShow().equals("0")) {
					cell6.setCellValue("不在位");
				} else if (list.get(i - 1).getIsShow() != null && list.get(i - 1).getIsShow().equals("1")) {
					cell6.setCellValue("在位");
				} else {
					cell6.setCellValue("不在位");
				}

			}
			fout = new FileOutputStream(fileName);
			wb.write(fout);
			fout.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fout.close();
		}
		return new FileInputStream(fileName);
	}
}
