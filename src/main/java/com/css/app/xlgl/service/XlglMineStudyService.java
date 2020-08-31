package com.css.app.xlgl.service;


import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.app.xlgl.entity.XlglMineStudy;
import com.css.app.xlgl.entity.XlglPhysical;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 训练管理自学表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-21 14:37:00
 */
public interface XlglMineStudyService {
	
	XlglMineStudy queryObject(String id);
	
	List<XlglMineStudy> queryList(Map<String, Object> map);
	
	void save(XlglMineStudy xlglMineStudy);
	
	void update(XlglMineStudy xlglMineStudy);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	public InputStream createExcelInfoFile(List<BaseAppUser> list, String fileName) throws Exception;

	List<XlglMineStudy> importExcle(InputStream is, String id) throws Exception;

	void deleteAllRecord(String[] ids);

	XlglMineStudy queryByUserId(String userId,String year);
}
