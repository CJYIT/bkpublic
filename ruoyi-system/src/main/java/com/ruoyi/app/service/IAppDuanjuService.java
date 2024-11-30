package com.ruoyi.app.service;

import com.ruoyi.app.domain.AppDuanju;

import java.util.List;

/**
 * 短剧资源Service接口
 * 
 * @author budiao
 * @date 2024-06-07
 */
public interface IAppDuanjuService 
{
    /**
     * 查询短剧资源
     * 
     * @param id 短剧资源主键
     * @return 短剧资源
     */
    public AppDuanju selectAppDuanjuById(Long id);

    /**
     * 查询短剧资源列表
     * 
     * @param appDuanju 短剧资源
     * @return 短剧资源集合
     */
    public List<AppDuanju> selectAppDuanjuList(AppDuanju appDuanju);

    /**
     * 新增短剧资源
     * 
     * @param appDuanju 短剧资源
     * @return 结果
     */
    public int insertAppDuanju(AppDuanju appDuanju);

    /**
     * 修改短剧资源
     * 
     * @param appDuanju 短剧资源
     * @return 结果
     */
    public int updateAppDuanju(AppDuanju appDuanju);

    /**
     * 批量删除短剧资源
     * 
     * @param ids 需要删除的短剧资源主键集合
     * @return 结果
     */
    public int deleteAppDuanjuByIds(Long[] ids);

    /**
     * 删除短剧资源信息
     * 
     * @param id 短剧资源主键
     * @return 结果
     */
    public int deleteAppDuanjuById(Long id);
}
