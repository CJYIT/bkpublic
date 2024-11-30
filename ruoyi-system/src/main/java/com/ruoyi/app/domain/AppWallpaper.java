package com.ruoyi.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 壁纸对象 app_wallpaper
 *
 * @author budiao
 * @date 2024-04-19
 */
public class AppWallpaper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 壁纸地址 */
    @Excel(name = "壁纸地址")
    private String imgUrl;

    /** 是否需要广告（0代表否 1代表是） */
    @Excel(name = "是否需要广告", readConverterExp = "0=代表否,1=代表是")
    private Long isAd;

    /** 是否隐藏（0代表存在 1代表删除） */
    @Excel(name = "是否隐藏", readConverterExp = "0=代表存在,1=代表删除")
    private String isShow;

    /** 下载次数 */
    @Excel(name = "下载次数")
    private String downNum;

    /** 搜索关键字 */
    @Excel(name = "搜索关键字")
    private String keyword;

    /** 壁纸类型 */
    @Excel(name = "壁纸类型")
    private Long wallpaperType;

    /** 权重 */
    @Excel(name = "权重")
    private Long weight;

    /** 压缩图地址 */
    private String compressImgUrl;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }
    public void setIsAd(Long isAd)
    {
        this.isAd = isAd;
    }

    public Long getIsAd()
    {
        return isAd;
    }
    public void setIsShow(String isShow)
    {
        this.isShow = isShow;
    }

    public String getIsShow()
    {
        return isShow;
    }
    public void setDownNum(String downNum)
    {
        this.downNum = downNum;
    }

    public String getDownNum()
    {
        return downNum;
    }
    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    public String getKeyword()
    {
        return keyword;
    }
    public void setWallpaperType(Long wallpaperType)
    {
        this.wallpaperType = wallpaperType;
    }

    public Long getWallpaperType()
    {
        return wallpaperType;
    }
    public void setWeight(Long weight)
    {
        this.weight = weight;
    }

    public Long getWeight()
    {
        return weight;
    }
    public void setCompressImgUrl(String compressImgUrl)
    {
        this.compressImgUrl = compressImgUrl;
    }

    public String getCompressImgUrl()
    {
        return compressImgUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("imgUrl", getImgUrl())
                .append("isAd", getIsAd())
                .append("isShow", getIsShow())
                .append("downNum", getDownNum())
                .append("keyword", getKeyword())
                .append("wallpaperType", getWallpaperType())
                .append("weight", getWeight())
                .append("createTime", getCreateTime())
                .append("compressImgUrl", getCompressImgUrl())
                .toString();
    }
}
