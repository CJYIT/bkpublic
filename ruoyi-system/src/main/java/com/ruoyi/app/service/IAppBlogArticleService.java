package com.ruoyi.app.service;

import java.util.List;

import com.ruoyi.app.domain.AppBlogArticle;

/**
 * 文章Service接口
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
public interface IAppBlogArticleService 
{
    /**
     * 查询文章
     * 
     * @param id 文章主键
     * @return 文章
     */
    public AppBlogArticle selectAppBlogArticleById(Long id);

    /**
     * 查询文章列表
     * 
     * @param appBlogArticle 文章
     * @return 文章集合
     */
    public List<AppBlogArticle> selectAppBlogArticleList(AppBlogArticle appBlogArticle);

    /**
     * 新增文章
     * 
     * @param appBlogArticle 文章
     * @return 结果
     */
    public int insertAppBlogArticle(AppBlogArticle appBlogArticle);

    /**
     * 修改文章
     * 
     * @param appBlogArticle 文章
     * @return 结果
     */
    public int updateAppBlogArticle(AppBlogArticle appBlogArticle);

    /**
     * 批量删除文章
     * 
     * @param ids 需要删除的文章主键集合
     * @return 结果
     */
    public int deleteAppBlogArticleByIds(Long[] ids);

    /**
     * 删除文章信息
     * 
     * @param id 文章主键
     * @return 结果
     */
    public int deleteAppBlogArticleById(Long id);
}
