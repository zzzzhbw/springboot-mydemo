package com.zhoubw.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserVo implements UserDetails {

    private long id;

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * 账号是否失效，返回false账号失效，不可用。
     *
     * @return
     */
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账号是否被锁，返回false，账号被锁，不可用
     * @return
     */
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 账号认证是否过期，返回false，过期，不可用
     * @return
     */
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账号是否可用。返回false不可用
     * @return
     */
    public boolean isEnabled() {
        return true;
    }

    /**
     * 返回用户的权限集合。
     * @return
     */
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
