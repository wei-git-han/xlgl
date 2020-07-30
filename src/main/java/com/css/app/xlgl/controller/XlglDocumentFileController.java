package com.css.app.xlgl.controller;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.UploadContext;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.AppConfig;
import com.css.addbase.FileBaseUtil;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgmapped.entity.BaseAppOrgMapped;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.constant.AppInterfaceConstant;
import com.css.addbase.suwell.OfdTransferUtil;
import com.css.app.xlgl.entity.XlglDocumentFile;
import com.css.app.xlgl.service.XlglDocumentFileService;
import com.css.base.utils.CrossDomainUtil;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

import cn.com.css.filestore.impl.HTTPFile;

import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;


/**
 * 基本信息表携带文件的关系表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-28 13:15:37
 */
@Controller
@RequestMapping("/xlgl/xlgldocumentfile")
public class XlglDocumentFileController{
	@Autowired
	private XlglDocumentFileService xlglDocumentFileService;
	@Autowired
	private AppConfig appConfig;
	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(String infoId){
		List<XlglDocumentFile> fileList=null;
		if(StringUtils.isNotBlank(infoId)) {
			Map<String, Object> map = new HashMap<>();
			map.put("infoId", infoId);
			fileList = xlglDocumentFileService.queryList(map);
		}
		Response.json(fileList);
	}
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/getFile")
	public void info(String id){
		System.err.println(id);
		XlglDocumentFile xlglDocumentFile = xlglDocumentFileService.queryObject(id);
		JSONObject json= new JSONObject();
		if(xlglDocumentFile!=null) {
			String formatId=xlglDocumentFile.getFileServerFormatId();
			if(StringUtils.isNotBlank(formatId)){
				//获取版式文件的下载路径
				HTTPFile httpFiles = new HTTPFile(formatId);
				if(httpFiles!=null) {
					json.put("formatId", formatId);
					json.put("downFormatIdUrl", httpFiles.getAssginDownloadURL(true));
				}
			}
		}
		Response.json(json);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlgldocumentfile:save")
	public void save(@RequestBody XlglDocumentFile xlglDocumentFile){
		xlglDocumentFile.setId(UUIDUtils.random());
		xlglDocumentFileService.save(xlglDocumentFile);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlgldocumentfile:update")
	public void update(@RequestBody XlglDocumentFile xlglDocumentFile){
		xlglDocumentFileService.update(xlglDocumentFile);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String ids){
		if(StringUtils.isNotBlank(ids)) {
			String[] idArray = ids.split(",");
			xlglDocumentFileService.deleteBatch(idArray);
			Response.json("result","success");
		}
	}
	
	/**
	 * 文件上传保存
	 * 
	 * @param idpdf
	 *            主记录id(documentInfo的id)
	 * @param pdf
	 *            文件
	 */
	@ResponseBody
	@RequestMapping("/uploadFile")
	public void savePDF(String idpdf, @RequestParam(required = false) MultipartFile[] pdf) {
		String formatDownPath = "";// 版式文件下载路径
		String retFormatId = null;// 返回的版式文件id
		String streamId = null;// 流式文件id
		String formatId = null;// 版式文件id
		JSONObject json = new JSONObject();
		if (StringUtils.isNotBlank(idpdf)) {
			if (pdf != null && pdf.length > 0) {
				for (int i = 0; i < pdf.length; i++) {
					String fileName = pdf[i].getOriginalFilename();
					// 获取文件后缀
					String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
					// 如果文件是流式则流式转换为版式
					if (!StringUtils.equals("ofd", fileType)) {
						streamId = FileBaseUtil.fileServiceUpload(pdf[i]);
						HTTPFile hf = new HTTPFile(streamId);
						try {
							String path = appConfig.getLocalFilePath() + UUIDUtils.random() + "." + hf.getSuffix();
							try {
								FileUtils.moveFile(new File(hf.getFilePath()), new File(path));
							} catch (IOException e) {
								e.printStackTrace();
							}
							if (StringUtils.isNotBlank(path)) {
								formatId = OfdTransferUtil.convertLocalFileToOFD(path);
							}
							// 删除本地的临时流式文件
							if (new File(path).exists()) {
								new File(path).delete();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						formatId = FileBaseUtil.fileServiceUpload(pdf[i]);
					}
					if (StringUtils.isNotBlank(formatId)) {
						if (i == 0) {
							retFormatId = formatId;
							// 获取版式文件的下载路径
							HTTPFile httpFiles = new HTTPFile(formatId);
							if (httpFiles != null) {
								formatDownPath = httpFiles.getAssginDownloadURL(true);
							}
						}
						// 保存文件相关数据
						XlglDocumentFile file = new XlglDocumentFile();
						file.setId(UUIDUtils.random());
						file.setDocInfoId(idpdf);
						file.setSort(xlglDocumentFileService.queryMinSort(idpdf));
						file.setFileName(fileName);
						file.setCreatedTime(new Date());
						if (StringUtils.isNotBlank(streamId)) {
							file.setFileServerStreamId(streamId);
						}
						file.setFileServerFormatId(formatId);
						xlglDocumentFileService.save(file);
					}
				}
				json.put("smjId", retFormatId);
				json.put("smjFilePath", formatDownPath);
				json.put("result", "success");
			}
		} else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
	
	/**
	 * 富文本上传
	 * @param currentSite
	 * @param currentWebID
	 * @param currentColumnID
	 * @param watermark
	 * @param user
	 */
	@ResponseBody
	@RequestMapping("/upLoad")
	public void Upload() {
		System.out.println("ddddddddddd");
	}
//	public void upLoad(Site currentSite,String currentWebID,String currentColumnID,String watermark,User user) {
//        JSONObject obj=new JSONObject();
//        try {
//            String uploadPath = MyUtil.getTmpDir();
//            uploadPath = uploadPath.substring(0, uploadPath.length() - 1);
//            String action = getPara("action");
//            String rtn = new ActionEnter(getRequest(), uploadPath).exec();
//            System.out.println("--rtn--" + rtn);
//            obj= JSON.parseObject(rtn);
//            System.out.println("--obj--" + obj);
//            String state = obj.getString("state");
//            WebFileService webFileService = new WebFileService();
//            // 将上传文件信息保存在数据库中
//            if (state != null && state.equals("SUCCESS")) {
//                String tempFile = uploadPath + obj.getString("url");
//                String url = obj.getString("url");
//                //String realPath=prefixPath+url;
//                String fileType = "";
//                //System.out.println("--dir--"+dir+"--url-"+url+"--action--"+action);
//
//                switch (action) {
//                    case "uploadvideo":
//                        // 转换为mp4
//
//                        String targetMp4 = VedioUtil.convertMp4Thread(uploadPath + url);
//                        url = targetMp4.substring(uploadPath.length(), targetMp4.length());
//                        String targetImg = targetMp4.substring(0, targetMp4.lastIndexOf(".")) + ".jpg";
//                        VedioUtil.processImage(targetMp4, targetImg, 5f, 5f);
//                        String urlImg = url.substring(0, url.lastIndexOf(".")) + ".jpg";
//                        obj.put("url", url);
//                        obj.put("urlImg", urlImg);
//                        fileType = "video";
//                        break;
//                    case "uploadfile":
//                        // 转换为swf
//                        String ext = url.toLowerCase().substring(url.lastIndexOf("."), url.length());
//                        System.out.println("--ext--" + ext);
//                        if (".doc.docx.ppt.txt.pptx.pdf".indexOf(ext) != -1) {
//                            String docFile = uploadPath + url;
//                            String pdfFile = docFile.substring(0, docFile.lastIndexOf(".")) + ".pdf";
//                            String swfFile = docFile.substring(0, docFile.lastIndexOf(".")) + ".swf";
//
//                            Doc2Swf d = new Doc2Swf();
//                            String OpenOffice_HOME = PropKit.use("myconfig.properties").get("OpenOffice_HOME");
//                            if (new File(OpenOffice_HOME).exists() && !ext.equals(".pdf")) {
//                                d.office2PDF(docFile, pdfFile);
//                                ext = ".pdf";
//                            }
//						/*if(ext.equals(".pdf")){
//							d.convertFileToSwf(pdfFile,swfFile);
//						}*/
//                            //url=url.substring(0, url.lastIndexOf("."))+".swf";
//                            //obj.put("url", url);
//                        }
//                        fileType = "file";
//                        break;
//                    case "uploadimage":
//                        // 水印
//                        //String watermark = "";
//                        if (StrKit.notBlank(watermark)) {
//                            WatermarkService ws = new WatermarkService();
//                            Watermark w = Watermark.dao.findById(Site.dao.findById(currentSite.getStr("keyid")).getStr("WaterMarkID"));
//                            if (w != null) {
//                                url = ws.addMark(uploadPath + url, url, w, watermark);
//                            }
//                            System.out.println("--url1--" + url);
//                            obj.put("url", url);
//                        }
//                        fileType = "image";
//                        break;
//                    case "catchimage":
//                        fileType = "image";
//                        //System.out.println("-----obj--"+obj.getJSONArray("list"));
//                        for (Object o : obj.getJSONArray("list")) {
//                            //System.out.println("--o--"+((JSONObject)o).getString("url"));
//                            JSONObject jo = (JSONObject) o;
//                            String url1 = jo.getString("url");
//                            String fileKeyID = url1.substring(url1.lastIndexOf("/") + 1, url1.lastIndexOf(".")).split("_")[0];//视频会在原文件后加_,图片加水印后会在后面加_1
//
//                            url1 = webFileService.addFile(tempFile, fileKeyID, MyUtil.getCTX(), currentSite.getStr("siteID"), currentColumnID, currentWebID, MyUtil.getDate(), jo.getString("title"), fileType);
//                            jo.put("url", url1);
//                        }
//					/*JSONArray arr=obj.getJSONArray("list");
//					for(int i=0;i<arr.size();i++){
//						System.out.println(""+arr[i].);
//					}*/
//                        break;
//                    default:
//                }
//                //System.out.println("--url--"+url);
//                // 保存数据库
//                //User user = null;
//                //System.out.println("--url--"+url);
//                if (StrKit.notBlank(url)) {
//                    String fileKeyID = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(".")).split("_")[0];//视频会在原文件后加_,图片加水印后会在后面加_1
//
//                    System.out.println("--uploadPath+url------------------------------------------------------------------------" + uploadPath + url + "-----fileKeyID-----" + fileKeyID);
//                    tempFile = uploadPath + obj.getString("url");//添加水印后的新地址
//                    url = webFileService.addFile(tempFile, fileKeyID, MyUtil.getCTX(), currentSite.getStr("siteID"), currentColumnID, currentWebID, MyUtil.getDate(), obj.getString("original"), fileType);
//                    obj.put("url", url);
//                   // logger.info("/myconsole/ueditor/url:{}",url);
//                    if (obj.get("urlImg") != null) {
//                        String urlImg = (String) obj.get("urlImg");
//                       // logger.info("/myconsole/ueditor/urlImg:{}",urlImg);
//                        //System.out.println("--uploadPath+urlImg-----------------------------------------------------"+uploadPath+urlImg);
//                        urlImg = webFileService.addFile(uploadPath + urlImg, fileKeyID + "1", MyUtil.getCTX(), currentSite.getStr("siteID"), currentColumnID, currentWebID, MyUtil.getDate(), obj.getString("original"), "image");
//                        obj.put("urlImg", urlImg);
//                    }
//                    Log.dao.recordLog(fileKeyID, "信息发布", "上传", "上传类型：" + action + "，url地址：" + obj.get("url"), user);
//                    if (StringUtils.equals(action, "uploadvideo")) {
//                        String videoUrl = "/videoplay?webFileId=" + fileKeyID;
//                        // 将返回值url重写为修改后的地址，请求VideoPlayController 中的index方法
//                        obj.put("url", videoUrl);
//                    }
//                }
//            }
//        }catch (Exception e) {
//           // logger.info("/myconsole/ueditor出错了:{}",e);
//            e.printStackTrace();
//        }
//        renderHtml(JSON.toJSONString(obj));
//
//	}
	
	
	/**
	 * 文件上传接口
	 * @param pdf
	 */
	@ResponseBody
	@RequestMapping("/upLoadFile")
	public void upLoad(@RequestParam(value = "pdf", required = false) MultipartFile pdf) {
		JSONObject json = new JSONObject();
		String fileId = FileBaseUtil.fileServiceUpload(pdf);
		json.put("fileId", fileId);
		Response.json(json);
	}
	
	/**
	 * 文件下载接口
	 * @param fileId
	 */
	@ResponseBody
	@RequestMapping("/downLoad")
	public void downLoad(String fileId) {
		HTTPFile httpFile = new HTTPFile(fileId);
		String fileName = httpFile.getFileName();
		Response.download(fileName, httpFile.getInputSteam());
	}
	
	/**
	 * 请假人数
	 * @return
	 */
	public List unOnlineUserIds(String deptId) {
		List<String> accountList = new ArrayList<String>();
		LinkedMultiValueMap<String,Object> infoMap = new LinkedMultiValueMap<String,Object>();
		infoMap.add("fromFlag", "listPage");
		infoMap.add("deptId", "");
		BaseAppOrgMapped mapped = (BaseAppOrgMapped) baseAppOrgMappedService.orgMappedByOrgId(null, "root",
				AppInterfaceConstant.APP_QXJGL);
		if(mapped != null){
			String url = mapped.getUrl() + AppInterfaceConstant.WEB_INTERFACE_QXJ;
			String returnString = CrossDomainUtil.postJSONString(url, infoMap);
			String accounts = returnString.substring(1,returnString.length()-1).replace("\"", "");
			String [] accountArray = accounts.split("\\s*,\\s*");
			accountList = new ArrayList<String>(Arrays.asList(accountArray));
		}
		return accountList;
	}
	
	/**
	 * 在线人
	 */
	public int userIdList() {
		List<String> accountList = new ArrayList<String>();
		LinkedMultiValueMap<String,Object> infoMap = new LinkedMultiValueMap<String,Object>();
		infoMap.add("arch", "arm64");
		BaseAppOrgMapped mapped = (BaseAppOrgMapped) baseAppOrgMappedService.orgMappedByOrgId(null, "root",
				AppInterfaceConstant.APP_XLGLZXR);
		if(mapped != null){
			String url = mapped.getUrl() + AppInterfaceConstant.WEB_INTERFACE_XLGLZXR;
			String returnString = CrossDomainUtil.postJSONString(url, infoMap);
			String accounts = returnString.substring(1,returnString.length()-1).replace("\"", "");
			String [] accountArray = accounts.split("\\s*,\\s*");
			accountList = new ArrayList<String>(Arrays.asList(accountArray));
		}
		return accountList.size();
	}
	
	/**
	 * 在编率
	 */
	
	public int zbl(String deptId) {
		int Sum = baseAppUserService.queryAllUser(deptId);
		int zbNum = baseAppUserService.queryZbUser(deptId);
		float result = (float)zbNum/Sum;
		DecimalFormat dFormat = new DecimalFormat("0.00");
		String resultStr = dFormat.format(result);
		float resultFloat = Float.parseFloat(resultStr);
		int resultInt = (int)(resultFloat * 100);
		return resultInt;
	}
	
	/**
	 * 各单位人员统计列表
	 */
	
	@ResponseBody
	@RequestMapping("/list")
	public void list() {
		JSONArray jsonArray = new JSONArray();
		List<BaseAppOrgan> list = baseAppOrganService.queryAllDept("root");
		for (int i = 0; i < list.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			String deptName = list.get(i).getName();
			String deptId = list.get(i).getId();
			int qjNum = unOnlineUserIds(deptId).size();//各单位请假人数
			int sum = baseAppUserService.queryUserNum(deptId);//各单位实际人数
			int zwNum = sum - qjNum;//各单位在位人数
			int zbl = zbl(deptId);//各单位在编率
			jsonObject.put("sum", sum);
			jsonObject.put("zwNum", zwNum);
			jsonObject.put("zwl", zwNum/sum);
			jsonObject.put("zbl", zbl);
			jsonObject.put("deptName", deptName);
			jsonArray.add(jsonObject);
		}
		Response.json(jsonArray);
		
	}
	
	/**
	 * 人员管理详情列表
	 */
	
	@ResponseBody
	@RequestMapping("/listInfo")
	public void listInfo() {
		String organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
		List<BaseAppUser> list = baseAppUserService.queryUsers(organId);// 各单位实际人员列表
		List qjList = unOnlineUserIds(organId);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < qjList.size(); j++) {
				Map<String, String> map = (Map<String, String>) qjList.get(j);
				if (list.get(i).getUserId().equals(map.get("userId"))) {
					list.get(i).setSfzw("1");
					continue;
				}
			}
		}
		Response.json("list", list);

	}
	
	
}
