package com.logistics.userdame.uilt;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class BsUilt {
//    图片上传方法
    public static String setFlit(MultipartFile file,String url){
// 所以为每个文件生成一个新的文件名(asda-df43t-f34t3-23r2-34t2)
        String picName = UUID.randomUUID().toString();
        // 截取文件的扩展名(如.jpg)
        String oriName = file.getOriginalFilename();
//        System.out.println("--上传文件名-->>"+oriName);
        // .png  .jpg
        String extName = oriName.substring(oriName.lastIndexOf("."));


        String dirName = url;
        //创建文件夹
        File dirFile = new File(dirName);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        //拼接新文件名
        String newFileName = picName + extName;
        File targetFile = new File(dirName , newFileName);
        // 保存文件        pp.setPsrc("/img/"+newFileName);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
    }

    //时间处理方法
    public static String setDate(Date date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String mydate= simpleDateFormat.format(date);
        return mydate;
    }
}
