package cn.shangpin.service;

import cn.shangpin.dto.UserInfoDto;
import cn.shangpin.dto.UserPersonalDto;
import cn.shangpin.query.UserInfoLogin;
import cn.shangpin.utils.JsonResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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

    @Test
    public void judgeByOpenId() throws Exception {
        Boolean judge = userInfoService.judgeByOpenId("owezi5JO-0Xo8wC8V2NpQ61f1mHg");
        System.out.println(judge);
    }

    @Test
    public void weChatLogin() throws Exception{
        UserInfoDto dto = userInfoService.weChatLogin("owezi5JO-0Xo8wC8V2NpQ61f1mHg");
        System.out.println(dto);
    }

    @Test
    public void getString() throws Exception{
        String redisStr = userInfoService.getString("user");
        System.out.println(redisStr);
    }

    @Test
    public void getEntity() throws Exception{
        UserInfoDto entity = userInfoService.getEntity("user1", UserInfoDto.class);
        System.out.println(entity);
    }

    @Test
    public void save() throws Exception{
        UserInfoDto dto = new UserInfoDto();
        dto.setPrefix("user");
        dto.setId(2L);
        dto.setUsername("登录");
        dto.setFaceImage("./1.jpg");
        dto.setFollowCounts(2);
        userInfoService.save(dto.getPrefix() + dto.getId(),dto,1000L);
    }

    @Test
    public void remove() throws Exception{
        userInfoService.remove("user");
    }
}
