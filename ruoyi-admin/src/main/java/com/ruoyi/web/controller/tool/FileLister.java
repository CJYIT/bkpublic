package com.ruoyi.web.controller.tool;


import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileLister {
    //UPDATE app_wallpaper SET img_url = REPLACE(img_url, '域名1', '域名2') WHERE nickname LIKE '%abc%';
    private static int counter = 1;
    public static void main(String[] args) {
        aVoid("D:\\BaiduNetdiskDownload\\壁纸\\月婵\\a");
        //cmm();


    }
    public static void aVoid(String url){
        File folder = new File(url);
        File[] files = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile();
            }
        });
        for (File file : files) {
            //INSERT INTO app_wallpaper (img_url, is_ad,keyword,wallpaper_type) VALUES ('url', 0, '关键字',1);
            String urlStr = "appimg/wallpaper/mobile_phone/yuechan/"+file.getName();
            System.out.println("INSERT INTO app_wallpaper (img_url, is_ad,keyword,wallpaper_type) VALUES ('"+urlStr+"',1,'动漫，古风，美女，月禅，性感，完美世界',1);");
            //System.out.println(file.getName());
        }
    }

    public static void cmm(String url){
        Path directoryPath = Paths.get(url); // 替换为你的目标路径
        try {
            Files.walk(directoryPath)
                    .filter(Files::isRegularFile)
                    .sorted()
                    .forEach(file -> {
                        String type = "";
                        String fileName = file.getFileName().toString();
                        int dotIndex = fileName.lastIndexOf(".");
                        if (dotIndex != -1) {
                            String fileExtension = fileName.substring(dotIndex + 1);
                            type = fileName.substring(dotIndex + 1);
                            //System.out.println("文件后缀为：" + fileExtension);
                        } else {
                            //System.out.println("文件名没有后缀");
                        }
                        System.out.println(type);
                        String newName = String.format("%d."+type, counter++); // 使用计数器来命名文件
                        System.out.println(newName);
                        Path newFilePath = file.getParent().resolve(newName);
                        try {
                            Files.move(file, newFilePath, StandardCopyOption.REPLACE_EXISTING); // 重命名文件
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
