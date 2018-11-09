package cn.shangpin.pojo;

import java.util.Date;

/**
 * Created by qujie on 2018/11/8
 * 举报信息实体类
 * */
public class UserReportTable {

    private Long id;
    /**
     * 被举报用户id
     * */
    private Long dealUserId;
    /**
     * 举报人用户id
     * */
    private Long reporterUserId;
    /**
     * 被举报视频id
     * */
    private Long dealVideoId;
    /**
     * 举报标题：如违法色情暴力
     * */
    private String title;
    /**
     * 举报具体内容(用户输入)
     * */
    private String content;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDealUserId() {
        return dealUserId;
    }

    public void setDealUserId(Long dealUserId) {
        this.dealUserId = dealUserId;
    }

    public Long getReporterUserId() {
        return reporterUserId;
    }

    public void setReporterUserId(Long reporterUserId) {
        this.reporterUserId = reporterUserId;
    }

    public Long getDealVideoId() {
        return dealVideoId;
    }

    public void setDealVideoId(Long dealVideoId) {
        this.dealVideoId = dealVideoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
