package com.css.app.xlgl.service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.PersonalFile;

public interface PersonalFileService {
	List<PersonalFile> queryList(Map<String,Object> map);
	
	int queryTotal(Map<String,Object> map);
	
	List<PersonalFile> getTitleList(Map<String,Object> map);
	
	List<PersonalFile> queryListBySubjectId(Map<String,Object> map);
	
	List<PersonalFile> queryRanking();
}
