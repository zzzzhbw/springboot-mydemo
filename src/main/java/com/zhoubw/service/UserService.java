package com.zhoubw.service;

import com.zhoubw.Authority.MyGrantedAuthority;
import com.zhoubw.mapper.UserMapper;
import com.zhoubw.pojo.UserEntity;
import com.zhoubw.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userMapper.getUserByName(username);
        UserVo vo=new UserVo();
        vo.setId(userEntity.getId());
        vo.setUsername(userEntity.getName());
        vo.setPassword(userEntity.getPassword());
        if (userEntity != null) {
            List<MyGrantedAuthority> authorities = userMapper.getRoleByUserId(userEntity.getId());
            vo.setAuthorities(authorities);
        }
        return User.withUserDetails(vo)
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .build();

    }
}