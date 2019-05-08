package com.css.app.db.config.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.app.db.business.entity.DocumentInfo;
import com.css.app.db.config.entity.DocumentDic;
import com.css.app.db.config.service.DocumentDicService;
import com.css.app.db.util.DbDefined;
import com.css.base.utils.GwPageUtils;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.thoughtworks.xstream.mapper.Mapper.Null;


/**
 * 字典配置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 15:23:36
 */
@Controller
@RequestMapping("/app/db/documentdic")
public class DocumentDicController {
	@Autowired
	private DocumentDicService documentDicService;
	
	
	/**
	 * 根据字典标识获取相适应配置的键值对
	 * @param dicType 字典标识
	 */
	@ResponseBody
	@RequestMapping("/getDicByTypet")
	public void getDicByType(String dicType) {
		JSONObject json = new JSONObject();
		if(StringUtils.isNotBlank(dicType)) {
			if(StringUtils.equals(DbDefined.ALL_DIC, dicType)) {
				 json.put(DbDefined.DOCUMENT_TYPE, documentDicService.queryDicByType(DbDefined.DOCUMENT_TYPE));
				 json.put(DbDefined.URGENCY_DEGREE, documentDicService.queryDicByType(DbDefined.URGENCY_DEGREE));
				 json.put(DbDefined.SECURITY_CLASSIFICATION, documentDicService.queryDicByType(DbDefined.SECURITY_CLASSIFICATION));
			}else {
				 json.put(dicType, documentDicService.queryDicByType(dicType));
			}
		}
		Response.json(json);
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/zdlist")
	public void zdlist(Integer page, Integer pagesize){
		
		if(page != null && pagesize != null){
			PageHelper.startPage(page, pagesize);
		}
		
		List<Map<String, Object>> dictionaryTypeList = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> tep1 = new HashMap<String, Object>();
		tep1.put("dicType", DbDefined.URGENCY_DEGREE);
		tep1.put("name", "紧急程度");
		tep1.put("children", documentDicService.queryDicByType(DbDefined.URGENCY_DEGREE));
		dictionaryTypeList.add(tep1);
		
		Map<String, Object> tep2 = new HashMap<String, Object>();
		tep2.put("dicType", DbDefined.SECURITY_CLASSIFICATION);
		tep2.put("name", "密级");
		tep2.put("children", documentDicService.queryDicByType(DbDefined.SECURITY_CLASSIFICATION));
		dictionaryTypeList.add(tep2);
		
		GwPageUtils pageUtil = new GwPageUtils(dictionaryTypeList);
		Response.json(pageUtil);
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("dbdocumentdic:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<DocumentDic> dbDocumentDicList = documentDicService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(dbDocumentDicList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbdocumentdic:info")
	public void info(@PathVariable("id") String id){
		DocumentDic dbDocumentDic = documentDicService.queryObject(id);
		Response.json("dbDocumentDic", dbDocumentDic);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("dbdocumentdic:save")
	public void save(DocumentDic dbDocumentDic){
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> resultMap = new HashMap<>();
		map.put("dicType", dbDocumentDic.getDicType());
		map.put("value", dbDocumentDic.getValue());
 		if(dbDocumentDic != null && dbDocumentDic.getId() != null && !"".equals(dbDocumentDic.getId())) {
			List<DocumentDic> queryList = documentDicService.queryList(map);
			if(queryList != null && queryList.size()==1 && dbDocumentDic.getId().equals(queryList.get(0).getId()) || queryList == null || queryList.size()==0) {
				documentDicService.update(dbDocumentDic);
				resultMap.put("code", "0");
				resultMap.put("result", "保存成功");
				Response.json(resultMap);
			}else {
				resultMap.put("code", "1");
				resultMap.put("result", "排序序号重复！");
				Response.json(resultMap);
			}
		}else {
			List<DocumentDic> queryList = documentDicService.queryList(map);
			if(queryList != null && queryList.size()>0) {
				resultMap.put("code", "1");
				resultMap.put("result", "排序序号重复！");
				Response.json(resultMap);
			}else {
				dbDocumentDic.setId(UUIDUtils.random());
				documentDicService.save(dbDocumentDic);
				resultMap.put("code", "0");
				resultMap.put("result", "保存成功");
				Response.json(resultMap);
			}
		}
		
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dbdocumentdic:update")
	public void update(@RequestBody DocumentDic dbDocumentDic){
		documentDicService.update(dbDocumentDic);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("dbdocumentdic:delete")
	public void delete(String ids){
		String[] idlist =null;
		if(ids != null && !"".equals(ids)) {
			idlist = ids.split(",");
			documentDicService.deleteBatch(idlist);
		}
		Response.ok();
	}
	
}
