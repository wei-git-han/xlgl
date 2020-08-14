package com.css.app.xlgl.dto;

import java.io.Serializable;

public class XlglConfirmDto implements Serializable {

    //部门名称
    private String deptName;
    //部门id
    private String deptId;
    //报名人数
    private String confirmCount;
    //未报名人数
    private String noConfirmCount;
    //延后人数
    private String qjCount;
    //是否确认 0未确认，1已确认
    private String status;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getConfirmCount() {
        return confirmCount;
    }

    public void setConfirmCount(String confirmCount) {
        this.confirmCount = confirmCount;
    }

    public String getNoConfirmCount() {
        return noConfirmCount;
    }

    public void setNoConfirmCount(String noConfirmCount) {
        this.noConfirmCount = noConfirmCount;
    }

    public String getQjCount() {
        return qjCount;
    }

    public void setQjCount(String qjCount) {
        this.qjCount = qjCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
