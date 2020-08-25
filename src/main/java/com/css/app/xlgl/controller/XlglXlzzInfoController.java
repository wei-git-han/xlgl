package com.css.app.xlgl.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.appconfig.service.BaseAppConfigService;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgan.util.OrgUtil;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.orgservice.OrgService;
import com.css.app.xlgl.entity.XlglPicture;
import com.css.app.xlgl.entity.XlglSubDocTracking;
import com.css.app.xlgl.entity.XlglXlzzInfo;
import com.css.app.xlgl.service.XlglPictureService;
import com.css.app.xlgl.service.XlglSubDocTrackingService;
import com.css.app.xlgl.service.XlglXlzzInfoService;
import com.css.base.utils.*;
import com.google.gson.JsonObject;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageHelper;
import org.thymeleaf.processor.ITextNodeProcessorMatcher;


/**
 * 训练组织基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 10:12:29
 *
 */
@Controller
@RequestMapping("/app/xlgl/xlglxlzzinfo")
public class XlglXlzzInfoController {
	@Autowired
	private XlglXlzzInfoService xlglXlzzInfoService;
	@Autowired
	private XlglSubDocTrackingService xlglSubDocTrackingService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;

	@Autowired
	private BaseAppUserService baseAppUserService;

	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;

	@Autowired
	private OrgService orgService;
	@Autowired
	private BaseAppConfigService baseAppConfigService;
	@Autowired
	private XlglPictureService xlglPictureService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglxlzzinfo:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglXlzzInfo> xlglXlzzInfoList = xlglXlzzInfoService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglXlzzInfoList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		String loginUser = CurrentUser.getUserId();
		XlglXlzzInfo xlglXlzzInfo = xlglXlzzInfoService.queryObject(id);
		//打开的同时，更新打开人的状态为已读
		XlglSubDocTracking xlglSubDocTracking = xlglSubDocTrackingService.queryInfo(id,loginUser);
		xlglSubDocTracking.setRead("1");
		xlglSubDocTrackingService.update(xlglSubDocTracking);
		xlglXlzzInfo.setStatus("1");//1为已读
		xlglXlzzInfo.setBaoming(xlglSubDocTracking.getBaoming());
		Response.json("xlglXlzzInfo", xlglXlzzInfo);
	}

	/**
	 * 查询某个文件所有的图片
	 * @param infoId
	 */
	@ResponseBody
	@RequestMapping("/pictureList")
	public void pictureList(String infoId){
		List<XlglPicture> list = new ArrayList<XlglPicture>();
		if(StringUtils.isNotBlank(infoId)){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("id",infoId);
			if(StringUtils.isNotBlank(infoId)){
				list = xlglPictureService.queryList(map);

			}
		}
		Response.json("list",list);
	}
	
	/**
	 * 保存
	 * type  视频是0；图片是1；文档是2
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglXlzzInfo xlglXlzzInfo,String pIds,String type){
		JSONObject jsonObject = new JSONObject();
		String fId = UUIDUtils.random();
		xlglXlzzInfo.setId(fId);
		xlglXlzzInfo.setCreateTime(new Date());
		xlglXlzzInfoService.save(xlglXlzzInfo);
		//保存上传图片，视频，文件
		if(StringUtils.isNotBlank(pIds)) {
			String[] ids = pIds.split(",");
			String[] types = type.split(",");
			xlglPictureService.deleteBatch(ids);
			for (int i = 0; i < ids.length; i++) {
				XlglPicture xlglPicture = new XlglPicture();
				xlglPicture.setId(UUIDUtils.random());
				xlglPicture.setFileId(fId);
				xlglPicture.setIsFirst("0");
				xlglPicture.setPictureId(ids[i]);
				xlglPicture.setSort("0");
				String typePicture = types[i];
				if("video/mp4".equals(typePicture)){
					xlglPicture.setPictureType("0");
				}else if("image/png".equals(typePicture)){
					xlglPicture.setPictureType("1");
				}else {
					xlglPicture.setPictureType("2");
				}
				xlglPictureService.save(xlglPicture);
			}
		}
		jsonObject.put("fileId",fId);
		jsonObject.put("result","success");
		Response.json(jsonObject);
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglxlzzinfo:update")
	public void update(@RequestBody XlglXlzzInfo xlglXlzzInfo){
		xlglXlzzInfoService.update(xlglXlzzInfo);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglxlzzinfo:delete")
	public void delete(@RequestBody String[] ids){
		xlglXlzzInfoService.deleteBatch(ids);
		
		Response.ok();
	}


	/**
	 * 获取当前登录人所在部门的训练跟踪情况
	 * @param infoId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getDateForDept")
	public void getDateForDept(String infoId) {
		Map<String, Object> map = new HashMap<String, Object>();
		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
		map.put("orgId", orgId);
		//获取了该局所有的部门id
		List<BaseAppOrgan> list = baseAppOrganService.queryAllDeptId(orgId);
		List listAllUser = new ArrayList();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				List<BaseAppUser> listUser = null;
				JSONObject jsonObject = new JSONObject();
				String deptId = list.get(i).getId();
				String deptName = list.get(i).getName();
				if (i == 0) {
					listUser = baseAppUserService.queryAllJuUserByDeptId(deptId,infoId);
				} else {
					listUser = baseAppUserService.queryAllUserByDeptId(deptId,infoId);
				}
				jsonObject.put("listUser",listUser);
				jsonObject.put("deptName",deptName);
				listAllUser.add(jsonObject);
			}

		}
		Response.json("listAllUser",listAllUser);
	}

	/**
	 * 局统计各处报名未报名个数
	 * @param infoId
	 */
	@ResponseBody
	@RequestMapping("/getDateForJu")
	public void getDateForJu(String infoId){
		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
		//获取了该局所有的部门id
		List<BaseAppOrgan> list = baseAppOrganService.queryAllDeptId(orgId);
		List listTotal = new ArrayList();
		if(list != null && list.size() > 0){
			for(int i=0;i<list.size();i++){
				JSONObject jsonObject = new JSONObject();
				String deptId = list.get(i).getId();
				String deptName = list.get(i).getName();
				int sum = baseAppUserService.queryBmCout(deptId,infoId,"1");//已报名
				int nsum = baseAppUserService.queryBmCout(deptId,infoId,"0");//未报名
				jsonObject.put("sum",sum);
				jsonObject.put("nsum",nsum);
				jsonObject.put("deptName",deptName);
				listTotal.add(jsonObject);
			}
		}

		Response.json("listTotal",listTotal);

	}

	/**
	 *更改个人训练情况
	 * @param infoId 文id
	 * @param userId  用户id
	 * @param status  0未报名，1已报名，2延后
	 */
	@ResponseBody
	@RequestMapping("/updateStatus")
	public void updateStatus(String infoId,String userId,String status){
		XlglSubDocTracking xlglSubDocTracking = xlglSubDocTrackingService.queryStatusByInfoIdAndUserId(infoId,userId);
		xlglSubDocTracking.setBaoming(status);
		xlglSubDocTrackingService.update(xlglSubDocTracking);
		Response.json("result","success");
	}

	/**
	 * 详情里面大讲堂单科目和所有局的参训率
	 */
	@ResponseBody
	@RequestMapping("/getPerData")
	public void getPerData(String fileId){
		int sum = 0;//每一个课程在有效期内所有的有效人员相加
		int count1 = 0;//每一个课程在有效期内所有参训人员相加
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject1 = new JSONObject();
		List<BaseAppOrgan> allDepts = baseAppOrganService.queryAllDeptIds();
		if(allDepts != null && allDepts.size() > 0){
			for(BaseAppOrgan baseAppOrgan : allDepts){
				String CurrentOrganId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
				JSONObject jsonObject = new JSONObject();
				String organId = baseAppOrgan.getId();
				Map<String, Object> map = new HashMap<String, Object>();
				if (com.css.base.utils.StringUtils.isNotBlank(organId) && !com.css.base.utils.StringUtils.equals("root", organId)) {
					//organId = allOrgIds(organId);
					//map.put("orgIds", organId.split(","));
					map.put("orgIds", organId);
				}
				XlglXlzzInfo xlglXlzzInfo = xlglXlzzInfoService.queryObject(fileId);
				String time = xlglXlzzInfo.getExerciseTime();
				map.put("time",time);
				int allCount = baseAppUserService.queryListAllYx(map);//查询所有的有效人员
				sum += allCount;

				//参训的人待会议那传过来，更新XLGL_SUB_DOC_TRACKING表的IS_WORK字段

				///////////////////////////////////////////////

				int count = xlglSubDocTrackingService.queryCount(fileId);
				count1 +=count;

				float lv = count/allCount;
				if(baseAppOrgan.getId().equals(CurrentOrganId)){
					jsonObject.put("isCurrentDept",true);
				}else {
					jsonObject.put("isCurrentDept",false);
				}
				jsonObject.put("lv",lv);//详情里面大讲堂单科目参训率
				jsonObject.put("name",baseAppOrgan.getName());
				jsonArray.add(jsonObject);
			}
		}
		float Alllv = count1/sum;
		jsonObject1.put("result",jsonArray);
		jsonObject1.put("Alllv",Alllv);//大讲堂列表各单位年度参训完成情况

		Response.json(jsonObject1);
	}



	private String allOrgIds(String orgId) {
		String ret = "";
		if (com.css.base.utils.StringUtils.isNotBlank(orgId)) {
			BaseAppOrgan org = baseAppOrganService.queryObject(orgId);
			if (org != null) {
				ret += org.getId() + ",";
				List<BaseAppOrgan> list = baseAppOrganService.getSubOrg(org.getId());
				if (list != null && list.size() > 0) {
					for (BaseAppOrgan organ : list) {
						ret += allOrgIds(organ.getId());
					}
				}
			}
		}
		return ret;
	}

	/**
	 * 强装兴装大讲堂列表
	 * type  1是已报名 2是延后
	 */
	@ResponseBody
	@RequestMapping("/getDjtList")
	public void getDjtList(String type){
		String userId = CurrentUser.getUserId();
		JSONArray jsonArray = new JSONArray();
		//查出所有的文id
		List<String> listInfoIds = xlglSubDocTrackingService.queryAllInfos(userId,type);
		if(listInfoIds != null && listInfoIds.size() > 0){
			for(String infoId : listInfoIds){
				JSONObject jsonObject = new JSONObject();
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("infoId",infoId);
				List<XlglPicture> listPicture = xlglPictureService.queryAllInfoByInfoId(map);
				jsonObject.put("listPicture",listPicture);
				jsonArray.add(jsonObject);
			}
		}

		Response.json("result",jsonArray);
	}

	/**
	 * 强装大讲堂详情页
	 * infoId 文id，id 视频保存的id（picture表的id）
	 */
	@ResponseBody
	@RequestMapping("/getInfo")
	public void getInfo(String infoId,String id){
		XlglPicture xlglPicture = xlglPictureService.queryObject(id);
		XlglSubDocTracking xlglSubDocTracking = xlglSubDocTrackingService.queryInfo(infoId,CurrentUser.getUserId());
		xlglSubDocTracking.setIsWork("1");
		xlglSubDocTrackingService.update(xlglSubDocTracking);
		Response.json("xlglPicture",xlglPicture);

	}

	/**
	 * 大讲堂列表参训完成率
	 */
	@ResponseBody
	@RequestMapping("/getWcl")
	public void getWcl(){
		String userId = CurrentUser.getUserId();
		int sum = xlglSubDocTrackingService.queryAllCount(userId);
		int count = xlglSubDocTrackingService.quereyWcCount(userId);
		float f = count/sum;
		Response.json("lv",f);

	}

	/**
	 * 训练组织列表参训完成率
	 */
	@ResponseBody
	@RequestMapping("/getCxwcl")
	public void getCxwcl() {
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<>();
		String userId = CurrentUser.getUserId();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy");
		Date date = new Date();
		String year = sd.format(date);
		map.put("userId", userId);
		map.put("year", year);
		int count = xlglSubDocTrackingService.queryCurrentYear(map);//本年度大讲堂数+日常训练数

		int ycx = xlglSubDocTrackingService.queryCxCount(map);//已参训的大讲堂数

		int ybm = xlglSubDocTrackingService.queryBmCount(map);
		float f = 0.0f;
		if (count > 0) {
			f = (ycx + ybm) / count;
		}
		jsonObject.put("wcl",f);
		jsonObject.put("ywc",ycx+ybm);
		jsonObject.put("bk",count - ybm - ycx);
		Response.json(jsonObject);
	}




	
}
