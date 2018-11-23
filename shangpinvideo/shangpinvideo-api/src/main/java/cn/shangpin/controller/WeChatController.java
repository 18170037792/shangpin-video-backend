package cn.shangpin.controller;

import cn.shangpin.dto.UserInfoDto;
import cn.shangpin.service.UserInfoService;
import cn.shangpin.utils.Constant;
import cn.shangpin.utils.HttpUtil;
import cn.shangpin.utils.JsonResult;
import cn.shangpin.utils.ValidateUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qujie on 2018/11/21
 * */
@RestController
@RequestMapping("/weChat")
public class WeChatController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 微信小程序授权登录
     * */
    @GetMapping("/mpLogin")
    public JsonResult<Object> mpLogin(String code) throws Exception{
        if(StringUtils.isNotEmpty(code)){
            /**
             * 请求地址
             * */
            String url="https://api.weixin.qq.com/sns/jscode2session?appid="+ Constant.MP_APPID
                    +"&secret="+Constant.MP_SECRET
                    +"&js_code="+code
                    +"&grant_type=authorization_code";
            JSONObject jsonObject = HttpUtil.doGetJson(url);
            String openid = jsonObject.getString("openid");
            String session_key = jsonObject.getString("session_key");
            if(ValidateUtil.isNull(openid)){
                return new JsonResult<>(Constant.FAILED_CODE,Constant.LOGIN_FAILED);
            }
            /**
             * openId存在,返回登录用户信息
             * */
            if(userInfoService.judgeByOpenId(openid)){
                UserInfoDto dto = userInfoService.weChatLogin(openid);
                return new  JsonResult<>(Constant.SUCCESS_CODE,Constant.LOGIN_SUCCESS,dto);
            }else {
                UserInfoDto dto = new UserInfoDto();
                dto.setOpenId(openid);
                userInfoService.saveUser(dto);
                UserInfoDto infoDto = userInfoService.weChatLogin(openid);
                return new  JsonResult<>(Constant.SUCCESS_CODE,Constant.LOGIN_SUCCESS,infoDto);
            }
        }

        return null;
    }
}
