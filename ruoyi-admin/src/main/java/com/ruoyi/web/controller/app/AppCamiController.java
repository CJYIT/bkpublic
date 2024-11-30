package com.ruoyi.web.controller.app;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
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
import com.ruoyi.app.domain.AppCami;
import com.ruoyi.app.service.IAppCamiService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 资源卡密Controller
 * 
 * @author ruoyi
 * @date 2024-06-19
 */
@RestController
@RequestMapping("/app/cami")
public class AppCamiController extends BaseController
{
    @Autowired
    private IAppCamiService appCamiService;

    /**
     * 查询资源卡密列表
     */
    @PreAuthorize("@ss.hasPermi('app:cami:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppCami appCami)
    {
        startPage();
        List<AppCami> list = appCamiService.selectAppCamiList(appCami);
        return getDataTable(list);
    }

    /**
     * 导出资源卡密列表
     */
    @PreAuthorize("@ss.hasPermi('app:cami:export')")
    @Log(title = "资源卡密", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppCami appCami)
    {
        List<AppCami> list = appCamiService.selectAppCamiList(appCami);
        ExcelUtil<AppCami> util = new ExcelUtil<AppCami>(AppCami.class);
        util.exportExcel(response, list, "资源卡密数据");
    }
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<AppCami> util = new ExcelUtil<AppCami>(AppCami.class);
        List<AppCami> List = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = appCamiService.importCami(List, updateSupport, operName);
        return success(message);
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        System.out.println("=========");
        ExcelUtil<AppCami> util = new ExcelUtil<AppCami>(AppCami.class);
        util.importTemplateExcel(response, "资源卡密数据");
    }

    /**
     * 获取资源卡密详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:cami:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appCamiService.selectAppCamiById(id));
    }

    /**
     * 新增资源卡密
     */
    @PreAuthorize("@ss.hasPermi('app:cami:add')")
    @Log(title = "资源卡密", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppCami appCami)
    {
        return toAjax(appCamiService.insertAppCami(appCami));
    }

    /**
     * 修改资源卡密
     */
    @PreAuthorize("@ss.hasPermi('app:cami:edit')")
    @Log(title = "资源卡密", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppCami appCami)
    {
        return toAjax(appCamiService.updateAppCami(appCami));
    }

    /**
     * 删除资源卡密
     */
    @PreAuthorize("@ss.hasPermi('app:cami:remove')")
    @Log(title = "资源卡密", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appCamiService.deleteAppCamiByIds(ids));
    }
}
