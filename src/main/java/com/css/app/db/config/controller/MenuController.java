package com.css.app.db.config.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.app.db.config.entity.AdminSet;
import com.css.app.db.config.entity.Menu;
import com.css.app.db.config.service.AdminSetService;
import com.css.app.db.config.service.MenuService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;


/**
 * 菜单表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:36
 */
@Controller
@RequestMapping("/app/db/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private AdminSetService adminSetService;
	
	@Value("${csse.dccb.appId}")
	private  String appId;	
	@Value("${csse.dccb.appSecret}")
	private  String clientSecret;
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/menuList")
	public void menuList(){
		boolean admin = CurrentUser.getIsManager(appId, clientSecret);
		Map<String, Object> menuMap = new HashMap<>();
		String[] menuIds = null;
		if (!admin) {
			Map<String, Object> map = new HashMap<>();
			map.put("userId", CurrentUser.getUserId());
			List<AdminSet> list = adminSetService.queryList(map);
			
			if(list!=null && list.size()>0) {
				String adminType = list.get(0).getAdminType();
				if(StringUtils.equals("1", adminType)) {
					menuIds= new String[] {"003"};
				}else if(StringUtils.equals("2", adminType)) {
					menuIds= new String[] {"001"};
				}
			}else {
				menuIds= new String[] {"001","003","006"};
			}
		}
		menuMap.put("menuIds", menuIds);
		List<Menu> menuList = menuService.queryList(menuMap);
		Response.json(menuList);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbmenu:info")
	public void info(@PathVariable("id") String id){
		Menu dbMenu = menuService.queryObject(id);
		Response.json("dbMenu", dbMenu);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("dbmenu:save")
	public void save(@RequestBody Menu dbMenu){
		dbMenu.setId(UUIDUtils.random());
		menuService.save(dbMenu);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dbmenu:update")
	public void update(@RequestBody Menu dbMenu){
		menuService.update(dbMenu);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("dbmenu:delete")
	public void delete(@RequestBody String[] ids){
		menuService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
