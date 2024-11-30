package com.ruoyi.web.controller.app;

import com.ruoyi.app.domain.AppLotteryLog;
import com.ruoyi.app.service.IAppLotteryLogService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 抽奖记录Controller
 * 
 * @author budiao
 * @date 2024-06-20
 */
@RestController
@RequestMapping("/app/lotteryLog")
public class AppLotteryLogController extends BaseController
{
    @Autowired
    private IAppLotteryLogService appLotteryLogService;

    /**
     * 查询抽奖记录列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AppLotteryLog appLotteryLog)
    {
        startPage();
        List<AppLotteryLog> list = appLotteryLogService.selectAppLotteryLogList(appLotteryLog);
        return getDataTable(list);
    }

    /**
     * 导出抽奖记录列表
     */
    @PreAuthorize("@ss.hasPermi('app:lotteryLog:export')")
    @Log(title = "抽奖记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppLotteryLog appLotteryLog)
    {
        List<AppLotteryLog> list = appLotteryLogService.selectAppLotteryLogList(appLotteryLog);
        ExcelUtil<AppLotteryLog> util = new ExcelUtil<AppLotteryLog>(AppLotteryLog.class);
        util.exportExcel(response, list, "抽奖记录数据");
    }

    /**
     * 获取抽奖记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:lotteryLog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appLotteryLogService.selectAppLotteryLogById(id));
    }

    /**
     * 新增抽奖记录
     */
    @PostMapping
    public AjaxResult add(@RequestBody AppLotteryLog appLotteryLog)
    {
        return toAjax(appLotteryLogService.insertAppLotteryLog(appLotteryLog));
    }

    /**
     * 修改抽奖记录
     */
    @PreAuthorize("@ss.hasPermi('app:lotteryLog:edit')")
    @Log(title = "抽奖记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppLotteryLog appLotteryLog)
    {
        return toAjax(appLotteryLogService.updateAppLotteryLog(appLotteryLog));
    }

    /**
     * 删除抽奖记录
     */
    @PreAuthorize("@ss.hasPermi('app:lotteryLog:remove')")
    @Log(title = "抽奖记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appLotteryLogService.deleteAppLotteryLogByIds(ids));
    }
}
