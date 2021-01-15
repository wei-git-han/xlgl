package com.css.app.xlgl.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgan.util.OrgUtil;
import com.css.addbase.apporgan.util.RedisUtil;
import com.css.addbase.apporgmapped.entity.BaseAppOrgMapped;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.constant.AppConstant;
import com.css.addbase.constant.AppInterfaceConstant;
import com.css.app.xlgl.config.entity.XlglRoleSet;
import com.css.app.xlgl.config.service.XlglRoleSetService;
import com.css.app.xlgl.dto.ExamMainAnswerAnalyseDto;
import com.css.app.xlgl.dto.LeaveorbackPlatDto;
import com.css.app.xlgl.dto.LeaveorbackUserPlatDto;
import com.css.app.xlgl.dto.TxlUserNEWDto;
import com.css.app.xlgl.service.XlglAdminSetService;
import com.css.base.utils.CrossDomainUtil;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.github.pagehelper.util.StringUtil;

@Controller
@RequestMapping("app/xlgl/peopleManagementNew")
public class PeopleManagementNewController {
	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private XlglAdminSetService adminSetService;
	@Autowired
	private XlglRoleSetService xlglRoleSetService;
	@Autowired
	private RedisUtil redisUtil;
	

	@Value("${filePath}")
	private String filePath;
	@Value("${csse.mircoservice.zaiwei}")
	private String urls;
	
	/**局单位树
	 * @throws JSONException 
	 * 
	 * */
	@ResponseBody
	@RequestMapping("/organTreeList")
	public void organTreeList(){
		JSONArray jsonArray = new JSONArray();
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		hashMap.put("parentId", "root");
		List<BaseAppOrgan> queryList = baseAppOrganService.queryList(hashMap);
		for (BaseAppOrgan baseAppOrgan : queryList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", baseAppOrgan.getId());
			jsonObject.put("name", baseAppOrgan.getName());
			jsonArray.add(jsonObject);
		}
		Response.json(jsonArray);
	}
	
    /**
     * 训练管理-人员管理-地图人数接口
     * @author 李振楠 2020-12-16
     * @param parentId 当前用户所能看的局id，部管理不传值默认为 root ,不是部管理员传当前局id
     * @param organId 查询条件 各局id
     * @param timeStr 查询条件 时间 默认当前时间
     * */
    @ResponseBody
    @RequestMapping("/getPlatNumber")
    public void getPlatNumber(String parentId,String organId,String timeStr){
    	LinkedMultiValueMap<String, Object> hashmap = new LinkedMultiValueMap<String, Object>();
    	hashmap.add("parentId", parentId);
    	hashmap.add("organId", organId);
    	hashmap.add("timeStr", timeStr);
    	BaseAppOrgMapped orgMapped = (BaseAppOrgMapped)baseAppOrgMappedService.orgMappedByOrgId("","root",AppConstant.APP_QXJGL);
		// 获取清销假app的接口
		String elecPath = orgMapped.getUrl() + AppInterfaceConstant.WEB_QXJ_XLGLAPICONTROLLER_GETPLATNUMBER;
		JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath, hashmap);
		String jsonArray = jsonData.getJSONArray("list").toString();
		List<LeaveorbackPlatDto> parseArray = JSONArray.parseArray(jsonArray, LeaveorbackPlatDto.class);
		List<LeaveorbackPlatDto> arrayList = new ArrayList<LeaveorbackPlatDto>();
		List<LeaveorbackPlatDto> listjingWai = new ArrayList<LeaveorbackPlatDto>();
		for (LeaveorbackPlatDto leaveorbackPlatDto : parseArray) {
			if(leaveorbackPlatDto.getPlat().equals("北京")) {
				arrayList.add(leaveorbackPlatDto);
			}else {
				listjingWai.add(leaveorbackPlatDto);
			}
		}
		listjingWai.sort(Comparator.comparing(LeaveorbackPlatDto :: getNumber).reversed());
		for (LeaveorbackPlatDto leaveorbackPlatDto : listjingWai) {
			arrayList.add(leaveorbackPlatDto);
		}
		jsonData.put("list", arrayList);
		if(StringUtils.isNotBlank(parentId)) {
			if(StringUtils.isNotBlank(timeStr)) {
				redisUtil.setString("xlgl-getPlatNumber-"+parentId+"-"+timeStr, jsonArray);
			}else {
				redisUtil.setString("xlgl-getPlatNumber-"+parentId, jsonArray);
			}
		}else {
			redisUtil.setString("xlgl-getPlatNumber", jsonArray);
		}
		
		Response.json(jsonData);
    }
    
    /**
     * 训练管理-人员管理-地图人员详情接口
     * @author 李振楠 2020-12-16
     * @param parentId 当前用户所能看的局id，部管理不传值默认为 root ,不是部管理员传当前局id
     * @param province 省份 为必填 不能为空
     * @param organId 查询条件各局id
     * @param timeStr 查询条件时间
     * @param userName 查询人员名称
     * */
    @ResponseBody
    @RequestMapping("/platList")
    public void platList(String parentId,String province,String organId,String timeStr,String userName){
    	JSONObject jsonObject = this.platListAndExport(parentId,province,organId,timeStr,userName);
    	String jsonArray = jsonObject.getJSONArray("list").toString();
    	if(StringUtils.isNotBlank(parentId)) {
			if(StringUtils.isNotBlank(timeStr)) {
				redisUtil.setString("xlgl-getPlatNumber-"+parentId+"-"+timeStr+"-"+province, jsonArray);
			}else {
				redisUtil.setString("xlgl-getPlatNumber-"+parentId+"-"+province, jsonArray);
			}
		}else {
			redisUtil.setString("xlgl-getPlatNumber-"+province, jsonArray);
		}
 
    	Response.json(jsonObject);
    }
   
    private JSONObject platListAndExport(String parentId,String province,String organId,
    		String timeStr,String userName) {
    	LinkedMultiValueMap<String, Object> hashmap = new LinkedMultiValueMap<String, Object>();
    	hashmap.add("parentId", parentId);
    	hashmap.add("province", province);
    	hashmap.add("organId", organId);
    	hashmap.add("timeStr", timeStr);
    	hashmap.add("userName", userName);
    	BaseAppOrgMapped orgMapped = (BaseAppOrgMapped)baseAppOrgMappedService.orgMappedByOrgId("","root",AppConstant.APP_QXJGL);
		// 获取清销假app的接口
		String elecPath = orgMapped.getUrl() + AppInterfaceConstant.WEB_QXJ_XLGLAPICONTROLLER_PLATLIST;
		JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath, hashmap);
		return jsonData;
    }
    /**
     * 人员管理-地图单位树
     * */
    @ResponseBody
    @RequestMapping("/organTree")
    public void organTree() {
    	JSONObject jsonObject = new JSONObject();
    	boolean organStatus = this.getOrganStatus();
    	if(organStatus) {
    		jsonObject =this.allOrgTree("root");
    		jsonObject.put("status", organStatus);
    	}else {
    		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
        	BaseAppOrgan baseAppOrgan = baseAppOrganService.queryDeptNameByUserId(orgId);
        	jsonObject =this.allOrgTree(baseAppOrgan.getId());
    		jsonObject.put("status", organStatus);
    	}
    	Response.json(jsonObject);
    	
    }
    /**
     * 训练管理-人员管理-列表单位树
     * */
    @ResponseBody
    @RequestMapping("/organTreeListALL")
    public void organTreeALL(String organId) {
		long starTime = System.currentTimeMillis();
    	JSONObject json = new JSONObject();
    	JSONArray jsonArray = new JSONArray();
    	if(StringUtils.isNotBlank(organId)) {
			List<BaseAppOrgan> organs = baseAppOrganService.queryList(null);
			List<String> arrayList = new ArrayList<String>();
			arrayList = OrgUtil.getOrganTreeList(organs, organId, true, true, arrayList);
			String [] arr = arrayList.toArray(new String[arrayList.size()]);
//			String[] arr = new String[arrayList.size()];
//			for (int i = 0; i < arr.length; i++) {
//				arr[i] = arrayList.get(i);
//			}
			 List<BaseAppOrgan> queryListByIds = baseAppOrganService.queryListByIds(arr);
			 List<String> queryUserOrganId = baseAppUserService.queryUserOrganId(arr);
			 for (BaseAppOrgan baseAppOrgan : queryListByIds) {
				 if(queryUserOrganId.size()>0 && queryUserOrganId.contains(baseAppOrgan.getId())) {
					 JSONObject jsonObject = new JSONObject();
					 jsonObject.put("id", baseAppOrgan.getId());
					 jsonObject.put("name", baseAppOrgan.getName());
					 jsonArray.add(jsonObject);
				 }	
			}
			 json.put("list", jsonArray);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("app/xlgl/peopleManagementNew/organTreeListALL接口执行时间："+(endTime-starTime)+"毫秒!!!!!!!!!");
    	Response.json(json);
    	
    }
    
    private boolean getOrganStatus() {
    	boolean status  = false;
    	//0:超级管理员 ;1：部管理员；2：局管理员；3：即是部管理员又是局管理员;4:处管理员
    	String adminFlag = adminSetService.getAdminTypeByUserId(CurrentUser.getUserId());
    	if(adminFlag.equals("1")) {
    		status = true;
    	}
    	XlglRoleSet  xlglRoleSet =xlglRoleSetService.queryByuserId(CurrentUser.getUserId());
    	if(xlglRoleSet != null){
    		if(StringUtils.isNotBlank(xlglRoleSet.getRoleFlag())){
    			String roleFlag = xlglRoleSet.getRoleFlag();
    			if("1".equals(roleFlag) || "3".equals(roleFlag)){//首长和局长
    				status = true;
				}
    		}
    	}
    	return status;
    }
    private JSONObject allOrgTree(String organId) {
		if(StringUtil.isEmpty(organId)) {
			organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
		}
		List<BaseAppOrgan> organs = baseAppOrganService.queryList(null);
		List<BaseAppOrgan> listOrg=new ArrayList<BaseAppOrgan>();
		for(BaseAppOrgan org:organs) {
			String[] arr=org.getTreePath().split(",");
			if(arr.length<5) {
				listOrg.add(org);
			}
		}
		
		JSONObject list= OrgUtil.getOrganTree(listOrg, organId);
		return list;
	
    }
  /**  训练管理-人员管理-地图人员详情 导出 接口
    * @author 李振楠 2020-12-16
    * @param parentId 当前用户所能看的局id，部管理不传值默认为 root ,不是部管理员传当前局id
    * @param province 省份 为必填 不能为空
    * @param timeStr 查询条件时间
    */
    @ResponseBody
   	@RequestMapping("/exportPlat")
       public void export(HttpServletResponse response,String parentId,String province,
       		String timeStr) {
       	String time = "";
       	if(StringUtils.isNotBlank(timeStr)) {
       		time =timeStr;
       	}else {
       		time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
       	}
       	BaseAppOrgan queryObject = new BaseAppOrgan();
       	String jsonArray = "";
    	if(StringUtils.isNotBlank(parentId)) {
    	 	 queryObject = baseAppOrganService.queryObject(parentId);
			if(StringUtils.isNotBlank(timeStr)) {
				 jsonArray = redisUtil.getString("xlgl-getPlatNumber-"+parentId+"-"+timeStr+"-"+province);
			}else {
				jsonArray = redisUtil.getString("xlgl-getPlatNumber-"+parentId+"-"+province);
			}
		}else {
			queryObject = baseAppOrganService.queryObject("root");
			jsonArray = redisUtil.getString("xlgl-getPlatNumber-"+province);
		}
    	String strName = queryObject.getName()+"单位人员分布清单("+province+"-"+time+")";
       	List<LeaveorbackUserPlatDto> list = JSONArray.parseArray(jsonArray, LeaveorbackUserPlatDto.class);
   		String format = new SimpleDateFormat("yyyy-MM-ddHHmmss").format(new Date());
   		String fileName = queryObject.getName() +"单位人员分布详情"+ format + ".xls";
   		File tempFile = new File(filePath, fileName);
   		if (tempFile.exists()) {
   			tempFile.delete();
   		} else {
   			tempFile.getParentFile().mkdirs();
   		}
   		Map<String, Object> resultMap = new HashMap<String, Object>();
		InputStream is = null;
   		String[] title = { "序号", "人员姓名", "单位名称", "部门名称", "联系电话", "当前位置", "详细地址","在位状态","事由说明" };
   		try {
   			is = createExcelInfoFlie(list, title, fileName, strName);
   			
   			String fileNameStr = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
   			response.reset();
   			response.setContentType("application/octet-stream");
   			response.setCharacterEncoding("UTF-8");
   			response.setHeader("Content-Disposition", "attachment;filename=" + fileNameStr);
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
       /**
        *   训练管理-人员管理-地图人员详情 导出 接口
        * @author 李振楠 2020-12-16
        * @param list 导出数据
        * @param title 表头
        * @param fileName 文件名称
        * @param strName 表标题
        * 
        * */
   	private InputStream createExcelInfoFlie(List<LeaveorbackUserPlatDto> list, String[] title, String fileName,String strName) throws Exception {
   	FileOutputStream fout = null;
   	int titleInt = title.length;
   	try {
   		HSSFWorkbook wb = new HSSFWorkbook();
   		
   		HSSFCellStyle style = wb.createCellStyle();
   		style.setAlignment(HorizontalAlignment.CENTER);//样式左右居中
   		
   		HSSFSheet sheet = wb.createSheet();
   		CellRangeAddress region = new CellRangeAddress(0,0,0,titleInt);//起始行，结束行，起始列，结束列
   		sheet.addMergedRegion(region);
   		
   		HSSFRow row = sheet.createRow(0);
   		HSSFCell createCell = row.createCell(0);
   		createCell.setCellStyle(style);
   		createCell.setCellValue(strName);
   		
   		HSSFRow row1 = sheet.createRow(1);
   		for (int i = 1; i < title.length+1; i++) {
   			HSSFCell createCell2 = row1.createCell(i-1);
   			createCell2.setCellValue(title[i-1]);
   		}
   		for (int i = 2; i < list.size() + 2; i++) {
   			HSSFRow rows = sheet.createRow(i);
   			HSSFCell cell0 = rows.createCell(0);// 序号
   			cell0.setCellValue(i-1);

   			HSSFCell cell1 = rows.createCell(1);// 人员姓名
   			cell1.setCellValue(list.get(i - 2).getUserName());

   			HSSFCell cell2 = rows.createCell(2);// 单位名称
   			cell2.setCellValue(list.get(i - 2).getDeptName());

   			HSSFCell cell3 = rows.createCell(3);// 部门名称
   			cell3.setCellValue(list.get(i - 2).getOrganName());

   			HSSFCell cell4 = rows.createCell(4);// 联系电话
   			cell4.setCellValue(list.get(i - 2).getPhone());

   			HSSFCell cell5 = rows.createCell(5);// 当前位置
   			cell5.setCellValue(list.get(i - 2).getLocation());

   			HSSFCell cell6 = rows.createCell(6);// 详细地址
   			cell6.setCellValue(list.get(i - 2).getAddress());
   			
   			HSSFCell cell7 = rows.createCell(7);// 在位状态
   			cell7.setCellValue(list.get(i - 2).getStatus());
   			
   			HSSFCell cell8 = rows.createCell(8);// 在位状态
   			cell8.setCellValue(list.get(i - 2).getOrigin());
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
   	*训练管理-人员管理-地图人数  导出 接口
    * @author 李振楠 2020-12-16
    * @param parentId 当前用户所能看的局id，部管理不传值默认为 root ,不是部管理员传当前局id
    * @param timeStr 查询条件时间
   	 * 
   	 * */
    @ResponseBody
   	@RequestMapping("/exportPlatAndNumber")
       public void exportPlatAndNumber(HttpServletResponse response,String parentId,String timeStr) {
       	String time = "";
       	if(StringUtils.isNotBlank(timeStr)) {
       		time =timeStr;
       	}else {
       		time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
       	}
    	BaseAppOrgan queryObject = new BaseAppOrgan();
       	String jsonArray = "";
       	if(StringUtils.isNotBlank(parentId)) {
       		queryObject = baseAppOrganService.queryObject(parentId);
			if(StringUtils.isNotBlank(timeStr)) {
				jsonArray = redisUtil.getString("xlgl-getPlatNumber-"+parentId+"-"+timeStr);
			}else {
				jsonArray = redisUtil.getString("xlgl-getPlatNumber-"+parentId);
			}
		}else {
			queryObject = baseAppOrganService.queryObject("root");
			jsonArray = redisUtil.getString("xlgl-getPlatNumber");
		}
       	String strName = queryObject.getName()+"单位人员分布清单("+time+")";
		List<LeaveorbackPlatDto> list = JSONArray.parseArray(jsonArray, LeaveorbackPlatDto.class);
		List<LeaveorbackPlatDto> arrayList = new ArrayList<LeaveorbackPlatDto>();
		List<LeaveorbackPlatDto> listjingWai = new ArrayList<LeaveorbackPlatDto>();
		for (LeaveorbackPlatDto leaveorbackPlatDto : list) {
			if(leaveorbackPlatDto.getPlat().equals("北京")) {
				arrayList.add(leaveorbackPlatDto);
			}else {
				listjingWai.add(leaveorbackPlatDto);
			}
		}
		listjingWai.sort(Comparator.comparing(LeaveorbackPlatDto :: getNumber).reversed());
		for (LeaveorbackPlatDto leaveorbackPlatDto : listjingWai) {
			arrayList.add(leaveorbackPlatDto);
		}
		 
   		String format = new SimpleDateFormat("yyyy-MM-ddHHmmss").format(new Date());
   		String fileName = queryObject.getName()+"单位人员分布清单"+format+".xls";
   		File tempFile = new File(filePath, fileName);
   		if (tempFile.exists()) {
   			tempFile.delete();
   		} else {
   			tempFile.getParentFile().mkdirs();
   		}
   		Map<String, Object> resultMap = new HashMap<String, Object>();
   		InputStream is = null;
   		String[] title = { "序号", "地图", "人数" };
   		try {
   			is = createExcelPlatFlie(arrayList, title, fileName, strName);

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
    /**
     * @param strName 表头
     * */
	private InputStream createExcelPlatFlie(List<LeaveorbackPlatDto> list, String[] title, String fileName,String strName) throws Exception {
	FileOutputStream fout = null;
	int titleInt = title.length;
	try {
		HSSFWorkbook wb = new HSSFWorkbook();
		
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);//样式左右居中
		
		HSSFSheet sheet = wb.createSheet();
		CellRangeAddress region = new CellRangeAddress(0,0,0,titleInt);//起始行，结束行，起始列，结束列
		sheet.addMergedRegion(region);
		
		HSSFRow row = sheet.createRow(0);
		HSSFCell createCell = row.createCell(0);
   		createCell.setCellStyle(style);
		createCell.setCellValue(strName);
		
		HSSFRow row1 = sheet.createRow(1);
		for (int i = 1; i < title.length+1; i++) {
			HSSFCell createCell2 = row1.createCell(i-1);
			createCell2.setCellValue(title[i-1]);
		}
		for (int i = 2; i < list.size() + 2; i++) {
			HSSFRow rows = sheet.createRow(i);
			HSSFCell cell0 = rows.createCell(0);// 序号
			cell0.setCellValue(i-1);

			HSSFCell cell1 = rows.createCell(1);// 地图
			cell1.setCellValue(list.get(i - 2).getPlat());

			HSSFCell cell2 = rows.createCell(2);// 人数
			cell2.setCellValue(list.get(i - 2).getNumber());
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
