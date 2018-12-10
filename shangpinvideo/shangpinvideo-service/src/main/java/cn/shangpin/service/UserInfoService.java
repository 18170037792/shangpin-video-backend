package cn.shangpin.service;

import cn.shangpin.dto.UserInfoDto;
import cn.shangpin.dto.UserPersonalDto;
import cn.shangpin.query.UserInfoLogin;

/**
 * Created by qujie on 2018/11/7
 * 用户信息业务层
 * */
public interface UserInfoService <T>{

    /**
     * 判断用户名是否存在
     * */
    public boolean userNameIsExist(String username) throws Exception;

    /**
     * 保存用户信息
     * */
    public void saveUser(UserInfoDto userInfoDto) throws Exception;

    /**
     * 修改用户信息
     * */
    public void updateUserInfo(UserInfoDto userInfoDto) throws Exception;

    /**
     * 用户登录
     * */
    public UserInfoDto login(UserInfoLogin userInfoLogin) throws Exception;

    /**
     * 根据用户id关联查询个人信息
     * */
    public UserPersonalDto getUserPersonalInfo(Long userId) throws Exception;

    /**
     * 判断oepnId是否绑定
     * */
    public Boolean judgeByOpenId(String openId) throws Exception;

    /**
     * 微信授权登录
     * */
    public UserInfoDto weChatLogin(String openId) throws Exception;

    /**
     * Redis中获取json对象
     * */
    public UserInfoDto getEntity(String key, Class<T> classz) throws Exception;

    /**
     * Redis中获取String
     * */
    public String getString(String key) throws Exception;

    /**
     * 存入对象至redis
     * */
    public void save(String key, UserInfoDto dto, long time) throws Exception;

    /**
     * 清除缓存
     * */
    public void remove(String key) throws Exception;
}
