package com.ruoyi.web.controller.tool;

import com.qiniu.util.Auth;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.utils.StringUtils;

public class QiniuSignedUrl {
    public static void main(String[] args) {
        // 配置你的accessKey和secretKey
        String accessKey = "";
        String secretKey = "";
        Auth auth = Auth.create(accessKey, secretKey);

        // 要访问的图片名，例如："image.jpg"
        String fileName = "appimg/goods/83cd28bd3ca19cf87d15bdebc596517.png";

        // 自定义域名，例如："http://your-custom-domain.com"
        String domainOfBucket = "";

        // 生成签名URL
        long expireInSeconds = 60; // 签名的有效时间，例如1小时(3600秒)
        String privateUrl = auth.privateDownloadUrl(domainOfBucket + "/" + fileName, expireInSeconds);

        System.out.println("Signed URL: " + privateUrl);
    }
    public String qiniuUrl(String url){
        String accessKey = "";
        String secretKey = "";
        Auth auth = Auth.create(accessKey, secretKey);
        // 要访问的图片名，例如："image.jpg"
        String fileName = url;
        // 自定义域名，例如："http://your-custom-domain.com"
        String domainOfBucket = "";
        // 生成签名URL
        long expireInSeconds = 60; // 签名的有效时间，例如1小时(3600秒)
        String privateUrl = auth.privateDownloadUrl(domainOfBucket + "/" + fileName, expireInSeconds);

        return "privateUrl";
    }
}
