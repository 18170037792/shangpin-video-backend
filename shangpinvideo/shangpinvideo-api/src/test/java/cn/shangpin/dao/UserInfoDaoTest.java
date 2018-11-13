package cn.shangpin.dao;

import cn.shangpin.pojo.UserInfoTable;
import cn.shangpin.query.UserInfoLogin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserInfoDaoTest {

    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void findByUsernname(){
        int result = userInfoDao.findByUsernname("瞿杰");
        if(result<1){
            System.out.println("用户不存在");
        }else {
            System.out.println("查询出:"+result+"条用户数据");
        }
    }

    @Test
    public void insertUser(){
        UserInfoTable userInfoTable=new UserInfoTable();
        userInfoTable.setUsername("阿呆");
        userInfoTable.setPassword("123123");
        userInfoTable.setPhone("15172294874");
        userInfoTable.setFaceImage("./123.jpg");
        userInfoTable.setFansCounts(0);
        userInfoTable.setReceiveLikeCounts(0);
        userInfoTable.setFollowCounts(0);
        int insert = userInfoDao.insert(userInfoTable);
        if(insert<1){
            System.out.println("注册用户失败");
        }else {
            System.out.println("注册用户成功");
        }
    }

    /**
     * 用户登录
     * */
    @Test
    public void login(){
        UserInfoLogin userInfoLogin =new UserInfoLogin();
        userInfoLogin.setUsername("瞿杰");
        userInfoLogin.setPassword("123123");
        UserInfoTable userInfo = userInfoDao.login(userInfoLogin);
        if(userInfo==null){
            System.out.println("用户不存在");
        }else {
            System.out.println("用户信息:"+userInfo);
        }
    }
}
