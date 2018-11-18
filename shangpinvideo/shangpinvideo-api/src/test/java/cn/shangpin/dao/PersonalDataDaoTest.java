package cn.shangpin.dao;

import cn.shangpin.pojo.PersonalDataTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PersonalDataDaoTest {

    @Autowired
    private PersonalDataDao personalDataDao;

    @Test
    public void insert(){
        PersonalDataTable table=new PersonalDataTable();
        table.setUserId(1L);
        table.setEmail("11111@qq.com");
        table.setGender(0);
        table.setPlace("杭州");
        table.setSchool("北京电影学院");
        table.setSignature("白茶清欢无别事，我在等风也等你");
        table.setCreateTime(new Date());
        int result = personalDataDao.insert(table);
        if(result==0){
            System.out.println("新增失败");
        }else {
            System.out.println("新增成功");
        }
    }
}
