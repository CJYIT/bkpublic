package com.ruoyi.app.service;

import com.ruoyi.app.domain.AppLotteryLog;

import java.util.List;

/**
 * 抽奖记录Service接口
 * 
 * @author budiao
 * @date 2024-06-20
 */
public interface IAppLotteryLogService 
{
    /**
     * 查询抽奖记录
     * 
     * @param id 抽奖记录主键
     * @return 抽奖记录
     */
    public AppLotteryLog selectAppLotteryLogById(Long id);

    /**
     * 查询抽奖记录列表
     * 
     * @param appLotteryLog 抽奖记录
     * @return 抽奖记录集合
     */
    public List<AppLotteryLog> selectAppLotteryLogList(AppLotteryLog appLotteryLog);

    /**
     * 新增抽奖记录
     * 
     * @param appLotteryLog 抽奖记录
     * @return 结果
     */
    public int insertAppLotteryLog(AppLotteryLog appLotteryLog);

    /**
     * 修改抽奖记录
     * 
     * @param appLotteryLog 抽奖记录
     * @return 结果
     */
    public int updateAppLotteryLog(AppLotteryLog appLotteryLog);

    /**
     * 批量删除抽奖记录
     * 
     * @param ids 需要删除的抽奖记录主键集合
     * @return 结果
     */
    public int deleteAppLotteryLogByIds(Long[] ids);

    /**
     * 删除抽奖记录信息
     * 
     * @param id 抽奖记录主键
     * @return 结果
     */
    public int deleteAppLotteryLogById(Long id);
}
