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
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgan.util.OrgUtil;
import com.css.addbase.apporgan.util.RedisUtil;
import com.css.addbase.apporgmapped.entity.BaseAppOrgMapped;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.constant.AppConstant;
import com.css.addbase.constant.AppInterfaceConstant;
import com.css.app.xlgl.dto.LeaveorbackUserPlatDto;
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
	
	@Autowired
	private RedisUtil redisUtil;

	@Value("${filePath}")
	private String filePath;
	@Value("${csse.mircoservice.zaiwei}")
	private String urls;


	/**人员管理新需求
	 * 单位人员统计列表
	 * @param parentId 各局的id
	 * @param organId 查询条件-各处的id
	 * @param userName 人员名称
	 */
	@ResponseBody
	@RequestMapping("/qxjUserInfoList")
	public void qxjUserInfoList(String parentId,String organId,String userName) {
		JSONObject qxjUserInfoList = this.getQxjUserInfoList(parentId, organId, userName);
		String jsonArray = qxjUserInfoList.getJSONArray("list").toString();
		redisUtil.setString("xlgl-UserInfoList-"+organId+CurrentUser.getUserId(), jsonArray);
		List<BaseAppOrgan> organList =(List<BaseAppOrgan>) qxjUserInfoList.get("list");
		Response.json(organList);
	}
	
	private JSONObject getQxjUserInfoList(String parentId,String organId,String userName) {
		JSONObject jsonObject = new JSONObject();
		List<String> userList = getUserArray();
		HashMap<String,Object> hashMap2 = new HashMap<String, Object>();
		hashMap2.put("parentId", parentId);
		if(StringUtils.isNotBlank(organId)) {
			hashMap2.put("organId", organId);
		}
		if(StringUtils.isNotBlank(userName)) {
			hashMap2.put("userName", userName);
		}
		List<BaseAppOrgan> organList = baseAppOrganService.findByParentIdAndIsinvalid(hashMap2);
		String[] array =new String[organList.size()];
		for (int i = 0; i < organList.size(); i++) {
			array[i] = organList.get(i).getId();
		}
		List<String> queryByOrgListUserID = new ArrayList<String>();
		if(array.length >0) {
		 queryByOrgListUserID = baseAppUserService.queryByOrgListUserID(array);
		}
		String txlStr = "xlgl-txlUsetNEWDto-"+parentId;
		String jsonArrayTxl = redisUtil.getString(txlStr);
		List<TxlUserNEWDto> parseArrayTxl = JSONArray.parseArray(jsonArrayTxl, TxlUserNEWDto.class);
		String jsonArrayQxj = redisUtil.getString("xlgl-qxl-people");
		List<QXJPeopleManagementDto> parseArrayQxj = JSONArray.parseArray(jsonArrayQxj, QXJPeopleManagementDto.class);
		for (BaseAppOrgan baseAppOrgan : organList) {
			ArrayList<TxlUserNEWDto> arrayList = new ArrayList<>();
			LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
			map.add("organId", baseAppOrgan.getId());
			JSONObject jsonObject1 = getNumber(map);
			Integer yzxrs = (Integer)jsonObject1.get("yzwrs"); //应在线人数 需等请销假开发完毕
			Integer userIdList=this.userIdNumber(baseAppOrgan.getId(), userList);// 在线人数
			baseAppOrgan.setZxrs(userIdList);
			baseAppOrgan.setYzwrs(yzxrs);
			baseAppOrgan.setYzxrs(yzxrs);
			for (TxlUserNEWDto txlUserDto : parseArrayTxl) {
				if(baseAppOrgan.getId().equals(txlUserDto.getOrganid())) {
					for (QXJPeopleManagementDto parseObject : parseArrayQxj) {
						if(parseObject.getUserId().equals(txlUserDto.getUserid())) {
							txlUserDto.setQXJweixiujiaDays(parseObject.getWeixiujiaDays());
							txlUserDto.setQXJtotalDays(parseObject.getTotalDays());
							txlUserDto.setQXJxiuJiaDays(parseObject.getXiuJiaDays());
							if (parseObject.getType() != null) {
								txlUserDto.setQXJmatters(parseObject.getType());
								txlUserDto.setQXJtype(parseObject.getType());
								txlUserDto.setQXJstartDate(parseObject.getStartDate());
								txlUserDto.setQXJendDate(parseObject.getEndDate());
							}
						}
					}
					//isShow 1： 在线 ， 2：请假 ，3：出差，4：异常
					if (userList.contains(txlUserDto.getAccount())) {
						txlUserDto.setIsShow("1");
					} else if(StringUtils.isNotBlank(txlUserDto.getQXJtype())
							&&txlUserDto.getQXJtype().equals("请假")){
						txlUserDto.setIsShow("2");
					}else if(StringUtils.isNotBlank(txlUserDto.getQXJtype()) &&
							txlUserDto.getQXJtype().equals("出差")) {
						txlUserDto.setIsShow("3");
					}else {
						txlUserDto.setIsShow("4");
					}
					if(!StringUtils.equals("", userName)&&txlUserDto.getFullname().contains(userName)) {
						txlUserDto.setIsSelect("1");
					}
					if(!StringUtils.equals(txlUserDto.getIsdelete(),"1")) {
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
					
				}
			}
			baseAppOrgan.setList(arrayList);
		}
		jsonObject.put("list", organList);
		return jsonObject;
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
		JSONObject jsonObject = this.getStatistics(status, organId);
		redisUtil.setString("statistics-0",jsonObject.toString() );
		
		Response.json(jsonObject);
	}
	
	/**
	 * 人员管理新需求 2020-12-11 修改接口
	 * 局的人员情况统计 
	 * 
	 */
	@ResponseBody
	@RequestMapping("/getStatisticsByDept")
	public void getStatisticsByDept(String organId) {
		JSONObject jsonObject = this.getStatistics(null, organId);
		redisUtil.setString("statistics-"+organId,jsonObject.toString() );
		
		Response.json(jsonObject);
	}
	
	
	private JSONObject getStatistics(String status,String organId) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		if(StringUtils.isNotBlank(status) && status.equals("0") && StringUtils.isBlank(organId)) {
			organId = "root";
		}else if (StringUtils.isNotBlank(status) &&status.equals("1") &&  StringUtils.isBlank(organId)) {
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
		}
		List<BaseAppOrgan> organs = baseAppOrganService.queryList(null);
		List<String> arrayList = new ArrayList<String>();
		arrayList = OrgUtil.getOrganTreeList(organs, organId, true, true, arrayList);
		String[] arr = new String[arrayList.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arrayList.get(i);
		}
		int userAllYx = 0;
		if(StringUtils.isNotBlank(organId) && !"root".equals(organId)){
			userAllYx = baseAppUserService.queryZc(organId); //注册人数
		}else {
			userAllYx = baseAppUserService.queryYXNumber(arr); //注册人数
		}

		map.add("organId", organId);
		List<String> list = getUserArray();
		JSONObject jsonData = this.getNumber(map);
		int userIdList = 0;
		if(StringUtils.isNotBlank(status) && status.equals("1")) {
			userIdList=this.userIdNumber(organId, list);// 在线人数
		}else if(StringUtils.isNotBlank(status) && status.equals("0")){
			userIdList=this.userIdNumber(null, list);// 在线人数
		}else {
			userIdList=this.userIdNumber(organId, list);// 在线人数
		}
		Integer userShouldNumber = 0; //应在线人数
		Integer qjNum = 0; //请假人数
		Integer evectionNum = 0; //出差人数
		Integer otherPlacesNum = 0 ; //京外人数

		if (jsonData != null) {
			qjNum =(Integer) jsonData.get("qjrs");
			evectionNum = jsonData.getInteger("chucai"); //现请销假无出差人数，等请销假开发完毕
			otherPlacesNum = jsonData.getInteger("jingwai"); //现请销假京外人数，等请销假开发完毕
		}
		userShouldNumber = userAllYx -qjNum -evectionNum-otherPlacesNum;
		float zwlv= 0;
		if (userIdList == 0) {
			jsonData.put("zwlv", zwlv);//在线率
		} else {
			DecimalFormat decimalFormat = new DecimalFormat("0.00");
			if (userIdList > 0) {
					zwlv = ((float) userIdList / (float) userAllYx) * 100;
					float zwlvs=(float)(Math.round(zwlv*100))/100;
					if (zwlv > 0) {
						jsonData.put("zwlv", zwlvs);
					} else {
						jsonData.put("zwlv", zwlv);
					}
			} else {
				jsonData.put("zwlv", zwlv);
			}
		}
		jsonData.put("userAllYx", userAllYx);//注册人数
		jsonData.put("userShouldNumber", userShouldNumber);//应在线人数
		jsonData.put("userIdList", userIdList);// 在线人数
		jsonData.put("qjNum", qjNum);  //请假人数
		jsonData.put("otherPlacesNum", otherPlacesNum);//京外人数
		return jsonData;
	}
	
	
	/**
	 *  人员管理新需求 2020-12-11 修改接口
	 *  人员管理-各局下-各处单位数据统计和人员-在线状态
	 * @param status
	 *           0:全部权限，1：当前用户所属局的权限
	 * @param organId 
	 * 			当 status 为 0时  organId 为空
	 * 			status 为 1时 organId 传各局的id
	 * 
	 * */ 
    @ResponseBody
   	@RequestMapping("/export")
       public void export(HttpServletResponse response,String status,String organId) {
       	BaseAppOrgan queryObject =  new BaseAppOrgan();
     	JSONObject statistics = new JSONObject();
       	JSONObject jsonObject = new JSONObject();
       	if(status.equals("0")) {
       		queryObject = baseAppOrganService.queryObject("root");
       		String string = redisUtil.getString("statistics-0");
       		statistics = JSON.parseObject(string);
       		String strOrgan = redisUtil.getString("statistics-"+organId);
       		jsonObject = JSON.parseObject(strOrgan);
       	}else {
       		queryObject = baseAppOrganService.queryObject(organId);
       		String strOrgan = redisUtil.getString("statistics-"+organId);
       		jsonObject = JSON.parseObject(strOrgan);
       	}
       	if(jsonObject == null) {
       		jsonObject = this.getStatistics(null, organId);
       	}
    	String strName = queryObject.getName();
       	String userInfoList = redisUtil.getString("xlgl-UserInfoList-"+organId+CurrentUser.getUserId());
       	List<BaseAppOrgan> list = new ArrayList<BaseAppOrgan>();
		if(StringUtils.isNotBlank(userInfoList)) {
			 list = JSONArray.parseArray(userInfoList, BaseAppOrgan.class);
		}else {
			JSONObject qxjUserInfoList = this.getQxjUserInfoList(organId, null, null);
			 list =(List<BaseAppOrgan>) qxjUserInfoList.get("list");
		}
       	
   		String format = new SimpleDateFormat("yyyy-MM-ddHHmmss").format(new Date());
   		String fileName = strName + format + ".xls";
   		File tempFile = new File(filePath, fileName);
   		if (tempFile.exists()) {
   			tempFile.delete();
   		} else {
   			tempFile.getParentFile().mkdirs();
   		}
   		Map<String, Object> resultMap = new HashMap<String, Object>();
   		InputStream is = null;
   		try {
   			if(status.equals("0")) {
   				is = createExcelInfoFlie(list, statistics,jsonObject,fileName, strName);
   			}else {
   				is = createExcelInfoFlie(list, jsonObject,fileName, strName);
   			}
   			
			String string = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			response.reset();
			response.setContentType("application/octet-stream");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + string);
			OutputStream os = response.getOutputStream();
			if(is !=null) {
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
					Response.error();
					return;
				} finally {
					bis.close();
					os.close();
				}
			}
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   		Response.json(resultMap);
       	
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
     * @param 权限为 普通用户，不是部管理员
     * @param list 数据 各处统计和人员-在线状态
     * @Param jsonObject 页面 选中 局的数据
     * @param fileName 文件名称
     * @param strName 表头
     * */
	private InputStream createExcelInfoFlie(List<BaseAppOrgan> list, 
			JSONObject jsonObject,String fileName,String strName) throws Exception {
	String	time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	FileOutputStream fout = null;
   	String titilName = strName+"人员在线情况清单("+time+")";
	try {
		HSSFWorkbook wb = new HSSFWorkbook();
		
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);//样式左右居中
		
		HSSFSheet sheet = wb.createSheet();
		CellRangeAddress region = new CellRangeAddress(0,0,0,6);//起始行，结束行，起始列，结束列
		sheet.addMergedRegion(region);
		
		CellRangeAddress region2 = new CellRangeAddress(1,1,0,6);//起始行，结束行，起始列，结束列
		sheet.addMergedRegion(region2);
		
		
		HSSFRow row = sheet.createRow(0);
		HSSFCell createCell = row.createCell(0);
   		createCell.setCellStyle(style);
		createCell.setCellValue(titilName);
		
		HSSFRow row1 = sheet.createRow(1);
		HSSFCell row1Cell0 = row1.createCell(0);
		row1Cell0.setCellStyle(style);
		row1Cell0.setCellValue(strName+"人员在线情况");
		
		HSSFRow row2 = sheet.createRow(2);
		HSSFCell row2Cell0 = row2.createCell(0);
		Integer userAllYx2 = jsonObject.getInteger("userAllYx");
		row2Cell0.setCellValue("注册人数："+userAllYx2);
		
		HSSFCell row2Cell1 = row2.createCell(1);
		Integer userShouldNumber2 = jsonObject.getInteger("userShouldNumber");
		row2Cell1.setCellValue("应在线人数："+userShouldNumber2);
		
		HSSFCell row4Cell2 = row2.createCell(2);
		Integer userIdList2 = jsonObject.getInteger("userIdList");
		row4Cell2.setCellValue("在线人数："+userIdList2);
		
		HSSFCell row2Cell3 = row2.createCell(3);
		Float zwlv2 = jsonObject.getFloat("zwlv");
		row2Cell3.setCellValue("在线人率："+zwlv2+"%");
		
		HSSFCell row2Cell4 = row2.createCell(4);
		Integer qjNum2 = jsonObject.getInteger("qjNum");
		row2Cell4.setCellValue("请假人数："+qjNum2);
		
		HSSFCell row2Cell5 = row2.createCell(5);
		Integer otherPlacesNum2 = jsonObject.getInteger("otherPlacesNum");
		row2Cell5.setCellValue("京外人数："+otherPlacesNum2);
		
		int rowNumber = 3;
		for (BaseAppOrgan baseAppOrgan : list) {
			CellRangeAddress region4 = new CellRangeAddress(rowNumber,rowNumber,0,6);//起始行，结束行，起始列，结束列
			sheet.addMergedRegion(region4);
			HSSFRow row5 = sheet.createRow(rowNumber);
			HSSFCell row5Cell0 = row5.createCell(0);
			row5Cell0.setCellStyle(style);
			row5Cell0.setCellValue(baseAppOrgan.getName()+"人员在线情况");
			rowNumber =rowNumber+1;
			HSSFRow row6 = sheet.createRow(rowNumber);
			HSSFCell row6Cell0 = row6.createCell(0);
			row6Cell0.setCellValue("注册人数："+baseAppOrgan.getZcrs());
			HSSFCell row6Cell1 = row6.createCell(1);
			if(baseAppOrgan.getYzxrs() == null) {
				row6Cell1.setCellValue("应在线：0");
			}else {
				row6Cell1.setCellValue("应在线："+baseAppOrgan.getYzxrs());
			}
			HSSFCell row6Cell2 = row6.createCell(2);
			row6Cell2.setCellValue("在线："+baseAppOrgan.getZxrs());
			List<TxlUserNEWDto> userList = baseAppOrgan.getList();
			rowNumber =rowNumber+1;
			HSSFRow row7 = sheet.createRow(rowNumber);
			HSSFCell row7Cell0 = row7.createCell(0);
			row7Cell0.setCellValue("人员名称");
			HSSFCell row7Cell1 = row7.createCell(1);
			row7Cell1.setCellValue("在线状态");
			for (TxlUserNEWDto txlUserNEWDto : userList) {
				String showStr = "";//在线状态
				rowNumber =rowNumber+1;
				HSSFRow row8 = sheet.createRow(rowNumber);
				HSSFCell row8Cell0 = row8.createCell(0);
				row8Cell0.setCellValue(txlUserNEWDto.getFullname());
				
				HSSFCell row8Cell1 = row8.createCell(1);
				
				if(txlUserNEWDto.getIsShow().equals("1")) {
					showStr = "在线";
				}else if(txlUserNEWDto.getIsShow().equals("2")) {
					showStr = "因私请假";
				}else if(txlUserNEWDto.getIsShow().equals("3")) {
					showStr = "因公出差";
				}else {
					showStr = "异常";
				}
				row8Cell1.setCellValue(showStr);
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

	
    /**
     * 有权限的导出
     * @param list 数据 各处统计和人员-在线状态
     * @param statistics 页面 全部数据统计
     * @Param jsonObject 页面 选中 局的数据
     * @param fileName 文件名称
     * @param strName 表头
     * */
	private InputStream createExcelInfoFlie(List<BaseAppOrgan> list, JSONObject statistics,
			JSONObject jsonObject,String fileName,String strName) throws Exception {
	String	time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	FileOutputStream fout = null;
   	String titilName = strName+"人员在线情况清单("+time+")";
	try {
		HSSFWorkbook wb = new HSSFWorkbook();
		
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);//样式左右居中
		
		HSSFSheet sheet = wb.createSheet();
		CellRangeAddress region = new CellRangeAddress(0,0,0,6);//起始行，结束行，起始列，结束列
		sheet.addMergedRegion(region);
		
		CellRangeAddress region2 = new CellRangeAddress(1,1,0,6);//起始行，结束行，起始列，结束列
		sheet.addMergedRegion(region2);
		
		
		CellRangeAddress region3 = new CellRangeAddress(3,3,0,6);//起始行，结束行，起始列，结束列
		sheet.addMergedRegion(region3);
		
		HSSFRow row = sheet.createRow(0);
		HSSFCell createCell = row.createCell(0);
   		createCell.setCellStyle(style);
		createCell.setCellValue(titilName);
		
		HSSFRow row1 = sheet.createRow(1);
		HSSFCell row1Cell0 = row1.createCell(0);
		row1Cell0.setCellStyle(style);
		row1Cell0.setCellValue("全局在线人员");
		
		HSSFRow row2 = sheet.createRow(2);
		HSSFCell row2Cell0 = row2.createCell(0);
		Integer userAllYx = statistics.getInteger("userAllYx");
		row2Cell0.setCellValue("注册人数："+userAllYx);
		
		HSSFCell row2Cell1 = row2.createCell(1);
		Integer userShouldNumber = statistics.getInteger("userShouldNumber");
		row2Cell1.setCellValue("应在线人数："+userShouldNumber);
		
		HSSFCell row2Cell2 = row2.createCell(2);
		Integer userIdList = statistics.getInteger("userIdList");
		row2Cell2.setCellValue("在线人数："+userIdList);
		
		HSSFCell row2Cell3 = row2.createCell(3);
		Float zwlv = statistics.getFloat("zwlv");
		row2Cell3.setCellValue("在线人率："+zwlv+"%");
		
		HSSFCell row2Cell4 = row2.createCell(4);
		Integer qjNum = statistics.getInteger("qjNum");
		row2Cell4.setCellValue("请假人数："+qjNum);
		
		HSSFCell row2Cell5 = row2.createCell(5);
		Integer otherPlacesNum = statistics.getInteger("otherPlacesNum");
		row2Cell5.setCellValue("京外人数："+otherPlacesNum);
		
		HSSFRow row3 = sheet.createRow(3);
		HSSFCell row3Cell0 = row3.createCell(0);
		row3Cell0.setCellStyle(style);
		row3Cell0.setCellValue(strName+"人员在线情况");
		
		HSSFRow row4 = sheet.createRow(4);
		HSSFCell row4Cell0 = row4.createCell(0);
		Integer userAllYx2 = jsonObject.getInteger("userAllYx");
		row4Cell0.setCellValue("注册人数："+userAllYx2);
		
		HSSFCell row4Cell1 = row4.createCell(1);
		Integer userShouldNumber2 = jsonObject.getInteger("userShouldNumber");
		row4Cell1.setCellValue("应在线人数："+userShouldNumber2);
		
		HSSFCell row4Cell2 = row4.createCell(2);
		Integer userIdList2 = jsonObject.getInteger("userIdList");
		row4Cell2.setCellValue("在线人数："+userIdList2);
		
		HSSFCell row4Cell3 = row4.createCell(3);
		Float zwlv2 = jsonObject.getFloat("zwlv");
		row4Cell3.setCellValue("在线人率："+zwlv2+"%");
		
		HSSFCell row4Cell4 = row4.createCell(4);
		Integer qjNum2 = jsonObject.getInteger("qjNum");
		row4Cell4.setCellValue("请假人数："+qjNum2);
		
		HSSFCell row4Cell5 = row4.createCell(5);
		Integer otherPlacesNum2 = jsonObject.getInteger("otherPlacesNum");
		row4Cell5.setCellValue("京外人数："+otherPlacesNum2);
		int rowNumber = 5;
		for (BaseAppOrgan baseAppOrgan : list) {
			CellRangeAddress region4 = new CellRangeAddress(rowNumber,rowNumber,0,6);//起始行，结束行，起始列，结束列
			sheet.addMergedRegion(region4);
			HSSFRow row5 = sheet.createRow(rowNumber);
			HSSFCell row5Cell0 = row5.createCell(0);
			row5Cell0.setCellStyle(style);
			row5Cell0.setCellValue(baseAppOrgan.getName()+"人员在线情况");
			rowNumber =rowNumber+1;
			HSSFRow row6 = sheet.createRow(rowNumber);
			HSSFCell row6Cell0 = row6.createCell(0);
			row6Cell0.setCellValue("注册人数："+baseAppOrgan.getZcrs());
			HSSFCell row6Cell1 = row6.createCell(1);
			if(baseAppOrgan.getYzxrs() == null) {
				row6Cell1.setCellValue("应在线：0");
			}else {
				row6Cell1.setCellValue("应在线："+baseAppOrgan.getYzxrs());
			}
			
			HSSFCell row6Cell2 = row6.createCell(2);
			row6Cell2.setCellValue("在线："+baseAppOrgan.getZxrs());
			List<TxlUserNEWDto> userList = baseAppOrgan.getList();
			rowNumber =rowNumber+1;
			HSSFRow row7 = sheet.createRow(rowNumber);
			HSSFCell row7Cell0 = row7.createCell(0);
			row7Cell0.setCellValue("人员名称");
			HSSFCell row7Cell1 = row7.createCell(1);
			row7Cell1.setCellValue("在线状态");
			for (TxlUserNEWDto txlUserNEWDto : userList) {
				String showStr = "";//在线状态
				rowNumber =rowNumber+1;
				HSSFRow row8 = sheet.createRow(rowNumber);
				HSSFCell row8Cell0 = row8.createCell(0);
				row8Cell0.setCellValue(txlUserNEWDto.getFullname());
				
				HSSFCell row8Cell1 = row8.createCell(1);
				
				if(txlUserNEWDto.getIsShow().equals("1")) {
					showStr = "在线";
				}else if(txlUserNEWDto.getIsShow().equals("2")) {
					showStr = "因私请假";
				}else if(txlUserNEWDto.getIsShow().equals("3")) {
					showStr = "因公出差";
				}else {
					showStr = "异常";
				}
				row8Cell1.setCellValue(showStr);
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


