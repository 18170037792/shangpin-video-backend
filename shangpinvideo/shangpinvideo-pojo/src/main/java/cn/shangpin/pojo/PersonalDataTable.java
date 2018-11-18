package cn.shangpin.pojo;

import java.util.Date;

/**
 * Created by qujie on 2018/11/18
 * Personal data entities
 * 个人资料实体类
 * */
public class PersonalDataTable {

    private Long id;
    /**
     * 用户id
     * */
    private Long userId;
    /**
     * 签名
     * */
    private String signature;
    /**
     * 学校
     * */
    private String school;
    /**
     * 性别
     * */
    private Integer gender;
    /**
     * 生日
     * */
    private Date birthday;
    /**
     * 所在地
     * */
    private String place;
    /**
     * 邮箱
     * */
    private String email;
    /**
     * 创建时间
     * */
    private Date createTime;
    /**
     * 修改时间
     * */
    private Date updateTime;

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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "PersonalDataTable{" +
                "id=" + id +
                ", userId=" + userId +
                ", signature='" + signature + '\'' +
                ", school='" + school + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", place='" + place + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
