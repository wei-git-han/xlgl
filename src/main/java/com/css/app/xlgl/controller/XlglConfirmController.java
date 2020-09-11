package com.css.app.xlgl.controller;

import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.app.xlgl.config.entity.XlglRoleSet;
import com.css.app.xlgl.config.service.XlglRoleSetService;
import com.css.app.xlgl.dto.XlglConfirmDto;
import com.css.app.xlgl.entity.Org;
import com.css.app.xlgl.entity.XlglConfirm;
import com.css.app.xlgl.service.XlglAdminSetService;
import com.css.app.xlgl.service.XlglConfirmService;
import com.css.app.xlgl.service.XlglSubDocTrackingService;
import com.css.base.utils.CurrentUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;


/**
 * 训练管理确认表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-12 17:01:55
 */
@Controller
@RequestMapping("/app/xlgl/xlglconfirm")
public class XlglConfirmController {
	@Autowired
	private XlglConfirmService xlglConfirmService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	@Autowired
	private XlglSubDocTrackingService xlglSubDocTrackingService;
	@Autowired
	private XlglAdminSetService adminSetService;
	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;
	@Autowired
	private XlglRoleSetService xlglRoleSetService;
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglconfirm:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglConfirm> xlglConfirmList = xlglConfirmService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglConfirmList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglconfirm:info")
	public void info(@PathVariable("id") String id){
		XlglConfirm xlglConfirm = xlglConfirmService.queryObject(id);
		Response.json("xlglConfirm", xlglConfirm);
	}
	
	/**
	 * 局/处管理员确认接口
	 */
	@ResponseBody
	@RequestMapping("/xlglConfirm")
	public void xlglConfirm(String infoId) {
		String deptId = null;
		deptId = baseAppUserService.queryByUserId(CurrentUser.getUserId());
		BaseAppOrgan organ = baseAppOrganService.queryObject(deptId);//获取部门信息
		JSONObject jsonObject = new JSONObject();
		String flag = "";
		String userId = CurrentUser.getUserId();
		XlglRoleSet xlglRoleSet = xlglRoleSetService.queryByuserId(userId);
		if (xlglRoleSet != null) {
			if ("5".equals(xlglRoleSet.getRoleFlag())) {//处长角色//处长只确认本处的
				XlglConfirm xlglConfirm = new XlglConfirm();
				xlglConfirm.setDeptid(deptId);
				xlglConfirm.setCreatedtime(new Date());
				xlglConfirm.setCreator(CurrentUser.getUserId());
				xlglConfirm.setCreatorname(CurrentUser.getUsername());
				xlglConfirm.setDeptname(organ.getName());
				xlglConfirm.setId(UUIDUtils.random());
				xlglConfirm.setStatus("1");
				xlglConfirm.setInfoid(infoId);
				xlglConfirmService.save(xlglConfirm);
			} else if ("3".equals(xlglRoleSet.getRoleFlag())) {//局长角色//局长点确认，会确认所有的处
				String orgId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
				List<BaseAppOrgan> appOrganList = baseAppOrganService.queryAllDeptId(orgId);
				if (appOrganList != null && appOrganList.size() > 0) {
					for (BaseAppOrgan baseAppOrgan : appOrganList) {
						String departmentId = baseAppOrgan.getId();
						XlglConfirm xlglConfirm = new XlglConfirm();
						xlglConfirm.setDeptid(departmentId);
						xlglConfirm.setCreatedtime(new Date());
						xlglConfirm.setCreator(CurrentUser.getUserId());
						xlglConfirm.setCreatorname(CurrentUser.getUsername());
						xlglConfirm.setDeptname(organ.getName());
						xlglConfirm.setId(UUIDUtils.random());
						xlglConfirm.setStatus("1");
						xlglConfirm.setInfoid(infoId);
						xlglConfirmService.save(xlglConfirm);
					}
				}
			}
		}
		Response.json("result", "success");
	}



	/**
	 * 判断确认按钮是否显示
	 * @param deptId
	 * flag 角色标识（3：局长；4：局秘书；5：处长；6：参谋；2：首长秘书；1：首长；）
	 */
	@ResponseBody
	@RequestMapping("/isHaveButton")
	public void isHaveButton(String deptId){
//		String organId = "";
//		//获取当前人的管理员类型（0:超级管理员 ;1：部管理员；2：局管理员；3：即是部管理员又是局管理员）
//		String adminFlag = adminSetService.getAdminTypeByUserId(CurrentUser.getUserId());
//		if("2".equals(adminFlag)){
//			organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
//		}else if("4".equals(adminFlag)){
//			organId = baseAppUserService.queryByUserId(CurrentUser.getUserId());
//		}
//		if(deptId.equals(organId)){
//			Response.json("result",true);
//		}else{
//			Response.json("result",false);
//		}
		String organId = "";
		JSONObject jsonObject = new JSONObject();
		String flag = "";
		String userId = CurrentUser.getUserId();
		XlglRoleSet xlglRoleSet = xlglRoleSetService.queryByuserId(userId);
		if (xlglRoleSet != null) {
			flag = xlglRoleSet.getRoleFlag();
		}
		if ("3".equals(flag)) {//如果是局长角色就显示确认按钮
			Response.json("result", true);
		} else if ("5".equals(flag)) {//判断是否是处长角色
			organId = baseAppUserService.queryByUserId(CurrentUser.getUserId());//当前登录人的处部门id
			if (deptId.equals(organId)) {
				Response.json("result", true);
			} else {
				Response.json("result", false);
			}
		}



//		if (xlglRoleSet != null) {
//			flag = xlglRoleSet.getRoleFlag();
//			jsonObject.put("flag", flag);
//		} else {
//			jsonObject.put("flag", "no");
//		}
	}


	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(@RequestBody XlglConfirm xlglConfirm){
		xlglConfirmService.update(xlglConfirm);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglconfirm:delete")
	public void delete(@RequestBody String[] ids){
		xlglConfirmService.deleteBatch(ids);
		
		Response.ok();
	}


	/**
	 * 局查看各处确认情况
	 */

	@ResponseBody
	@RequestMapping("/getAllDeptList")
	public void getAllDeptList(String infoId) {
		Map<String,Object> map = new HashMap<String,Object>();
		//查询所有的局id
		List<BaseAppOrgan> listAllJu = baseAppOrganService.queryAllDeptIds();
		List list = new ArrayList();
		JSONObject jsonObject = new JSONObject();
		if (listAllJu != null && listAllJu.size() > 0) {
			for (BaseAppOrgan baseAppOrgan : listAllJu) {
				map.put("deptId",baseAppOrgan.getId());
				map.put("infoId",infoId);
				XlglConfirmDto xlglConfirmDto = xlglConfirmService.queryPerDeptInfo(map);
				list.add(xlglConfirmDto);
			}
		}
		jsonObject.put("list", list);
		Response.json(jsonObject);

	}

}
