package com.ruoyi.app.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 兑换记录对象 app_exchange_records
 *
 * @author budiao
 * @date 2024-04-11
 */
public class AppExchangeRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsName;

    /** 兑换人 */
    @Excel(name = "兑换人")
    private String recordsUserId;

    /** 使用积分数 */
    @Excel(name = "使用积分数")
    private Long recordsNumber;

    /** 兑换时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "兑换时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date recordsTime;

    /** 兑换码 */
    @Excel(name = "兑换码")
    private String redemptionCode;

    /** 是否兑换 */
    @Excel(name = "是否兑换")
    private String redemptionState;

    /** 卡密 */
    private Long isCami;
    private Long camiType;

    public Long getIsCami() {
        return isCami;
    }

    public void setIsCami(Long isCami) {
        this.isCami = isCami;
    }

    public Long getCamiType() {
        return camiType;
    }

    public void setCamiType(Long camiType) {
        this.camiType = camiType;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName()
    {
        return goodsName;
    }
    public void setRecordsUserId(String recordsUserId)
    {
        this.recordsUserId = recordsUserId;
    }

    public String getRecordsUserId()
    {
        return recordsUserId;
    }
    public void setRecordsNumber(Long recordsNumber)
    {
        this.recordsNumber = recordsNumber;
    }

    public Long getRecordsNumber()
    {
        return recordsNumber;
    }
    public void setRecordsTime(Date recordsTime)
    {
        this.recordsTime = recordsTime;
    }

    public Date getRecordsTime()
    {
        return recordsTime;
    }
    public void setRedemptionCode(String redemptionCode)
    {
        this.redemptionCode = redemptionCode;
    }

    public String getRedemptionCode()
    {
        return redemptionCode;
    }
    public void setRedemptionState(String redemptionState)
    {
        this.redemptionState = redemptionState;
    }

    public String getRedemptionState()
    {
        return redemptionState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("goodsName", getGoodsName())
                .append("recordsUserId", getRecordsUserId())
                .append("recordsNumber", getRecordsNumber())
                .append("recordsTime", getRecordsTime())
                .append("redemptionCode", getRedemptionCode())
                .append("redemptionState", getRedemptionState())
                .toString();
    }
}
