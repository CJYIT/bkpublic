package com.ruoyi.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.AppLotteryGoodsMapper;
import com.ruoyi.app.domain.AppLotteryGoods;
import com.ruoyi.app.service.IAppLotteryGoodsService;

/**
 * 抽奖礼品配置Service业务层处理
 * 
 * @author budiao
 * @date 2024-06-19
 */
@Service
public class AppLotteryGoodsServiceImpl implements IAppLotteryGoodsService 
{
    @Autowired
    private AppLotteryGoodsMapper appLotteryGoodsMapper;

    /**
     * 查询抽奖礼品配置
     * 
     * @param id 抽奖礼品配置主键
     * @return 抽奖礼品配置
     */
    @Override
    public AppLotteryGoods selectAppLotteryGoodsById(Long id)
    {
        return appLotteryGoodsMapper.selectAppLotteryGoodsById(id);
    }

    /**
     * 查询抽奖礼品配置列表
     * 
     * @param appLotteryGoods 抽奖礼品配置
     * @return 抽奖礼品配置
     */
    @Override
    public List<AppLotteryGoods> selectAppLotteryGoodsList(AppLotteryGoods appLotteryGoods)
    {
        return appLotteryGoodsMapper.selectAppLotteryGoodsList(appLotteryGoods);
    }

    /**
     * 新增抽奖礼品配置
     * 
     * @param appLotteryGoods 抽奖礼品配置
     * @return 结果
     */
    @Override
    public int insertAppLotteryGoods(AppLotteryGoods appLotteryGoods)
    {
        return appLotteryGoodsMapper.insertAppLotteryGoods(appLotteryGoods);
    }

    /**
     * 修改抽奖礼品配置
     * 
     * @param appLotteryGoods 抽奖礼品配置
     * @return 结果
     */
    @Override
    public int updateAppLotteryGoods(AppLotteryGoods appLotteryGoods)
    {
        return appLotteryGoodsMapper.updateAppLotteryGoods(appLotteryGoods);
    }

    /**
     * 批量删除抽奖礼品配置
     * 
     * @param ids 需要删除的抽奖礼品配置主键
     * @return 结果
     */
    @Override
    public int deleteAppLotteryGoodsByIds(Long[] ids)
    {
        return appLotteryGoodsMapper.deleteAppLotteryGoodsByIds(ids);
    }

    /**
     * 删除抽奖礼品配置信息
     * 
     * @param id 抽奖礼品配置主键
     * @return 结果
     */
    @Override
    public int deleteAppLotteryGoodsById(Long id)
    {
        return appLotteryGoodsMapper.deleteAppLotteryGoodsById(id);
    }
}
