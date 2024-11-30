package com.ruoyi.web.controller.app;

import com.ruoyi.app.domain.ShuiYinVo;
import com.ruoyi.app.mapper.AppPunlicMapper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/app/public")
public class PublicController  extends BaseController {
    @Resource
    AppPunlicMapper appPunlicMapper;
    @Autowired
    private ISysConfigService configService;
    /**
     * 获取微信openid信息
     */
    @GetMapping(value = "/autoLoginWx/{code}")
    public AjaxResult autoLoginWx(@PathVariable("code") String code)
    {
        HttpUtils httpUtils = new HttpUtils();
        String appid = configService.selectConfigByKey("miniapp.wx.appId");
        String secret = configService.selectConfigByKey("miniapp.wx.secret");
        String param = "appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
        String s = httpUtils.httpGet("https://api.weixin.qq.com/sns/jscode2session", param);
        return success(s);
    }

    /**
     * 去水印 key 免费申请联系作者微信：budiaoziyuan666
     * @return
     */
    @Value("${ruoyi.delWatermarkKey}")
    private String delWatermarkKey;
    @PostMapping(value = "/delSHuiYin")
    public AjaxResult delSHuiYin(HttpServletRequest request, @RequestBody ShuiYinVo shuiYinVo)  {
        HttpUtils httpUtils = new HttpUtils();
        String key = configService.selectConfigByKey("miniapp.shuiyin.key");
        String param = "key="+key+"&url="+shuiYinVo.getUrl();
        String s = httpUtils.httpGet("https://api.emoboy.vip/api/shuiyin/delWatermark", param);
        return success(s);
    }

    //记录未配置的安全域名
    @GetMapping(value = "/addNewDownloadUrl/{url}")
    public AjaxResult addNewDownloadUrl(@PathVariable("url") String url)
    {
        url = "https://"+url;
        int add = appPunlicMapper.isAdd(url);
        if (add == 0){
            appPunlicMapper.add(url);
        }
        return success(1);
    }

    //获取系统配置数据
    @GetMapping(value = "/getSysSet")
    public HashMap<String, Object> getSysSet()
    {
        HashMap<String, Object> map = new HashMap<>();
        //广告id
        String adVideoAd = configService.selectConfigByKey("miniapp.ad.videoAd");
        String downVideoAd = configService.selectConfigByKey("miniapp.down.videoAd");
        String homeAd = configService.selectConfigByKey("miniapp.home.interstitialAd");
        String zyinfoAd = configService.selectConfigByKey("miniapp.zyinfo.ad");
        String wzinfoAd = configService.selectConfigByKey("miniapp.wzinfo.ad");
        String computerAd = configService.selectConfigByKey("miniapp.computer.ad");
        String phoneAd = configService.selectConfigByKey("miniapp.phone.ad");
        String indexModalInfo = configService.selectConfigByKey("miniapp.index.modal");
        String indexNotice = configService.selectConfigByKey("miniapp.index.notice");
        String indexSwiper = configService.selectConfigByKey("miniapp.index.swiper");
        map.put("adVideoAd",adVideoAd);
        map.put("downVideoAd",downVideoAd);
        map.put("homeAd",homeAd);
        map.put("zyinfoAd",zyinfoAd);
        map.put("wzinfoAd",wzinfoAd);
        map.put("computerAd",computerAd);
        map.put("phoneAd",phoneAd);
        map.put("indexModalInfo",indexModalInfo);
        map.put("indexNotice",indexNotice);
        map.put("indexSwiper",indexSwiper);
        return map;
    }

}
