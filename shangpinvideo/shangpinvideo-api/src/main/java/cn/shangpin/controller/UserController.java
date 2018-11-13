package cn.shangpin.controller;

import cn.shangpin.dto.UserInfoDto;
import cn.shangpin.pojo.UserInfoTable;
import cn.shangpin.query.UserInfoLogin;
import cn.shangpin.service.UserInfoService;
import cn.shangpin.utils.Constant;
import cn.shangpin.utils.GetMD5;
import cn.shangpin.utils.HttpUtil;
import cn.shangpin.utils.JsonResult;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
     * @api {post} user/login 用户登录
     * @apiVersion 1.0.0
     * @apiName login
     * @apiGroup user
     * @apiDescription  用户通过账号密码进行登录
     * @apiParam {String} userName 账号
     * @apiParam {String} password 密码
     * @apiParamExample {json} 请求示例：
     * {
     *      "userName":"李四",
     *      "password":"123123"
     * }
     * @apiSuccess {Number} code 返回类型
     * @apiSuccess {String} msg 返回提示
     * @apiSuccess {Object} data 用户信息
     * @apiSuccess {String} data.phone 手机号
     * @apiSuccess {String} data.username 用户名称
     * @apiSuccess {String} data.password 登录密码
     * @apiSuccess {String} data.faceImage 用户头像
     * @apiSuccess {String} data.nickname 用户昵称
     * @apiSuccess {Number} data.fansCounts 粉丝数量
     * @apiSuccess {Number} data.followCounts 关注的用户数
     * @apiSuccess {Number} data.receiveLikeCounts 用户收到的点赞/收藏数量
     * @apiSuccessExample {json} 返回示例：
     *  {
     *   "code":200,
     *   "msg":"登录成功",
     *   "data":{
     *       "phone":"157xxxxxxxx",
     *       "username":"test",
     *       "password":"xxx",
     *       "faceImage":"123456",
     *       "nickname":"1234",
     *       "fansCounts":1000,
     *       "followCounts":1000,
     *       "receiveLikeCounts":1000
     *       }
     *   }
     */
    @PostMapping("/login")
    public JsonResult<Object> login(@RequestBody UserInfoLogin userInfoLogin) throws Exception {
        if(StringUtils.isBlank(userInfoLogin.getUsername())||StringUtils.isBlank(userInfoLogin.getPassword())){
            return new JsonResult<>(Constant.FAILED_CODE,"用户名或密码不能为空");
        }
        UserInfoDto userInfoDto = userInfoService.login(userInfoLogin);
        if(userInfoDto==null){
            return new JsonResult<>(Constant.FAILED_CODE,"此用户不存在，请重新登录");
        }else {
            return new JsonResult<>(Constant.SUCCESS_CODE,Constant.LOGIN_SUCCESS,userInfoDto);
        }
    }

    /**
     * 微信小程序授权登录
     * */
    @PostMapping("/mpLogin")
    public JsonResult<Object> mpLogin(String code) throws Exception{
        if(StringUtils.isNotEmpty(code)){
            /**
             * 请求地址
             * */
            String url="https://api.weixin.qq.com/sns/jscode2session?appid="+Constant.MP_APPID
                    +"&secret="+Constant.MP_SECRET
                    +"&js_code="+code
                    +"&grant_type=authorization_code";
            JSONObject jsonObject = HttpUtil.doGetJson(url);
            String openid = jsonObject.getString("openid");
            String session_key = jsonObject.getString("session_key");
            System.out.println("openId:"+openid);
            System.out.println("session_key:"+session_key);
        }

        return new  JsonResult<>(Constant.SUCCESS_CODE,Constant.LOGIN_SUCCESS);
    }

}
