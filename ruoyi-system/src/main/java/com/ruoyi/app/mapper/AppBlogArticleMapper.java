package com.ruoyi.app.mapper;

import java.util.List;

import com.ruoyi.app.domain.AppBlogArticle;
import org.apache.ibatis.annotations.Update;

/**
 * 文章Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
public interface AppBlogArticleMapper 
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
     * 删除文章
     * 
     * @param id 文章主键
     * @return 结果
     */
    public int deleteAppBlogArticleById(Long id);

    /**
     * 批量删除文章
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppBlogArticleByIds(Long[] ids);

    /**
     * 点赞+1
     *
     * @param id 需要id
     * @return 结果
     */
    @Update("update app_blog_article SET love_number = love_number+1 where id = #{id}")
    public int zan(Long id);

    /**
     * 游览+1
     *
     * @param id 需要id
     * @return 结果
     */
    @Update("update app_blog_article SET look_number = look_number+1 where id = #{id}")
    public int lookAddNumber(Long id);
}
