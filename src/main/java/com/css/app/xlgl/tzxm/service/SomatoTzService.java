package com.css.app.xlgl.tzxm.service;

import com.css.app.xlgl.tzxm.entity.SoldierTz;

public interface SomatoTzService {

	SoldierTz selectBMI(Float height, Float weight, String sex,int age);
	
	
}
