package com.css.app.xlgl.tzxm.entity;

import java.io.Serializable;

public class SoldierTz implements Serializable{

	private String height;
	
	private Float min_weight;
	
	private Float max_weight;
	
	private int min_age;
	
	private int max_age;
	
	private String sex;
	
	private Float MIN_BMI;
	
	private Float MAX_BMI;

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public Float getMin_weight() {
		return min_weight;
	}

	public void setMin_weight(Float min_weight) {
		this.min_weight = min_weight;
	}

	public Float getMax_weight() {
		return max_weight;
	}

	public void setMax_weight(Float max_weight) {
		this.max_weight = max_weight;
	}

	public int getMin_age() {
		return min_age;
	}

	public void setMin_age(int min_age) {
		this.min_age = min_age;
	}

	public int getMax_age() {
		return max_age;
	}

	public void setMax_age(int max_age) {
		this.max_age = max_age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Float getMIN_BMI() {
		return MIN_BMI;
	}

	public void setMIN_BMI(Float mIN_BMI) {
		MIN_BMI = mIN_BMI;
	}

	public Float getMAX_BMI() {
		return MAX_BMI;
	}

	public void setMAX_BMI(Float mAX_BMI) {
		MAX_BMI = mAX_BMI;
	}

}
