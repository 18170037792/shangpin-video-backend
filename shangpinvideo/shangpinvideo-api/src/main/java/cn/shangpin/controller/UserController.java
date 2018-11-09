package cn.shangpin.controller;

import cn.shangpin.dto.UserInfoDto;
import cn.shangpin.pojo.UserInfoTable;
import cn.shangpin.query.UserInfoLogin;
import cn.shangpin.service.UserInfoService;
import cn.shangpin.utils.Constant;
import cn.shangpin.utils.GetMD5;
import cn.shangpin.utils.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qujie on 2018/11/7
 * 用户模块api
 * */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 用户注册
     * */
    @PostMapping("/regist")
    public JsonResult<Object> regist(@RequestBody UserInfoDto userInfoDto) throws Exception{

        /**
         * 判断用户名和密码是否为空
         * */
        if(StringUtils.isBlank(userInfoDto.getUsername())|| StringUtils.isBlank(userInfoDto.getPassword())){
            return new JsonResult<>(Constant.FAILED_CODE,"用户名或密码不能为空");
        }

        /**
         * 判断用户名是否存在
         * */
        boolean flag = userInfoService.userNameIsExist(userInfoDto.getUsername());

        /**
         * 保存用户注册信息
         * */
        if(!flag){
            userInfoDto.setPassword(GetMD5.getMD5(userInfoDto.getPassword()));
            userInfoDto.setNickname(userInfoDto.getUsername());
            userInfoDto.setFansCounts(0);
            userInfoDto.setFollowCounts(0);
            userInfoDto.setReceiveLikeCounts(0);
            userInfoService.saveUser(userInfoDto);
        }else {
            return new JsonResult<>(Constant.FAILED_CODE,"用户名已存在");
        }

        return new JsonResult<>(Constant.SUCCESS_CODE,Constant.SAVE_SUCCESS);
    }

    /**
     * 用户登录
     * */
    @PostMapping("/login")
    public JsonResult<Object> login(@RequestBody UserInfoLogin userInfoLogin) throws Exception{

        if(StringUtils.isBlank(userInfoLogin.getUsername())){
            /**
             * 使用手机号和密码登录
             * */
            if(StringUtils.isBlank(userInfoLogin.getPhone())||StringUtils.isBlank(userInfoLogin.getPassword())){
                return new JsonResult<>(Constant.FAILED_CODE,"用户名或密码不能为空");
            }
            /**
             * 验证登录信息
             * */
            UserInfoDto infoDto = userInfoService.login(userInfoLogin);
            if(infoDto==null){
                return new JsonResult<>(Constant.FAILED_CODE,"此用户不存在，请重新登录");
            }else {
                return new JsonResult<>(Constant.SUCCESS_CODE,Constant.LOGIN_SUCCESS,infoDto);
            }
        }else if (StringUtils.isBlank(userInfoLogin.getPhone())){
            /**
             * 使用帐号和密码登录
             * */
            if (StringUtils.isBlank(userInfoLogin.getUsername())||StringUtils.isBlank(userInfoLogin.getPassword())){
                return new JsonResult<>(Constant.FAILED_CODE,"用户名或密码不能为空");
            }
            UserInfoDto infoDto = userInfoService.login(userInfoLogin);
            if(infoDto==null){
                return new JsonResult<>(Constant.FAILED_CODE,"此用户不存在，请重新登录");
            }else {
                return new JsonResult<>(Constant.SUCCESS_CODE,Constant.LOGIN_SUCCESS,infoDto);
            }
        }
        return null;
    }

}
