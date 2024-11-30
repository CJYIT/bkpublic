package com.ruoyi.web.controller.system;
import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/qiniu")
public class SysqiniuController {
    @GetMapping("/getUpToken")
    public String getUpToken(){
        // 配置你的accessKey和secretKey
        String accessKey = "";
        String secretKey = "";
        Auth auth = Auth.create(accessKey, secretKey);
        String token = auth.uploadToken("emoboy");
        return token;
    }
}
