package com.ruoyi.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 待配置安全域名对象 new_download_url
 * 
 * @author budiao
 * @date 2024-04-28
 */
public class NewDownloadUrl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 待配置域名 */
    @Excel(name = "待配置域名")
    private String httpUrl;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHttpUrl(String httpUrl) 
    {
        this.httpUrl = httpUrl;
    }

    public String getHttpUrl() 
    {
        return httpUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("httpUrl", getHttpUrl())
            .toString();
    }
}
