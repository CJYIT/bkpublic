package com.ruoyi.app.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 短剧资源对象 app_duanju
 * 
 * @author budiao
 * @date 2024-06-07
 */
public class AppDuanju extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 短句名称 */
    @Excel(name = "短句名称")
    private String bjName;

    /** 短句链接 */
    @Excel(name = "短句链接")
    private String djUrl;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBjName(String bjName) 
    {
        this.bjName = bjName;
    }

    public String getBjName() 
    {
        return bjName;
    }
    public void setDjUrl(String djUrl) 
    {
        this.djUrl = djUrl;
    }

    public String getDjUrl() 
    {
        return djUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bjName", getBjName())
            .append("djUrl", getDjUrl())
            .append("createTime", getCreateTime())
            .toString();
    }
}
