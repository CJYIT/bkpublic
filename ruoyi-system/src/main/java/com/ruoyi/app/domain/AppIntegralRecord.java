package com.ruoyi.app.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 积分记录对象 app_integral_record
 * 
 * @author budiao
 * @date 2024-04-07
 */
public class AppIntegralRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 来源 */
    @Excel(name = "来源")
    private String source;

    /** 是否增加（0代表增加 1代表减少） */
    @Excel(name = "是否增加", readConverterExp = "0=代表增加,1=代表减少")
    private Long isAdd;

    /** 增减分数 */
    @Excel(name = "增减分数")
    private Long integralNumber;

    /** 记录用户 */
    @Excel(name = "记录用户")
    private Long userId;

    /** 记录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "记录时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date integralTime;
    private Long fId;

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setIsAdd(Long isAdd) 
    {
        this.isAdd = isAdd;
    }

    public Long getIsAdd() 
    {
        return isAdd;
    }
    public void setIntegralNumber(Long integralNumber) 
    {
        this.integralNumber = integralNumber;
    }

    public Long getIntegralNumber() 
    {
        return integralNumber;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("source", getSource())
            .append("isAdd", getIsAdd())
            .append("integralNumber", getIntegralNumber())
            .append("userId", getUserId())
            .append("integralTime", getIntegralTime())
            .toString();
    }
}
