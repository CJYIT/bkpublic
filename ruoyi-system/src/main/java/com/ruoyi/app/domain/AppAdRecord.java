package com.ruoyi.app.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 广告点击记录对象 app_ad_record
 * 
 * @author budiao
 * @date 2024-04-07
 */
public class AppAdRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 点击用户 */
    @Excel(name = "点击用户")
    private Long userId;

    /** 点击时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "点击时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date integralTime;

    /** 广告类型 */
    @Excel(name = "广告类型")
    private Long adType;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setIntegralTime(Date integralTime) 
    {
        this.integralTime = integralTime;
    }

    public Date getIntegralTime() 
    {
        return integralTime;
    }
    public void setAdType(Long adType) 
    {
        this.adType = adType;
    }

    public Long getAdType() 
    {
        return adType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("integralTime", getIntegralTime())
            .append("adType", getAdType())
            .toString();
    }
}
