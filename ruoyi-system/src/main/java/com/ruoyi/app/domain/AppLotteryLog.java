package com.ruoyi.app.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 抽奖记录对象 app_lottery_log
 * 
 * @author budiao
 * @date 2024-06-20
 */
public class AppLotteryLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 中奖礼品id */
    @Excel(name = "中奖礼品id")
    private Long goodId;

    /** 中奖人id */
    @Excel(name = "中奖人id")
    private Long lotteryUserId;

    /** 中奖时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "中奖时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lotteryTime;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGoodId(Long goodId) 
    {
        this.goodId = goodId;
    }

    public Long getGoodId() 
    {
        return goodId;
    }
    public void setLotteryUserId(Long lotteryUserId) 
    {
        this.lotteryUserId = lotteryUserId;
    }

    public Long getLotteryUserId() 
    {
        return lotteryUserId;
    }
    public void setLotteryTime(Date lotteryTime) 
    {
        this.lotteryTime = lotteryTime;
    }

    public Date getLotteryTime() 
    {
        return lotteryTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodId", getGoodId())
            .append("lotteryUserId", getLotteryUserId())
            .append("lotteryTime", getLotteryTime())
            .toString();
    }
}
