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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikeCounts() {
        return likeCounts;
    }

    public void setLikeCounts(Integer likeCounts) {
        this.likeCounts = likeCounts;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SignatureHistoryTable{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", likeCounts=" + likeCounts +
                ", createTime=" + createTime +
                '}';
    }
}
