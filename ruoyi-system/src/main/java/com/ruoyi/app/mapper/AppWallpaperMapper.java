package com.ruoyi.app.mapper;

import java.util.List;
import com.ruoyi.app.domain.AppWallpaper;
import org.apache.ibatis.annotations.Update;

/**
 * 壁纸Mapper接口
 * 
 * @author budiao
 * @date 2024-04-12
 */
public interface AppWallpaperMapper 
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
     * 删除壁纸
     * 
     * @param id 壁纸主键
     * @return 结果
     */
    public int deleteAppWallpaperById(Long id);

    /**
     * 批量删除壁纸
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppWallpaperByIds(Long[] ids);

    /**
     * 游览+1
     *
     * @param id 需要id
     * @return 结果
     */
    @Update("update app_wallpaper SET down_num = down_num+1 where id = #{id}")
    public int lookAddNumber(Long id);
}
