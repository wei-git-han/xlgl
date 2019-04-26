package com.css.app.db.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.css.app.db.business.entity.ReplyExplain;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.service.ReplyAttacService;
import com.css.app.db.business.service.ReplyExplainService;
import com.css.app.db.business.service.SubDocInfoService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;

import cn.com.css.filestore.impl.HTTPFile;


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
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();	
		List<ReplyExplain> dbReplyExplainList = replyExplainService.queryList(map);	
		Response.json(dbReplyExplainList);
	}
	
	/**
	 * 保存反馈意见
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(String subId,String infoId,String teamId,String replyContent,@RequestParam(value = "file", required = false) MultipartFile[] files){
		String loginUserId=CurrentUser.getUserId();
		String loginUserName=CurrentUser.getUsername();
		JSONObject json=new JSONObject();
		if(StringUtils.isNotBlank(infoId) && StringUtils.isNotBlank(subId)) {
			SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
			if(StringUtils.isBlank(teamId)) {
				String uuid=UUIDUtils.random();
				//新增反馈及附件
				replyExplainService.saveReply(subId, infoId, loginUserId, loginUserName, uuid, replyContent, subDocInfo.getSubDeptId(), subDocInfo.getSubDeptName());
				if(files!=null){
					replyAttacService.saveAttacs(files, subId, uuid);
				}
			}else {
				Map<String, Object> map =new HashMap<>();
				map.put("subId", subId);
				map.put("userId", loginUserId);
				map.put("teamId", teamId);
				map.put("showFlag", "0");
				ReplyExplain tempReply = replyExplainService.queryLastestTempReply(map);
				if(tempReply != null) {
					tempReply.setReplyContent(replyContent);
					replyExplainService.update(tempReply);
					if(files!=null){
						replyAttacService.saveAttacs(files, subId, teamId);
					}
				}else {
					replyExplainService.saveReply(subId, infoId, loginUserId, loginUserName, teamId, replyContent, subDocInfo.getSubDeptId(), subDocInfo.getSubDeptName());
				}
			}
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
	
	/**
	 * 删除附件
	 * @param id 附件id
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
}
