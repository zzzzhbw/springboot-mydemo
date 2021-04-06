package com.zhoubw.mapper;

import com.zhoubw.Authority.MyGrantedAuthority;
import com.zhoubw.pojo.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserMapper {

    /**
     * 根据账号查询用户。
     *
     * @param username
     * @return
     */
    UserEntity getUserByName(String username);

    /**
     * 根据用户查找权限
     *
     * @param id
     * @return
     */
    List<MyGrantedAuthority> getRoleByUserId(long id);
}
