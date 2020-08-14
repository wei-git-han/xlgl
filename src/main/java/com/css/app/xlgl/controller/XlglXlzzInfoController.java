package com.css.app.xlgl.controller;

import java.util.*;

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
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglXlzzInfo xlglXlzzInfo,String pIds){
		String fId = UUIDUtils.random();
		xlglXlzzInfo.setId(fId);
		xlglXlzzInfo.setCreateTime(new Date());
		xlglXlzzInfoService.save(xlglXlzzInfo);
		//保存上传图片，视频，文件
		if(StringUtils.isNotBlank(pIds)) {
			String[] ids = pIds.split(",");
			xlglPictureService.deleteBatch(ids);
			for (int i = 0; i < ids.length; i++) {
				XlglPicture xlglPicture = new XlglPicture();
				xlglPicture.setId(UUIDUtils.random());
				xlglPicture.setFileId(fId);
				xlglPicture.setIsFirst("0");
				xlglPicture.setPictureId(ids[i]);
				xlglPicture.setSort("0");
				xlglPictureService.save(xlglPicture);
			}
		}
		Response.json("result","success");
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

	
}
