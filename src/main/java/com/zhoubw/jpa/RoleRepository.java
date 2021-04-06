package com.zhoubw.jpa;

import com.zhoubw.pojo.Role;
import com.zhoubw.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
