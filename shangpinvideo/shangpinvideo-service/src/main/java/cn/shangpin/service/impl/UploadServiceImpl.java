package cn.shangpin.service.impl;

import cn.shangpin.service.UploadService;
import cn.shangpin.utils.GetMD5;
import cn.shangpin.utils.GetRandom;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by qujie on 2018/11/21
 * */
@Service
public class UploadServiceImpl implements UploadService {

    @Value("${web.upload-img-path}")
    String imgPath;

    /**
     * 普通图片上传
     * @param file
     * @return
     * @throws Exception
     */
    @Override
    public String upload(MultipartFile file) throws Exception {
        /**
         * 获取文件名
         */
        String fileName = file.getOriginalFilename();
        /**
         * 获取文件的后缀名
         */
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = GetMD5.getMD5(fileName.substring(fileName.indexOf(".")-1) + "/"+System.currentTimeMillis())+ GetRandom.getRandom()+suffixName;

        File dest = new File(imgPath + fileName);
        /**
         * 检测是否存在目录
         */
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);
        return fileName;
    }

    /**
     * Base64图片上传
     * @param base64
     * @param targetPath
     * @return
     */
    @Override
    public String uploadBase64(String base64,String targetPath) throws Exception{
        byte[] buffer;
        FileOutputStream out = null;
        try {
            /**
             * Base64格式转换
             */
            buffer = new BASE64Decoder().decodeBuffer(base64);
            out = new FileOutputStream(imgPath+"/"+targetPath);
            out.write(buffer);
        } finally {
            /**
             * 关闭流
             */
            if (out != null) {
                out.close();
            }
        }
        return "/"+targetPath;
    }

}
