package com.ruoyi.app.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.system.service.ISysConfigService;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.AppCamiMapper;
import com.ruoyi.app.domain.AppCami;
import com.ruoyi.app.service.IAppCamiService;

import javax.validation.Validator;

/**
 * 资源卡密Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-19
 */
@Service
public class AppCamiServiceImpl implements IAppCamiService 
{
    private static final Logger log = LoggerFactory.getLogger(AppCamiServiceImpl.class);
    @Autowired
    private AppCamiMapper appCamiMapper;
    @Autowired
    private ISysConfigService configService;
    @Autowired
    protected Validator validator;

    /**
     * 查询资源卡密
     * 
     * @param id 资源卡密主键
     * @return 资源卡密
     */
    @Override
    public AppCami selectAppCamiById(Long id)
    {
        return appCamiMapper.selectAppCamiById(id);
    }

    /**
     * 查询资源卡密列表
     * 
     * @param appCami 资源卡密
     * @return 资源卡密
     */
    @Override
    public List<AppCami> selectAppCamiList(AppCami appCami)
    {
        return appCamiMapper.selectAppCamiList(appCami);
    }

    /**
     * 新增资源卡密
     * 
     * @param appCami 资源卡密
     * @return 结果
     */
    @Override
    public int insertAppCami(AppCami appCami)
    {
        appCami.setCreateTime(DateUtils.getNowDate());
        return appCamiMapper.insertAppCami(appCami);
    }

    /**
     * 修改资源卡密
     * 
     * @param appCami 资源卡密
     * @return 结果
     */
    @Override
    public int updateAppCami(AppCami appCami)
    {
        return appCamiMapper.updateAppCami(appCami);
    }

    /**
     * 批量删除资源卡密
     * 
     * @param ids 需要删除的资源卡密主键
     * @return 结果
     */
    @Override
    public int deleteAppCamiByIds(Long[] ids)
    {
        return appCamiMapper.deleteAppCamiByIds(ids);
    }

    /**
     * 删除资源卡密信息
     * 
     * @param id 资源卡密主键
     * @return 结果
     */
    @Override
    public int deleteAppCamiById(Long id)
    {
        return appCamiMapper.deleteAppCamiById(id);
    }

    @Override
    public String importCami(List<AppCami> List, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(List) || List.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String password = configService.selectConfigByKey("sys.user.initPassword");
        for (AppCami cami : List)
        {
            try
            {
                BeanValidators.validateWithException(validator, cami);
                cami.setCreateTime(new Date());
                appCamiMapper.insertAppCami(cami);
                successNum++;
                successMsg.append("<br/>" + successNum + "、卡密： " + cami.getCami() + " 导入成功");
//                // 验证是否存
//                SysUser u = appCamiMapper.selectAppCamiById(user.getUserName());
//                if (StringUtils.isNull(u))
//                {
//                    BeanValidators.validateWithException(validator, cami);
//                    cami.setCreateTime(new Date());
//                    appCamiMapper.insertAppCami(cami);
//                    successNum++;
//                    successMsg.append("<br/>" + successNum + "、账号 " + user.getUserName() + " 导入成功");
//                }
//                else if (isUpdateSupport)
//                {
//                    BeanValidators.validateWithException(validator, user);
//                    checkUserAllowed(u);
//                    checkUserDataScope(u.getUserId());
//                    user.setUserId(u.getUserId());
//                    user.setUpdateBy(operName);
//                    userMapper.updateUser(user);
//                    successNum++;
//                    successMsg.append("<br/>" + successNum + "、账号 " + user.getUserName() + " 更新成功");
//                }
//                else
//                {
//                    failureNum++;
//                    failureMsg.append("<br/>" + failureNum + "、账号 " + user.getUserName() + " 已存在");
//                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、卡密： " + cami.getCami() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
