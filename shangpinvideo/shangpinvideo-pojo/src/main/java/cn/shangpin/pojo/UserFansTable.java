package cn.shangpin.pojo;

/**
 * Created by qujie on 2018/11/7
 * 粉丝关系实体类
 * */
public class UserFansTable {

    private Long id;
    /**
     * 被关注者用户id
     * */
    private Long userId;
    /**
     * 关注者用户id
     * */
    private Long fansId;

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

    public Long getFansId() {
        return fansId;
    }

    public void setFansId(Long fansId) {
        this.fansId = fansId;
    }
}
