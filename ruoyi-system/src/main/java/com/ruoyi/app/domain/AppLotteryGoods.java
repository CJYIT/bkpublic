package com.ruoyi.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 抽奖礼品配置对象 app_lottery_goods
 *
 * @author budiao
 * @date 2024-06-19
 */
public class AppLotteryGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 展示图 */
    @Excel(name = "展示图")
    private String image;

    /** 礼品名称 */
    @Excel(name = "礼品名称")
    private String name;

    /** 获得概率 */
    @Excel(name = "获得概率")
    private Long percentage;

    /** 积分奖励 */
    @Excel(name = "积分奖励")
    private Long reward;

    /** 礼品索引 */
    @Excel(name = "礼品索引")
    private Long indexNum;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setImage(String image)
    {
        this.image = image;
    }

    public String getImage()
    {
        return image;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setPercentage(Long percentage)
    {
        this.percentage = percentage;
    }

    public Long getPercentage()
    {
        return percentage;
    }
    public void setReward(Long reward)
    {
        this.reward = reward;
    }

    public Long getReward()
    {
        return reward;
    }
    public void setIndexNum(Long indexNum)
    {
        this.indexNum = indexNum;
    }

    public Long getIndexNum()
    {
        return indexNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("image", getImage())
                .append("name", getName())
                .append("percentage", getPercentage())
                .append("reward", getReward())
                .append("indexNum", getIndexNum())
                .toString();
    }
}
