package com.css.app.xlgl.controller;

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

import com.css.app.xlgl.entity.DocumentMenu;
import com.css.app.xlgl.service.DocumentMenuService;
import com.css.base.utils.GwPageUtils;
import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;


/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-04 15:18:03
 */
@Controller
@RequestMapping("/app/xlgl/documentmenu")
public class DocumentMenuController {
	
	@Autowired
	private DocumentMenuService documentMenuService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("documentmenu:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<DocumentMenu> documentMenuList = documentMenuService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(documentMenuList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("documentmenu:info")
	public void info(@PathVariable("id") String id){
		DocumentMenu documentMenu = documentMenuService.queryObject(id);
		Response.json("documentMenu", documentMenu);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("documentmenu:save")
	public void save(@RequestBody DocumentMenu documentMenu){
		documentMenu.setId(UUIDUtils.random());
		documentMenuService.save(documentMenu);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("documentmenu:update")
	public void update(@RequestBody DocumentMenu documentMenu){
		documentMenuService.update(documentMenu);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("documentmenu:delete")
	public void delete(@RequestBody String[] ids){
		documentMenuService.deleteBatch(ids);
		
		Response.ok();
	}
	
	@ResponseBody
	@RequestMapping("/menulist")
	public void menulist(Integer page, Integer pagesize){
		Map<String, Object> map = new HashMap<String, Object>();
		if(page != null && page > 0){
			PageHelper.startPage(page, pagesize);
		}
		//查询列表数据
		List<DocumentMenu> menuList = documentMenuService.queryList(map);
		
		GwPageUtils pageUtil = new GwPageUtils(menuList);
		Response.json(pageUtil);
	}
}
