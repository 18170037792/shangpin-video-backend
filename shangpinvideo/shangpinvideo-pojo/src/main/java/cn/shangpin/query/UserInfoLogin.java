package cn.shangpin.query;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by qujie on 2018/11/9
 * 用户信息查询条件类
 * */
public class UserInfoLogin {

    @NotNull(message = "用户名不能为空")
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空")
    private String password;

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
}
