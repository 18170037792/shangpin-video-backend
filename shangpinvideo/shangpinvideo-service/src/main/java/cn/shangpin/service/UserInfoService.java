package cn.shangpin.service;

import cn.shangpin.dto.UserInfoDto;
import cn.shangpin.dto.UserPersonalDto;
import cn.shangpin.query.UserInfoLogin;
import cn.shangpin.utils.JsonResult;

import javax.servlet.http.HttpSession;

/**
 * Created by qujie on 2018/11/7
 * 用户信息业务层
 * */
public interface UserInfoService {

    /**
     * 判断用户名是否存在
     * */
    public boolean userNameIsExist(String username) throws Exception;

    /**
     * 保存用户信息
     * */
    public void saveUser(UserInfoDto userInfoDto) throws Exception;

    /**
     * 用户登录
     * */
    public JsonResult<UserInfoDto> login(UserInfoLogin userInfoLogin) throws Exception;

    /**
     * 根据用户id关联查询个人信息
     * */
    public UserPersonalDto getUserPersonalInfo(Long userId) throws Exception;
}
