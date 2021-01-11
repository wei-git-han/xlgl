package com.css.addbase.apporgan.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.css.app.xlgl.config.entity.XlglRoleSet;
import com.css.app.xlgl.config.service.XlglRoleSetService;
import com.css.app.xlgl.service.XlglAdminSetService;
import com.css.base.utils.GwPageUtils;
import com.github.pagehelper.PageHelper;
import freemarker.cache.StrongCacheStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.SysOrgan;
import com.css.addbase.appconfig.entity.BaseAppConfig;
import com.css.addbase.appconfig.service.BaseAppConfigService;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgan.util.OrgUtil;
import com.css.addbase.apporgmapped.entity.BaseAppOrgMapped;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.constant.AppConstant;
import com.css.addbase.constant.AppInterfaceConstant;
import com.css.addbase.orgservice.OrgService;
import com.css.addbase.orgservice.Organ;
import com.css.addbase.orgservice.UserInfo;
import com.css.base.entity.SSOUser;
import com.css.base.filter.SSOAuthFilter;
import com.css.base.utils.CrossDomainUtil;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2017-06-15 10:37:13
 */
@Controller
@RequestMapping("app/base/user")
public class BaseAppUserController {
	
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
	private XlglAdminSetService adminSetService;
	@Autowired
	private XlglRoleSetService xlglRoleSetService;
	
	/**
	 * 获取指定部门下的人员列表
	 * @param organId 组织机构Id
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public void getList(Integer page, Integer pagesize,String organId) {
		if (StringUtils.isEmpty(organId)) {
			organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(organId) && !StringUtils.equals("root", organId)) {
			organId = allOrgIds(organId);
			map.put("orgIds", organId.split(","));
		}
		//List<BaseAppUser> users = baseAppUserService.findByOrganid(organId);
		PageHelper.startPage(page, pagesize);
		List<BaseAppUser> users = baseAppUserService.queryList(map);
		JSONObject result = new JSONObject();
		result.put("page", 1);
		result.put("total", users.size());
		JSONArray jsons = new JSONArray();
		for (BaseAppUser user:users) {
			JSONObject json = new JSONObject();
			json.put("id", user.getId());
			json.put("truename", user.getTruename());
			json.put("work", "");
			json.put("departmentName", baseAppOrganService.queryObject(user.getOrganid()).getName());
			json.put("moblie", user.getMobile());
			json.put("sfzb", user.getSfzb());
			json.put("sfyx",user.getSfyx());
			jsons.add(json);
			user.setDeptName(baseAppOrganService.queryObject(user.getOrganid()).getName());
		}
		//result.put("rows", jsons);
		//Response.json(result);
		GwPageUtils pageUtil = new GwPageUtils(users);
		Response.json(pageUtil);
	}
	
	/**
	 * 加载全部人员树
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/allTree")
	@ResponseBody
	public Object getAllUserTree() {
		List<BaseAppOrgan> organs = baseAppOrganService.queryList(null);
		List<BaseAppUser> users = baseAppUserService.queryList(null);
		JSONObject list =OrgUtil.getUserTree(organs, users);
		return list;
	}
	
	/**
	 * 获取当前登录人所在部门的人员树
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/tree")
	@ResponseBody
	public Object getUserTree() {
		String organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
		List<BaseAppOrgan> organs = baseAppOrganService.queryList(null);
		List<BaseAppUser> users = baseAppUserService.queryList(null);
		if (StringUtils.isNotEmpty(organId)) {
			JSONObject list=  OrgUtil.getUserTree(organs, users, organId);
			return list;
		} else {
			JSONObject list=  OrgUtil.getUserTree(organs, users);
			return list;
		}
	}
	
	
	/**
	 * 获取当前登录人所在部门的人员树
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/chuTree")
	@ResponseBody
	public Object getUserChuTree() {
		String organId = baseAppOrgMappedService.getChuByUserId(CurrentUser.getUserId());
		List<BaseAppOrgan> organs = baseAppOrganService.queryList(null);
		List<BaseAppUser> users = baseAppUserService.queryList(null);
		if (StringUtils.isNotEmpty(organId)) {
			JSONObject list=  OrgUtil.getUserTree(organs, users, organId);
			return list;
		} else {
			JSONObject list=  OrgUtil.getUserTree(organs, users);
			return list;
		}
	}
	
	/**
	 * 获取当前登录人所在部门的人员树指定不显示的人员
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/treePart")
	@ResponseBody
	public Object getUserTreePart() {
		String organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
		List<BaseAppOrgan> organs = baseAppOrganService.queryList(null);
		List<BaseAppUser> users = baseAppUserService.queryList(null);
		String[] hideUserIds = {CurrentUser.getUserId()};
		if (StringUtils.isNotEmpty(organId)) {
			JSONObject list=  OrgUtil.getUserTree(organs, users, organId, null,null,hideUserIds,null);
			return list;
		} else {
			JSONObject list=  OrgUtil.getUserTree(organs, users, organId, null,null,hideUserIds,null);
			return list;
		}
	}
	/**
	 * 根据业务配置筛选人员树
	 * @return
	 */
	@RequestMapping(value = "/treeBySet")
	@ResponseBody
	public Object getUserTreeBySet() {
		String organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
		List<BaseAppOrgan> organs = baseAppOrganService.queryList(null);
		List<BaseAppUser> users = baseAppUserService.queryListBySet(null);
		if (StringUtils.isNotEmpty(organId)) {
			JSONObject list=  OrgUtil.getUserTree(organs, users, organId);
			return list;
		} else {
			JSONObject list=  OrgUtil.getUserTree(organs, users);
			return list;
		}
//		JSONObject list=  OrgUtil.getUserTree(organs, users, organId,"1");
	}
	/**
	 * 根据人员所在局或者部获取加载人员树，部级加载全部人员
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/treeByPost")
	@ResponseBody
	public Object getUserTreeByPosition() {
		String ret=baseAppOrgMappedService.getAppLevelByType(AppConstant.APP_DZBMS);
		List<BaseAppOrgan> organs = baseAppOrganService.queryList(null);
		List<BaseAppUser> users = baseAppUserService.queryList(null);
		if("true".equals(ret)){
			JSONObject list = OrgUtil.getUserTree(organs,users);
			return list;
		}else{
			String organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
			JSONObject list=  OrgUtil.getUserTree(organs,users,organId);
			return list;
		}
	}
	
	/**
	 * 获取当前登录用户信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/userInfo")
    public void getUserInfo(){
		//0:超级管理员 ;1：部管理员；2：局管理员；3：即是部管理员又是局管理员;4:处管理员
		String adminFlag = adminSetService.getAdminTypeByUserId(CurrentUser.getUserId());
		JSONObject userJson = new JSONObject();
    	SSOUser ssoUser = SSOAuthFilter.getSUser();
    	userJson.put("result","error");
    	if(ssoUser != null){
    		userJson = (JSONObject) JSONObject.toJSON(ssoUser);
    		userJson.put("result","success");
    		userJson.put("adminFlag",adminFlag);
    	}
    	XlglRoleSet  xlglRoleSet =xlglRoleSetService.queryByuserId(CurrentUser.getUserId());
    	if(xlglRoleSet != null){
    		if(StringUtils.isNotBlank(xlglRoleSet.getRoleFlag())){
    			String roleFlag = xlglRoleSet.getRoleFlag();
    			if("1".equals(roleFlag) || "3".equals(roleFlag)){//首长和局长
    				userJson.put("roleFlag",true);
				}else {
    				userJson.put("roleFlag",false);
				}
			}else {
				userJson.put("roleFlag",false);
			}
		}else {
			userJson.put("roleFlag",false);
		}

		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
    	BaseAppOrgan baseAppOrgan = baseAppOrganService.queryDeptNameByUserId(orgId);
    	if(baseAppOrgan != null){
			String orgName = baseAppOrgan.getName();
			userJson.put("juId",orgId);
			userJson.put("juName",orgName);
		}
    	Response.json(userJson);
    }
	

	/**
	 * 导入系统部门及其所属子部门和人员
	 * @param deptIds
	 */
	@ResponseBody
	@RequestMapping("/importOrg")
	public void importOrg(String deptIds) {
		Set<String> userSet = new HashSet<String>();
		Set<String> deptSet = new HashSet<String>();
		if (StringUtils.isNotEmpty(deptIds)) {
			String[] depts = deptIds.split(",");
			for (String dept:depts) {
				userSet.add(dept);
				Organ organ = orgService.getOrgan(dept);
				String[] paths = organ.getP().split(",");
				for (String path:paths) {
					deptSet.add(path);
				}
			}
			deptSet.remove("-1");
			importUsers(deptSet,userSet);
			Response.json("result", "success");
		}
		
	}
	
	/**
	 * 递归导入指定部门及其所属子部门和人员
	 * @param String deptId
	 */
	private void importUsers(Set<String> deptSet,Set<String> userSet) {
		//
		for (String deptId:deptSet) {
			Organ organ = orgService.getOrgan(deptId);
			BaseAppOrgan dept = baseAppOrganService.queryObject(deptId);
			if (null == dept) {
				dept = new BaseAppOrgan();
				dept.setId(organ.getOrganId());
				dept.setName(organ.getOrganName());
				dept.setParentId(organ.getFatherId());
				dept.setTreePath(organ.getP());
				dept.setSort(organ.getOrderId());
				dept.setDeptOfficer(-1);//默认值为-1， 0-处室， 1-局 FIXME 如何确定部门级别？
				dept.setIsdelete(organ.getIsDelete());
				baseAppOrganService.save(dept);
				dept = null;
			} else {
				dept = new BaseAppOrgan();
				dept.setId(organ.getOrganId());
				dept.setName(organ.getOrganName());
				dept.setParentId(organ.getFatherId());
				dept.setTreePath(organ.getP());
				dept.setSort(organ.getOrderId());
				dept.setDeptOfficer(-1);//默认值为-1， 0-处室， 1-局 FIXME 如何确定部门级别？
				dept.setIsdelete(organ.getIsDelete());
				baseAppOrganService.update(dept);
				dept = null;
			}
		}
		for (String deptId:userSet) {
			UserInfo[] users = orgService.getUserInfos(deptId);
			for (UserInfo sysuser : users) {
				String userId = sysuser.getUserid();
				BaseAppUser user = baseAppUserService.queryObject(userId);
				if (null == user) {				
					user = new BaseAppUser();
					user.setId(userId);
					user.setUserId(userId);
					user.setAccount(sysuser.getAccount());
					user.setTruename(sysuser.getFullname());
					user.setMobile(sysuser.getMobile());
					user.setUseremail(sysuser.getUserEmail());
					user.setOrganid(sysuser.getOrganId());
					user.setSort(sysuser.getOrderId());
					user.setSex(sysuser.getSex());
					user.setIsdelete(sysuser.getIsDelete());
					baseAppUserService.save(user);
					user = null;
				} else {
					user = new BaseAppUser();
					user.setId(userId);
					user.setUserId(userId);
					user.setAccount(sysuser.getAccount());
					user.setTruename(sysuser.getFullname());
					user.setMobile(sysuser.getMobile());
					user.setUseremail(sysuser.getUserEmail());
					user.setOrganid(sysuser.getOrganId());
					user.setSort(sysuser.getOrderId());
					user.setSex(sysuser.getSex());
					user.setIsdelete(sysuser.getIsDelete());
					baseAppUserService.update(user);
					user = null;
				}
			}
		}
	}
	
	@ResponseBody
	@RequestMapping("/getToken")
    public void getToken(){
    String token=SSOAuthFilter.getToken();
    Response.json("result",token);
	}
	
	/**
	 * 仅加载办公厅保密档案室人员 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getBmdasUserTree")
	@ResponseBody
	public Object getBmdasUserTree() {
		JSONObject list=new JSONObject();
		BaseAppConfig conf =baseAppConfigService.queryObject("bmdas_orgid");
		if(conf!=null) {
			String organId = conf.getValue();
			List<BaseAppOrgan> organs = baseAppOrganService.queryList(null);
			List<BaseAppUser> users = baseAppUserService.queryList(null);
			if (StringUtils.isNotEmpty(organId)) {
				list=  OrgUtil.getUserTree(organs, users, organId);
				System.out.println("没有设置办公厅保密档案室人员 ");
			}
		}
		return list;
	}
	
	/**
	 * 加载当前人及当前人的部门
	 */
	@ResponseBody
	@RequestMapping("/addInfo")
    public void addInfo(String leaderId){
		//删掉的代码没有调用到
		JSONObject json = new JSONObject();
		json.put("title", "");
		json.put("secretLevel", "密级");
		json.put("secretLevelName", "保密");
		json.put("jjcdId", "1");
		json.put("undertakeDeptId", "");
	    if(StringUtils.isBlank(leaderId)) {
        	json.put("undertakeDept", CurrentUser.getOrgName());
        	json.put("undertakeUser", CurrentUser.getUsername());
        }else {
        	BaseAppUser user = baseAppUserService.queryObject(leaderId);
        	json.put("undertakeDept", baseAppOrganService.queryObject(user.getOrganid()).getName());
        	json.put("undertakeUser", user.getTruename());
        }
		Response.json(json);
	}
	
	
	/**
	 * 加载当前人及当前人的部门
	 * 更改在编状态
	 */
	@ResponseBody
	@RequestMapping("/updateZbqk")
    public void updateZbqk(BaseAppUser baseAppUser){
		//删掉的代码没有调用到
		JSONObject json = new JSONObject();
		baseAppUserService.update(baseAppUser);
		Response.json("result","success");
	}

	/**
	 * 加载当前人及当前人的部门
	 * 更改是否有效状态
	 */
	@ResponseBody
	@RequestMapping("/updateSfyx")
	public void updateSfyx(BaseAppUser baseAppUser){
		JSONObject json = new JSONObject();
		baseAppUserService.update(baseAppUser);
		Map<String, Object> map = new HashMap<String, Object>();
		BaseAppUser queryObject = baseAppUserService.queryObject(baseAppUser.getId());
		List<String> arrayList = new ArrayList<String>();
		String chu = "2"; // 0 改为 有效 ，1 改为无效，2 为默认不改  
		String ju = "2"; // 0 改为 有效 ，1 改为无效，2 为默认不改  
		if(queryObject !=null) {
			List<BaseAppUser> queryUsers = baseAppUserService.queryUsers(queryObject.getOrganid());
			BaseAppOrgan baseAppOrganChu = new BaseAppOrgan();
			baseAppOrganChu.setId(queryObject.getOrganid());
			if(queryUsers.size() <=0) {
				chu = "1";
				baseAppOrganChu.setIsInvalId("1");
				baseAppOrganService.update(baseAppOrganChu);
			}else if(queryUsers.size() ==1){
				chu = "0";
				baseAppOrganChu.setIsInvalId("0");
				baseAppOrganService.update(baseAppOrganChu);
			}
			BaseAppOrgan queryObject2 = baseAppOrganService.queryObject(queryObject.getOrganid());
			if(StringUtils.isNotBlank(queryObject2.getTreePath())) {
				String parentId = queryObject2.getTreePath();
				if(parentId.contains(",")) {
					String[] split = parentId.split(",");
					for (int i = 0; i < split.length; i++) {
						if(i>1) {
							arrayList.add(split[i]);
						}
					}
				}
			}
			String string = arrayList.get(0);
			List<BaseAppOrgan> findOrganByParentIdAll = baseAppOrganService.findOrganByParentIdAll(string);
			List<BaseAppUser> queryUsers2 = baseAppUserService.queryUsers(string);
			BaseAppOrgan baseAppOrgan = new BaseAppOrgan();
			baseAppOrgan.setId(string);
			if(findOrganByParentIdAll.size()<=0 && queryUsers2.size()<=0) {
				ju = "1";
				baseAppOrgan.setIsInvalId("1");
				baseAppOrganService.update(baseAppOrgan);
			}else if(findOrganByParentIdAll.size()==1 && queryUsers2.size() ==1){
				ju = "0";
				baseAppOrgan.setIsInvalId("0");
				baseAppOrganService.update(baseAppOrgan);
			}
		}
		LinkedMultiValueMap<String, Object> hashmap = new LinkedMultiValueMap<String, Object>();
    	hashmap.add("id", baseAppUser.getId());
    	hashmap.add("sfyx", baseAppUser.getSfyx());
    	this.updateSfyxQXJ(hashmap);
		Response.json("result","success");
	}
	
	private String allOrgIds(String orgId) {
		String ret = "";
		if (StringUtils.isNotBlank(orgId)) {
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

	private JSONObject updateSfyxQXJ(LinkedMultiValueMap<String, Object> map) {
		BaseAppOrgMapped orgMapped = (BaseAppOrgMapped)baseAppOrgMappedService.orgMappedByOrgId("","root",AppConstant.APP_QXJGL);
		// 获取清销假app的接口
		String elecPath = orgMapped.getUrl() + AppInterfaceConstant.WEB_INTERFACE_QXJ_UPDATE_SFYX;
		JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath, map);
		return jsonData;
	}
}
