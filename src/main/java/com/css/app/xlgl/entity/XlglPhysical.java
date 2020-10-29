package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 军事体育训练
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-20 19:38:37
 */
public class XlglPhysical implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//姓名
	private String name;
	//身份证号
	private String idCard;
	//性别
	private String sex;
	//身高
	private String high;
	//类别
	private String type;
	//体重
	private String wight;
	//出生年月
	private String birthday;
	//引体向上
	private String up;
	//仰卧起坐
	private String sit;
	//30*2跑
	private String srun;
	//3000米跑
	private String trun;
	//体型分数
	private String tscore;
	//体型评定
	private String judge;
	//军事体育成绩
	private String allScore;
	//体育等级评定
	private String allJudge;
	//创建时间
	private Date createdTime;
	//创建人
	private String creator;
	//创建人id
	private String userId;
	//年龄
	private String age;

	//人员所在部门
	private String deptName;

	//每次上传的id
	private String upId;

	//是否是正式上传还是自己保存  0是自己保存  1是上传
	private String normal;

	//引体向上个数
	private String ytxs;
	//仰卧起坐个数
	private String ywqz;
	//蛇形跑时间
	private String sxp;
	//3000米长跑用时分
	private String cpf;
	//3000米长跑用时秒
	private String cpm;

	//上一年
	private String lastYear;

	//当前年
	private String curentYear;

	public String getCurentYear() {
		return curentYear;
	}

	public void setCurentYear(String curentYear) {
		this.curentYear = curentYear;
	}

	public String getLastYear() {
		return lastYear;
	}

	public void setLastYear(String lastYear) {
		this.lastYear = lastYear;
	}

	public String getYtxs() {
		return ytxs;
	}

	public void setYtxs(String ytxs) {
		this.ytxs = ytxs;
	}

	public String getYwqz() {
		return ywqz;
	}

	public void setYwqz(String ywqz) {
		this.ywqz = ywqz;
	}

	public String getSxp() {
		return sxp;
	}

	public void setSxp(String sxp) {
		this.sxp = sxp;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpm() {
		return cpm;
	}

	public void setCpm(String cpm) {
		this.cpm = cpm;
	}

	public String getNormal() {
		return normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
	}

	public String getUpId() {
		return upId;
	}

	public void setUpId(String upId) {
		this.upId = upId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：身份证号
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/**
	 * 获取：身份证号
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：身高
	 */
	public void setHigh(String high) {
		this.high = high;
	}
	/**
	 * 获取：身高
	 */
	public String getHigh() {
		return high;
	}
	/**
	 * 设置：类别
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类别
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：体重
	 */
	public void setWight(String wight) {
		this.wight = wight;
	}
	/**
	 * 获取：体重
	 */
	public String getWight() {
		return wight;
	}
	/**
	 * 设置：出生年月
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：出生年月
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * 设置：引体向上
	 */
	public void setUp(String up) {
		this.up = up;
	}
	/**
	 * 获取：引体向上
	 */
	public String getUp() {
		return up;
	}
	/**
	 * 设置：仰卧起坐
	 */
	public void setSit(String sit) {
		this.sit = sit;
	}
	/**
	 * 获取：仰卧起坐
	 */
	public String getSit() {
		return sit;
	}
	/**
	 * 设置：30*2跑
	 */
	public void setSrun(String srun) {
		this.srun = srun;
	}
	/**
	 * 获取：30*2跑
	 */
	public String getSrun() {
		return srun;
	}
	/**
	 * 设置：3000米跑
	 */
	public void setTrun(String trun) {
		this.trun = trun;
	}
	/**
	 * 获取：3000米跑
	 */
	public String getTrun() {
		return trun;
	}
	/**
	 * 设置：体型分数
	 */
	public void setTscore(String tscore) {
		this.tscore = tscore;
	}
	/**
	 * 获取：体型分数
	 */
	public String getTscore() {
		return tscore;
	}
	/**
	 * 设置：体型评定
	 */
	public void setJudge(String judge) {
		this.judge = judge;
	}
	/**
	 * 获取：体型评定
	 */
	public String getJudge() {
		return judge;
	}
	/**
	 * 设置：军事体育成绩
	 */
	public String getAllScore() {
		return allScore;
	}

	public void setAllScore(String allScore) {
		this.allScore = allScore;
	}
	/**
	 * 获取：军事体育成绩
	 */
	/**
	 * 设置：体育等级评定
	 */
	public void setAllJudge(String allJudge) {
		this.allJudge = allJudge;
	}
	/**
	 * 获取：体育等级评定
	 */
	public String getAllJudge() {
		return allJudge;
	}
	/**
	 * 设置：创建时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * 设置：创建人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * 设置：创建人id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：创建人id
	 */
	public String getUserId() {
		return userId;
	}
}
