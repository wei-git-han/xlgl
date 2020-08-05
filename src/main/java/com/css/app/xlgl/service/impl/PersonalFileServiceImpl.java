package com.css.app.xlgl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.PersonalFileDao;
import com.css.app.xlgl.entity.PersonalFile;
import com.css.app.xlgl.service.PersonalFileService;

@Service("personalFileService")
public class PersonalFileServiceImpl implements PersonalFileService {
	@Autowired
	private PersonalFileDao personalFileDao;
	@Override
	public List<PersonalFile> queryList(Map<String, Object> map) {
		return personalFileDao.queryList(map);
	}
	@Override
	public int queryTotal(Map<String, Object> map) {
		return personalFileDao.queryTotal(map);
	}
	@Override
	public List<PersonalFile> getTitleList(Map<String, Object> map) {
		return personalFileDao.getTitleList(map);
	}
	@Override
	public List<PersonalFile> queryListBySubjectId(Map<String, Object> map) {
		return personalFileDao.queryListBySubjectId(map);
	}
	@Override
	public List<PersonalFile> queryRanking() {
		return personalFileDao.queryRanking();
	}

}
