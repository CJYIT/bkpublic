package com.ruoyi.app.mapper;

import com.ruoyi.app.domain.AppDuanju;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 短剧资源Mapper接口
 * 
 * @author budiao
 * @date 2024-06-07
 */
public interface AppDuanjuMapper 
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
     * 删除短剧资源
     * 
     * @param id 短剧资源主键
     * @return 结果
     */
    public int deleteAppDuanjuById(Long id);

    /**
     * 批量删除短剧资源
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppDuanjuByIds(Long[] ids);

    @Select("SELECT COUNT(0) FROM `app_duanju`")
    public int listNumber();
}
