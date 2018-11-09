package cn.shangpin.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 业务层
 * */
public class UserInfoDto {

    private String phone;
    @NotNull(message = "用户名不能为空")
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空")
    private String password;
    private String faceImage;
    private String nickname;
    private Integer fansCounts;
    private Integer followCounts;
    private Integer receiveLikeCounts;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public String getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getFansCounts() {
        return fansCounts;
    }

    public void setFansCounts(Integer fansCounts) {
        this.fansCounts = fansCounts;
    }

    public Integer getFollowCounts() {
        return followCounts;
    }

    public void setFollowCounts(Integer followCounts) {
        this.followCounts = followCounts;
    }

    public Integer getReceiveLikeCounts() {
        return receiveLikeCounts;
    }

    public void setReceiveLikeCounts(Integer receiveLikeCounts) {
        this.receiveLikeCounts = receiveLikeCounts;
    }

    @Override
    public String toString() {
        return "UserInfoDto{" +
                "phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", faceImage='" + faceImage + '\'' +
                ", nickname='" + nickname + '\'' +
                ", fansCounts=" + fansCounts +
                ", followCounts=" + followCounts +
                ", receiveLikeCounts=" + receiveLikeCounts +
                '}';
    }
}
