package com.ruoyi.web.controller.app;

import com.ruoyi.app.domain.AppDuanju;
import com.ruoyi.app.mapper.AppDuanjuMapper;
import com.ruoyi.app.service.IAppDuanjuService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 短剧资源Controller
 * 
 * @author budiao
 * @date 2024-06-07
 */
@RestController
@RequestMapping("/app/duanju")
public class AppDuanjuController extends BaseController
{
    @Autowired
    private IAppDuanjuService appDuanjuService;
    @Resource
    private AppDuanjuMapper appDuanjuMapper;

    /**
     * 查询短剧资源列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AppDuanju appDuanju)
    {
        startPage();
        List<AppDuanju> list = appDuanjuService.selectAppDuanjuList(appDuanju);
        return getDataTable(list);
    }

    /**
     * 查询短剧资源数量
     */
    @GetMapping("/app/listNumber")
    public int listNumber()
    {
        return appDuanjuMapper.listNumber();
    }

    /**
     * 导出短剧资源列表
     */
    @PreAuthorize("@ss.hasPermi('app:duanju:export')")
    @Log(title = "短剧资源", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppDuanju appDuanju)
    {
        List<AppDuanju> list = appDuanjuService.selectAppDuanjuList(appDuanju);
        ExcelUtil<AppDuanju> util = new ExcelUtil<AppDuanju>(AppDuanju.class);
        util.exportExcel(response, list, "短剧资源数据");
    }

    /**
     * 获取短剧资源详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:duanju:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appDuanjuService.selectAppDuanjuById(id));
    }

    /**
     * 新增短剧资源
     */
    @PreAuthorize("@ss.hasPermi('app:duanju:add')")
    @Log(title = "短剧资源", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppDuanju appDuanju)
    {
        return toAjax(appDuanjuService.insertAppDuanju(appDuanju));
    }

    /**
     * 修改短剧资源
     */
    @PreAuthorize("@ss.hasPermi('app:duanju:edit')")
    @Log(title = "短剧资源", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppDuanju appDuanju)
    {
        return toAjax(appDuanjuService.updateAppDuanju(appDuanju));
    }

    /**
     * 删除短剧资源
     */
    @PreAuthorize("@ss.hasPermi('app:duanju:remove')")
    @Log(title = "短剧资源", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appDuanjuService.deleteAppDuanjuByIds(ids));
    }
}
