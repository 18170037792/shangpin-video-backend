package cn.shangpin.pojo;

import java.util.Date;

/**
 * Created by qujie on 2018/11/18
 * Personal signature history record
 * 个性签名历史实体类
 * */
public class SignatureHistoryTable {

    private Long id;
    /**
     * 用户id
     * */
    private Long userId;
    /**
     * 个性签名内容
     * */
    private String content;
    /**
     * 点赞数
     * */
    private Integer likeCounts;
    /**
     * 创建时间
     * */
    private Date createTime;
}
