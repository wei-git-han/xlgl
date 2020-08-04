package com.css.app.xlgl.tzxm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.css.app.xlgl.tzxm.entity.SoldierTz;

@Mapper
public interface SomatoTzDao {

	SoldierTz selectBMI(@Param("height") Float height,@Param("weight") Float weight,@Param("sex") String sex,@Param("age") int age);
	

}
