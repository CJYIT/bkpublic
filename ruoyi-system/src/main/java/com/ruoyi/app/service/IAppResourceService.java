package com.ruoyi.app.service;

import java.util.List;
import com.ruoyi.app.domain.AppResource;

/**
 * 资源Service接口
 * 
 * @author budiao
 * @date 2024-04-07
 */
public interface IAppResourceService 
{
    /**
     * 查询资源
     * 
     * @param id 资源主键
     * @return 资源
     */
    public AppResource selectAppResourceById(Long id);

    /**
     * 查询资源列表
     * 
     * @param appResource 资源
     * @return 资源集合
     */
    public List<AppResource> selectAppResourceList(AppResource appResource);

    /**
     * 新增资源
     * 
     * @param appResource 资源
     * @return 结果
     */
    public int insertAppResource(AppResource appResource);

    /**
     * 修改资源
     * 
     * @param appResource 资源
     * @return 结果
     */
    public int updateAppResource(AppResource appResource);

    /**
     * 批量删除资源
     * 
     * @param ids 需要删除的资源主键集合
     * @return 结果
     */
    public int deleteAppResourceByIds(Long[] ids);

    /**
     * 删除资源信息
     * 
     * @param id 资源主键
     * @return 结果
     */
    public int deleteAppResourceById(Long id);
}
