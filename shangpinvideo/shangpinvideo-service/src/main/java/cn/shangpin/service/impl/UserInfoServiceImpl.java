package cn.shangpin.service.impl;

import cn.shangpin.dao.UserInfoDao;
import cn.shangpin.dto.UserInfoDto;
import cn.shangpin.dto.UserPersonalDto;
import cn.shangpin.exception.ServiceException;
import cn.shangpin.pojo.UserInfoTable;
import cn.shangpin.query.UserInfoLogin;
import cn.shangpin.service.UserInfoService;
import cn.shangpin.utils.Constant;
import cn.shangpin.utils.GetMD5;
import cn.shangpin.utils.ValidateUtil;
import cn.shangpin.view.UserPersonalView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

/**
 * Created by qujie on 2018/11/7
 * 用户模块业务层接口
 * */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean userNameIsExist(String username) {
        int result = userInfoDao.findByUsernname(username);
        return result >= 1 ? true : false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser(UserInfoDto userInfoDto) {
        if(!ValidateUtil.isNull(userInfoDto.getPassword())){
            userInfoDto.setPassword(GetMD5.getMD5(userInfoDto.getPassword()));
        }
        UserInfoTable userInfoTable=new UserInfoTable();
        BeanUtils.copyProperties(userInfoDto,userInfoTable);
        userInfoDao.insert(userInfoTable);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserInfo(UserInfoDto userInfoDto) throws Exception {
        if(!ValidateUtil.isNull(userInfoDto.getPassword())){
            userInfoDto.setPassword(GetMD5.getMD5(userInfoDto.getPassword()));
        }
        UserInfoTable userInfoTable=new UserInfoTable();
        BeanUtils.copyProperties(userInfoDto,userInfoTable);
        userInfoDao.updateUserInfo(userInfoTable);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoDto login(UserInfoLogin userInfoLogin) throws Exception {
        UserInfoTable infoTable = userInfoDao.login(userInfoLogin);
        if(infoTable==null){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
        UserInfoDto userInfoDto=new UserInfoDto();
        BeanUtils.copyProperties(infoTable,userInfoDto);
        userInfoDto.setPassword("");
        return userInfoDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserPersonalDto getUserPersonalInfo(Long userId) throws Exception {
        UserPersonalDto dto=new UserPersonalDto();
        UserPersonalView view = userInfoDao.getUserPersonalInfo(userId);
        BeanUtils.copyProperties(view,dto);
        if(dto==null){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
        return dto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean judgeByOpenId(String openId) throws Exception {
        int count = userInfoDao.openIdIsExist(openId);
        if(count == 0){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoDto weChatLogin(String openId) throws Exception {
        UserInfoDto dto = new UserInfoDto();
        UserInfoTable table = userInfoDao.weChatLogin(openId);
        BeanUtils.copyProperties(table,dto);
        return dto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoDto getEntity(String key, Class classz) throws Exception {
        String redisStr = this.getString(key);
        return JSON.parseObject(redisStr, (Type) classz);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String getString(String key) throws Exception {
        String redisStr = (String) redisTemplate.opsForValue().get(key);
        return redisStr == null ? "" : redisStr;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(String key, UserInfoDto dto, long time) throws Exception {
        String objectStr = JSON.toJSONString(dto, new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
        if(time < 0L){
            redisTemplate.opsForValue().set(key, objectStr);
        }else {
            redisTemplate.opsForValue().set(key, objectStr, time, TimeUnit.SECONDS);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String key) throws Exception {
        redisTemplate.delete(key);
    }

}
