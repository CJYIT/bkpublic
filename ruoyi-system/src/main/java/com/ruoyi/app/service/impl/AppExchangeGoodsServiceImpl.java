package com.ruoyi.app.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.AppExchangeGoodsMapper;
import com.ruoyi.app.domain.AppExchangeGoods;
import com.ruoyi.app.service.IAppExchangeGoodsService;

/**
 * 积分商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
@Service
public class AppExchangeGoodsServiceImpl implements IAppExchangeGoodsService 
{
    @Autowired
    private AppExchangeGoodsMapper appExchangeGoodsMapper;

    /**
     * 查询积分商品
     * 
     * @param id 积分商品主键
     * @return 积分商品
     */
    @Override
    public AppExchangeGoods selectAppExchangeGoodsById(Long id)
    {
        return appExchangeGoodsMapper.selectAppExchangeGoodsById(id);
    }

    /**
     * 查询积分商品列表
     * 
     * @param appExchangeGoods 积分商品
     * @return 积分商品
     */
    @Override
    public List<AppExchangeGoods> selectAppExchangeGoodsList(AppExchangeGoods appExchangeGoods)
    {
        return appExchangeGoodsMapper.selectAppExchangeGoodsList(appExchangeGoods);
    }

    /**
     * 新增积分商品
     * 
     * @param appExchangeGoods 积分商品
     * @return 结果
     */
    @Override
    public int insertAppExchangeGoods(AppExchangeGoods appExchangeGoods)
    {
        appExchangeGoods.setCreateTime(DateUtils.getNowDate());
        return appExchangeGoodsMapper.insertAppExchangeGoods(appExchangeGoods);
    }

    /**
     * 修改积分商品
     * 
     * @param appExchangeGoods 积分商品
     * @return 结果
     */
    @Override
    public int updateAppExchangeGoods(AppExchangeGoods appExchangeGoods)
    {
        return appExchangeGoodsMapper.updateAppExchangeGoods(appExchangeGoods);
    }

    /**
     * 批量删除积分商品
     * 
     * @param ids 需要删除的积分商品主键
     * @return 结果
     */
    @Override
    public int deleteAppExchangeGoodsByIds(Long[] ids)
    {
        return appExchangeGoodsMapper.deleteAppExchangeGoodsByIds(ids);
    }

    /**
     * 删除积分商品信息
     * 
     * @param id 积分商品主键
     * @return 结果
     */
    @Override
    public int deleteAppExchangeGoodsById(Long id)
    {
        return appExchangeGoodsMapper.deleteAppExchangeGoodsById(id);
    }
}
