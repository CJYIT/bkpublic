package com.ruoyi.app.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资源对象 app_resource
 *
 * @author budiao
 * @date 2024-04-08
 */
public class AppResource extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 资源标题 */
    @Excel(name = "资源标题")
    private String resourceTitle;

    /** 封面图 */
    @Excel(name = "封面图")
    private String showImg;

    /** 说明 */
    @Excel(name = "说明")
    private String explain;

    /** 资源类型 */
    @Excel(name = "资源类型")
    private Long resourceType;

    /** 搜素关键字 */
    @Excel(name = "搜素关键字")
    private String keyword;

    /** 是否隐藏（0代表存在 1代表删除） */
    @Excel(name = "是否隐藏", readConverterExp = "0=代表存在,1=代表删除")
    private Long isShow;

    /** 是否需要广告（0代表否 1代表是） */
    @Excel(name = "是否需要广告", readConverterExp = "0=代表否,1=代表是")
    private Long isAd;

    /** 需要观看几次广告解锁 */
    @Excel(name = "需要观看几次广告解锁")
    private Long adNumber;

    /** 下载次数 */
    @Excel(name = "下载次数")
    private Long downNum;

    /** 权重 */
    @Excel(name = "权重")
    private Long weight;

    /** 删除标志（0代表存在 1代表删除） */
    private Long delFlag;

    /** 资源列信息 */
    private List<AppResourceList> appResourceListList;

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
    public void setResourceTitle(String resourceTitle)
    {
        this.resourceTitle = resourceTitle;
    }

    public String getResourceTitle()
    {
        return resourceTitle;
    }
    public void setShowImg(String showImg)
    {
        this.showImg = showImg;
    }

    public String getShowImg()
    {
        return showImg;
    }
    public void setExplain(String explain)
    {
        this.explain = explain;
    }

    public String getExplain()
    {
        return explain;
    }
    public void setResourceType(Long resourceType)
    {
        this.resourceType = resourceType;
    }

    public Long getResourceType()
    {
        return resourceType;
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
    public void setDownNum(Long downNum)
    {
        this.downNum = downNum;
    }

    public Long getDownNum()
    {
        return downNum;
    }
    public void setWeight(Long weight)
    {
        this.weight = weight;
    }

    public Long getWeight()
    {
        return weight;
    }
    public void setDelFlag(Long delFlag)
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag()
    {
        return delFlag;
    }

    public List<AppResourceList> getAppResourceListList()
    {
        return appResourceListList;
    }

    public void setAppResourceListList(List<AppResourceList> appResourceListList)
    {
        this.appResourceListList = appResourceListList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("resourceTitle", getResourceTitle())
                .append("showImg", getShowImg())
                .append("explain", getExplain())
                .append("resourceType", getResourceType())
                .append("isShow", getIsShow())
                .append("isAd", getIsAd())
                .append("adNumber", getAdNumber())
                .append("downNum", getDownNum())
                .append("weight", getWeight())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("remark", getRemark())
                .append("appResourceListList", getAppResourceListList())
                .toString();
    }
}
