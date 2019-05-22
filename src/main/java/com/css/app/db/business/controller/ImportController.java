package com.css.app.db.business.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.app.db.business.entity.DocumentInfo;
import com.css.app.db.business.entity.DocumentSzps;
import com.css.app.db.business.entity.ReplyExplain;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.service.DocumentInfoService;
import com.css.app.db.business.service.DocumentSzpsService;
import com.css.app.db.business.service.ImportExcleService;
import com.css.app.db.business.service.ReplyExplainService;
import com.css.app.db.business.service.SubDocInfoService;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;

/**
 * 导入wps-excle
 * @author weizy
 *
 */
@RestController
@RequestMapping("/app/db/import")
public class ImportController{
    @Autowired
	DocumentInfoService documentInfoService;
    @Autowired
    DocumentSzpsService documentSzpsService;
    @Autowired
    ReplyExplainService replyExplainService;
    @Autowired
    SubDocInfoService subDocInfoService;
    @Autowired
    BaseAppOrgMappedService baseAppOrgMappedService;
    @Autowired
    ImportExcleService importExcleService;    
    @Autowired
    BaseAppUserService baseAppUserService;    
	@Value("${filePath}")
	private String filePath;

	/**
	 * 导入
	 * 0：军委办件号；1：文件标题；2、承办人姓名；3、批示指示时间；4、发表批示内容
	 * 5、督办落实情况人员姓名；6、督办落实情况时间；7、督办落实情况内容
	 * 8、办理状态名字； 9、承办单位；10、承办人员姓名；11承办人员电话
	 * 12、印发时间；13、文件号；14、工作分工内容
	 */
	@Transactional
	@RequestMapping("/importExcle")
	public void importExcle(MultipartFile file) {
		String userId = "";
		try {
			List<List<Object>> excleDates = importExcleService.getExcleDate(file);
			for (List<Object> excleDate : excleDates) {
				DocumentInfo docInfo = new DocumentInfo();
				docInfo.setId(UUIDUtils.random());
				docInfo.setBanjianNumber(String.valueOf(excleDate.get(0)));// 0：军委办件号
				docInfo.setDocTitle(String.valueOf(excleDate.get(1)));// 1：文件标题
				docInfo.setStatus((Integer) excleDate.get(4));// 8、办理状态
//				docInfo.setBanjianNumber(String.valueOf(excleDate.get(0)));// 0：军委办件号
//				docInfo.setBanjianNumber(String.valueOf(excleDate.get(0)));// 0：军委办件号
				documentInfoService.save(docInfo);
				// ---------------------批示指示内容
				List<Map<String, String>> pszsnrLis = (List<Map<String, String>>) excleDate.get(2);// 批示指示内容
				for (Map<String, String> pszsnrMap : pszsnrLis) {
					DocumentSzps docSzps = new DocumentSzps();
					List<BaseAppUser> queryUserByName = baseAppUserService.queryUserByName(pszsnrMap.get("cbrxm"));
					if (queryUserByName != null && queryUserByName.size() > 0) {
						userId = queryUserByName.get(0).getUserId();
					}
					String pszssj = pszsnrMap.get("pszssj");
					String pizsnr = pszsnrMap.get("pizsnr");
					docSzps.setId(UUIDUtils.random());
					docSzps.setUserId(userId);
					docSzps.setUserName(pszsnrMap.get("cbrxm"));
					docSzps.setCreatedTime(pszssj);
					docSzps.setLeaderComment(pizsnr);
					documentSzpsService.save(docSzps);
				}
				// -------------------督办落实情况
				List<Map<String, String>> dblsqkLis = (List<Map<String, String>>) excleDate.get(3);// 批示指示内容
				for (Map<String, String> dblsqkMap : dblsqkLis) {
					ReplyExplain replyExplain = new ReplyExplain();
					List<BaseAppUser> queryUserByName = baseAppUserService.queryUserByName(dblsqkMap.get("dblsqkryxm"));
					if (queryUserByName != null && queryUserByName.size() > 0) {
						userId = queryUserByName.get(0).getUserId();
					}
					String dblsqksj = dblsqkMap.get("dblsqksj");// 7、督办落实情况时间；
					String dblsqknr = dblsqkMap.get("dblsqknr");// 8、督办落实情况内容
					replyExplain.setId(UUIDUtils.random());
					replyExplain.setUserId(userId);
					replyExplain.setUserName(dblsqkMap.get("dblsqkryxm"));
					replyExplain.setCreatedTime(new SimpleDateFormat("yyyy-MM-dd").parse(dblsqksj));
					replyExplain.setReplyContent(dblsqknr);
					replyExplainService.save(replyExplain);
				}
				// ------------------------承办单位人员
				List<Map<String, String>> undertakeLis = (List<Map<String, String>>) excleDate.get(5);// 承办单位和人员
				for (Map<String, String> undertakerMap : undertakeLis) {
					SubDocInfo subDocInfo = new SubDocInfo();
					List<BaseAppUser> queryUserByName = baseAppUserService.queryUserByName(undertakerMap.get("cbr"));
					if (queryUserByName != null && queryUserByName.size() > 0) {
						userId = queryUserByName.get(0).getUserId();
					}
					String cbdw = undertakerMap.get("cbdw");// 承办单位；
					// String cbrdh = undertakerMap.get("cbrdh");//承办人电话
					subDocInfo.setId(UUIDUtils.random());
					subDocInfo.setUndertaker(userId);
					subDocInfo.setUndertakerName(undertakerMap.get("cbr"));
					subDocInfo.setSubDeptName(cbdw);
					subDocInfoService.save(subDocInfo);
				}

			}
		   } catch (Exception e) {
			e.printStackTrace();
		}
	    Response.ok();
	}
}
