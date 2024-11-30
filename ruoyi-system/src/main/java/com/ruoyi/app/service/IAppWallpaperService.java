package com.ruoyi.app.service;

import java.util.List;
import com.ruoyi.app.domain.AppWallpaper;

/**
 * 壁纸Service接口
 * 
 * @author budiao
 * @date 2024-04-12
 */
public interface IAppWallpaperService 
{
    /**
     * 查询壁纸
     * 
     * @param id 壁纸主键
     * @return 壁纸
     */
    public AppWallpaper selectAppWallpaperById(Long id);

    /**
     * 查询壁纸列表
     * 
     * @param appWallpaper 壁纸
     * @return 壁纸集合
     */
    public List<AppWallpaper> selectAppWallpaperList(AppWallpaper appWallpaper);

    /**
     * 新增壁纸
     * 
     * @param appWallpaper 壁纸
     * @return 结果
     */
    public int insertAppWallpaper(AppWallpaper appWallpaper);

    /**
     * 修改壁纸
     * 
     * @param appWallpaper 壁纸
     * @return 结果
     */
    public int updateAppWallpaper(AppWallpaper appWallpaper);

    /**
     * 批量删除壁纸
     * 
     * @param ids 需要删除的壁纸主键集合
     * @return 结果
     */
    public int deleteAppWallpaperByIds(Long[] ids);

    /**
     * 删除壁纸信息
     * 
     * @param id 壁纸主键
     * @return 结果
     */
    public int deleteAppWallpaperById(Long id);
}
