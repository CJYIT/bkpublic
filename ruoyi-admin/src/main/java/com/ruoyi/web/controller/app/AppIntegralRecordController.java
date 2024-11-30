package com.ruoyi.web.controller.app;

import java.util.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.app.domain.AppLotteryGoods;
import com.ruoyi.app.domain.AppLotteryLog;
import com.ruoyi.app.mapper.AppIntegralRecordMapper;
import com.ruoyi.app.service.IAppLotteryGoodsService;
import com.ruoyi.app.service.IAppLotteryLogService;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.service.ISysConfigService;
import org.springframework.data.annotation.Transient;
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
import com.ruoyi.app.domain.AppIntegralRecord;
import com.ruoyi.app.service.IAppIntegralRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 积分记录Controller
 * 
 * @author budiao
 * @date 2024-04-07
 */
@RestController
@RequestMapping("/app/appIntegra")
public class AppIntegralRecordController extends BaseController
{
    @Autowired
    private IAppIntegralRecordService appIntegralRecordService;
    @Autowired
    private ISysConfigService configService;
    @Resource
    private AppIntegralRecordMapper appIntegralRecordMapper;
    @Resource
    private SysUserMapper sysUserMapper;
    @Autowired
    private IAppLotteryGoodsService appLotteryGoodsService;
    @Autowired
    private IAppLotteryLogService appLotteryLogService;

    /**
     * 查询积分记录列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AppIntegralRecord appIntegralRecord)
    {
        startPage();
        List<AppIntegralRecord> list = appIntegralRecordService.selectAppIntegralRecordList(appIntegralRecord);
        return getDataTable(list);
    }

    /**
     * 导出积分记录列表
     */
    @PreAuthorize("@ss.hasPermi('app:appIntegra:export')")
    @Log(title = "积分记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppIntegralRecord appIntegralRecord)
    {
        List<AppIntegralRecord> list = appIntegralRecordService.selectAppIntegralRecordList(appIntegralRecord);
        ExcelUtil<AppIntegralRecord> util = new ExcelUtil<AppIntegralRecord>(AppIntegralRecord.class);
        util.exportExcel(response, list, "积分记录数据");
    }

    /**
     * 获取积分记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:appIntegra:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appIntegralRecordService.selectAppIntegralRecordById(id));
    }

    /**
     * 新增积分记录
     */
    @Log(title = "积分记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppIntegralRecord appIntegralRecord)
    {
        return toAjax(appIntegralRecordService.insertAppIntegralRecord(appIntegralRecord));
    }

    /**
     * 修改积分记录
     */
    @PreAuthorize("@ss.hasPermi('app:appIntegra:edit')")
    @Log(title = "积分记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppIntegralRecord appIntegralRecord)
    {
        return toAjax(appIntegralRecordService.updateAppIntegralRecord(appIntegralRecord));
    }

    /**
     * 删除积分记录
     */
    @PreAuthorize("@ss.hasPermi('app:appIntegra:remove')")
    @Log(title = "积分记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appIntegralRecordService.deleteAppIntegralRecordByIds(ids));
    }

    //积分记录，增加积分
    @Transactional
    @PostMapping("/apps")
    public AjaxResult appAdd(@RequestBody AppIntegralRecord appIntegralRecord)
    {
        Date date = new Date();
        appIntegralRecord.setIntegralTime(date);
        int i = appIntegralRecordMapper.selectAppIntegralRecordCount(appIntegralRecord);
        String article = "";
        if (appIntegralRecord.getSource().equals("文章浏览")){
            article = configService.selectConfigByKey("miniapp.article.integral");
        }else if(appIntegralRecord.getSource().equals("文章分享")){
            article = configService.selectConfigByKey("miniapp.share.integral");
        }else if (appIntegralRecord.getSource().equals("广告任务")){
            article = configService.selectConfigByKey("miniapp.ad.integral");
        }
        else if (appIntegralRecord.getSource().equals("签到")){
            article = configService.selectConfigByKey("miniapp.signin.integral");
        }
        System.out.println(article);
        System.out.println(i+"------"+article.split(",")[1]);
        if (i<Integer.parseInt(article.split(",")[1])){
            appIntegralRecord.setIsAdd(0L);
            appIntegralRecord.setIntegralNumber(Long.parseLong(article.split(",")[0]));
            appIntegralRecordService.insertAppIntegralRecord(appIntegralRecord);
            sysUserMapper.addIntegralByUserId(Integer.parseInt(article.split(",")[0]),appIntegralRecord.getUserId());
            return success("+"+article.split(",")[0]);
        }else{
            return success("已上限");
        }
    }
    //今天是否可以积分记录，增加积分
    @Transactional
    @PostMapping("/isApps")
    public AjaxResult isApps(@RequestBody AppIntegralRecord appIntegralRecord)
    {
        Date date = new Date();
        appIntegralRecord.setIntegralTime(date);
        int i = appIntegralRecordMapper.selectAppIntegralRecordCount(appIntegralRecord);
        String article = "";
        if (appIntegralRecord.getSource().equals("文章浏览")){
            article = configService.selectConfigByKey("miniapp.article.integral");
        }else if(appIntegralRecord.getSource().equals("文章分享")){
            article = configService.selectConfigByKey("miniapp.share.integral");
        }else if (appIntegralRecord.getSource().equals("广告任务")){
            article = configService.selectConfigByKey("miniapp.ad.integral");
        }
        else if (appIntegralRecord.getSource().equals("签到")){
            article = configService.selectConfigByKey("miniapp.signin.integral");
        }
        if (i<Integer.parseInt(article.split(",")[1])){

            return success("200");
        }else{
            return success("已上限");
        }
    }



    /**
     * 积分记录，增减用户积分通用
     */
    @Transactional
    @PostMapping("/resource")
    public AjaxResult resource(@RequestBody AppIntegralRecord appIntegralRecord)
    {
        Date date = new Date();
        appIntegralRecord.setIntegralTime(date);
        appIntegralRecordService.insertAppIntegralRecord(appIntegralRecord);
        if (appIntegralRecord.getIsAdd() == 0){
            sysUserMapper.addIntegralByUserId(Math.toIntExact(appIntegralRecord.getIntegralNumber()), appIntegralRecord.getUserId());
        }else {
            sysUserMapper.delIntegralByUserId(Math.toIntExact(appIntegralRecord.getIntegralNumber()), appIntegralRecord.getUserId());
        }

        return toAjax(1);
    }

    /**
     * 抽奖校验次数生成概率
     */
    @Transactional
    @PostMapping("/lottery")
    public HashMap<Object, Object> lottery(@RequestBody AppIntegralRecord appIntegralRecord)
    {
        Date date = new Date();
        HashMap<Object, Object> data = new HashMap<>();
        appIntegralRecord.setIntegralTime(date);
        appIntegralRecord.setUserId(getUserId());
        appIntegralRecord.setSource("抽奖");
        int i = appIntegralRecordMapper.selectAppIntegralRecordCount(appIntegralRecord);
        String lotteryConfig = configService.selectConfigByKey("miniapp.lottery.integral");
        int freeNumber = Integer.parseInt(lotteryConfig.split(",")[0]);
        int adNumber = Integer.parseInt(lotteryConfig.split(",")[1]);
        if (i < freeNumber){
            data.put("lotteryType",0);
        }else if (i >= freeNumber && i < adNumber){
            data.put("lotteryType",1);
        }else {
            data.put("lotteryType",2);
        }
        int randomNumber = (int)(Math.random() * 100)+1;
        data.put("sj",randomNumber);
        List<AppLotteryGoods> AwardList = appLotteryGoodsService.selectAppLotteryGoodsList(null);
        // 前端获取奖励
        ArrayList<AppLotteryGoods> arr = new ArrayList<>();
        for (int ii = 0; ii < AwardList.size(); ii++) {
            if (AwardList.get(ii).getPercentage() >= randomNumber) {
                arr.add(AwardList.get(ii));
            }
        }
        System.out.println(arr);
        // 随机获得索引
        int sjNum = -1;
        if (arr.size() > 1) {
            Random random = new Random();
            int randomIndex = random.nextInt(arr.size());
            sjNum = Math.toIntExact(arr.get(randomIndex).getIndexNum());;
        } else {
            sjNum = Math.toIntExact(arr.get(0).getIndexNum());
        }
        data.put("sjNum",sjNum);
        return data;
    }

    //抽奖奖励发放
    @Transactional
    @PostMapping("/lotteryAdd")
    public AjaxResult lotteryAdd(@RequestBody AppIntegralRecord appIntegralRecord)
    {
        appIntegralRecord.setIntegralTime(new Date());
        appIntegralRecordService.insertAppIntegralRecord(appIntegralRecord);
        sysUserMapper.addIntegralByUserId(Math.toIntExact(appIntegralRecord.getIntegralNumber()),appIntegralRecord.getUserId());
        AppLotteryLog appLotteryLog = new AppLotteryLog();
        appLotteryLog.setGoodId(appIntegralRecord.getfId());
        appLotteryLog.setLotteryUserId(getUserId());
        appLotteryLog.setLotteryTime(new Date());
        appLotteryLogService.insertAppLotteryLog(appLotteryLog);
        return success("奖励已发放");

    }

}
