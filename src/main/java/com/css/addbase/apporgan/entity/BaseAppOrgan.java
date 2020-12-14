package com.css.addbase.apporgan.entity;

import java.io.Serializable;
import java.util.List;

import com.css.app.xlgl.dto.TxlUserDto;

/**
 * 部门表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2017-11-29 15:10:13
 */
public class BaseAppOrgan implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	//树路径
	private String treePath;
	//删除标识
	private Integer isdelete;
	//部门名称
	private String name;
	//更新时间戳
	private Long timestamp;
	//排序
	private Integer sort;
	//更新类型
	private Integer type;
	//部门编码
	private String code;
	//上级部门
	private String parentId;
	//更新类型
	private Integer deptOfficer;
	//业务配置-是否有效0或null是有效，1：为无效
	private String isInvalid;
	
	//应在位人数
	private Integer yzwrs;
	//实际在位人数
	private Integer sjzwrs;
	//人员在位率
	private String zwrate;
	//请假人数
	private Integer qjrs;
	//休假人数
	private Integer xjrs;
	//查看权限 0:不能看，1：能看
	private String status;
	
	//注册人数
	private Integer zcrs;
	//应在线人数
	private Integer yzxrs;
	//在线人数
	private Integer zxrs;
	
	private List<TxlUserDto> list;
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
	 * 设置：树路径
	 */
	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}
	/**
	 * 获取：树路径
	 */
	public String getTreePath() {
		return treePath;
	}
	/**
	 * 设置：删除标识
	 */
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	/**
	 * 获取：删除标识
	 */
	public Integer getIsdelete() {
		return isdelete;
	}
	/**
	 * 设置：部门名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：部门名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：更新时间戳
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * 获取：更新时间戳
	 */
	public Long getTimestamp() {
		return timestamp;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：更新类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：更新类型
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：部门编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：部门编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：上级部门
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级部门
	 */
	public String getParentId() {
		return parentId;
	}
	public Integer getDeptOfficer() {
		return deptOfficer;
	}
	public void setDeptOfficer(Integer deptOfficer) {
		this.deptOfficer = deptOfficer;
	}
	public Integer getYzwrs() {
		return yzwrs;
	}
	public void setYzwrs(Integer yzwrs) {
		this.yzwrs = yzwrs;
	}
	public Integer getSjzwrs() {
		return sjzwrs;
	}
	public void setSjzwrs(Integer sjzwrs) {
		this.sjzwrs = sjzwrs;
	}
	public Integer getQjrs() {
		return qjrs;
	}
	public void setQjrs(Integer qjrs) {
		this.qjrs = qjrs;
	}
	public Integer getXjrs() {
		return xjrs;
	}
	public void setXjrs(Integer xjrs) {
		this.xjrs = xjrs;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getZwrate() {
		return zwrate;
	}
	public void setZwrate(String zwrate) {
		this.zwrate = zwrate;
	}
	public String getIsInvalid() {
		return isInvalid;
	}
	public void setIsInvalid(String isInvalid) {
		this.isInvalid = isInvalid;
	}
	public Integer getZcrs() {
		return zcrs;
	}
	public void setZcrs(Integer zcrs) {
		this.zcrs = zcrs;
	}
	public Integer getYzxrs() {
		return yzxrs;
	}
	public void setYzxrs(Integer yzxrs) {
		this.yzxrs = yzxrs;
	}
	public Integer getZxrs() {
		return zxrs;
	}
	public void setZxrs(Integer zxrs) {
		this.zxrs = zxrs;
	}
	public List<TxlUserDto> getList() {
		return list;
	}
	public void setList(List<TxlUserDto> list) {
		this.list = list;
	}
	
	
	
}
