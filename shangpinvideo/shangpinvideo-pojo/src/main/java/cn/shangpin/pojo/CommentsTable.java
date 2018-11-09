package cn.shangpin.pojo;

import java.util.Date;

/**
 * Created by qujie on 2018/11/7
 * 留言评论实体类
 * */
public class CommentsTable {

    private Long id;
    /**
     * 视频id
     * */
    private Long videoId;
    /**
     * 评论人用户id
     * */
    private Long fromUserId;
    /**
     * 留言内容
     * */
    private String content;
    /**
     * 留言时间
     * */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
