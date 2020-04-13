package com.css.app.db.business.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.addbase.SysOrgan;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.db.config.entity.RoleSet;
import com.css.app.db.config.service.RoleSetService;
import com.css.app.db.util.DbDefined;
import com.css.base.utils.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.app.db.business.entity.DocumentSzps;
import com.css.app.db.business.service.DocumentSzpsService;


/**
 * 首长批示内容表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 14:39:12
 */
@Controller
@RequestMapping("/app/db/documentszps")
public class DocumentSzpsController {
	@Autowired
	private DocumentSzpsService documentSzpsService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private RoleSetService roleSetService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/queryList")
	public void list(String infoId){
		List<DocumentSzps> documentSzpsList = null;
		if(StringUtils.isNotBlank(infoId)) {
			Map<String, Object> map = new HashMap<>();
			map.put("infoId", infoId);
			documentSzpsList = documentSzpsService.queryList(map);
		}
		Response.json(documentSzpsList);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(DocumentSzps documentSzps){
		JSONObject json=new JSONObject();
		if(StringUtils.isBlank(documentSzps.getId())) {
			documentSzps.setId(UUIDUtils.random());
			documentSzpsService.save(documentSzps);
		}else {
			documentSzpsService.update(documentSzps);
		}
		json.put("result", "success");
		Response.json(json);
	}

	/**
	 * 针对批量导入，直接粘贴复制内容
	 */
	@ResponseBody
	@RequestMapping("/newSaves")
	public void saveInfos(String leaderComment,String infoId,String id){
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<>();
		map.put("roleFlag", DbDefined.ROLE_1);
		List<RoleSet> roleSetList = roleSetService.queryList(map);
		if (StringUtils.isNotBlank(leaderComment)) {
			String[] infomentions = leaderComment.split(",");
			if (infomentions != null) {
				for (int i = 0; i < infomentions.length; i++) {
					Date date = new Date();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
					String year = simpleDateFormat.format(date).substring(0, 4);
					String strs = infomentions[i];
					String[] contents = strs.split("：");
					String[] contentss = strs.split(":");
					//以下是为了区分英文和中文下的  :
					if (contents.length >= contentss.length) {
						contents = contents;
					}else {
						contents = contentss;
					}
					if (contents != null) {
						String userId = "";
						int t = contents[0].indexOf("部长");
						String userName = contents[0].substring(0, t + 2);
						for (int j = 0; j < roleSetList.size(); j++) {
							//判断这个人是否是首长
							if (StringUtils.equals(userName, roleSetList.get(j).getUserName())) {
								userId = roleSetList.get(j).getUserId();
								if (StringUtils.isNotBlank(contents[1])) {//批示内容不为空的才保存。
									String pishiContent = contents[1].substring(1, contents[1].length() - 1);
									int tMonth = contents[0].indexOf("月");
									String month = contents[0].substring(t + 2, tMonth);
									if (Integer.parseInt(month) < 10) {
										month = 0 + month;
									}
									int tDay = contents[0].indexOf("日");
									String day = contents[0].substring(tMonth + 1, tDay);
									if (Integer.parseInt(day) < 10) {
										day = 0 + day;
									}
									DocumentSzps documentSzps = new DocumentSzps();
									documentSzps.setUserId(userId);
									documentSzps.setUserName(userName);
									documentSzps.setLeaderComment(pishiContent);
									documentSzps.setCreatedTime(year + "年" + month + "月" + day + "日");
									documentSzps.setInfoId(infoId);
									if (StringUtils.isBlank(id)) {
										documentSzps.setId(UUIDUtils.random());
										documentSzpsService.save(documentSzps);
									} else {
										documentSzps.setId(id);
										documentSzpsService.update(documentSzps);
									}

								}
							}
						}

					}
				}
			}
		}
		jsonObject.put("result", "success");
		Response.json(jsonObject);
	}

	/**
	 * 针对批量导入新的保存接口
	 * 新的保存
	 *
	 */
	@ResponseBody
	@RequestMapping("/newSave")
	public void saveInfo(String infos) {
		JSONObject jsonObject = new JSONObject();
		if (StringUtils.isNotBlank(infos)) {
			String[] info = infos.split(",");
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					String[] infomention = info[i].split("_");
					if (infomention != null) {
						//如果用户选了多个首长，只给一个首长填了批示，那只保存填了批示的首长，也就是通过批示内容那个字段是否有值来判断。
						if (StringUtils.isNotBlank(infomention[3])) {
							DocumentSzps documentSzps = new DocumentSzps();
							documentSzps.setUserId(infomention[1]);
							documentSzps.setUserName(infomention[2]);
							documentSzps.setLeaderComment(infomention[3]);
							documentSzps.setCreatedTime(infomention[4]+"01日");
							documentSzps.setInfoId(infomention[5]);
							if (StringUtils.isBlank(infomention[0])) {
								documentSzps.setId(UUIDUtils.random());
								documentSzpsService.save(documentSzps);
							} else {
								documentSzps.setId(infomention[0]);
								documentSzpsService.update(documentSzps);
							}
						}
					}
				}
			}
		}
		jsonObject.put("result", "success");
		Response.json(jsonObject);
	}


	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String id){
		documentSzpsService.delete(id);
		Response.json("result", "success");
	}
	
}
