package com.ruoyi.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.AppAdRecordMapper;
import com.ruoyi.app.domain.AppAdRecord;
import com.ruoyi.app.service.IAppAdRecordService;

/**
 * 广告点击记录Service业务层处理
 * 
 * @author budiao
 * @date 2024-04-07
 */
@Service
public class AppAdRecordServiceImpl implements IAppAdRecordService 
{
    @Autowired
    private AppAdRecordMapper appAdRecordMapper;

    /**
     * 查询广告点击记录
     * 
     * @param id 广告点击记录主键
     * @return 广告点击记录
     */
    @Override
    public AppAdRecord selectAppAdRecordById(Long id)
    {
        return appAdRecordMapper.selectAppAdRecordById(id);
    }

    /**
     * 查询广告点击记录列表
     * 
     * @param appAdRecord 广告点击记录
     * @return 广告点击记录
     */
    @Override
    public List<AppAdRecord> selectAppAdRecordList(AppAdRecord appAdRecord)
    {
        return appAdRecordMapper.selectAppAdRecordList(appAdRecord);
    }

    /**
     * 新增广告点击记录
     * 
     * @param appAdRecord 广告点击记录
     * @return 结果
     */
    @Override
    public int insertAppAdRecord(AppAdRecord appAdRecord)
    {
        return appAdRecordMapper.insertAppAdRecord(appAdRecord);
    }

    /**
     * 修改广告点击记录
     * 
     * @param appAdRecord 广告点击记录
     * @return 结果
     */
    @Override
    public int updateAppAdRecord(AppAdRecord appAdRecord)
    {
        return appAdRecordMapper.updateAppAdRecord(appAdRecord);
    }

    /**
     * 批量删除广告点击记录
     * 
     * @param ids 需要删除的广告点击记录主键
     * @return 结果
     */
    @Override
    public int deleteAppAdRecordByIds(Long[] ids)
    {
        return appAdRecordMapper.deleteAppAdRecordByIds(ids);
    }

    /**
     * 删除广告点击记录信息
     * 
     * @param id 广告点击记录主键
     * @return 结果
     */
    @Override
    public int deleteAppAdRecordById(Long id)
    {
        return appAdRecordMapper.deleteAppAdRecordById(id);
    }
}
