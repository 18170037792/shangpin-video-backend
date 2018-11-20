package cn.shangpin.dao;

import cn.shangpin.pojo.UserInfoTable;
import cn.shangpin.query.UserInfoLogin;
import cn.shangpin.view.UserPersonalView;

import java.util.List;

/**
 * Created by qujie on 2018/11/7
 * */
public interface UserInfoDao {

    public int insert(UserInfoTable userInfoTable);

    public int findByUsernname(String username);

    public UserInfoTable login(UserInfoLogin userInfoLogin);

    public UserPersonalView getUserPersonalInfo(Long userId);
}
