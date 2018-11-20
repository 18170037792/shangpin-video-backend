package cn.shangpin.dao;

import cn.shangpin.pojo.SignatureHistoryTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qujie on 2018/11/20
 * */
public interface SignatureHistoryDao {

    /**
     * 根据用户id获取个签历史列表
     * */
    public List<SignatureHistoryTable> getSignatureList(Long userId);

    /**
     * 根据个签id批量删除个性签名
     * */
    public int deleteHistory(@Param("ids") List<Long> ids);
}
