package cn.shangpin.dao;

import cn.shangpin.pojo.SignatureHistoryTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SignatureHistoryDaoTest {

    @Autowired
    private SignatureHistoryDao signatureHistoryDao;

    @Test
    public void getSignatureList(){
        List<SignatureHistoryTable> signatureList = signatureHistoryDao.getSignatureList(3L);
        System.out.println(signatureList);
    }

    @Test
    public void deleteHistory(){
        List<Long> ids=new ArrayList<>();
        ids.add(2L);
        ids.add(3L);
        int result = signatureHistoryDao.deleteHistory(ids);
        if(result<1){
            System.out.println("删除失败");
        }else {
            System.out.println("删除成功");
        }
    }
}
