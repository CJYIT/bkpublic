package com.ruoyi.app.mapper;

import java.util.List;
import com.ruoyi.app.domain.AppCami;

/**
 * 资源卡密Mapper接口
 * 
 * @author ruoyi
 * @date 2024-06-19
 */
public interface AppCamiMapper 
{
    /**
     * 查询资源卡密
     * 
     * @param id 资源卡密主键
     * @return 资源卡密
     */
    public AppCami selectAppCamiById(Long id);

    /**
     * 查询资源卡密列表
     * 
     * @param appCami 资源卡密
     * @return 资源卡密集合
     */
    public List<AppCami> selectAppCamiList(AppCami appCami);

    /**
     * 新增资源卡密
     * 
     * @param appCami 资源卡密
     * @return 结果
     */
    public int insertAppCami(AppCami appCami);

    /**
     * 修改资源卡密
     * 
     * @param appCami 资源卡密
     * @return 结果
     */
    public int updateAppCami(AppCami appCami);

    /**
     * 删除资源卡密
     * 
     * @param id 资源卡密主键
     * @return 结果
     */
    public int deleteAppCamiById(Long id);

    /**
     * 批量删除资源卡密
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppCamiByIds(Long[] ids);
}
