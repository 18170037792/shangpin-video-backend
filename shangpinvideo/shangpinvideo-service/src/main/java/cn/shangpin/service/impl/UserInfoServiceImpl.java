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
import cn.shangpin.utils.JsonResult;
import cn.shangpin.view.UserPersonalView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * Created by qujie on 2018/11/7
 * 用户模块业务层接口
 * */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean userNameIsExist(String username) {
        int result = userInfoDao.findByUsernname(username);
        return result >= 1 ? true : false;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveUser(UserInfoDto userInfoDto) {
        userInfoDto.setPassword(GetMD5.getMD5(userInfoDto.getPassword()));
        UserInfoTable userInfoTable=new UserInfoTable();
        BeanUtils.copyProperties(userInfoDto,userInfoTable);
        userInfoDao.insert(userInfoTable);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserInfo(UserInfoDto userInfoDto) throws Exception {
        userInfoDto.setPassword(GetMD5.getMD5(userInfoDto.getPassword()));
        UserInfoTable userInfoTable=new UserInfoTable();
        BeanUtils.copyProperties(userInfoDto,userInfoTable);
        userInfoDao.updateUserInfo(userInfoTable);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public JsonResult<UserInfoDto> login(UserInfoLogin userInfoLogin) throws Exception {
        UserInfoTable infoTable = userInfoDao.login(userInfoLogin);
        if(infoTable==null){
            return new JsonResult<UserInfoDto>(Constant.FAILED_CODE,Constant.LOGIN_ERROR);
        }
        UserInfoDto userInfoDto=new UserInfoDto();
        BeanUtils.copyProperties(infoTable,userInfoDto);
        userInfoDto.setPassword("");
        return new JsonResult<UserInfoDto>(Constant.SUCCESS_CODE,Constant.LOGIN_SUCCESS,userInfoDto);
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public UserPersonalDto getUserPersonalInfo(Long userId) throws Exception {
        UserPersonalDto dto=new UserPersonalDto();
        UserPersonalView view = userInfoDao.getUserPersonalInfo(userId);
        BeanUtils.copyProperties(view,dto);
        if(dto==null){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
        return dto;
    }
}
