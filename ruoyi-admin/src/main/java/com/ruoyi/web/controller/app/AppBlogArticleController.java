package com.ruoyi.web.controller.app;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.app.mapper.AppBlogArticleMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.app.domain.AppBlogArticle;
import com.ruoyi.app.service.IAppBlogArticleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章Controller
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
@RestController
@RequestMapping("/app/article")
public class AppBlogArticleController extends BaseController
{
    @Autowired
    private IAppBlogArticleService appBlogArticleService;

    @Resource
    private AppBlogArticleMapper appBlogArticleMapper;

    /**
     * 查询文章列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AppBlogArticle appBlogArticle)
    {
        startPage();
        List<AppBlogArticle> list = appBlogArticleService.selectAppBlogArticleList(appBlogArticle);
        return getDataTable(list);
    }

    /**
     * 导出文章列表
     */
    @PreAuthorize("@ss.hasPermi('app:article:export')")
    @Log(title = "文章", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppBlogArticle appBlogArticle)
    {
        List<AppBlogArticle> list = appBlogArticleService.selectAppBlogArticleList(appBlogArticle);
        ExcelUtil<AppBlogArticle> util = new ExcelUtil<AppBlogArticle>(AppBlogArticle.class);
        util.exportExcel(response, list, "文章数据");
    }

    /**
     * 获取文章详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:article:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appBlogArticleService.selectAppBlogArticleById(id));
    }
    @GetMapping(value = "/app/{id}")
    public AjaxResult appGetInfo(@PathVariable("id") Long id)
    {
        return success(appBlogArticleService.selectAppBlogArticleById(id));
    }

    /**
     * 新增文章
     */
    @PreAuthorize("@ss.hasPermi('app:article:add')")
    @Log(title = "文章", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppBlogArticle appBlogArticle)
    {
        return toAjax(appBlogArticleService.insertAppBlogArticle(appBlogArticle));
    }

    /**
     * 修改文章
     */
    @PreAuthorize("@ss.hasPermi('app:article:edit')")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppBlogArticle appBlogArticle)
    {
        return toAjax(appBlogArticleService.updateAppBlogArticle(appBlogArticle));
    }
    /**
     * 点赞+1
     */
    @PutMapping("/app/zan")
    public AjaxResult zan(@RequestBody AppBlogArticle appBlogArticle)
    {
        return toAjax( appBlogArticleMapper.zan(appBlogArticle.getId()));
    }
    /**
     * 游览+1
     */
    @PutMapping("/app/lookAddNumber")
    public AjaxResult lookAddNumber(@RequestBody AppBlogArticle appBlogArticle)
    {
        return toAjax( appBlogArticleMapper.lookAddNumber(appBlogArticle.getId()));
    }

    /**
     * 删除文章
     */
    @PreAuthorize("@ss.hasPermi('app:article:remove')")
    @Log(title = "文章", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appBlogArticleService.deleteAppBlogArticleByIds(ids));
    }
}
