package com.ruoyi.app.service;

import java.util.List;
import com.ruoyi.app.domain.AppAdRecord;

/**
 * 广告点击记录Service接口
 * 
 * @author budiao
 * @date 2024-04-07
 */
public interface IAppAdRecordService 
{
    /**
     * 查询广告点击记录
     * 
     * @param id 广告点击记录主键
     * @return 广告点击记录
     */
    public AppAdRecord selectAppAdRecordById(Long id);

    /**
     * 查询广告点击记录列表
     * 
     * @param appAdRecord 广告点击记录
     * @return 广告点击记录集合
     */
    public List<AppAdRecord> selectAppAdRecordList(AppAdRecord appAdRecord);

    /**
     * 新增广告点击记录
     * 
     * @param appAdRecord 广告点击记录
     * @return 结果
     */
    public int insertAppAdRecord(AppAdRecord appAdRecord);

    /**
     * 修改广告点击记录
     * 
     * @param appAdRecord 广告点击记录
     * @return 结果
     */
    public int updateAppAdRecord(AppAdRecord appAdRecord);

    /**
     * 批量删除广告点击记录
     * 
     * @param ids 需要删除的广告点击记录主键集合
     * @return 结果
     */
    public int deleteAppAdRecordByIds(Long[] ids);

    /**
     * 删除广告点击记录信息
     * 
     * @param id 广告点击记录主键
     * @return 结果
     */
    public int deleteAppAdRecordById(Long id);
}
