package cn.shangpin.controller;

import cn.shangpin.dto.UserInfoDto;
import cn.shangpin.dto.UserPersonalDto;
import cn.shangpin.query.UserInfoLogin;
import cn.shangpin.service.UserInfoService;
import cn.shangpin.utils.Constant;
import cn.shangpin.utils.GetMD5;
import cn.shangpin.utils.JsonResult;
import cn.shangpin.utils.ValidateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
            userInfoDto.setPassword(userInfoDto.getPassword());
            userInfoDto.setNickname(userInfoDto.getUsername());
            userInfoDto.setFansCounts(0);
            userInfoDto.setFollowCounts(0);
            userInfoDto.setReceiveLikeCounts(0);
            userInfoService.saveUser(userInfoDto);
        }else {
            return new JsonResult<>(Constant.FAILED_CODE,"用户名已存在");
        }

        return new JsonResult<>(Constant.SUCCESS_CODE,Constant.SAVE_SUCCESS,userInfoDto);
    }

    @PostMapping("/login")
    public JsonResult<UserInfoDto> login(@RequestBody UserInfoLogin userInfoLogin) throws Exception {
        if(StringUtils.isBlank(userInfoLogin.getUsername())||StringUtils.isBlank(userInfoLogin.getPassword())){
            return new JsonResult<>(Constant.FAILED_CODE,"用户名或密码不能为空");
        }
        /**
         * md5加密参数
         * */
        userInfoLogin.setPassword(GetMD5.getMD5(userInfoLogin.getPassword()));
        UserInfoDto infoDto = userInfoService.login(userInfoLogin);
        infoDto.setPrefix("user");
        /**
         * 登录信息存入redis中
         * */
        userInfoService.save(infoDto.getPrefix() + infoDto.getId(),infoDto,10086L);
        return new JsonResult<>(Constant.SUCCESS_CODE,Constant.LOGIN_SUCCESS,infoDto);

    }

    /**
     * 用户注销
     * */
    @PostMapping("/logout")
    public JsonResult<Object> logout(HttpServletRequest request) throws Exception{
        String accessToken = request.getHeader("Token");
        if (accessToken != null && !accessToken.equals("")) {
            userInfoService.remove(accessToken);
        }
        return new JsonResult<>(Constant.SUCCESS_CODE,Constant.UNLOGIN_SUCCESS);
    }

    /**
     * 查询个人信息
     * */
    @GetMapping("/userPersonal")
    public JsonResult<UserPersonalDto> getUserPersonal(Long userId) throws Exception {
        UserPersonalDto dto = userInfoService.getUserPersonalInfo(userId);
        if(dto==null){
            return new JsonResult<>(Constant.FAILED_CODE,Constant.WAIT_AGAIN);
        }else {
            return new JsonResult<>(Constant.SUCCESS_CODE,Constant.QUERY_SUCCESS,dto);
        }
    }

}
