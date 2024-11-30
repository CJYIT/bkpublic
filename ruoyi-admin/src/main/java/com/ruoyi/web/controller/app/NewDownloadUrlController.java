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
import com.ruoyi.app.domain.NewDownloadUrl;
import com.ruoyi.app.service.INewDownloadUrlService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 待配置安全域名Controller
 * 
 * @author budiao
 * @date 2024-04-28
 */
@RestController
@RequestMapping("/app/newurl")
public class NewDownloadUrlController extends BaseController
{
    @Autowired
    private INewDownloadUrlService newDownloadUrlService;

    /**
     * 查询待配置安全域名列表
     */
    @PreAuthorize("@ss.hasPermi('app:newurl:list')")
    @GetMapping("/list")
    public TableDataInfo list(NewDownloadUrl newDownloadUrl)
    {
        startPage();
        List<NewDownloadUrl> list = newDownloadUrlService.selectNewDownloadUrlList(newDownloadUrl);
        return getDataTable(list);
    }

    /**
     * 导出待配置安全域名列表
     */
    @PreAuthorize("@ss.hasPermi('app:newurl:export')")
    @Log(title = "待配置安全域名", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NewDownloadUrl newDownloadUrl)
    {
        List<NewDownloadUrl> list = newDownloadUrlService.selectNewDownloadUrlList(newDownloadUrl);
        ExcelUtil<NewDownloadUrl> util = new ExcelUtil<NewDownloadUrl>(NewDownloadUrl.class);
        util.exportExcel(response, list, "待配置安全域名数据");
    }

    /**
     * 获取待配置安全域名详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:newurl:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(newDownloadUrlService.selectNewDownloadUrlById(id));
    }

    /**
     * 新增待配置安全域名
     */
    @PreAuthorize("@ss.hasPermi('app:newurl:add')")
    @Log(title = "待配置安全域名", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NewDownloadUrl newDownloadUrl)
    {
        return toAjax(newDownloadUrlService.insertNewDownloadUrl(newDownloadUrl));
    }

    /**
     * 修改待配置安全域名
     */
    @PreAuthorize("@ss.hasPermi('app:newurl:edit')")
    @Log(title = "待配置安全域名", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NewDownloadUrl newDownloadUrl)
    {
        return toAjax(newDownloadUrlService.updateNewDownloadUrl(newDownloadUrl));
    }

    /**
     * 删除待配置安全域名
     */
    @PreAuthorize("@ss.hasPermi('app:newurl:remove')")
    @Log(title = "待配置安全域名", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(newDownloadUrlService.deleteNewDownloadUrlByIds(ids));
    }
}
