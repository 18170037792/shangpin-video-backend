package cn.shangpin.controller;

import cn.shangpin.dto.UserInfoDto;
import cn.shangpin.service.UserInfoService;
import cn.shangpin.utils.Constant;
import cn.shangpin.utils.JsonResult;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UserInfoService userInfoService;

    //上传路径
    @Value("${web.upload-path}")
    String imgPath;

    /**
     * 头像上传接口
     * */
    @PostMapping("/image")
    public JsonResult<String> uploadImage(Long userId, @RequestParam("file") MultipartFile[] files) throws Exception {

        if (userId == null) {
            return new JsonResult<String>(Constant.FAILED_CODE,Constant.PARAMETER_ERROR);
        }
        // 保存到数据库中的相对路径
        String uploadPathDB ="/img" + "/" + userId.toString() + "/face";

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            if (files != null && files.length > 0) {
                String fileName = files[0].getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {
                    // 文件上传的最终保存路径
                    String finalFacePath = imgPath + uploadPathDB + "/" + fileName;
                    // 设置数据库保存的路径
                    uploadPathDB += ("/" + fileName);

                    File outFile = new File(finalFacePath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        // 创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }

                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = files[0].getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            } else {
                return new JsonResult<String>(Constant.FAILED_CODE,Constant.UPLOAD_FALIED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult<String>(Constant.FAILED_CODE,Constant.UPLOAD_FALIED);
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        /**
         * 保存用户信息
         * */
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(userId);
        userInfoDto.setFaceImage(uploadPathDB);
        userInfoService.updateUserInfo(userInfoDto);
        return new JsonResult<String>(Constant.SUCCESS_CODE,Constant.UPLOAD_SUCCESS,uploadPathDB);
    }
}
