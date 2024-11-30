package com.ruoyi.app.service.impl;

import com.ruoyi.app.domain.AppDuanju;
import com.ruoyi.app.mapper.AppDuanjuMapper;
import com.ruoyi.app.service.IAppDuanjuService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 短剧资源Service业务层处理
 * 
 * @author budiao
 * @date 2024-06-07
 */
@Service
public class AppDuanjuServiceImpl implements IAppDuanjuService 
{
    @Autowired
    private AppDuanjuMapper appDuanjuMapper;

    /**
     * 查询短剧资源
     * 
     * @param id 短剧资源主键
     * @return 短剧资源
     */
    @Override
    public AppDuanju selectAppDuanjuById(Long id)
    {
        return appDuanjuMapper.selectAppDuanjuById(id);
    }

    /**
     * 查询短剧资源列表
     * 
     * @param appDuanju 短剧资源
     * @return 短剧资源
     */
    @Override
    public List<AppDuanju> selectAppDuanjuList(AppDuanju appDuanju)
    {
        return appDuanjuMapper.selectAppDuanjuList(appDuanju);
    }

    /**
     * 新增短剧资源
     * 
     * @param appDuanju 短剧资源
     * @return 结果
     */
    @Override
    public int insertAppDuanju(AppDuanju appDuanju)
    {
        appDuanju.setCreateTime(DateUtils.getNowDate());
        return appDuanjuMapper.insertAppDuanju(appDuanju);
    }

    /**
     * 修改短剧资源
     * 
     * @param appDuanju 短剧资源
     * @return 结果
     */
    @Override
    public int updateAppDuanju(AppDuanju appDuanju)
    {
        return appDuanjuMapper.updateAppDuanju(appDuanju);
    }

    /**
     * 批量删除短剧资源
     * 
     * @param ids 需要删除的短剧资源主键
     * @return 结果
     */
    @Override
    public int deleteAppDuanjuByIds(Long[] ids)
    {
        return appDuanjuMapper.deleteAppDuanjuByIds(ids);
    }

    /**
     * 删除短剧资源信息
     * 
     * @param id 短剧资源主键
     * @return 结果
     */
    @Override
    public int deleteAppDuanjuById(Long id)
    {
        return appDuanjuMapper.deleteAppDuanjuById(id);
    }
}
