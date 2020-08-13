package com.css.app.xlgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.entity.XlglConfirm;
import com.css.app.xlgl.service.XlglConfirmService;
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
	 * 处管理员确认接口
	 */
	@ResponseBody
	@RequestMapping("/xlglConfirm")
	public void xlglConfirm(@RequestBody XlglConfirm xlglConfirm) {
		String deptId = baseAppUserService.queryByUserId(CurrentUser.getUserId());
		xlglConfirm.setDeptid(deptId);
		xlglConfirm.setCreatedtime(new Date());
		xlglConfirm.setCreator(CurrentUser.getUserId());
		xlglConfirm.setCreatorname(CurrentUser.getUsername());
		BaseAppOrgan organ = baseAppOrganService.queryObject(deptId);//获取部门信息
		xlglConfirm.setDeptname(organ.getName());
		xlglConfirm.setId(UUIDUtils.random());
		xlglConfirmService.save(xlglConfirm);
		Response.json("result", "success");
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
	
}
