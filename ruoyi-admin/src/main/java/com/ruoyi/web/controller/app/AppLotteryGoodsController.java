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
import com.ruoyi.app.domain.AppLotteryGoods;
import com.ruoyi.app.service.IAppLotteryGoodsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 抽奖礼品配置Controller
 * 
 * @author budiao
 * @date 2024-06-19
 */
@RestController
@RequestMapping("/app/lottery")
public class AppLotteryGoodsController extends BaseController
{
    @Autowired
    private IAppLotteryGoodsService appLotteryGoodsService;

    /**
     * 查询抽奖礼品配置列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AppLotteryGoods appLotteryGoods)
    {
        startPage();
        List<AppLotteryGoods> list = appLotteryGoodsService.selectAppLotteryGoodsList(appLotteryGoods);
        return getDataTable(list);
    }

    /**
     * 导出抽奖礼品配置列表
     */
    @PreAuthorize("@ss.hasPermi('app:lottery:export')")
    @Log(title = "抽奖礼品配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppLotteryGoods appLotteryGoods)
    {
        List<AppLotteryGoods> list = appLotteryGoodsService.selectAppLotteryGoodsList(appLotteryGoods);
        ExcelUtil<AppLotteryGoods> util = new ExcelUtil<AppLotteryGoods>(AppLotteryGoods.class);
        util.exportExcel(response, list, "抽奖礼品配置数据");
    }

    /**
     * 获取抽奖礼品配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:lottery:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appLotteryGoodsService.selectAppLotteryGoodsById(id));
    }

    /**
     * 新增抽奖礼品配置
     */
    @PreAuthorize("@ss.hasPermi('app:lottery:add')")
    @Log(title = "抽奖礼品配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppLotteryGoods appLotteryGoods)
    {
        return toAjax(appLotteryGoodsService.insertAppLotteryGoods(appLotteryGoods));
    }

    /**
     * 修改抽奖礼品配置
     */
    @PreAuthorize("@ss.hasPermi('app:lottery:edit')")
    @Log(title = "抽奖礼品配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppLotteryGoods appLotteryGoods)
    {
        return toAjax(appLotteryGoodsService.updateAppLotteryGoods(appLotteryGoods));
    }

    /**
     * 删除抽奖礼品配置
     */
    @PreAuthorize("@ss.hasPermi('app:lottery:remove')")
    @Log(title = "抽奖礼品配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appLotteryGoodsService.deleteAppLotteryGoodsByIds(ids));
    }
}
