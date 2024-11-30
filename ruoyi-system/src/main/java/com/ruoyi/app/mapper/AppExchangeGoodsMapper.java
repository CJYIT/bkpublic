package com.ruoyi.app.mapper;

import java.util.List;
import com.ruoyi.app.domain.AppExchangeGoods;

/**
 * 积分商品Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
public interface AppExchangeGoodsMapper 
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
     * 删除积分商品
     * 
     * @param id 积分商品主键
     * @return 结果
     */
    public int deleteAppExchangeGoodsById(Long id);

    /**
     * 批量删除积分商品
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppExchangeGoodsByIds(Long[] ids);
}
