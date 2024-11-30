package com.ruoyi.web.controller.app;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.app.domain.AppAdRecord;
import com.ruoyi.app.service.IAppAdRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 广告点击记录Controller
 * 
 * @author budiao
 * @date 2024-04-07
 */
@RestController
@RequestMapping("/app/adrecord")
public class AppAdRecordController extends BaseController
{
    @Autowired
    private IAppAdRecordService appAdRecordService;

    /**
     * 查询广告点击记录列表
     */
    @PreAuthorize("@ss.hasPermi('app:adrecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppAdRecord appAdRecord)
    {
        startPage();
        List<AppAdRecord> list = appAdRecordService.selectAppAdRecordList(appAdRecord);
        return getDataTable(list);
    }

    /**
     * 导出广告点击记录列表
     */
    @PreAuthorize("@ss.hasPermi('app:adrecord:export')")
    @Log(title = "广告点击记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppAdRecord appAdRecord)
    {
        List<AppAdRecord> list = appAdRecordService.selectAppAdRecordList(appAdRecord);
        ExcelUtil<AppAdRecord> util = new ExcelUtil<AppAdRecord>(AppAdRecord.class);
        util.exportExcel(response, list, "广告点击记录数据");
    }

    /**
     * 获取广告点击记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:adrecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appAdRecordService.selectAppAdRecordById(id));
    }

    /**
     * 新增广告点击记录
     */
    @PreAuthorize("@ss.hasPermi('app:adrecord:add')")
    @Log(title = "广告点击记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppAdRecord appAdRecord)
    {
        return toAjax(appAdRecordService.insertAppAdRecord(appAdRecord));
    }

    /**
     * 修改广告点击记录
     */
    @PreAuthorize("@ss.hasPermi('app:adrecord:edit')")
    @Log(title = "广告点击记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppAdRecord appAdRecord)
    {
        return toAjax(appAdRecordService.updateAppAdRecord(appAdRecord));
    }

    /**
     * 删除广告点击记录
     */
    @PreAuthorize("@ss.hasPermi('app:adrecord:remove')")
    @Log(title = "广告点击记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appAdRecordService.deleteAppAdRecordByIds(ids));
    }
}
