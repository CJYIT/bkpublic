package com.ruoyi.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资源列对象 app_resource_list
 * 
 * @author budiao
 * @date 2024-04-07
 */
public class AppResourceList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 资源名称 */
    @Excel(name = "资源名称")
    private String listName;

    /** 资源地址 */
    @Excel(name = "资源地址")
    private String listUrl;

    /** 访问密码 */
    @Excel(name = "访问密码")
    private String password;

    /** 关联主表app_resource */
    @Excel(name = "关联主表app_resource")
    private Long appResourceId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setListName(String listName) 
    {
        this.listName = listName;
    }

    public String getListName() 
    {
        return listName;
    }
    public void setListUrl(String listUrl) 
    {
        this.listUrl = listUrl;
    }

    public String getListUrl() 
    {
        return listUrl;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setAppResourceId(Long appResourceId) 
    {
        this.appResourceId = appResourceId;
    }

    public Long getAppResourceId() 
    {
        return appResourceId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("listName", getListName())
            .append("listUrl", getListUrl())
            .append("password", getPassword())
            .append("appResourceId", getAppResourceId())
            .toString();
    }
}
