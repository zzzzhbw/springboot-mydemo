package com.zhoubw.jpa;

import com.zhoubw.pojo.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
