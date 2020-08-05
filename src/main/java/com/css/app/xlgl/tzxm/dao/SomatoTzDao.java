package com.css.app.xlgl.tzxm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.css.app.xlgl.tzxm.entity.SoldierTz;

@Mapper
public interface SomatoTzDao {

	SoldierTz selectBMI(@Param("height") Float height,@Param("weight") Float weight,@Param("sex") String sex,@Param("age") int age);

	//引体向上
	int selYtxsCount(@Param("age")String age,@Param("ytxscount") String ytxscount);
	//屈臂悬垂
	int selQbxcCount(@Param("age")String age, @Param("qbxcCount")String qbxcCount);
	//仰卧起坐
	int selYwqzCount(@Param("age")String age,@Param("sex") String sex, @Param("ywqzcount")String ywqzcount);
	//30米蛇形跑
	int selSrunCount(@Param("age")String age,@Param("sex") String sex, @Param("sruncount")String sruncount);
	//3000米长跑
	int selTsruncount(@Param("age")String age,@Param("sex") String sex, @Param("tsruncount")String tsruncount);
	
}
