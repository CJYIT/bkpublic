package com.ruoyi.app.mapper;

import java.util.List;
import com.ruoyi.app.domain.AppLotteryGoods;

/**
 * 抽奖礼品配置Mapper接口
 * 
 * @author budiao
 * @date 2024-06-19
 */
public interface AppLotteryGoodsMapper 
{
    /**
     * 查询抽奖礼品配置
     * 
     * @param id 抽奖礼品配置主键
     * @return 抽奖礼品配置
     */
    public AppLotteryGoods selectAppLotteryGoodsById(Long id);

    /**
     * 查询抽奖礼品配置列表
     * 
     * @param appLotteryGoods 抽奖礼品配置
     * @return 抽奖礼品配置集合
     */
    public List<AppLotteryGoods> selectAppLotteryGoodsList(AppLotteryGoods appLotteryGoods);

    /**
     * 新增抽奖礼品配置
     * 
     * @param appLotteryGoods 抽奖礼品配置
     * @return 结果
     */
    public int insertAppLotteryGoods(AppLotteryGoods appLotteryGoods);

    /**
     * 修改抽奖礼品配置
     * 
     * @param appLotteryGoods 抽奖礼品配置
     * @return 结果
     */
    public int updateAppLotteryGoods(AppLotteryGoods appLotteryGoods);

    /**
     * 删除抽奖礼品配置
     * 
     * @param id 抽奖礼品配置主键
     * @return 结果
     */
    public int deleteAppLotteryGoodsById(Long id);

    /**
     * 批量删除抽奖礼品配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppLotteryGoodsByIds(Long[] ids);
}
