package com.css.app.xlgl.service;


import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.app.xlgl.entity.XlglPhysical;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 军事体育训练
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-20 19:38:37
 */
public interface XlglPhysicalService {
	
	XlglPhysical queryObject(String id);
	
	List<XlglPhysical> queryList(Map<String, Object> map);
	
	void save(XlglPhysical xlglPhysical);
	
	void update(XlglPhysical xlglPhysical);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	void deleteAllRecord(String[] ids);

	public InputStream createExcelInfoFile(List<BaseAppUser> list, String fileName) throws Exception;

	List<XlglPhysical> importExcle(InputStream is,String id) throws Exception;

	XlglPhysical queryByUserId(String userId,String year);


}
