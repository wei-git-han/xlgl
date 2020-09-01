package com.css.app.xlgl.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.entity.XlglNotice;
import com.css.app.xlgl.entity.XlglPicture;
import com.css.app.xlgl.service.XlglNoticeService;
import com.css.app.xlgl.service.XlglPictureService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.GwPageUtils;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

import cn.com.css.filestore.impl.HTTPFile;
import net.sf.json.JSONObject;



/**
 * 训练管理-通知公告表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-04 13:44:55
 */
@Controller
@RequestMapping("/app/xlgl/xlglnotice")
public class XlglNoticeController {
	private final Logger logger = LoggerFactory.getLogger(XlglNewsController.class);
	@Autowired
	private XlglNoticeService xlglNoticeService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;	
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private XlglPictureService xlglPictureService;
	

	/**
	 * 查询全局发布通知公告数和各局发布通知公告数
	 * @param type 查询类型 week:周、month：月、year:年
	 */
	@ResponseBody
	@RequestMapping("/queryTotal")
	public void queryTotal(String type){
		JSONObject json = new JSONObject();
		//查询全局本年度发布新闻数
		int totalYear = xlglNoticeService.queryTotalYear();
		//查询全局本月发布通知公告数
		int totalMonth = xlglNoticeService.queryTotalMonth();
		//查询全局本周发布通知公告数
		int totalWeek = xlglNoticeService.queryTotalWeek();
		//判断查询类型是年、月、周
		if(!StringUtils.isEmpty(type)&&StringUtils.equalsIgnoreCase("week", type)){
			List<LinkedHashMap<String, Integer>> totalWeekByOrgan = xlglNoticeService.queryTotalWeekByOrgan();
			json.put("totalWeekByOrgan", totalWeekByOrgan);
		}else if(!StringUtils.isEmpty(type)&&StringUtils.equalsIgnoreCase("month", type)){
			List<LinkedHashMap<String, Integer>> totalMonthByOrgan = xlglNoticeService.queryTotalMonthByOrgan();
			json.put("totalMonthByOrgan", totalMonthByOrgan);
		}else if(!StringUtils.isEmpty(type)&&StringUtils.equalsIgnoreCase("year", type)){
			List<LinkedHashMap<String, Integer>> totalYearByOrgan = xlglNoticeService.queryTotalYearByOrgan();
			json.put("totalYearByOrgan", totalYearByOrgan);
		}
		json.put("totalYear", totalYear);
		json.put("totalMonth", totalMonth);
		json.put("totalWeek", totalWeek);
		Response.json(json);
	}
	
	/**
	 * 列表
	 * @param page
	 * @param pagesize
	 * type   查询的类型
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit,String type){
		Map<String, Object> map = new HashMap<>();
		map.put("type",type);
		PageHelper.startPage(page, limit);
		//查询列表数据
		List<XlglNotice> xlglNoticeList = xlglNoticeService.queryList(map);
		for (XlglNotice xlglNotice : xlglNoticeList) {
			map.put("pictureId", xlglNotice.getId());
			List<XlglPicture> queryList = xlglPictureService.queryList(map);
			ArrayList<String> pictureIds = new ArrayList<String>();
			if(queryList.size()>0) {
				for (XlglPicture xlglPicture : queryList) {
					pictureIds.add(xlglPicture.getFileId());
				}
			}
			xlglNotice.setPictureIds(pictureIds);
		}
		PageUtils pageUtil = new PageUtils(xlglNoticeList);
		Response.json("page",pageUtil);
	}
	
	/**
	 * 获取上一篇，下一篇
	 * type   查询的类型
	 */
	@ResponseBody
	@RequestMapping("/infoUpAndDown")
	public void infoUpAndDown(String id,String type){
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<>();
		map.put("type",type);
		//查询列表数据
		List<XlglNotice> xlglNoticeList = xlglNoticeService.queryList(map);
		for (int i = 0; i < xlglNoticeList.size(); i++) {
			if(xlglNoticeList.get(i).getId().equals(id)) {
				if(i !=0) {
					jsonObject.put("upNotice", xlglNoticeList.get(i-1));
				}
				if(i != xlglNoticeList.size()-1) {
					jsonObject.put("downNotice", xlglNoticeList.get(i+1));
				}
			}
		}
		Response.json(jsonObject);
	}
	
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		XlglNotice xlglNotice = xlglNoticeService.queryObject(id);
		if(xlglNotice.getViewNumber() !=null) {
			xlglNotice.setViewNumber(xlglNotice.getViewNumber()+1);
		}else {
			xlglNotice.setViewNumber(1);
		}
		
		xlglNoticeService.update(xlglNotice);
		Response.json("xlglNotice", xlglNotice);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglNotice xlglNotice){
		xlglNotice.setId(UUIDUtils.random());
		xlglNoticeService.save(xlglNotice);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglNotice xlglNotice){
		xlglNoticeService.update(xlglNotice);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		Date date = new Date();
		logger.info("当前操作人："+CurrentUser.getUsername()+"---id:"+CurrentUser.getUserId()+"--时间是："+date);
		xlglNoticeService.deleteBatch(ids);
		Response.ok();
	}
	/**
	 * 置顶通知功能
	 * @param id
	 * @param istop 0不置顶，1置顶
	 */
	@ResponseBody
	@RequestMapping("/top")
	public void topping(String id,String istop){
		XlglNotice queryObject = xlglNoticeService.queryObject(id);
		if(queryObject != null && StringUtils.isNotBlank(istop)) {
			queryObject.setIsTop(Integer.parseInt(istop));
		}
		xlglNoticeService.update(queryObject);
		Response.ok();
	}
	
	
	@ResponseBody
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(XlglNotice xlglNotice,String pIds){
		//判断是新增还是修改,id不为空则是修改，为空则是新增
		String id = xlglNotice.getId();
		if(StringUtils.isNotBlank(xlglNotice.getReleaseTimeStr())) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date parse = simpleDateFormat.parse(xlglNotice.getReleaseTimeStr());
				xlglNotice.setReleaseTime(parse);
			} catch (ParseException e) {
				e.printStackTrace();
				Response.error();
			}
		}
		if(!StringUtils.isEmpty(id)){
			xlglNoticeService.update(xlglNotice);
			if(StringUtils.isNotBlank(pIds)) {
				String[] ids = pIds.split(",");
				for (int i = 0; i < ids.length; i++) {
					XlglPicture xlglPicture = new XlglPicture();
					xlglPicture.setId(UUIDUtils.random());
					xlglPicture.setFileId(xlglNotice.getId());
					xlglPicture.setIsFirst("0");
					xlglPicture.setPictureId(ids[i]);
					xlglPicture.setSort("0");
					HTTPFile httpFile = new HTTPFile(ids[i]);
					xlglPicture.setPictureName(httpFile.getFileName());
					xlglPictureService.save(xlglPicture);
				}
			}
		}else{
			String releaseOrganid="";
			String releaseOrgan="";
			String releaseDeptid="";
			String releaseDept="";
			//设置id
			String fId = UUIDUtils.random();
			xlglNotice.setId(fId);
			//设置发布时间
			xlglNotice.setReleaseTime(new Date());
			xlglNotice.setIsTop(0);
			//获取发布人id
			String releaseUserid = CurrentUser.getUserId();
			if(StringUtils.isNotBlank(releaseUserid)) {
				//设置发布人id
				releaseOrganid = baseAppUserService.getBareauByUserId(releaseUserid);
				if(StringUtils.isNotBlank(releaseOrganid)) {
					BaseAppOrgan organ = baseAppOrganService.queryObject(releaseOrganid);
					if(organ != null) {
						releaseOrgan=organ.getName();
					}
				}
				List<BaseAppUser> users = baseAppUserService.findByUserId(releaseUserid);
				if(users != null) {
					releaseDeptid = users.get(0).getOrganid();
					BaseAppOrgan dept = baseAppOrganService.queryObject(releaseDeptid);
					if(dept != null) {
						releaseDept=dept.getName();
					}
				}
			}
			//设置发布部门id和发布部门
			xlglNotice.setReleaseOrganid(releaseOrganid);
			xlglNotice.setReleaseOrgan(releaseOrgan);
			xlglNoticeService.save(xlglNotice);
			if(StringUtils.isNotBlank(pIds)) {
				String[] ids = pIds.split(",");
				xlglPictureService.deleteBatch(ids);
				for (int i = 0; i < ids.length; i++) {
					XlglPicture xlglPicture = new XlglPicture();
					xlglPicture.setId(UUIDUtils.random());
					xlglPicture.setFileId(fId);
					xlglPicture.setIsFirst("0");
					xlglPicture.setPictureId(ids[i]);
					HTTPFile httpFile = new HTTPFile(ids[i]);
					xlglPicture.setPictureName(httpFile.getFileName());
					xlglPicture.setSort("0");
					xlglPictureService.save(xlglPicture);
				}
			}

		}
		Response.ok();
		
	}
	
	/**
	 * 查询某个文件所有的图片
	 * @param id
	 */
	@ResponseBody
	@RequestMapping("/pictureList")
	public void pictureList(String id){
		List<XlglPicture> list = new ArrayList<XlglPicture>();
		if(StringUtils.isNotBlank(id)){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("id",id);
			if(StringUtils.isNotBlank(id)){
				list = xlglPictureService.queryList(map);
			}
		}
		Response.json("list",list);
	}
	
	/**
	 * 查询草稿箱
	 * @param page
	 * @param pagesize
	 */
	@ResponseBody
	@RequestMapping("/queryDrafts")
	public void queryDrafts(Integer page, Integer pagesize){
		HashMap<String, Object> map = new HashMap<String,Object>();
		PageHelper.startPage(page, pagesize);
		List<XlglNotice> queryDrafts = xlglNoticeService.queryDrafts(map);
		GwPageUtils pageUtil = new GwPageUtils(queryDrafts);
		Response.json(pageUtil);
	}
	
	
	/**
	 * 保存图片
	 * @param file
	 */
	@ResponseBody
	@RequestMapping("/uploadPicture")
	public void uploadPicture(@RequestParam(value="file",required=false) MultipartFile file ){
		JSONObject json = new JSONObject();
		String originalFilename = file.getOriginalFilename();
		try {
			 HTTPFile httpFile=HTTPFile.save( file.getInputStream(),file.getOriginalFilename());
			 String filePath = httpFile.getFilePath();
			 json.put("fileName", originalFilename);
			 json.put("filePath", filePath);
			 json.put("fileid", httpFile.getFileId());
			 Response.json(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 文件下载
	 * @param fileId
	 */
	@ResponseBody
	@RequestMapping("/downloadPicture")
	public void downloadPicture(String fileId){
		HTTPFile httpFile = new HTTPFile(fileId);
		Response.download(httpFile.getFileName(), httpFile.getInputSteam());
	}
}
