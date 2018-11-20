package cn.shangpin.dao;

import cn.shangpin.pojo.PersonalDataTable;
import cn.shangpin.utils.DateFormatUtil;
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
        table.setUserId(6L);
        table.setEmail("16956@qq.com");
        table.setGender(0);
        table.setPlace("四川");
        table.setSchool("四川大学");
        table.setSignature("巴适得很");
        table.setCreateTime(new Date());
        int result = personalDataDao.insert(table);
        if(result==0){
            System.out.println("新增失败");
        }else {
            System.out.println("新增成功");
        }
    }

    @Test
    public void update() throws Exception {
        Date birthdayDate = DateFormatUtil.parseBirthdayDate("1993-03-16");
        PersonalDataTable table=new PersonalDataTable();
        table.setUserId(3L);
        table.setSignature("Quelle belle fille");
        table.setBirthday(birthdayDate);
        table.setUpdateTime(new Date());
        int update = personalDataDao.update(table);
        if(update==0){
            System.out.println("修改失败");
        }else {
            System.out.println("修改成功");
        }
    }
}
