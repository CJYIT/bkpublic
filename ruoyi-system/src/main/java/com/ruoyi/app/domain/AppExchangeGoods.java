package com.ruoyi.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 积分商品对象 app_exchange_goods
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
public class AppExchangeGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsName;

    /** 封面图 */
    @Excel(name = "封面图")
    private String goodsImg;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private Long goodsType;

    /** 兑换所需积分 */
    @Excel(name = "兑换所需积分")
    private Long goodsExchange;

    /** 是否火爆（0代表否 1代表是） */
    @Excel(name = "是否火爆", readConverterExp = "0=代表否,1=代表是")
    private Long isHot;

    /** 删除标志（0代表存在 1代表删除） */
    private Long delFlag;

    /** 是否有库存卡密 */
    @Excel(name = "是否有库存卡密")
    private Long isCami;

    /** 卡密类型 */
    @Excel(name = "卡密类型")
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
    public void setGoodsImg(String goodsImg) 
    {
        this.goodsImg = goodsImg;
    }

    public String getGoodsImg() 
    {
        return goodsImg;
    }
    public void setGoodsType(Long goodsType) 
    {
        this.goodsType = goodsType;
    }

    public Long getGoodsType() 
    {
        return goodsType;
    }
    public void setGoodsExchange(Long goodsExchange) 
    {
        this.goodsExchange = goodsExchange;
    }

    public Long getGoodsExchange() 
    {
        return goodsExchange;
    }
    public void setIsHot(Long isHot) 
    {
        this.isHot = isHot;
    }

    public Long getIsHot() 
    {
        return isHot;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodsName", getGoodsName())
            .append("goodsImg", getGoodsImg())
            .append("goodsType", getGoodsType())
            .append("goodsExchange", getGoodsExchange())
            .append("isHot", getIsHot())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
