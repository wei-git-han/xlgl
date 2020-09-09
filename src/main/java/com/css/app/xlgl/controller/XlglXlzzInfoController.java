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
import com.css.app.xlgl.dto.XlglConfirmDto;
import com.css.app.xlgl.entity.*;
import com.css.app.xlgl.service.*;
import com.css.base.utils.*;
import com.google.gson.JsonObject;
import com.sun.org.apache.xerces.internal.xs.LSInputList;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.http.cookie.SM;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageHelper;
import org.springframework.web.context.request.NativeWebRequest;
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
	@Autowired
	private XlglSubDocInfoService xlglSubDocInfoService;
	@Autowired
	private XlglConfirmService xlglConfirmService;

	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer pagesize){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, pagesize);
		
		//查询列表数据
		List<XlglXlzzInfo> xlglXlzzInfoList = xlglXlzzInfoService.queryList(map);
		if(xlglXlzzInfoList != null && xlglXlzzInfoList.size() > 0){
			for(XlglXlzzInfo xlglXlzzInfo : xlglXlzzInfoList){
				xlglXlzzInfo.setInfoId(xlglXlzzInfo.getId());
			}
		}
		
//		PageUtils pageUtil = new PageUtils(xlglXlzzInfoList);
//		Response.json("page",pageUtil);

		GwPageUtils pageUtil = new GwPageUtils(xlglXlzzInfoList);
		Response.json(pageUtil);
	}

	/**
	 *是否有编辑权限
	 */
	@ResponseBody
	@RequestMapping("/getIsHavePerssion")
	public void getIsHavePerssion(String id) {
		String currentUserId = CurrentUser.getUserId();
		XlglXlzzInfo xlglXlzzInfo = xlglXlzzInfoService.queryObject(id);
		if (xlglXlzzInfo != null) {
			if (StringUtils.isNotBlank(xlglXlzzInfo.getCreator())) {
				if (currentUserId.equals(xlglXlzzInfo.getCreator())) {
					Response.json("result", "success");
				} else {
					Response.json("result", "fail");
				}
			} else {
				Response.json("result", "fail");
			}
		} else {
			Response.json("result", "fail");
		}
	}
	
	
	/**
	 * 信息
	 * flag 0:局待转发；1：我的训练；2：全部训练
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id,String flag) {
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<>();
		String loginUser = CurrentUser.getUserId();
		String deptName = CurrentUser.getOrgName();
		XlglXlzzInfo xlglXlzzInfo = xlglXlzzInfoService.queryObject(id);
		//打开的同时，更新打开人的状态为已读
		XlglSubDocTracking xlglSubDocTracking = xlglSubDocTrackingService.queryInfo(id, loginUser);
		if (xlglSubDocTracking != null) {
			if (xlglSubDocTracking != null) {
				xlglSubDocTracking.setRead("1");
				xlglSubDocTrackingService.update(xlglSubDocTracking);
				if (StringUtils.isNotBlank(xlglSubDocTracking.getBaoming())) {
					xlglXlzzInfo.setBaoming(xlglSubDocTracking.getBaoming());
				}
				if (StringUtils.isNotBlank(xlglSubDocTracking.getReason())) {
					xlglXlzzInfo.setReason(xlglSubDocTracking.getReason());
				}
			}
			xlglXlzzInfo.setStatus("1");//1为已读

		}
		xlglXlzzInfo.setFbDept(deptName);
		map.put("fileId", id);
		List<XlglPicture> list = xlglPictureService.queryAllInfoByInfoId(map);
		List listVedio = new ArrayList();
		List listPicture = new ArrayList();
		List listFile = new ArrayList();
		if (list != null && list.size() > 0) {
			for (XlglPicture xlglPicture : list) {
				JSONObject jsVedio = new JSONObject();
				JSONObject jsPicture = new JSONObject();
				JSONObject jsFile = new JSONObject();
				String type = xlglPicture.getPictureType();
				if ("0".equals(type)) {
					jsVedio.put("pictureId", xlglPicture.getPictureId());
					jsVedio.put("pictureName", xlglPicture.getPictureName());
					jsVedio.put("type","video/mp4");
					listVedio.add(jsVedio);
				} else if ("1".equals(type)) {
					jsPicture.put("pictureId", xlglPicture.getPictureId());
					jsPicture.put("pictureName", xlglPicture.getPictureName());
					jsPicture.put("type","image/png");
					listPicture.add(jsPicture);
				} else {
					jsFile.put("pictureId", xlglPicture.getPictureId());
					jsFile.put("pictureName", xlglPicture.getPictureName());
					jsFile.put("type","application/ofd");
					listFile.add(jsFile);
				}
			}
		}

		if("2".equals(flag)) {//全部的上下翻页
			if (StringUtils.isNotBlank(xlglXlzzInfo.getSort())) {
				String preId = "";
				String sufId = "";
				String sort = xlglXlzzInfo.getSort();
				int sortInt = Integer.parseInt(sort);
				Map<String, Object> mapSort = new HashMap<>();
				int sortPre = sortInt - 1;
				int sortSuf = sortInt + 1;
				mapSort.put("sortPre", String.valueOf(sortPre));
				mapSort.put("sortSuf", String.valueOf(sortSuf));
				List<XlglXlzzInfo> listSort = xlglXlzzInfoService.queryBySort(mapSort);
				if (listSort != null && listSort.size() > 0) {
					for (XlglXlzzInfo xlglXlzzInfo1 : listSort) {
						String sortNew = xlglXlzzInfo1.getSort();
						if (StringUtils.isNotBlank(sortNew)) {
							if (sortNew.equals(String.valueOf(sortPre))) {
								preId = xlglXlzzInfo1.getId();
							} else if (sortNew.equals(String.valueOf(sortSuf))) {
								sufId = xlglXlzzInfo1.getId();
							}
						}
					}
				}
				if (StringUtils.isBlank(preId)) {
					preId = "no";
				}
				if (StringUtils.isBlank(sufId)) {
					sufId = "no";
				}
				jsonObject.put("preId", preId);
				jsonObject.put("sufId", sufId);
			}
		}else if("1".equals(flag)){//我的训练
			XlglSubDocTracking Tracking = xlglSubDocTrackingService.querySortByInfoIdAndUserId(id,CurrentUser.getUserId());
			if(Tracking != null){
				if(StringUtils.isNotBlank(Tracking.getSort())){
					String preId = "";
					String sufId = "";
					Map<String,Object> mapSort = new HashMap<>();
					String sort = Tracking.getSort();
					String sortPre = String.valueOf(Integer.parseInt(sort) - 1);
					String sortSuf = String.valueOf(Integer.parseInt(sort) + 1);
					SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					mapSort.put("sortPre",sortPre);
					mapSort.put("sortSuf",sortSuf);
					mapSort.put("receiveId",CurrentUser.getUserId());
					mapSort.put("time",format.format(new Date()));
					List<XlglSubDocTracking> subDocTrackingList = xlglSubDocTrackingService.queryBySort(mapSort);
					if(subDocTrackingList != null && subDocTrackingList.size() > 0){
						for(XlglSubDocTracking xlglSubDocTracking1 : subDocTrackingList){
								String sortNew = xlglSubDocTracking1.getSort();
							if (StringUtils.isNotBlank(sortNew)) {
								if (sortNew.equals(String.valueOf(sortPre))) {
									preId = xlglSubDocTracking1.getInfoId();
								} else if (sortNew.equals(String.valueOf(sortSuf))) {
									sufId = xlglSubDocTracking1.getInfoId();
								}
							}
						}
					}
					if (StringUtils.isBlank(preId)) {
						preId = "no";
					}
					if (StringUtils.isBlank(sufId)) {
						sufId = "no";
					}
					jsonObject.put("preId", preId);
					jsonObject.put("sufId", sufId);
				}
			}

		}else if("0".equals(flag)){//0:局待转发
			String deptId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
			XlglSubDocInfo xlglSubDocInfo = xlglSubDocInfoService.querySortByInfoIdAndDeptId(id,deptId);
			if(xlglSubDocInfo != null){
				String preId = "";
				String sufId = "";
				String sort = xlglSubDocInfo.getSort();
				if(StringUtils.isNotBlank(sort)){
					Map<String,Object> mapSort = new HashedMap();
					String sortPre = String.valueOf(Integer.parseInt(sort) - 1);
					String sortSuf = String.valueOf(Integer.parseInt(sort) + 1);
					SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					mapSort.put("sortPre",sortPre);
					mapSort.put("sortSuf",sortSuf);
					mapSort.put("orgId",deptId);
					mapSort.put("time",format.format(new Date()));
					List<XlglSubDocInfo> subDocInfoList = xlglSubDocInfoService.queryBySort(mapSort);
					if(subDocInfoList != null && subDocInfoList.size() > 0){
						for(XlglSubDocInfo xlglSubDocInfo1 : subDocInfoList){
							String sortNew = xlglSubDocInfo1.getSort();
							if(StringUtils.isNotBlank(sortNew)){
								if(sortPre.equals(sortNew)){
									preId = xlglSubDocInfo1.getInfoId();
								}else if(sortSuf.equals(sortNew)){
									sufId = xlglSubDocInfo1.getInfoId();
								}
							}
						}
					}
					if (StringUtils.isBlank(preId)) {
						preId = "no";
					}
					if (StringUtils.isBlank(sufId)) {
						sufId = "no";
					}
					jsonObject.put("preId", preId);
					jsonObject.put("sufId", sufId);
				}
			}
		}



		jsonObject.put("listVedio", listVedio);
		jsonObject.put("listPicture", listPicture);
		jsonObject.put("listFile", listFile);
		jsonObject.put("xlglXlzzInfo", xlglXlzzInfo);
		Response.json(jsonObject);
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
	public void save(XlglXlzzInfo xlglXlzzInfo,String pIds,String type,String pidNames){
		JSONObject jsonObject = new JSONObject();
		String fId = null;
		if(StringUtils.isNotBlank(xlglXlzzInfo.getId())){
			fId = xlglXlzzInfo.getId();
			xlglXlzzInfoService.update(xlglXlzzInfo);
		}else {
			fId = UUIDUtils.random();
			xlglXlzzInfo.setId(fId);
			xlglXlzzInfo.setCreator(CurrentUser.getUserId());
			xlglXlzzInfo.setCreateTime(new Date());
			xlglXlzzInfoService.save(xlglXlzzInfo);
		}
		//保存上传图片，视频，文件
		if(StringUtils.isNotBlank(pIds)) {
			String[] ids = pIds.split(",");
			String[] types = type.split(",");
			String[] names = pidNames.split(",");
			xlglPictureService.deleteByInfoId(fId);
			for (int i = 0; i < ids.length; i++) {
				XlglPicture xlglPicture = new XlglPicture();
				xlglPicture.setId(UUIDUtils.random());
				xlglPicture.setFileId(fId);
				xlglPicture.setIsFirst("0");
				xlglPicture.setPictureId(ids[i]);
				xlglPicture.setSort("0");
				xlglPicture.setPictureName(names[i]);
				String typePicture = types[i];
				String[] pictureType = typePicture.split("/");
				if("video".equals(pictureType[0])){
					xlglPicture.setPictureType("0");
				}else if("image".equals(pictureType[0])){
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
	public void delete(String id){
		String[] ids = id.split(",");
		xlglXlzzInfoService.deleteBatch(ids);
		Response.json("result","success");
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
	public void getDateForJu(String id){
		String infoId = id;
		int ybm = 0;
		int wbm = 0;
		JSONObject jsonObject2 = new JSONObject();
		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
		String orgName = baseAppOrganService.queryObject(orgId).getName();
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
				int yhSum = baseAppUserService.queryBmCout(deptId,infoId,"2");//延后报名
				ybm += sum;
				wbm += nsum;
				int yjs = baseAppUserService.queryYjs(deptId,infoId);//已接受
				int wjs = baseAppUserService.queryWjs(deptId,infoId);//未接受
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("deptId",deptId);
				map.put("infoId",infoId);
//				XlglConfirmDto xlglConfirmDto = xlglConfirmService.queryPerDeptInfo(map);
//				String status = null;
//				if(xlglConfirmDto != null){
//					status = xlglConfirmDto.getStatus();
//				}else {
//					status = "0";
//				}
//				List<BaseAppUser> listUser = null;
//				if (i == 0) {
//					listUser = baseAppUserService.queryAllJuUserByDeptId(deptId,infoId);
//				} else {
//					listUser = baseAppUserService.queryAllUserByDeptId(deptId,infoId);
//				}

				List<XlglConfirm> xlglConfirmList = xlglConfirmService.queryByInfoIdAndDeptId(deptId,infoId);
				if(xlglConfirmList != null && xlglConfirmList.size() > 0){
					jsonObject.put("confirm",true);
				}else {
					jsonObject.put("confirm",false);
				}
				jsonObject.put("sum",sum);//已报名
				jsonObject.put("nsum",nsum);//未报名
				jsonObject.put("yhSum",yhSum);//延后报名
				jsonObject.put("yjs",yjs);
				jsonObject.put("wjs",wjs);
				jsonObject.put("deptName",deptName);
				jsonObject.put("deptId",deptId);
				//jsonObject.put("isConfirm",status);
				//jsonObject.put("listUser",listUser);
				listTotal.add(jsonObject);
			}
		}
		Map<String,Object> map1 = new HashMap<String,Object>();
		String organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
		int ycx = xlglSubDocTrackingService.queryAllCxByInfoId(infoId,orgId);//局内已参训
		int bk = xlglSubDocTrackingService.queryAllBkByInfoId(infoId,orgId);//局内未参训
		map1.put("deptId",organId);
		map1.put("infoId",infoId);
		String confirm = xlglConfirmService.queryConfromForJu(map1);//局的已确认情况
		if(StringUtils.isNotBlank(confirm) && "1".equals(confirm)){
			confirm = "1";
		}else {
			confirm = "0";
		}

		//获取了该局所有的部门id
		List<BaseAppOrgan> list3 = baseAppOrganService.queryAllDeptId(orgId);
		List listAllUser = new ArrayList();
		if (list3 != null && list3.size() > 0) {
			for (int i = 0; i < list3.size(); i++) {
				List<BaseAppUser> listUser = null;
				JSONObject jsonObject = new JSONObject();
				String deptId = list3.get(i).getId();
				String deptName = list3.get(i).getName();
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

		jsonObject2.put("ycx",ycx);
		jsonObject2.put("bk",bk);
		int sum = ycx + bk;
		float t = 0.0f;
		if(sum > 0){
			t = ycx/(ycx+bk);
		}else {
			t = 0.0f;
		}
		jsonObject2.put("cxl",t);//参训率
		jsonObject2.put("listTotal",listTotal);
		jsonObject2.put("confirm",confirm);
		jsonObject2.put("ybm",ybm);
		jsonObject2.put("wbm",wbm);
		jsonObject2.put("listAllUser",listAllUser);
		jsonObject2.put("junName",orgName);
		Response.json(jsonObject2);

	}

	/**
	 * 训练跟踪部管理员看到的信息
	 * 所有的局的信息
	 * @param id
	 */
	@ResponseBody
	@RequestMapping("/getDateForAll")
	public void getDateForAll(String id){
		JSONArray jsonArray = new JSONArray();
		JSONObject object = new JSONObject();
		List<BaseAppOrgan> allList = baseAppOrganService.queryAllDeptIds();
		if(allList != null && allList.size() > 0){
			for(BaseAppOrgan baseAppOrgan : allList){
				String judeptId = baseAppOrgan.getId();//获取局id
				String juName = baseAppOrgan.getName();//获取局名字
				String infoId = id;
				int ybm = 0;
				int wbm = 0;
				JSONObject jsonObject2 = new JSONObject();
				String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
				//获取了该局所有的部门id
				List<BaseAppOrgan> list = baseAppOrganService.queryAllDeptId(judeptId);
				List listTotal = new ArrayList();
				if(list != null && list.size() > 0){
					for(int i=0;i<list.size();i++){
						JSONObject jsonObject = new JSONObject();
						String deptId = list.get(i).getId();
						String deptName = list.get(i).getName();
						int sum = baseAppUserService.queryBmCout(deptId,infoId,"1");//已报名
						int nsum = baseAppUserService.queryBmCout(deptId,infoId,"0");//未报名
						int yhSum = baseAppUserService.queryBmCout(deptId,infoId,"2");//延后报名
						ybm += sum;
						wbm += nsum;
						int yjs = baseAppUserService.queryYjs(deptId,infoId);//已接受
						int wjs = baseAppUserService.queryWjs(deptId,infoId);//未接受
						Map<String,Object> map = new HashMap<String,Object>();
						map.put("deptId",deptId);
						map.put("infoId",infoId);
//						XlglConfirmDto xlglConfirmDto = xlglConfirmService.queryPerDeptInfo(map);
//						String status = null;
//						if(xlglConfirmDto != null){
//							status = xlglConfirmDto.getStatus();
//						}else {
//							status = "0";
//						}
//				List<BaseAppUser> listUser = null;
//				if (i == 0) {
//					listUser = baseAppUserService.queryAllJuUserByDeptId(deptId,infoId);
//				} else {
//					listUser = baseAppUserService.queryAllUserByDeptId(deptId,infoId);
//				}

						List<XlglConfirm> xlglConfirmList = xlglConfirmService.queryByInfoIdAndDeptId(deptId,infoId);
						if(xlglConfirmList != null && xlglConfirmList.size() > 0){
							jsonObject.put("confirm",true);
						}else {
							jsonObject.put("confirm",false);
						}
						jsonObject.put("sum",sum);//已报名
						jsonObject.put("nsum",nsum);//未报名
						jsonObject.put("yhSum",yhSum);//延后报名
						jsonObject.put("yjs",yjs);
						jsonObject.put("wjs",wjs);
						jsonObject.put("deptName",deptName);
						jsonObject.put("deptId",deptId);
						//jsonObject.put("isConfirm",status);
						//jsonObject.put("listUser",listUser);
						listTotal.add(jsonObject);
					}
				}
				Map<String,Object> map1 = new HashMap<String,Object>();
				String organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
				int ycx = xlglSubDocTrackingService.queryAllCxByInfoId(infoId,judeptId);//局内已参训
				int bk = xlglSubDocTrackingService.queryAllBkByInfoId(infoId,judeptId);//局内未参训
				map1.put("deptId",organId);
				map1.put("infoId",infoId);
				String confirm = xlglConfirmService.queryConfromForJu(map1);//局的已确认情况
				if(StringUtils.isNotBlank(confirm) && "1".equals(confirm)){
					confirm = "1";
				}else {
					confirm = "0";
				}

				//获取了该局所有的部门id
				List<BaseAppOrgan> list3 = baseAppOrganService.queryAllDeptId(judeptId);
				List listAllUser = new ArrayList();
				if (list3 != null && list3.size() > 0) {
					for (int i = 0; i < list3.size(); i++) {
						List<BaseAppUser> listUser = null;
						JSONObject jsonObject = new JSONObject();
						String deptId = list3.get(i).getId();
						String deptName = list3.get(i).getName();
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

				jsonObject2.put("ycx",ycx);
				jsonObject2.put("bk",bk);
				int sum = ycx + bk;
				float t = 0.0f;
				if(sum > 0){
					t = ycx/(ycx+bk);
				}else {
					t = 0.0f;
				}
				jsonObject2.put("cxl",t);//参训率
				jsonObject2.put("listTotal",listTotal);
				jsonObject2.put("confirm",confirm);
				jsonObject2.put("ybm",ybm);
				jsonObject2.put("wbm",wbm);
				jsonObject2.put("listAllUser",listAllUser);
				jsonObject2.put("juName",juName);
				jsonArray.add(jsonObject2);
			}
		}
		object.put("result","success");
		object.put("list",jsonArray);
		Response.json(object);

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
				float lv = 0.0f;
				if(allCount ==0){
					lv = 0;
				}else {
					lv = count/allCount;
				}

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
		float Alllv = 0.0f;
		if(sum == 0){
			Alllv = 0;
		}else {
			Alllv = count1/sum;
		}
		//float Alllv = count1/sum;
		//在编人数
		int zbSum = baseAppUserService.getAllZbSum();
		jsonObject1.put("result",jsonArray);
		jsonObject1.put("Alllv",Alllv);//大讲堂列表各单位年度参训完成率
		jsonObject1.put("zbSum",zbSum);//在编人数
		int cxSum = xlglSubDocTrackingService.queryAllCx(fileId);//已参训
		jsonObject1.put("cxSum",cxSum);//已参训
		int yhSum = xlglSubDocTrackingService.queryAllYh(fileId);//延后参训,缺席
		jsonObject1.put("yhSum",yhSum);

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
	 * type  0是未开始 1是历史学习
	 * flag 0是大讲堂信息 1是历年课堂
	 */
	@ResponseBody
	@RequestMapping("/getDjtList")
	public void getDjtList(Integer page, Integer limit,String type,String flag,String search) {
		Map<String, Object> map1 = new HashMap<>();
		String userId = CurrentUser.getUserId();
		JSONArray jsonArray = new JSONArray();
		//查出所有的文id
		map1.put("userId", userId);
		map1.put("type", type);
		map1.put("search", search);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map1.put("time", format.format(new Date()));
		List<XlglSubDocTracking> listInfoIds = null;
		PageHelper.startPage(page, limit);
		if ("0".equals(flag)) {
			listInfoIds = xlglSubDocTrackingService.queryAllInfos(map1);
		} else {
			listInfoIds = xlglSubDocTrackingService.queryAllYear(map1);
		}
		//List<XlglSubDocTracking> listInfoIds = xlglSubDocTrackingService.queryAllInfos(map1);
		if (listInfoIds != null && listInfoIds.size() > 0) {
			for (XlglSubDocTracking xlglSubDocTracking : listInfoIds) {
				JSONObject jsonObject = new JSONObject();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("infoId", xlglSubDocTracking.getInfoId());
				List<XlglPicture> listPicture = xlglPictureService.queryAllVedioByInfoId(map);
				if (listPicture.size() == 0) {//未上传
					jsonObject.put("isUpload", true);
					xlglSubDocTracking.setIsUpload("true");
				} else {
					jsonObject.put("isUpload", false);
					xlglSubDocTracking.setIsUpload("false");
				}
				List list = new ArrayList();
				String pictrueIds = "";
				if (listPicture != null && listPicture.size() > 0) {
					for (XlglPicture xlglPicture : listPicture) {
						list.add(xlglPicture.getPictureId());
					}
				}
				jsonObject.put("picturePath", xlglSubDocTracking.getPicturePath());
				jsonObject.put("baoming", xlglSubDocTracking.getBaoming());//2是需补课
				jsonObject.put("listPictureIds", list);
				jsonObject.put("type", type);
				jsonObject.put("title", xlglSubDocTracking.getTitle());
				jsonObject.put("startTime", xlglSubDocTracking.getExerciseTime());
				jsonObject.put("sendPeople", xlglSubDocTracking.getSenderName());
				jsonObject.put("infoId", xlglSubDocTracking.getInfoId());
				jsonArray.add(jsonObject);

				xlglSubDocTracking.setType(type);
				xlglSubDocTracking.setListPictureIds(list);

			}
		}
		//一个文里面可能有多个视频，在大讲堂里面，一个视频算一条数据，要把所有的视频数遍历出来，没有视频的也得算一条数据
		int sum = 0;
		if(listInfoIds != null && listInfoIds.size() > 0) {
			for (int i = 0; i < listInfoIds.size(); i++) {
				sum += listInfoIds.get(i).getListPictureIds().size() == 0 ? 1 : listInfoIds.get(i).getListPictureIds().size();
			}
		}
		PageUtils pageUtil = new PageUtils(listInfoIds);
		pageUtil.setTotalCount(sum);
		Response.json("page", pageUtil);
		//Response.json("result", jsonArray);
	}

	/**
	 * 强装大讲堂详情页
	 * infoId 文id，id 视频保存的id（picture表的id）
	 */
	@ResponseBody
	@RequestMapping("/getInfo")
	public void getInfo(String infoId,String id){
		JSONObject jsonObject = new JSONObject();
		Map<String,Object> map = new HashMap<>();
		map.put("id",infoId);
		map.put("type","1");
		XlglXlzzInfo xlglXlzzInfo = xlglXlzzInfoService.queryObject(infoId);
		if(StringUtils.isNotBlank(id)){
			XlglPicture xlglPicture = xlglPictureService.queryVedio(id);
			xlglPicture.setTitle(xlglXlzzInfo.getTitle());
			xlglPicture.setExerciseTime(xlglXlzzInfo.getExerciseTime());
			jsonObject.put("xlglPicture",xlglPicture);
		}
		List<XlglPicture> list = xlglPictureService.queryList(map);
		XlglSubDocTracking xlglSubDocTracking = xlglSubDocTrackingService.queryInfo(infoId,CurrentUser.getUserId());
		if(xlglSubDocTracking != null){
			xlglSubDocTracking.setIsWork("1");
			xlglSubDocTrackingService.update(xlglSubDocTracking);
		}
		jsonObject.put("title",xlglXlzzInfo.getTitle());
		jsonObject.put("time",xlglXlzzInfo.getExerciseTime());
		jsonObject.put("list",list);
		Response.json(jsonObject);

	}

	/**
	 * 大讲堂列表参训完成率
	 */
	@ResponseBody
	@RequestMapping("/getWcl")
	public void getWcl() {
		int sum = 0;
		int count = 0;
		int bk = 0;
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		JSONObject jsonObject = new JSONObject();
		String userId = CurrentUser.getUserId();
		sum = xlglSubDocTrackingService.queryAllCount(userId, year);//所有的课程
		count = xlglSubDocTrackingService.quereyWcCount(userId, year);//已参训的课程
		if (sum > 0) {
			bk = sum - count;
			float f = count / sum;
			jsonObject.put("wcl", f);
			jsonObject.put("ywc", count);
			jsonObject.put("bk", bk);
		} else {
			jsonObject.put("wcl", "0");
			jsonObject.put("ywc", "0");
			jsonObject.put("bk", "0");
		}
		Response.json(jsonObject);

	}

	/**
	 * 训练组织列表参训完成率,已完成，需补考
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

	/**
	 * 大讲堂列表的各单位年度参训完成情况
	 */
	@ResponseBody
	@RequestMapping("/getPerDeptWcl")
	public void getPerDeptWcl(){
		Map<String,Object> map = new HashMap<>();
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
		List<XlglSubDocInfo> list = xlglSubDocInfoService.queryAllClass(orgId,year);
		int s = 0;
		int cxCount = 0;
		if(list != null && list.size() > 0){
//			for(XlglSubDocInfo xlglSubDocInfo : list){
//				//String exerciseTime = xlglSubDocInfo.getExerciseTime();//每一个的截止时间
				int count = baseAppUserService.queryListAllYxCount();//有效的人数，不能计算出每一个课程在有效期之前的有效人数
//				int cxCount = xlglSubDocTrackingService.queryAllYx(xlglSubDocInfo.getInfoId(),year);//参训人数
//
//			}
			int size = list.size();
			s = count * size;//总的有效人
			cxCount = xlglSubDocTrackingService.queryAllYx(year);
		}

	}


//	@ResponseBody
//	@RequestMapping("/getCurrentDoneInfo")
//	public void getCurrentDoneInfo(String infoId) {
//		JSONObject jsonObject = new JSONObject();
//		Map<String, Object> map = new HashMap<>();
//		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
//		int yxCount = baseAppUserService.queryYxCount(orgId);//当前局的有效人数
//		map.put("infoId", infoId);
//		map.put("orgId", orgId);
//		int cxCount = xlglSubDocTrackingService.queryCxAllCount(map);//当前课堂参训人数
//		float DoneLv = cxCount / yxCount;
//		jsonObject.put("wcl", DoneLv);
//		jsonObject.put("result", "success");
//		Response.json(jsonObject);
//	}

	public Float getCurrentDoneInfo(String infoId,String orgId){
		Map<String, Object> map = new HashMap<>();
		map.put("infoId", infoId);
		map.put("orgId", orgId);
		//String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
		int yxCount = baseAppUserService.queryYxCount(map);//当前局的有效人数

		int cxCount = xlglSubDocTrackingService.queryCxAllCount(map);//当前课堂参训人数
		float DoneLv = cxCount / yxCount;
		return DoneLv;
	}

	/**
	 * 大讲堂完成情况
	 * @param infoId
	 */
	@ResponseBody
	@RequestMapping("/getAllDeptDoneInfo")
	public void getAllDeptDoneInfo(String infoId) {
		List listAll = new ArrayList();
		JSONObject json = new JSONObject();
		List<BaseAppOrgan> list = baseAppOrganService.queryAllDeptIds();
		if (list != null && list.size() > 0) {
			for (BaseAppOrgan baseAppOrgan : list) {
				JSONObject jsonObject = new JSONObject();
				String orgId = baseAppOrgan.getId();
				String orgName = baseAppOrgan.getName();
				float t = getCurrentDoneInfo(infoId, orgId);
				jsonObject.put("name", orgName);
				jsonObject.put("wcl", t);
				listAll.add(jsonObject);
			}
		}
		json.put("result", "success");
		json.put("list", listAll);
		Response.json(json);

	}




	
}
