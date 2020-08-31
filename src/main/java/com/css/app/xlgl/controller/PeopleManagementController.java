package com.css.app.xlgl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
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
import com.css.app.xlgl.dto.TxlUserDto;
import com.css.app.xlgl.entity.XlglAdminSet;
import com.css.app.xlgl.service.XlglAdminSetService;
import com.css.base.utils.CrossDomainUtil;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.github.pagehelper.PageHelper;
/**
 * 
 * 日常管理-人员管理
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-03 11:36:19
 * 
 * */
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

	/**
	 * 
	 * 各单位人员情况统计列表
	 * */
	@RequestMapping("/list")
	public void list(Integer page, Integer limit) {

		String userId = CurrentUser.getUserId();
		Map<String, Object> hashmap = new HashMap<>();
		hashmap.put("userId", userId);
		List<XlglAdminSet> queryList2 = adminSetService.queryList(hashmap);
		boolean status = false;
		if(queryList2.size()>0) {
			XlglAdminSet xlglAdminSet = queryList2.get(0);
			//管理员类型（1：部管理员；2：局管理员；3：参谋）
			if(xlglAdminSet !=null) {
				switch (xlglAdminSet.getAdminType()) {
				case "1":
						status = true;
					break;
				case "2":
					status = true;
				break;
				case "4":
					status = true;
				break;
				default:
					break;
				}
			}
		}
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		List<BaseAppOrgan> queryList = baseAppOrganService.queryList(map);
		PageUtils pageUtil = new PageUtils(queryList);
		queryList = getBaseAppOrganList(queryList,queryList2,status);
		Response.json("page",pageUtil);
	}
	
	private List<BaseAppOrgan> getBaseAppOrganList(List<BaseAppOrgan> queryList,List<XlglAdminSet> queryList2,Boolean status) {
		LinkedMultiValueMap<String, Object> linkeMap = new LinkedMultiValueMap<String,Object>();
		for (BaseAppOrgan baseAppOrgan : queryList) {
			if(status != null) {
				if(status) {
					String str = "0";
					if(queryList2.size()>0) {
						 str =baseAppOrgan.getId().equals(queryList2.get(0).getDeptId())?"1":"0";
					}
					baseAppOrgan.setStatus(str);
				}else {
					baseAppOrgan.setStatus("1");
				}
			}
			linkeMap.add("organId", baseAppOrgan.getId());
			JSONObject jsonData = this.getNumber(linkeMap);
			Integer yzwrs=0;
			Integer qjrs=0;
			Integer xjrs=0;
			Object object = jsonData.get("yzwrs");
			Object object2 = jsonData.get("qjrs");
			Object object3 = jsonData.get("xjrs");
			if( object!=null) {
				yzwrs = (Integer)object;
			}
			if( object2!=null) {
				yzwrs = (Integer)object2;
			}
			if( object3!=null) {
				yzwrs = (Integer)object3;
			}
			int userIdList = this.userIdNumber();//实际在位人数
			int zwRate = (userIdList /yzwrs)*100; //人员在位率
			baseAppOrgan.setYzwrs(yzwrs);
			baseAppOrgan.setQjrs(qjrs);
			baseAppOrgan.setXjrs(xjrs);
			baseAppOrgan.setSjzwrs(userIdList);
			baseAppOrgan.setZwrate(zwRate);
		}
		return queryList;
	}
	
	
	/**
	 * 单位人员统计列表
	 * */
	@ResponseBody
	@RequestMapping("/qxjUserInfoList")
	public void qxjUserInfoList(Integer page, Integer limit,String organId) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String,Object>();
		map.add("orgid", organId);
		map.add("page", page);
		map.add("rows", limit);
		/* Map<String, Object> hashmap = new HashMap<>();
		 * hashmap.put("organId", organId);
		 * PageHelper.startPage(page, limit);
		List<BaseAppUser> queryListByOrganid = baseAppUserService.queryListByOrganid(hashmap);
		PageUtils pageUtil = new PageUtils(queryListByOrganid);*/
		JSONObject txl = getTXL(map);
	
		Response.json(txl);
	}

	/**
	 * 全局人员情况-统计全局休假人数、请假人数、应在位人数(总人数-请假人数-休假人数)、人员在位率(实际在位人数/应在位人数)
	 * @param status 0:全部，1：一个部门
	 * */
	@ResponseBody
	@RequestMapping("/statistics")
	public void statistics(String status) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String,Object>();
		if(status.equals("1")) {
			String organId = CurrentUser.getSSOUser().getOrganId();
			map.add("organId", organId);
		}
		JSONObject jsonData = this.getNumber(map);
		int userIdList = this.userIdNumber();//实际在位人数
		Integer object = 0;
		if(jsonData!=null) {
			Object object2 = jsonData.get("zwrs");
			object =(Integer)object2;//应在位人数
		}
		int zwRate = (userIdList /object)*100;
		jsonData.put("zwlv", zwRate);
		Response.json(jsonData);
	}
	
	/**
	 * 本局的单位人员情况-全局点击查看功能后
	 * 
	 * */
	@ResponseBody
	@RequestMapping("/listByOrganid")
	public void listByOrganid(String organId) {
		LinkedMultiValueMap<String, Object> linkeMap = new LinkedMultiValueMap<String,Object>();
		BaseAppOrgan baseAppOrgan = baseAppOrganService.queryObject(organId);
		linkeMap.add("organId", baseAppOrgan.getId());
		JSONObject jsonData = this.getNumber(linkeMap);
		Integer yzwrs=(Integer)jsonData.get("yzwrs");
		Integer qjrs=(Integer)jsonData.get("qjrs");
		Integer xjrs=(Integer)jsonData.get("xjrs");
		int userIdList = this.userIdNumber();//实际在位人数
		int zwRate = (userIdList /yzwrs)*100; //人员在位率
		baseAppOrgan.setYzwrs(yzwrs);
		baseAppOrgan.setQjrs(qjrs);
		baseAppOrgan.setXjrs(xjrs);
		baseAppOrgan.setSjzwrs(userIdList);
		baseAppOrgan.setZwrate(zwRate);
		Response.json("baseAppOrgan",baseAppOrgan);
	}
	
	private JSONObject getTXL(LinkedMultiValueMap<String, Object> map) {
		// 获取清销假app的接口
		String elecPath = baseAppOrgMappedService.getWebUrl(AppConstant.APP_TXL, AppInterfaceConstant.WEB_TXL);
		JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath,map);
		return jsonData;
	}
	
	private JSONObject getNumber(LinkedMultiValueMap<String, Object> map) {
		// 获取清销假app的接口
		String elecPath = baseAppOrgMappedService.getWebUrl(AppConstant.APP_QXJGL, AppInterfaceConstant.WEB_INTERFACE_QXJ_statistics);
		JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath,map);
		return jsonData;
	}
	
	/**
	 * 在线人
	 */
	private  int userIdNumber() {
		return getUserArray().size();
	}
	/**
	 * 获得在位用户
	 * */
	private List<String> getUserArray() {
		List<String> accountList = new ArrayList<String>();
		LinkedMultiValueMap<String,Object> infoMap = new LinkedMultiValueMap<String,Object>();
		infoMap.add("arch", "arm64");
		BaseAppOrgMapped mapped = (BaseAppOrgMapped) baseAppOrgMappedService.orgMappedByOrgId(null, "root",
				AppInterfaceConstant.APP_XLGLZXR);
		if(mapped != null){
			String url = mapped.getUrl() + AppInterfaceConstant.WEB_INTERFACE_XLGLZXR;
			String returnString = CrossDomainUtil.postJSONString(url, infoMap);
			String accounts = returnString.substring(1,returnString.length()-1).replace("\"", "");
			String [] accountArray = accounts.split("\\s*,\\s*");
			accountList = new ArrayList<String>(Arrays.asList(accountArray));
		}
		return accountList;
	} 
	
	/**
	 * 单位人员详情-鼠标悬停显示 目前废弃不用
	 * */
	@ResponseBody
	@RequestMapping("/qxjUserInto")
	public void list(String userId) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String,Object>();
		map.add("userId", userId);
		// 获取办件开放的接口
		String elecPath = baseAppOrgMappedService.getWebUrl(AppConstant.APP_QXJGL, AppInterfaceConstant.WEB_INTERFACE_QXJ_USER_INFO_QJDAYS);
		JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath,map);
		Response.json(jsonData);
	}
	/**
	 * 各单位人员情况统计列表
	 * 导出功能
	 * */
	@ResponseBody
	@RequestMapping("/export")
	public void export() {
		List<BaseAppOrgan> queryList = baseAppOrganService.queryList(null);
		queryList = getBaseAppOrganList(queryList,null,null);
		File tempFile = new File(filePath, "人员管理-各单位人员情况统计表.xls");
		if (tempFile.exists()) {
			tempFile.delete();
		} else {
			tempFile.getParentFile().mkdirs();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		InputStream is;
		String[] title ={"序号","部门名称","应在位人数","实际在位人数","人员在位率","请假人数","休假人数"};
		try {
			is = createExcelList(queryList,title,tempFile.getAbsolutePath());
			is.close();
			resultMap.put("fileUrl", tempFile.getAbsoluteFile());
			resultMap.put("fileName", tempFile.getName());
			resultMap.put("result", "success");
		}catch (Exception e) {
			e.printStackTrace();
		}
		Response.json(resultMap);
	}
	/**
	 * 各单位人员情况统计列表导出
	 * */
	private InputStream createExcelList(List<BaseAppOrgan> list, String[] title ,String fileName) throws Exception {
		FileOutputStream fout = null;
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFRow row = sheet.createRow(0);
			for (int i = 0; i < title.length; i++) {
				HSSFCell createCell = row.createCell(i);
				createCell.setCellValue(title[i]);
			}
			for (int i = 1; i < list.size(); i++) {
				HSSFRow rows = sheet.createRow(i);
				HSSFCell cell0 = rows.createCell(0);//序号
				cell0.setCellValue(i);
				
				HSSFCell cell1 = rows.createCell(1);//部门名称
				cell1.setCellValue(list.get(i).getName());
				
				HSSFCell cell2 = rows.createCell(2);//应在位人数
				cell2.setCellValue(list.get(i).getYzwrs());
				
				HSSFCell cell3 = rows.createCell(3);//实际在位人数
				cell3.setCellValue(list.get(i).getSjzwrs());
				
				HSSFCell cell4 = rows.createCell(4);//人员在未率
				cell4.setCellValue(list.get(i).getZwrate());
				
				HSSFCell cell5 = rows.createCell(5);//请假人数
				cell5.setCellValue(list.get(i).getQjrs());
				
				HSSFCell cell6 = rows.createCell(6);//休假人数
				cell6.setCellValue(list.get(i).getXjrs());
			}
			fout = new FileOutputStream(fileName);
			wb.write(fout);
			fout.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fout != null) {
				fout.close();
			}
		}
		return new FileInputStream(fileName);
	}
	
	/**
	 * 	organName：部门名称
		fullname：用户名称
		mobile：移动电话
		post：职务
		telephone：座机
		address 地址（没有房间号，先用地址吧）
		isShow：是否在位
	 * */
	private InputStream createExcelInfoFlie(List<TxlUserDto> list, String[] title ,String fileName) throws Exception {
		FileOutputStream fout = null;
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFRow row = sheet.createRow(0);
			for (int i = 0; i < title.length; i++) {
				HSSFCell createCell = row.createCell(i);
				createCell.setCellValue(title[i]);
			}
			for (int i = 1; i < list.size(); i++) {
				HSSFRow rows = sheet.createRow(i);
				HSSFCell cell0 = rows.createCell(0);//用户名称
				cell0.setCellValue(list.get(i).getFullname());
				
				HSSFCell cell1 = rows.createCell(1);//职务
				cell1.setCellValue(list.get(i).getPost());
				
				HSSFCell cell2 = rows.createCell(2);//座机
				cell2.setCellValue(list.get(i).getTelephone());
				
				HSSFCell cell3 = rows.createCell(3);//手机号
				cell3.setCellValue(list.get(i).getMobile());
				
				HSSFCell cell4 = rows.createCell(4);//房间号
				cell4.setCellValue("");
				
				HSSFCell cell5 = rows.createCell(5);//部门名称
				cell5.setCellValue(list.get(i).getOrganName());
				
				HSSFCell cell6 = rows.createCell(6);//在位情况
				if(list.get(i).getIsShow() != null && list.get(i).getIsShow().equals("0")) {
					cell6.setCellValue("否");
				}else if(list.get(i).getIsShow() != null && list.get(i).getIsShow().equals("1")) {
					cell6.setCellValue("是");
				}
				
			}
			fout = new FileOutputStream(fileName);
			wb.write(fout);
			fout.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fout != null) {
				fout.close();
			}
		}
		return new FileInputStream(fileName);
	}
}
