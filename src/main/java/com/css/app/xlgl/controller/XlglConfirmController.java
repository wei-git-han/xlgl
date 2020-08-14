package com.css.app.xlgl.controller;

import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.dto.XlglConfirmDto;
import com.css.app.xlgl.entity.XlglConfirm;
import com.css.app.xlgl.service.XlglConfirmService;
import com.css.app.xlgl.service.XlglSubDocTrackingService;
import com.css.base.utils.CurrentUser;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
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
	public void xlglConfirm(@RequestBody XlglConfirm xlglConfirm) {
		String deptId = baseAppUserService.queryByUserId(CurrentUser.getUserId());
		BaseAppOrgan organ = baseAppOrganService.queryObject(deptId);//获取部门信息
		List<Map<String, Object>> infoList = xlglSubDocTrackingService.queryBmInfo(xlglConfirm.getInfoid(), deptId);
		if (infoList != null && infoList.size() > 0) {
			for (Map<String, Object> map : infoList) {
				String baoming = (String) map.get("baoming");
				String wbm = (String) map.get("wbm");
				String qj = (String) map.get("qj");
				xlglConfirm.setConfirmCount(baoming);
				xlglConfirm.setNoConfirmCount(wbm);
				xlglConfirm.setQjCount(qj);
			}
		}
		xlglConfirm.setDeptid(deptId);
		xlglConfirm.setCreatedtime(new Date());
		xlglConfirm.setCreator(CurrentUser.getUserId());
		xlglConfirm.setCreatorname(CurrentUser.getUsername());
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


	/**
	 * 局查看各处确认情况
	 */

	@ResponseBody
	@RequestMapping("/getAllDeptList")
	public void getAllDeptList(String infoId) {
		Map<String,Object> map = new HashMap<String,Object>();
		//查询所有的局id
		List<String> listAllJu = baseAppOrganService.queryAllDeptIds();
		List list = new ArrayList();
		JSONObject jsonObject = new JSONObject();
		if (listAllJu != null && listAllJu.size() > 0) {
			for (String deptId : listAllJu) {
				map.put("deptId",deptId);
				map.put("infoId",infoId);
				XlglConfirmDto xlglConfirmDto = xlglConfirmService.queryPerDeptInfo(map);
				list.add(xlglConfirmDto);
			}
		}
		jsonObject.put("list", list);
		Response.json(jsonObject);

	}

}
