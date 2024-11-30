package com.ruoyi.app.mapper;

import java.util.List;
import com.ruoyi.app.domain.AppExchangeRecords;

/**
 * 兑换记录Mapper接口
 * 
 * @author budiao
 * @date 2024-04-07
 */
public interface AppExchangeRecordsMapper 
{
    /**
     * 查询兑换记录
     * 
     * @param id 兑换记录主键
     * @return 兑换记录
     */
    public AppExchangeRecords selectAppExchangeRecordsById(Long id);

    /**
     * 查询兑换记录列表
     * 
     * @param appExchangeRecords 兑换记录
     * @return 兑换记录集合
     */
    public List<AppExchangeRecords> selectAppExchangeRecordsList(AppExchangeRecords appExchangeRecords);

    /**
     * 新增兑换记录
     * 
     * @param appExchangeRecords 兑换记录
     * @return 结果
     */
    public int insertAppExchangeRecords(AppExchangeRecords appExchangeRecords);

    /**
     * 修改兑换记录
     * 
     * @param appExchangeRecords 兑换记录
     * @return 结果
     */
    public int updateAppExchangeRecords(AppExchangeRecords appExchangeRecords);

    /**
     * 删除兑换记录
     * 
     * @param id 兑换记录主键
     * @return 结果
     */
    public int deleteAppExchangeRecordsById(Long id);

    /**
     * 批量删除兑换记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppExchangeRecordsByIds(Long[] ids);
}
