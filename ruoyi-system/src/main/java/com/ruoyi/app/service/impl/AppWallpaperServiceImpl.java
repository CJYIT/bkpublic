package com.ruoyi.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.AppWallpaperMapper;
import com.ruoyi.app.domain.AppWallpaper;
import com.ruoyi.app.service.IAppWallpaperService;

/**
 * 壁纸Service业务层处理
 * 
 * @author budiao
 * @date 2024-04-12
 */
@Service
public class AppWallpaperServiceImpl implements IAppWallpaperService 
{
    @Autowired
    private AppWallpaperMapper appWallpaperMapper;

    /**
     * 查询壁纸
     * 
     * @param id 壁纸主键
     * @return 壁纸
     */
    @Override
    public AppWallpaper selectAppWallpaperById(Long id)
    {
        return appWallpaperMapper.selectAppWallpaperById(id);
    }

    /**
     * 查询壁纸列表
     * 
     * @param appWallpaper 壁纸
     * @return 壁纸
     */
    @Override
    public List<AppWallpaper> selectAppWallpaperList(AppWallpaper appWallpaper)
    {
        return appWallpaperMapper.selectAppWallpaperList(appWallpaper);
    }

    /**
     * 新增壁纸
     * 
     * @param appWallpaper 壁纸
     * @return 结果
     */
    @Override
    public int insertAppWallpaper(AppWallpaper appWallpaper)
    {
        return appWallpaperMapper.insertAppWallpaper(appWallpaper);
    }

    /**
     * 修改壁纸
     * 
     * @param appWallpaper 壁纸
     * @return 结果
     */
    @Override
    public int updateAppWallpaper(AppWallpaper appWallpaper)
    {
        return appWallpaperMapper.updateAppWallpaper(appWallpaper);
    }

    /**
     * 批量删除壁纸
     * 
     * @param ids 需要删除的壁纸主键
     * @return 结果
     */
    @Override
    public int deleteAppWallpaperByIds(Long[] ids)
    {
        return appWallpaperMapper.deleteAppWallpaperByIds(ids);
    }

    /**
     * 删除壁纸信息
     * 
     * @param id 壁纸主键
     * @return 结果
     */
    @Override
    public int deleteAppWallpaperById(Long id)
    {
        return appWallpaperMapper.deleteAppWallpaperById(id);
    }
}
