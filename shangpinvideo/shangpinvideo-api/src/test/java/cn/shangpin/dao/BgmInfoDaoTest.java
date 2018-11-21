package cn.shangpin.dao;

import cn.shangpin.pojo.BgmInfoTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BgmInfoDaoTest {

    @Autowired
    private BgmInfoDao bgmInfoDao;

    @Test
    public void getBgmList(){
        List<BgmInfoTable> bgmList = bgmInfoDao.getBgmList();
        System.out.println(bgmList);
    }

    @Test
    public void getCount(){
        int count = bgmInfoDao.getCount();
        if(count==0){
            System.out.println("没有数据");
        }else {
            System.out.println("有:"+count+"条数据");
        }
    }
}
