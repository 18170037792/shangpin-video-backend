package cn.shangpin.service;

import cn.shangpin.dto.UserInfoDto;
import cn.shangpin.dto.UserPersonalDto;
import cn.shangpin.query.UserInfoLogin;
import cn.shangpin.utils.JsonResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void userNameIsExist() throws Exception{
        boolean flag = userInfoService.userNameIsExist("瞿杰");
        System.out.println(flag);
    }

    @Test
    public void getUserPersonalInfo() throws Exception{
        UserPersonalDto info = userInfoService.getUserPersonalInfo(1006L);
        System.out.println(info);
    }

    @Test
    public void updateUserInfo() throws Exception{
        UserInfoDto infoDto=new UserInfoDto();
        infoDto.setId(1002L);
        infoDto.setPassword("123456");
        userInfoService.updateUserInfo(infoDto);
    }
}
