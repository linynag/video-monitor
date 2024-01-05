package com.yiwei.web.domain;

import com.alibaba.fastjson2.annotation.JSONField;
import com.yiwei.web.entity.SysUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现UserDetails接口之后，要重写UserDetails接口里面的7个方法
 */
@Data // get和set方法
@NoArgsConstructor // 无参构造
public class LoginUser implements UserDetails {

    private SysUser user;

    // 查询用户权限信息
    private List<String> permissions;

    // 不让authorities成员变量序列化存入redis，避免redis不支持而报异常
    @JSONField(serialize = false)
    private List<SimpleGrantedAuthority> authorities;

    public LoginUser(SysUser user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    /**
     * 重写GrantedAuthority接口的getAuthorities方法
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 当authorities集合为空，就说明是第一次，就需要转换，当不为空就说明不是第一次，就不需要转换直接返回
        if (authorities != null) { // 严谨来说这个if判断是避免整个调用链中security本地线程变量在获取用户时的重复解析，和redis存取无关
            return authorities;
        }
        authorities = permissions
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        // 最终返回转换结果
        return authorities;
    }


    @Override
    // 用于获取用户密码。由于使用的实体类是User，所以获取的是数据库的用户密码
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    // 用于获取用户名。由于使用的实体类是User，所以获取的是数据库的用户名
    public String getUsername() {
        // TODO: 2024/1/3 确认账号还是昵称
        return user.getAccount();
    }

    @Override
    // 判断登录状态是否过期。把这个改成true，表示永不过期
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    // 判断账号是否被锁定。把这个改成true，表示未锁定，不然登录的时候，不让你登录
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    // 判断登录凭证是否过期。把这个改成true，表示永不过期
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    // 判断用户是否可用。把这个改成true，表示可用状态
    public boolean isEnabled() {
        return true;
    }
}