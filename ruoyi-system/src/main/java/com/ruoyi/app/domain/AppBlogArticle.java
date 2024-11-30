package com.ruoyi.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章对象 app_blog_article
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
public class AppBlogArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String title;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String contentInfo;

    /** 文章类型 */
    @Excel(name = "文章类型")
    private Long articleType;

    /** 搜素关键字 */
    @Excel(name = "搜素关键字")
    private String keyword;

    /** 封面图url */
    @Excel(name = "封面图url")
    private String showImg;

    /** 关联已有资源（关联app_resource id） */
    @Excel(name = "关联已有资源", readConverterExp = "关=联app_resource,i=d")
    private Long appResourceId;

    /** 游览次数 */
    @Excel(name = "游览次数")
    private Long lookNumber;

    /** 点赞次数 */
    @Excel(name = "点赞次数")
    private Long loveNumber;

    /** 是否为推荐文章 */
    @Excel(name = "是否为推荐文章")
    private Long isRecommendation;

    /** 是否隐藏（0代表存在 1代表删除） */
    @Excel(name = "是否隐藏", readConverterExp = "0=代表存在,1=代表删除")
    private Long isShow;

    /** 是否需要广告（0代表否 1代表是） */
    @Excel(name = "是否需要广告", readConverterExp = "0=代表否,1=代表是")
    private Long isAd;

    /** 需要观看几次广告解锁 */
    @Excel(name = "需要观看几次广告解锁")
    private Long adNumber;

    /** 删除标志（0代表存在 1代表删除） */
    private Long delFlag;

    /** 排序字段 */
    private String orderType;
    /** 权重 */
    @Excel(name = "权重")
    private Long weight;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContentInfo(String contentInfo) 
    {
        this.contentInfo = contentInfo;
    }

    public String getContentInfo() 
    {
        return contentInfo;
    }
    public void setArticleType(Long articleType) 
    {
        this.articleType = articleType;
    }

    public Long getArticleType() 
    {
        return articleType;
    }
    public void setShowImg(String showImg) 
    {
        this.showImg = showImg;
    }

    public String getShowImg() 
    {
        return showImg;
    }
    public void setAppResourceId(Long appResourceId) 
    {
        this.appResourceId = appResourceId;
    }

    public Long getAppResourceId() 
    {
        return appResourceId;
    }
    public void setLookNumber(Long lookNumber) 
    {
        this.lookNumber = lookNumber;
    }

    public Long getLookNumber() 
    {
        return lookNumber;
    }
    public void setLoveNumber(Long loveNumber) 
    {
        this.loveNumber = loveNumber;
    }

    public Long getLoveNumber() 
    {
        return loveNumber;
    }
    public void setIsRecommendation(Long isRecommendation) 
    {
        this.isRecommendation = isRecommendation;
    }

    public Long getIsRecommendation() 
    {
        return isRecommendation;
    }
    public void setIsShow(Long isShow) 
    {
        this.isShow = isShow;
    }

    public Long getIsShow() 
    {
        return isShow;
    }
    public void setIsAd(Long isAd) 
    {
        this.isAd = isAd;
    }

    public Long getIsAd() 
    {
        return isAd;
    }
    public void setAdNumber(Long adNumber) 
    {
        this.adNumber = adNumber;
    }

    public Long getAdNumber() 
    {
        return adNumber;
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
            .append("title", getTitle())
            .append("contentInfo", getContentInfo())
            .append("articleType", getArticleType())
            .append("showImg", getShowImg())
            .append("appResourceId", getAppResourceId())
            .append("lookNumber", getLookNumber())
            .append("loveNumber", getLoveNumber())
            .append("isRecommendation", getIsRecommendation())
            .append("isShow", getIsShow())
            .append("isAd", getIsAd())
            .append("adNumber", getAdNumber())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
