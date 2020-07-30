package com.css.app.xlgl.zzxl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.app.xlgl.zzxl.entity.GroupTrain;
import com.css.app.xlgl.zzxl.service.GroupTrainService;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.css.base.utils.ZxPageUtils;

/**
 *
 *
 *
 */
@RestController
@RequestMapping("/group/train")
public class GroupTrainController{
    @Autowired
    GroupTrainService groupTrainService;
    @Autowired
	private BaseAppOrganService baseAppOrganService;

	@Transactional
	@RequestMapping("/getList")
	public void getList(HttpServletRequest request) {
		ZxPageUtils pageUtil = groupTrainService.getByPage(request);
		Response.json(pageUtil);
	}
	@Transactional
	@RequestMapping("/getDetInfo")
	public void getDetInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", "root");
		List<BaseAppOrgan> organs = baseAppOrganService.queryList(map);
		
		Map<String, Object> ret = new HashMap<String, Object>();
//		ret.put("deptInfo", getOption(organs));
		ret.put("deptInfo", organs);
		Response.json(ret);
	}
	@Transactional
	@RequestMapping("/getRootName")
	public void getRootName() {
		BaseAppOrgan organ = baseAppOrganService.queryObject("root");
		
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rootName", organ.getName());
		Response.json(ret);
	}
	
	public static String getOption(List<BaseAppOrgan> organs) {
		StringBuffer sb = new StringBuffer();
		sb.append(":请选择");
		for (int j = 0; j < organs.size(); j++) {
			sb.append(";" + organs.get(j).getId() + ":" + organs.get(j).getName());
		}
		return sb.toString();
	}
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/getInfo")
	public void info(String id){
		GroupTrain tGroupTrain = groupTrainService.queryObject(id);
		Response.json("GroupTrain", tGroupTrain);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/add")
	@RequiresPermissions("grouptrain:save")
	public void save(@RequestBody GroupTrain tGroupTrain){
		tGroupTrain.setId(UUIDUtils.random());
		groupTrainService.save(tGroupTrain);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("grouptrain:update")
	public void update(@RequestBody GroupTrain tGroupTrain){
		groupTrainService.update(tGroupTrain);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("grouptrain:delete")
	public void delete(@RequestBody String[] ids){
		groupTrainService.deleteBatch(ids);
		
		Response.ok();
	}
}
