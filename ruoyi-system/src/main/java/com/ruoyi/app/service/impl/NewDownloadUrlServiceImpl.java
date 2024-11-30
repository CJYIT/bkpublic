package com.ruoyi.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.NewDownloadUrlMapper;
import com.ruoyi.app.domain.NewDownloadUrl;
import com.ruoyi.app.service.INewDownloadUrlService;

/**
 * 待配置安全域名Service业务层处理
 * 
 * @author budiao
 * @date 2024-04-28
 */
@Service
public class NewDownloadUrlServiceImpl implements INewDownloadUrlService 
{
    @Autowired
    private NewDownloadUrlMapper newDownloadUrlMapper;

    /**
     * 查询待配置安全域名
     * 
     * @param id 待配置安全域名主键
     * @return 待配置安全域名
     */
    @Override
    public NewDownloadUrl selectNewDownloadUrlById(Long id)
    {
        return newDownloadUrlMapper.selectNewDownloadUrlById(id);
    }

    /**
     * 查询待配置安全域名列表
     * 
     * @param newDownloadUrl 待配置安全域名
     * @return 待配置安全域名
     */
    @Override
    public List<NewDownloadUrl> selectNewDownloadUrlList(NewDownloadUrl newDownloadUrl)
    {
        return newDownloadUrlMapper.selectNewDownloadUrlList(newDownloadUrl);
    }

    /**
     * 新增待配置安全域名
     * 
     * @param newDownloadUrl 待配置安全域名
     * @return 结果
     */
    @Override
    public int insertNewDownloadUrl(NewDownloadUrl newDownloadUrl)
    {
        return newDownloadUrlMapper.insertNewDownloadUrl(newDownloadUrl);
    }

    /**
     * 修改待配置安全域名
     * 
     * @param newDownloadUrl 待配置安全域名
     * @return 结果
     */
    @Override
    public int updateNewDownloadUrl(NewDownloadUrl newDownloadUrl)
    {
        return newDownloadUrlMapper.updateNewDownloadUrl(newDownloadUrl);
    }

    /**
     * 批量删除待配置安全域名
     * 
     * @param ids 需要删除的待配置安全域名主键
     * @return 结果
     */
    @Override
    public int deleteNewDownloadUrlByIds(Long[] ids)
    {
        return newDownloadUrlMapper.deleteNewDownloadUrlByIds(ids);
    }

    /**
     * 删除待配置安全域名信息
     * 
     * @param id 待配置安全域名主键
     * @return 结果
     */
    @Override
    public int deleteNewDownloadUrlById(Long id)
    {
        return newDownloadUrlMapper.deleteNewDownloadUrlById(id);
    }
}
