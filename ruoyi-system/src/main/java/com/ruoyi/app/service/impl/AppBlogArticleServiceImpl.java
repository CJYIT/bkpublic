package com.ruoyi.app.service.impl;

import java.util.List;

import com.ruoyi.app.domain.AppBlogArticle;
import com.ruoyi.app.mapper.AppBlogArticleMapper;
import com.ruoyi.app.service.IAppBlogArticleService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文章Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
@Service
public class AppBlogArticleServiceImpl implements IAppBlogArticleService
{
    @Autowired
    private AppBlogArticleMapper appBlogArticleMapper;

    /**
     * 查询文章
     * 
     * @param id 文章主键
     * @return 文章
     */
    @Override
    public AppBlogArticle selectAppBlogArticleById(Long id)
    {
        return appBlogArticleMapper.selectAppBlogArticleById(id);
    }

    /**
     * 查询文章列表
     * 
     * @param appBlogArticle 文章
     * @return 文章
     */
    @Override
    public List<AppBlogArticle> selectAppBlogArticleList(AppBlogArticle appBlogArticle)
    {
        return appBlogArticleMapper.selectAppBlogArticleList(appBlogArticle);
    }

    /**
     * 新增文章
     * 
     * @param appBlogArticle 文章
     * @return 结果
     */
    @Override
    public int insertAppBlogArticle(AppBlogArticle appBlogArticle)
    {
        appBlogArticle.setCreateTime(DateUtils.getNowDate());
        return appBlogArticleMapper.insertAppBlogArticle(appBlogArticle);
    }

    /**
     * 修改文章
     * 
     * @param appBlogArticle 文章
     * @return 结果
     */
    @Override
    public int updateAppBlogArticle(AppBlogArticle appBlogArticle)
    {
        return appBlogArticleMapper.updateAppBlogArticle(appBlogArticle);
    }

    /**
     * 批量删除文章
     * 
     * @param ids 需要删除的文章主键
     * @return 结果
     */
    @Override
    public int deleteAppBlogArticleByIds(Long[] ids)
    {
        return appBlogArticleMapper.deleteAppBlogArticleByIds(ids);
    }

    /**
     * 删除文章信息
     * 
     * @param id 文章主键
     * @return 结果
     */
    @Override
    public int deleteAppBlogArticleById(Long id)
    {
        return appBlogArticleMapper.deleteAppBlogArticleById(id);
    }
}
