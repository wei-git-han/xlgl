package com.css.app.xlgl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.css.app.xlgl.entity.PersonalFile;

@Mapper
public interface PersonalFileDao {
	List<PersonalFile> queryList(Map<String,Object> map);
	
	int queryTotal(Map<String,Object> map);
	
	List<PersonalFile> getTitleList(Map<String,Object> map);
	
	List<PersonalFile> queryListBySubjectId(Map<String,Object> map);
	
	List<PersonalFile> queryRanking();
	
	
	
}
