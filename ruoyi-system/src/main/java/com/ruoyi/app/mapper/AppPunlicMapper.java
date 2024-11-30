package com.ruoyi.app.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface AppPunlicMapper {
    //安全域名查询是否存在
    @Select("SELECT COUNT(0) FROM new_download_url where http_url = #{url}")
    public int isAdd(String url);

    //新增安全域名
    @Insert("insert into new_download_url (http_url) values (#{url})")
    public int add(String url);
}
