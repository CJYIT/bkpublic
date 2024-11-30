package com.ruoyi.app.service.impl;

import com.ruoyi.app.domain.AppLotteryLog;
import com.ruoyi.app.mapper.AppLotteryLogMapper;
import com.ruoyi.app.service.IAppLotteryLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 抽奖记录Service业务层处理
 * 
 * @author budiao
 * @date 2024-06-20
 */
@Service
public class AppLotteryLogServiceImpl implements IAppLotteryLogService 
{
    @Autowired
    private AppLotteryLogMapper appLotteryLogMapper;

    /**
     * 查询抽奖记录
     * 
     * @param id 抽奖记录主键
     * @return 抽奖记录
     */
    @Override
    public AppLotteryLog selectAppLotteryLogById(Long id)
    {
        return appLotteryLogMapper.selectAppLotteryLogById(id);
    }

    /**
     * 查询抽奖记录列表
     * 
     * @param appLotteryLog 抽奖记录
     * @return 抽奖记录
     */
    @Override
    public List<AppLotteryLog> selectAppLotteryLogList(AppLotteryLog appLotteryLog)
    {
        return appLotteryLogMapper.selectAppLotteryLogList(appLotteryLog);
    }

    /**
     * 新增抽奖记录
     * 
     * @param appLotteryLog 抽奖记录
     * @return 结果
     */
    @Override
    public int insertAppLotteryLog(AppLotteryLog appLotteryLog)
    {
        return appLotteryLogMapper.insertAppLotteryLog(appLotteryLog);
    }

    /**
     * 修改抽奖记录
     * 
     * @param appLotteryLog 抽奖记录
     * @return 结果
     */
    @Override
    public int updateAppLotteryLog(AppLotteryLog appLotteryLog)
    {
        return appLotteryLogMapper.updateAppLotteryLog(appLotteryLog);
    }

    /**
     * 批量删除抽奖记录
     * 
     * @param ids 需要删除的抽奖记录主键
     * @return 结果
     */
    @Override
    public int deleteAppLotteryLogByIds(Long[] ids)
    {
        return appLotteryLogMapper.deleteAppLotteryLogByIds(ids);
    }

    /**
     * 删除抽奖记录信息
     * 
     * @param id 抽奖记录主键
     * @return 结果
     */
    @Override
    public int deleteAppLotteryLogById(Long id)
    {
        return appLotteryLogMapper.deleteAppLotteryLogById(id);
    }
}
