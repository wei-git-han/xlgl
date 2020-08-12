package com.css.app.xlgl.controller;

import java.io.IOException;
import java.util.*;

import com.css.app.xlgl.entity.XlglPicture;
import com.css.app.xlgl.service.XlglPictureService;
import com.netflix.discovery.converters.Auto;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.entity.XlglNews;
import com.css.app.xlgl.service.XlglNewsService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.GwPageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

import cn.com.css.filestore.impl.HTTPFile;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("/app/xlgl/news")
public class XlglNewsController {
	private final Logger logger = LoggerFactory.getLogger(XlglNewsController.class);
	
	
	@Autowired
	private XlglNewsService xlglNewsService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;	
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private XlglPictureService xlglPictureService;
	
	
	/**
	 * 查询全局发布新闻数和各局发布新闻数
	 * @param type 查询类型 week:周、month：月、year:年
	 */
	@ResponseBody
	@RequestMapping("/queryTotal")
	public void queryTotal(String type){
		JSONObject json = new JSONObject();
		//查询全局本年度发布新闻数
		int totalYear = xlglNewsService.queryTotalYear();
		//查询全局本月发布新闻数
		int totalMonth = xlglNewsService.queryTotalMonth();
		//查询全局本周发布新闻数
		int totalWeek = xlglNewsService.queryTotalWeek();
		//判断查询类型是年、月、周
		if(!StringUtils.isEmpty(type)&&StringUtils.equalsIgnoreCase("week", type)){
			List<LinkedHashMap<String, Integer>> totalWeekByOrgan = xlglNewsService.queryTotalWeekByOrgan();
			json.put("totalWeekByOrgan", totalWeekByOrgan);
		}else if(!StringUtils.isEmpty(type)&&StringUtils.equalsIgnoreCase("month", type)){
			List<LinkedHashMap<String, Integer>> totalMonthByOrgan = xlglNewsService.queryTotalMonthByOrgan();
			json.put("totalMonthByOrgan", totalMonthByOrgan);
		}else if(!StringUtils.isEmpty(type)&&StringUtils.equalsIgnoreCase("year", type)){
			List<LinkedHashMap<String, Integer>> totalYearByOrgan = xlglNewsService.queryTotalYearByOrgan();
			json.put("totalYearByOrgan", totalYearByOrgan);
		}
		json.put("totalYear", totalYear);
		json.put("totalMonth", totalMonth);
		json.put("totalWeek", totalWeek);
		Response.json(json);
	}
	
	/**
	 * 删除新闻动态
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String ids){
		Date date = new Date();
		logger.info("当前操作人："+CurrentUser.getUsername()+"---id:"+CurrentUser.getUserId()+"--时间是："+date);
		String[] idArry = ids.split(",");
		xlglNewsService.deleteBatch(idArry);
		Response.json("result","success");
	}
	
	
	/**
	 * 置顶新闻
	 * @param id
	 */
	@ResponseBody
	@RequestMapping("/top")
	public void topping(String id){
		//查询目前置顶的新闻，先将目前置顶的新闻置顶状态改为0
//		XlglNews topXlglNews = xlglNewsService.queryNowTop();
//		if(null != topXlglNews){
//			topXlglNews.setIsTop(0);
//			xlglNewsService.update(topXlglNews);
//		}
		//将要置顶的新闻置顶状态改为1

		XlglNews xlglNews = xlglNewsService.queryObject(id);
		//xlglNews.setId(id);
		xlglNews.setIsTop(1);
		xlglNewsService.update(xlglNews);
		Response.json("result", "success");
	}


	@ResponseBody
	@RequestMapping("/topCancle")
	public void topCancle(String id){
		XlglNews xlglNews  = xlglNewsService.queryObject(id);
		xlglNews.setIsTop(0);
		xlglNewsService.update(xlglNews);
		Response.json("result","success");

	}
	
	
	/**
	 * 列表展示
	 * @param page
	 * @param pagesize
	 * type   查询的类型
	 */
	@ResponseBody
	@RequestMapping("list")
	public void list(Integer page, Integer pagesize,String type){
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("type",type);
		PageHelper.startPage(page, pagesize);
		List<XlglNews> xlglNewsList = xlglNewsService.queryList(map);
		GwPageUtils pageUtil = new GwPageUtils(xlglNewsList);
		Response.json(pageUtil);
	}
	
	
	/**
	 * 增加新闻点击量
	 * 详情页接口
	 * @param id
	 */
	@ResponseBody
	@RequestMapping("addHits")
	public void addHits(String id){
		//查询目前的点击量
		synchronized (id) {
			XlglNews xlglNews = xlglNewsService.queryObject(id);
			Integer hits = xlglNews.getHits();
			hits+=1;
			xlglNews.setHits(hits);
			xlglNewsService.update(xlglNews);
			Response.json("xlglNews",xlglNews);
		}
		
		
	}
	
	
	
	@ResponseBody
	@RequestMapping("saveOrUpdate")
	public void saveOrUpdate(XlglNews xlglNews,String pIds){
		//判断是新增还是修改,id不为空则是修改，为空则是新增
		String id = xlglNews.getId();
		if(!StringUtils.isEmpty(id)){
			xlglNewsService.update(xlglNews);
		}else{
			String releaseOrganid="";
			String releaseOrgan="";
			String releaseDeptid="";
			String releaseDept="";
			//设置id
			String fId = UUIDUtils.random();
			xlglNews.setId(fId);
			//设置发布时间
			xlglNews.setReleaseDate(new Date());
			//获取发布人id
			String releaseUserid = CurrentUser.getUserId();
			if(StringUtils.isNotBlank(releaseUserid)) {
				//设置发布人id
				xlglNews.setReleaseUserid(releaseUserid);
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
			//设置发布人姓名
			xlglNews.setReleaseUser(CurrentUser.getUsername());
			//设置发布部门id和发布部门
			xlglNews.setReleaseOrganid(releaseOrganid);
			xlglNews.setReleaseOrgan(releaseOrgan);
			//设置发布单位id和发布单位
			xlglNews.setReleaseDeptid(releaseDeptid);
			xlglNews.setReleaseDept(releaseDept);
			xlglNewsService.save(xlglNews);

			if(StringUtils.isNotBlank(pIds)) {
				String[] ids = pIds.split(",");
				xlglPictureService.deleteBatch(ids);
				for (int i = 0; i < ids.length; i++) {
					XlglPicture xlglPicture = new XlglPicture();
					xlglPicture.setId(UUIDUtils.random());
					xlglPicture.setFileId(fId);
					xlglPicture.setIsFirst("0");
					xlglPicture.setPictureId(ids[i]);
					xlglPicture.setSort("0");
					xlglPictureService.save(xlglPicture);
				}
			}

		}
		Response.json("result","success");
		
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
	 * 正式发布
	 */
	@ResponseBody
	@RequestMapping("/fabu")
	public void fabu(String id){
		if(StringUtils.isNotBlank(id)){
			XlglNews xlglNews = xlglNewsService.queryObject(id);
			if(xlglNews != null){
				xlglNews.setIsRelease("1");
				xlglNewsService.update(xlglNews);
				Response.json("result","发布成功");
			}

		}
	}
	
	/**
	 * 查询草稿箱
	 * @param page
	 * @param pagesize
	 */
	@ResponseBody
	@RequestMapping("queryDrafts")
	public void queryDrafts(Integer page, Integer pagesize){
		HashMap<String, Object> map = new HashMap<String,Object>();
		PageHelper.startPage(page, pagesize);
		List<XlglNews> xlglNewsList = xlglNewsService.queryDrafts(map);
		GwPageUtils pageUtil = new GwPageUtils(xlglNewsList);
		Response.json(pageUtil);
	}


	
	/**
	 * 保存图片
	 * @param file
	 */
	@ResponseBody
	@RequestMapping("uploadPicture")
	public void uploadPicture(@RequestParam(value="httpFile",required=false) MultipartFile file ){
		JSONObject json = new JSONObject();
		
		try {
			 HTTPFile httpFile=HTTPFile.save( file.getInputStream(),file.getOriginalFilename());
			 String filePath = httpFile.getFilePath();
			 json.put("filePath", filePath);
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
	@RequestMapping("downloadPicture")
	public void downloadPicture(String fileId){
		HTTPFile httpFile = new HTTPFile(fileId);
		String filePath = httpFile.getFilePath();
		Response.json(filePath);
	}
}
