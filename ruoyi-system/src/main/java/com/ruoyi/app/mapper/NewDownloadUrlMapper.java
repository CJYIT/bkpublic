package com.ruoyi.app.mapper;

import java.util.List;
import com.ruoyi.app.domain.NewDownloadUrl;

/**
 * 待配置安全域名Mapper接口
 * 
 * @author budiao
 * @date 2024-04-28
 */
public interface NewDownloadUrlMapper 
{
    /**
     * 查询待配置安全域名
     * 
     * @param id 待配置安全域名主键
     * @return 待配置安全域名
     */
    public NewDownloadUrl selectNewDownloadUrlById(Long id);

    /**
     * 查询待配置安全域名列表
     * 
     * @param newDownloadUrl 待配置安全域名
     * @return 待配置安全域名集合
     */
    public List<NewDownloadUrl> selectNewDownloadUrlList(NewDownloadUrl newDownloadUrl);

    /**
     * 新增待配置安全域名
     * 
     * @param newDownloadUrl 待配置安全域名
     * @return 结果
     */
    public int insertNewDownloadUrl(NewDownloadUrl newDownloadUrl);

    /**
     * 修改待配置安全域名
     * 
     * @param newDownloadUrl 待配置安全域名
     * @return 结果
     */
    public int updateNewDownloadUrl(NewDownloadUrl newDownloadUrl);

    /**
     * 删除待配置安全域名
     * 
     * @param id 待配置安全域名主键
     * @return 结果
     */
    public int deleteNewDownloadUrlById(Long id);

    /**
     * 批量删除待配置安全域名
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNewDownloadUrlByIds(Long[] ids);
}
