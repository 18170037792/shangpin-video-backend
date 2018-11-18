package cn.shangpin.pojo;

import sun.dc.pr.PRError;

import java.util.Date;

/**
 * Created by qujie on 2018/11/8
 * 视频表实体类
 * */
public class VideosTable {

    private Long id;
    /**
     * 发布者用户id
     * */
    private Long userId;
    /**
     * 背景音乐id
     * */
    private Long bgmId;
    /**
     * 视频内容描述
     * */
    private String videoDesc;
    /**
     * 上传路径
     * */
    private String videoPath;
    /**
     * 视频播放秒数
     * */
    private float videoSeconds;
    /**
     * 视频宽度
     * */
    private Integer videoWidth;
    /**
     * 视频高度
     * */
    private Integer videoHeight;
    /**
     * 视频封面路径
     * */
    private String coverPath;
    /**
     * 点赞数
     * */
    private Long likeCounts;
    /**
     * 视频状态：1，发布成功 2，禁止播放
     * */
    private Integer status;
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

    public Long getBgmId() {
        return bgmId;
    }

    public void setBgmId(Long bgmId) {
        this.bgmId = bgmId;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public float getVideoSeconds() {
        return videoSeconds;
    }

    public void setVideoSeconds(float videoSeconds) {
        this.videoSeconds = videoSeconds;
    }

    public Integer getVideoWidth() {
        return videoWidth;
    }

    public void setVideoWidth(Integer videoWidth) {
        this.videoWidth = videoWidth;
    }

    public Integer getVideoHeight() {
        return videoHeight;
    }

    public void setVideoHeight(Integer videoHeight) {
        this.videoHeight = videoHeight;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public Long getLikeCounts() {
        return likeCounts;
    }

    public void setLikeCounts(Long likeCounts) {
        this.likeCounts = likeCounts;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
