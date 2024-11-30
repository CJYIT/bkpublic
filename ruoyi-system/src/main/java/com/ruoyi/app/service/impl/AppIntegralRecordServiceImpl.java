package com.ruoyi.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.AppIntegralRecordMapper;
import com.ruoyi.app.domain.AppIntegralRecord;
import com.ruoyi.app.service.IAppIntegralRecordService;

/**
 * 积分记录Service业务层处理
 * 
 * @author budiao
 * @date 2024-04-07
 */
@Service
public class AppIntegralRecordServiceImpl implements IAppIntegralRecordService 
{
    @Autowired
    private AppIntegralRecordMapper appIntegralRecordMapper;

    /**
     * 查询积分记录
     * 
     * @param id 积分记录主键
     * @return 积分记录
     */
    @Override
    public AppIntegralRecord selectAppIntegralRecordById(Long id)
    {
        return appIntegralRecordMapper.selectAppIntegralRecordById(id);
    }

    /**
     * 查询积分记录列表
     * 
     * @param appIntegralRecord 积分记录
     * @return 积分记录
     */
    @Override
    public List<AppIntegralRecord> selectAppIntegralRecordList(AppIntegralRecord appIntegralRecord)
    {
        return appIntegralRecordMapper.selectAppIntegralRecordList(appIntegralRecord);
    }

    /**
     * 新增积分记录
     * 
     * @param appIntegralRecord 积分记录
     * @return 结果
     */
    @Override
    public int insertAppIntegralRecord(AppIntegralRecord appIntegralRecord)
    {
        return appIntegralRecordMapper.insertAppIntegralRecord(appIntegralRecord);
    }

    /**
     * 修改积分记录
     * 
     * @param appIntegralRecord 积分记录
     * @return 结果
     */
    @Override
    public int updateAppIntegralRecord(AppIntegralRecord appIntegralRecord)
    {
        return appIntegralRecordMapper.updateAppIntegralRecord(appIntegralRecord);
    }

    /**
     * 批量删除积分记录
     * 
     * @param ids 需要删除的积分记录主键
     * @return 结果
     */
    @Override
    public int deleteAppIntegralRecordByIds(Long[] ids)
    {
        return appIntegralRecordMapper.deleteAppIntegralRecordByIds(ids);
    }

    /**
     * 删除积分记录信息
     * 
     * @param id 积分记录主键
     * @return 结果
     */
    @Override
    public int deleteAppIntegralRecordById(Long id)
    {
        return appIntegralRecordMapper.deleteAppIntegralRecordById(id);
    }
}
