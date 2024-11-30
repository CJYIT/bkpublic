package com.ruoyi.app.service;

import java.util.List;
import com.ruoyi.app.domain.AppExchangeGoods;

/**
 * 积分商品Service接口
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
public interface IAppExchangeGoodsService 
{
    /**
     * 查询积分商品
     * 
     * @param id 积分商品主键
     * @return 积分商品
     */
    public AppExchangeGoods selectAppExchangeGoodsById(Long id);

    /**
     * 查询积分商品列表
     * 
     * @param appExchangeGoods 积分商品
     * @return 积分商品集合
     */
    public List<AppExchangeGoods> selectAppExchangeGoodsList(AppExchangeGoods appExchangeGoods);

    /**
     * 新增积分商品
     * 
     * @param appExchangeGoods 积分商品
     * @return 结果
     */
    public int insertAppExchangeGoods(AppExchangeGoods appExchangeGoods);

    /**
     * 修改积分商品
     * 
     * @param appExchangeGoods 积分商品
     * @return 结果
     */
    public int updateAppExchangeGoods(AppExchangeGoods appExchangeGoods);

    /**
     * 批量删除积分商品
     * 
     * @param ids 需要删除的积分商品主键集合
     * @return 结果
     */
    public int deleteAppExchangeGoodsByIds(Long[] ids);

    /**
     * 删除积分商品信息
     * 
     * @param id 积分商品主键
     * @return 结果
     */
    public int deleteAppExchangeGoodsById(Long id);
}
