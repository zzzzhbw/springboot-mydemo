package com.zhoubw.jpa;

import com.zhoubw.pojo.SportEntity;
import com.zhoubw.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
