package com.ruoyi.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.AppExchangeRecordsMapper;
import com.ruoyi.app.domain.AppExchangeRecords;
import com.ruoyi.app.service.IAppExchangeRecordsService;

/**
 * 兑换记录Service业务层处理
 * 
 * @author budiao
 * @date 2024-04-07
 */
@Service
public class AppExchangeRecordsServiceImpl implements IAppExchangeRecordsService 
{
    @Autowired
    private AppExchangeRecordsMapper appExchangeRecordsMapper;

    /**
     * 查询兑换记录
     * 
     * @param id 兑换记录主键
     * @return 兑换记录
     */
    @Override
    public AppExchangeRecords selectAppExchangeRecordsById(Long id)
    {
        return appExchangeRecordsMapper.selectAppExchangeRecordsById(id);
    }

    /**
     * 查询兑换记录列表
     * 
     * @param appExchangeRecords 兑换记录
     * @return 兑换记录
     */
    @Override
    public List<AppExchangeRecords> selectAppExchangeRecordsList(AppExchangeRecords appExchangeRecords)
    {
        return appExchangeRecordsMapper.selectAppExchangeRecordsList(appExchangeRecords);
    }

    /**
     * 新增兑换记录
     * 
     * @param appExchangeRecords 兑换记录
     * @return 结果
     */
    @Override
    public int insertAppExchangeRecords(AppExchangeRecords appExchangeRecords)
    {
        return appExchangeRecordsMapper.insertAppExchangeRecords(appExchangeRecords);
    }

    /**
     * 修改兑换记录
     * 
     * @param appExchangeRecords 兑换记录
     * @return 结果
     */
    @Override
    public int updateAppExchangeRecords(AppExchangeRecords appExchangeRecords)
    {
        return appExchangeRecordsMapper.updateAppExchangeRecords(appExchangeRecords);
    }

    /**
     * 批量删除兑换记录
     * 
     * @param ids 需要删除的兑换记录主键
     * @return 结果
     */
    @Override
    public int deleteAppExchangeRecordsByIds(Long[] ids)
    {
        return appExchangeRecordsMapper.deleteAppExchangeRecordsByIds(ids);
    }

    /**
     * 删除兑换记录信息
     * 
     * @param id 兑换记录主键
     * @return 结果
     */
    @Override
    public int deleteAppExchangeRecordsById(Long id)
    {
        return appExchangeRecordsMapper.deleteAppExchangeRecordsById(id);
    }
}
