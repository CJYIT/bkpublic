package com.ruoyi.app.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.app.domain.AppResourceList;
import com.ruoyi.app.mapper.AppResourceMapper;
import com.ruoyi.app.domain.AppResource;
import com.ruoyi.app.service.IAppResourceService;

/**
 * 资源Service业务层处理
 * 
 * @author budiao
 * @date 2024-04-07
 */
@Service
public class AppResourceServiceImpl implements IAppResourceService 
{
    @Autowired
    private AppResourceMapper appResourceMapper;

    /**
     * 查询资源
     * 
     * @param id 资源主键
     * @return 资源
     */
    @Override
    public AppResource selectAppResourceById(Long id)
    {
        return appResourceMapper.selectAppResourceById(id);
    }

    /**
     * 查询资源列表
     * 
     * @param appResource 资源
     * @return 资源
     */
    @Override
    public List<AppResource> selectAppResourceList(AppResource appResource)
    {
        return appResourceMapper.selectAppResourceList(appResource);
    }

    /**
     * 新增资源
     * 
     * @param appResource 资源
     * @return 结果
     */
    @Transactional
    @Override
    public int insertAppResource(AppResource appResource)
    {
        appResource.setCreateTime(DateUtils.getNowDate());
        int rows = appResourceMapper.insertAppResource(appResource);
        insertAppResourceList(appResource);
        return rows;
    }

    /**
     * 修改资源
     * 
     * @param appResource 资源
     * @return 结果
     */
    @Transactional
    @Override
    public int updateAppResource(AppResource appResource)
    {
        appResourceMapper.deleteAppResourceListByAppResourceId(appResource.getId());
        insertAppResourceList(appResource);
        return appResourceMapper.updateAppResource(appResource);
    }

    /**
     * 批量删除资源
     * 
     * @param ids 需要删除的资源主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteAppResourceByIds(Long[] ids)
    {
        appResourceMapper.deleteAppResourceListByAppResourceIds(ids);
        return appResourceMapper.deleteAppResourceByIds(ids);
    }

    /**
     * 删除资源信息
     * 
     * @param id 资源主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteAppResourceById(Long id)
    {
        appResourceMapper.deleteAppResourceListByAppResourceId(id);
        return appResourceMapper.deleteAppResourceById(id);
    }

    /**
     * 新增资源列信息
     * 
     * @param appResource 资源对象
     */
    public void insertAppResourceList(AppResource appResource)
    {
        List<AppResourceList> appResourceListList = appResource.getAppResourceListList();
        Long id = appResource.getId();
        if (StringUtils.isNotNull(appResourceListList))
        {
            List<AppResourceList> list = new ArrayList<AppResourceList>();
            for (AppResourceList appResourceList : appResourceListList)
            {
                appResourceList.setAppResourceId(id);
                list.add(appResourceList);
            }
            if (list.size() > 0)
            {
                appResourceMapper.batchAppResourceList(list);
            }
        }
    }
}
