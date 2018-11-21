package cn.shangpin.service;

import cn.shangpin.dto.PersonalDataDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.dc.pr.PRError;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PersonalDataServiceTest {

    @Autowired
    private PersonalDataService personalDataService;

    @Test
    public void insert() throws Exception {
        PersonalDataDto personalDataDto = new PersonalDataDto();
        personalDataDto.setEmail("12456235@qq.com");
        personalDataDto.setGender(1);
        personalDataDto.setPlace("江西南昌");
        personalDataDto.setSignature("时光柔软，光阴易逝");
        personalDataDto.setCreateTime(new Date());
        personalDataDto.setUserId(7L);
        personalDataService.insert(personalDataDto);
    }
}
