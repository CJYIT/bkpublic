package com.ruoyi.app.mapper;

import java.util.List;
import com.ruoyi.app.domain.AppResource;
import com.ruoyi.app.domain.AppResourceList;
import org.apache.ibatis.annotations.Update;

/**
 * 资源Mapper接口
 * 
 * @author budiao
 * @date 2024-04-07
 */
public interface AppResourceMapper 
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
     * 删除资源
     * 
     * @param id 资源主键
     * @return 结果
     */
    public int deleteAppResourceById(Long id);

    /**
     * 批量删除资源
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppResourceByIds(Long[] ids);

    /**
     * 批量删除资源列
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppResourceListByAppResourceIds(Long[] ids);
    
    /**
     * 批量新增资源列
     * 
     * @param appResourceListList 资源列列表
     * @return 结果
     */
    public int batchAppResourceList(List<AppResourceList> appResourceListList);
    

    /**
     * 通过资源主键删除资源列信息
     * 
     * @param id 资源ID
     * @return 结果
     */
    public int deleteAppResourceListByAppResourceId(Long id);

    /**
     * 游览+1
     *
     * @param id 需要id
     * @return 结果
     */
    @Update("update app_resource SET down_num = down_num+1 where id = #{id}")
    public int lookAddNumber(Long id);
}
