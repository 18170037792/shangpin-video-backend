package cn.shangpin.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by qujie on 2018/11/21
 * 文件上传接口
 * */
public interface UploadService {

    /**
     * 普通图片上传
     * @param file
     * @return
     * @throws Exception
     */
    public String upload(MultipartFile file) throws Exception;

    /**
     * Base64图片上传
     * @param base64
     * @param targetPath
     * @return
     */
    public String uploadBase64(String base64,String targetPath) throws Exception;

}
