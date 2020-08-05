package com.css.app.xlgl.tzxm.service;

import com.css.app.xlgl.tzxm.entity.SoldierTz;

public interface SomatoTzService {

	SoldierTz selectBMI(Float height, Float weight, String sex,int age);

	//引体向上成绩
	int selYtxsCount(String age, String ytxscount);

	//屈臂垂悬成绩
	int selQbxcCount(String age, String qbxcCount);

	//仰卧起坐成绩
	int selYwqzCount(String age, String sex, String ywqzcount);

	//蛇形跑成绩
	int selSrunCount(String age, String sex, String sruncount);

	//3000米长跑成绩
	int selTsruncount(String age, String sex, String tsruncount);
	
}
