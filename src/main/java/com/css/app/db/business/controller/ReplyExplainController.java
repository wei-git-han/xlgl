package com.css.app.db.business.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;

import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

import cn.com.css.filestore.impl.HTTPFile;

import com.css.base.utils.Response;
import com.css.addbase.FileBaseUtil;
import com.css.app.db.business.entity.ReplyAttac;
import com.css.app.db.business.entity.ReplyExplain;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.service.ReplyAttacService;
import com.css.app.db.business.service.ReplyExplainService;
import com.css.app.db.business.service.SubDocInfoService;


/**
 * 办理反馈表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 19:07:17
 */
@Controller
@RequestMapping("/app/db/replyexplain")
public class ReplyExplainController {
	@Autowired
	private ReplyExplainService replyExplainService;
	@Autowired
	private ReplyAttacService replyAttacService;
	@Autowired
	private SubDocInfoService subDocInfoService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("dbreplyexplain:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<ReplyExplain> dbReplyExplainList = replyExplainService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(dbReplyExplainList);
		Response.json("page",pageUtil);
	}
	
	/**
	 * 保存反馈意见
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(String subId,String infoId,ReplyExplain replyExplain,@RequestParam(value = "file", required = false) MultipartFile[] files){
		String loginUserId=CurrentUser.getUserId();
		String loginUserName=CurrentUser.getUsername();
		SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
		if(StringUtils.isNotBlank(replyExplain.getId())) {
			replyExplainService.update(replyExplain);
		}else {
			replyExplain.setId(UUIDUtils.random());
			replyExplain.setSubId(subId);
			replyExplain.setInfoId(infoId);
			replyExplain.setUserId(loginUserId);
			replyExplain.setUserName(loginUserName);
			replyExplain.setCreatedTime(new Date());
			replyExplain.setSubDeptId(subDocInfo.getSubDeptId());
			replyExplain.setSubDeptName(subDocInfo.getSubDeptName());
			replyExplainService.save(replyExplain);
		}
		if(files!=null){
			for(int i=0;i<files.length;i++) {
				ReplyAttac attach=new ReplyAttac();
				String fileId = FileBaseUtil.fileServiceUpload(files[i]);
				attach.setId(UUIDUtils.random());
				attach.setKeyId(subId);
				attach.setFileName(files[i].getOriginalFilename());
				attach.setFileServerId(fileId);
				attach.setCreatedTime(new Date());
				replyAttacService.save(attach);
			}
		}
		Response.ok();
	}
	
	/**
	 * 删除附件
	 * @param id 腹肌id
	 */
	@ResponseBody
	@RequestMapping("/deleteAttch")
	public void delete(String id){
		replyAttacService.delete(id);
		Response.json("result", "success");
	}
	
    /**
     * 下载附件
     * @param fileId
     */
	@ResponseBody
	@RequestMapping("/downLoad")
	public void downLoad(String fileId){
		String url="";
		if(StringUtils.isNotBlank(fileId)){
			HTTPFile hf = new HTTPFile(fileId);
		    url = hf.getAssginDownloadURL();
		}
		Response.json("url", url);
	}
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbreplyexplain:info")
	public void info(@PathVariable("id") String id){
		ReplyExplain dbReplyExplain = replyExplainService.queryObject(id);
		Response.json("dbReplyExplain", dbReplyExplain);
	}
	
	
	/**
	 * 修改办理反馈流版本
	 * @param subId
	 * @param infoId
	 * @param replyContent
	 */
	@ResponseBody
	@RequestMapping("/edit")
	public void update(String subId,String infoId,String replyContent){
		String loginUserId=CurrentUser.getUserId();
		String loginUserName=CurrentUser.getUsername();
		SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
		ReplyExplain reply=new ReplyExplain();
		reply.setId(UUIDUtils.random());
		reply.setSubId(subId);
		reply.setInfoId(infoId);
		reply.setReplyContent(replyContent);
		reply.setUserId(loginUserId);
		reply.setUserName(loginUserName);
		reply.setCreatedTime(new Date());
		reply.setSubDeptId(subDocInfo.getSubDeptId());
		reply.setSubDeptName(subDocInfo.getSubDeptName());
		replyExplainService.save(reply);
		Response.json("result", "success");
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("dbreplyexplain:delete")
	public void delete(@RequestBody String[] ids){
		replyExplainService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
