package com.ruoyi.web.controller.app;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.app.domain.AppWallpaper;
import com.ruoyi.app.mapper.AppResourceMapper;
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
import com.ruoyi.app.domain.AppResource;
import com.ruoyi.app.service.IAppResourceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资源Controller
 * 
 * @author budiao
 * @date 2024-04-07
 */
@RestController
@RequestMapping("/app/resource")
public class AppResourceController extends BaseController
{
    @Autowired
    private IAppResourceService appResourceService;

    @Resource
    private AppResourceMapper appResourceMapper;

    /**
     * 查询资源列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AppResource appResource)
    {
        startPage();
        List<AppResource> list = appResourceService.selectAppResourceList(appResource);
        return getDataTable(list);
    }

    /**
     * 导出资源列表
     */
    @PreAuthorize("@ss.hasPermi('app:resource:export')")
    @Log(title = "资源", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppResource appResource)
    {
        List<AppResource> list = appResourceService.selectAppResourceList(appResource);
        ExcelUtil<AppResource> util = new ExcelUtil<AppResource>(AppResource.class);
        util.exportExcel(response, list, "资源数据");
    }

    /**
     * 获取资源详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:resource:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appResourceService.selectAppResourceById(id));
    }

    @GetMapping(value = "/app/{id}")
    public AjaxResult getInfoApp(@PathVariable("id") Long id)
    {
        return success(appResourceService.selectAppResourceById(id));
    }

    /**
     * 新增资源
     */
    @PreAuthorize("@ss.hasPermi('app:resource:add')")
    @Log(title = "资源", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppResource appResource)
    {
        return toAjax(appResourceService.insertAppResource(appResource));
    }

    /**
     * 修改资源
     */
    @PreAuthorize("@ss.hasPermi('app:resource:edit')")
    @Log(title = "资源", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppResource appResource)
    {
        return toAjax(appResourceService.updateAppResource(appResource));
    }

    /**
     * 删除资源
     */
    @PreAuthorize("@ss.hasPermi('app:resource:remove')")
    @Log(title = "资源", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appResourceService.deleteAppResourceByIds(ids));
    }

    /**
     * 下载+1
     */
    @PutMapping("/app/downLoad")
    public AjaxResult lookAddNumber(@RequestBody AppResource appResource)
    {
        return toAjax( appResourceMapper.lookAddNumber(appResource.getId()));
    }
}
