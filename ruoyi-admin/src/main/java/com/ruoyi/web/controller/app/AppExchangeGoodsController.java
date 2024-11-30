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
import com.ruoyi.app.domain.AppExchangeGoods;
import com.ruoyi.app.service.IAppExchangeGoodsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 积分商品Controller
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
@RestController
@RequestMapping("/app/goods")
public class AppExchangeGoodsController extends BaseController
{
    @Autowired
    private IAppExchangeGoodsService appExchangeGoodsService;

    /**
     * 查询积分商品列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AppExchangeGoods appExchangeGoods)
    {
        startPage();
        List<AppExchangeGoods> list = appExchangeGoodsService.selectAppExchangeGoodsList(appExchangeGoods);
        return getDataTable(list);
    }

    /**
     * 导出积分商品列表
     */
    @PreAuthorize("@ss.hasPermi('app:goods:export')")
    @Log(title = "积分商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppExchangeGoods appExchangeGoods)
    {
        List<AppExchangeGoods> list = appExchangeGoodsService.selectAppExchangeGoodsList(appExchangeGoods);
        ExcelUtil<AppExchangeGoods> util = new ExcelUtil<AppExchangeGoods>(AppExchangeGoods.class);
        util.exportExcel(response, list, "积分商品数据");
    }

    /**
     * 获取积分商品详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:goods:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appExchangeGoodsService.selectAppExchangeGoodsById(id));
    }

    /**
     * 新增积分商品
     */
    @PreAuthorize("@ss.hasPermi('app:goods:add')")
    @Log(title = "积分商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppExchangeGoods appExchangeGoods)
    {
        return toAjax(appExchangeGoodsService.insertAppExchangeGoods(appExchangeGoods));
    }

    /**
     * 修改积分商品
     */
    @PreAuthorize("@ss.hasPermi('app:goods:edit')")
    @Log(title = "积分商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppExchangeGoods appExchangeGoods)
    {
        return toAjax(appExchangeGoodsService.updateAppExchangeGoods(appExchangeGoods));
    }

    /**
     * 删除积分商品
     */
    @PreAuthorize("@ss.hasPermi('app:goods:remove')")
    @Log(title = "积分商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appExchangeGoodsService.deleteAppExchangeGoodsByIds(ids));
    }
}
