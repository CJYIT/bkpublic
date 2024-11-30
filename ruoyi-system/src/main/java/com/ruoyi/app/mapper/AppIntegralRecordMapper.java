package com.ruoyi.app.mapper;

import java.util.List;
import com.ruoyi.app.domain.AppIntegralRecord;

/**
 * 积分记录Mapper接口
 * 
 * @author budiao
 * @date 2024-04-07
 */
public interface AppIntegralRecordMapper 
{
    /**
     * 查询积分记录
     * 
     * @param id 积分记录主键
     * @return 积分记录
     */
    public AppIntegralRecord selectAppIntegralRecordById(Long id);

    /**
     * 查询积分记录列表
     * 
     * @param appIntegralRecord 积分记录
     * @return 积分记录集合
     */
    public List<AppIntegralRecord> selectAppIntegralRecordList(AppIntegralRecord appIntegralRecord);

    public int selectAppIntegralRecordCount(AppIntegralRecord appIntegralRecord);

    /**
     * 新增积分记录
     * 
     * @param appIntegralRecord 积分记录
     * @return 结果
     */
    public int insertAppIntegralRecord(AppIntegralRecord appIntegralRecord);

    /**
     * 修改积分记录
     * 
     * @param appIntegralRecord 积分记录
     * @return 结果
     */
    public int updateAppIntegralRecord(AppIntegralRecord appIntegralRecord);

    /**
     * 删除积分记录
     * 
     * @param id 积分记录主键
     * @return 结果
     */
    public int deleteAppIntegralRecordById(Long id);

    /**
     * 批量删除积分记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppIntegralRecordByIds(Long[] ids);
}
