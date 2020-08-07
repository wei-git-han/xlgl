package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * @author 中软信息系统工程有限公司
 * @email
 * @date 2020-08-05 13:46:02
 */
public class TaskMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private String menuId;
    //
    private String menuName;
    //
    private String displayName;
    //
    private String defaultPage;
    //
    private Integer sort;
    //
    private String treePath;
    //
    private Integer displayType;
    //
    private String remark;
    //
    private String parentId;

    private String icon;

    private String path;

    /**
     * 设置：
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取：
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 设置：
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取：
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置：
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 获取：
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 设置：
     */
    public void setDefaultPage(String defaultPage) {
        this.defaultPage = defaultPage;
    }

    /**
     * 获取：
     */
    public String getDefaultPage() {
        return defaultPage;
    }

    /**
     * 设置：
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取：
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置：
     */
    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }

    /**
     * 获取：
     */
    public String getTreePath() {
        return treePath;
    }

    /**
     * 设置：
     */
    public void setDisplayType(Integer displayType) {
        this.displayType = displayType;
    }

    /**
     * 获取：
     */
    public Integer getDisplayType() {
        return displayType;
    }

    /**
     * 设置：
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置：
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：
     */
    public String getParentId() {
        return parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
