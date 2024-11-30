package com.ruoyi.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资源卡密对象 app_cami
 * 
 * @author ruoyi
 * @date 2024-06-19
 */
public class AppCami extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 卡密 */
    @Excel(name = "卡密")
    private String cami;

    /** 卡密类型 */
    @Excel(name = "卡密类型")
    private Long camiTyep;

    /** 是否使用 */
    @Excel(name = "是否使用")
    private Long delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCami(String cami) 
    {
        this.cami = cami;
    }

    public String getCami() 
    {
        return cami;
    }
    public void setCamiTyep(Long camiTyep) 
    {
        this.camiTyep = camiTyep;
    }

    public Long getCamiTyep() 
    {
        return camiTyep;
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
            .append("cami", getCami())
            .append("camiTyep", getCamiTyep())
            .append("createTime", getCreateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
