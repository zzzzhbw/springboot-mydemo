package com.zhoubw.jpa;

import com.zhoubw.pojo.SportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository  extends JpaRepository<SportEntity, Integer> {
}
