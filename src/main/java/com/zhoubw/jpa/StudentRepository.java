package com.zhoubw.jpa;

import com.zhoubw.pojo.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<StudentEntity, Integer> {
}
