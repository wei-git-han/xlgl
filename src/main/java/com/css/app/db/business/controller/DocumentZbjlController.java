package com.css.app.db.business.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.app.db.business.entity.DocumentZbjl;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.service.DocumentZbjlService;
import com.css.app.db.business.service.SubDocInfoService;
import com.css.app.db.util.DbDocStatusDefined;


/**
 * 转办记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:39:37
 */
@Controller
@RequestMapping("/app/db/documentzbjl")
public class DocumentZbjlController {
	@Autowired
	private DocumentZbjlService documentZbjlService;
	@Autowired
	private SubDocInfoService subDocInfoService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("dbdocumentzbjl:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<DocumentZbjl> dbDocumentZbjlList = documentZbjlService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(dbDocumentZbjlList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbdocumentzbjl:info")
	public void info(@PathVariable("id") String id){
		DocumentZbjl dbDocumentZbjl = documentZbjlService.queryObject(id);
		Response.json("dbDocumentZbjl", dbDocumentZbjl);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(String infoId,String deptIds,String deptNames){
		JSONObject json =new JSONObject();
		if(StringUtils.isNotBlank(infoId) && StringUtils.isNotBlank(deptIds)) {
			//获取当前登录人信息
			String loginUserId=CurrentUser.getUserId();
			String loginUserName=CurrentUser.getUsername();
			String loginUserDeptId=CurrentUser.getDepartmentId();
			String loginUserDeptName=CurrentUser.getOrgName();
			//添加转办记录
			DocumentZbjl zbjl=new DocumentZbjl();
			zbjl.setId(UUIDUtils.random());
			zbjl.setInfoId(infoId);
			zbjl.setUserId(loginUserId);
			zbjl.setUserName(loginUserName);
			zbjl.setDeptId(loginUserDeptId);
			zbjl.setDeptName(loginUserDeptName);
			zbjl.setReceiverIds(deptIds);
			zbjl.setReceiverNames(deptNames);
			zbjl.setCreatedTime(new Date());
			documentZbjlService.save(zbjl);
			//添加子分支主记录
			String[] deptArray = deptIds.split(",");
			for (String deptId : deptArray) {
				BaseAppOrgan organ = baseAppOrganService.queryObject(deptId);
				SubDocInfo subInfo=new SubDocInfo();
				subInfo.setId(UUIDUtils.random());
				subInfo.setInfoId(infoId);
				subInfo.setSubDeptId(deptId);
				if(organ !=null) {
					subInfo.setSubDeptName(organ.getName());
				}
				subInfo.setDocStatus(DbDocStatusDefined.DAI_LUO_SHI);
				subInfo.setCreatedTime(new Date());
				subDocInfoService.save(subInfo);
			}
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}		
		Response.json(json);
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dbdocumentzbjl:update")
	public void update(@RequestBody DocumentZbjl dbDocumentZbjl){
		documentZbjlService.update(dbDocumentZbjl);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("dbdocumentzbjl:delete")
	public void delete(@RequestBody String[] ids){
		documentZbjlService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
