---

---


<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">不凋博客资源</h1>
<h4 align="center">基于UniApp开发</h4>
<p align="center">
	<img src="https://img.shields.io/github/license/mashape/apistatus.svg">
</p>

## 平台简介

最近更新内容：首页按钮自定义，后台字定义表单，后端接口幂等性问题优化，后台微信用户权限修改，首页加载优化，头像新增广告位配置，修复文章修改bug，短剧增加重复校验。有其他需求的用户请联系我

不凋博客资源变现专为内容/资源下载场景设计，一站式解决内容带货、流量、资源变现，资源博客文章分享难题，目前以实现个人博客，文章发表，资源收集下载，手机壁纸下载，电脑壁纸下载，头像下载，小程序端提交网盘资源，支持抖音，快手，小红书等 100+ 平台的图片视频水印去除(注意因服务器消耗高已取消图片去水印)，这些内容展示均已实现微信小程序流量主广告变现功能，可根据自己需要进行配置
另外还加入了积分系统以及积分任务和积分商店,可让用户完成相应的任务获得积分换取奖励，源码无保留可二次开发。

* 应用框架基于[uniapp](https://uniapp.dcloud.net.cn/)，支持小程序、H5、Android和IOS。（流量主流量变现广告目前只支持微信小程序）
* 前端组件采用[uni-ui](https://github.com/dcloudio/uni-ui)，全端兼容的高性能UI框架。
* 阿里云免费试用3个月，新老用户7折优惠：https://www.aliyun.com/minisite/goods?userCode=zm2iaoye
  需要后端代码请打开微信搜索公众号关注 “不凋不败” 或微信扫面下方二维码关注微信公众号发送 "后端源码" 即可获取

![公众号不凋不败](https://github.com/user-attachments/assets/369a6a91-b43a-4ada-acbb-c58aae2f698d)





后台网站首页
![后台系统](https://github.com/user-attachments/assets/ad3cfff7-697b-45c8-a597-4d258863349e)
后台登录页面
![后台登录](https://github.com/user-attachments/assets/7b3e7660-e852-4b50-a3a9-8f5da2176494)
后台管理页面
![后台管理](https://github.com/user-attachments/assets/8587a672-551a-47d9-b84c-0f5aa8233513)


## 技术文档

- 运行之前请打开接口 \ruoyi-admin\src\main\java\com\ruoyi\web\controller\app\PublicController,把 PublicController 接口里面的 autoLoginWx（获取微信openid信息方法） 里面的 appid 和 secret 2个参数 设置为您的微信appId和secret（不需要微信登录可以忽略这一步
- 新下载的项目默认实现的微信登录，如不需要微信登录而使用账号密码登录请将前端的登录接口指向 \ruoyi-admin\src\main\java\com\ruoyi\web\controller\system\SysLoginController 接口的 login 方法即可，反之该接口的 wxLogin 方法是微信授权登录接口
- 后端运行请编辑resources目录下的application-druid.yml 修改为自己的数据库信息
- 前端运行请进入根目录的 budiao-blog-ui 文价夹下先安装依赖运行命令 npm install --registry=https://registry.npmmirror.com 然后本地开发运行 npm run dev 启动好后打开浏览器，输入：(http://localhost:80 (opens new window)) 默认账户/密码 admin/admin123）即可访问
- 如问题欢迎联系作者QQ： 2922064790 或 微信：a223312
- 微信小程序端页面：
![微信小程序页面01](https://github.com/user-attachments/assets/aac0eedd-d3bf-427d-95cd-a05b85fa05ad)

![微信小程序页面02](https://github.com/user-attachments/assets/2fd7df04-b762-4c63-8d82-8956b340d562)

- 打开微信扫描下面的小程序码即可体验小程序

![微信小程序](https://github.com/user-attachments/assets/a577f0cf-e4e0-4024-8943-ecd1831d28d9)


