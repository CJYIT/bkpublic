package com.ruoyi.web.controller.app;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.app.domain.AppCami;
import com.ruoyi.app.domain.AppIntegralRecord;
import com.ruoyi.app.service.IAppCamiService;
import com.ruoyi.app.service.IAppIntegralRecordService;
import com.ruoyi.system.mapper.SysUserMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
import com.ruoyi.app.domain.AppExchangeRecords;
import com.ruoyi.app.service.IAppExchangeRecordsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 兑换记录Controller
 * 
 * @author budiao
 * @date 2024-04-07
 */
@RestController
@RequestMapping("/app/exchange")
public class AppExchangeRecordsController extends BaseController
{
    @Autowired
    private IAppExchangeRecordsService appExchangeRecordsService;
    @Autowired
    private IAppIntegralRecordService appIntegralRecordService;
    @Resource
    private SysUserMapper sysUserMapper;
    @Autowired
    private IAppCamiService appCamiService;


    /**
     * 查询兑换记录列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AppExchangeRecords appExchangeRecords)
    {
        startPage();
        List<AppExchangeRecords> list = appExchangeRecordsService.selectAppExchangeRecordsList(appExchangeRecords);
        return getDataTable(list);
    }

    /**
     * 导出兑换记录列表
     */
    @PreAuthorize("@ss.hasPermi('app:exchange:export')")
    @Log(title = "兑换记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppExchangeRecords appExchangeRecords)
    {
        List<AppExchangeRecords> list = appExchangeRecordsService.selectAppExchangeRecordsList(appExchangeRecords);
        ExcelUtil<AppExchangeRecords> util = new ExcelUtil<AppExchangeRecords>(AppExchangeRecords.class);
        util.exportExcel(response, list, "兑换记录数据");
    }

    /**
     * 获取兑换记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:exchange:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appExchangeRecordsService.selectAppExchangeRecordsById(id));
    }

    /**
     * 新增兑换记录
     */
    @PreAuthorize("@ss.hasPermi('app:exchange:add')")
    @Log(title = "兑换记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppExchangeRecords appExchangeRecords)
    {
        return toAjax(appExchangeRecordsService.insertAppExchangeRecords(appExchangeRecords));
    }

    /**
     * 修改兑换记录
     */
    @PreAuthorize("@ss.hasPermi('app:exchange:edit')")
    @Log(title = "兑换记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppExchangeRecords appExchangeRecords)
    {
        return toAjax(appExchangeRecordsService.updateAppExchangeRecords(appExchangeRecords));
    }

    /**
     * 删除兑换记录
     */
    @PreAuthorize("@ss.hasPermi('app:exchange:remove')")
    @Log(title = "兑换记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appExchangeRecordsService.deleteAppExchangeRecordsByIds(ids));
    }

    /**
     * 积分商品兑换
     */
    @Transactional
    @PostMapping("/goods")
    public AjaxResult exchangeGoods(@RequestBody AppExchangeRecords appExchangeRecords)
    {
        Date date = new Date();
        appExchangeRecords.setRecordsTime(date);
        if (appExchangeRecords.getIsCami() == 0){
            AppCami appCami = new AppCami();
            appCami.setCamiTyep(appExchangeRecords.getCamiType());
            appCami.setDelFlag(1L);
            List<AppCami> appCamis = appCamiService.selectAppCamiList(appCami);
            if (appCamis.size() == 0){
                return error("卡密库存不足,请联系客服");
            }else {
                appCamis.get(0).setDelFlag(0L);
                appCamiService.updateAppCami(appCamis.get(0));
                appExchangeRecords.setRedemptionCode(appCamis.get(0).getCami());
            }
        }else {
            appExchangeRecords.setRedemptionCode(date.getTime()+"");
        }
        appExchangeRecords.setRedemptionState("否");
        appExchangeRecordsService.insertAppExchangeRecords(appExchangeRecords);
        AppIntegralRecord appIntegralRecord = new AppIntegralRecord();
        appIntegralRecord.setSource("积分兑换");
        appIntegralRecord.setIsAdd(1L);
        appIntegralRecord.setIntegralNumber(appExchangeRecords.getRecordsNumber());
        appIntegralRecord.setUserId(Long.parseLong(appExchangeRecords.getRecordsUserId()));
        appIntegralRecord.setIntegralTime(date);
        appIntegralRecordService.insertAppIntegralRecord(appIntegralRecord);

        sysUserMapper.delIntegralByUserId(Math.toIntExact(appExchangeRecords.getRecordsNumber()),appIntegralRecord.getUserId());


        return success(appExchangeRecords.getRedemptionCode());
    }
}
