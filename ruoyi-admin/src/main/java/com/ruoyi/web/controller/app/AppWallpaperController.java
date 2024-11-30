package com.ruoyi.web.controller.app;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.app.domain.AppBlogArticle;
import com.ruoyi.app.mapper.AppWallpaperMapper;
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
import com.ruoyi.app.domain.AppWallpaper;
import com.ruoyi.app.service.IAppWallpaperService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 壁纸Controller
 * 
 * @author budiao
 * @date 2024-04-12
 */
@RestController
@RequestMapping("/app/wallpaper")
public class AppWallpaperController extends BaseController
{
    @Autowired
    private IAppWallpaperService appWallpaperService;
    @Resource
    private AppWallpaperMapper appWallpaperMapper;

    /**
     * 查询壁纸列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AppWallpaper appWallpaper)
    {
        startPage();
        List<AppWallpaper> list = appWallpaperService.selectAppWallpaperList(appWallpaper);
        return getDataTable(list);
    }

    /**
     * 导出壁纸列表
     */
    @PreAuthorize("@ss.hasPermi('app:wallpaper:export')")
    @Log(title = "壁纸", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppWallpaper appWallpaper)
    {
        List<AppWallpaper> list = appWallpaperService.selectAppWallpaperList(appWallpaper);
        ExcelUtil<AppWallpaper> util = new ExcelUtil<AppWallpaper>(AppWallpaper.class);
        util.exportExcel(response, list, "壁纸数据");
    }

    /**
     * 获取壁纸详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:wallpaper:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appWallpaperService.selectAppWallpaperById(id));
    }

    /**
     * 新增壁纸
     */
    @PreAuthorize("@ss.hasPermi('app:wallpaper:add')")
    @Log(title = "壁纸", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppWallpaper appWallpaper)
    {
        appWallpaper.setCreateTime(new Date());
        return toAjax(appWallpaperService.insertAppWallpaper(appWallpaper));
    }

    /**
     * 修改壁纸
     */
    @PreAuthorize("@ss.hasPermi('app:wallpaper:edit')")
    @Log(title = "壁纸", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppWallpaper appWallpaper)
    {
        return toAjax(appWallpaperService.updateAppWallpaper(appWallpaper));
    }

    /**
     * 删除壁纸
     */
    @PreAuthorize("@ss.hasPermi('app:wallpaper:remove')")
    @Log(title = "壁纸", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appWallpaperService.deleteAppWallpaperByIds(ids));
    }

    /**
     * 下载+1
     */
    @PutMapping("/app/downLoad")
    public AjaxResult lookAddNumber(@RequestBody AppWallpaper appWallpaper)
    {
        return toAjax( appWallpaperMapper.lookAddNumber(appWallpaper.getId()));
    }
}
