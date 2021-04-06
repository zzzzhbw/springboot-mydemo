package com.zhoubw.service;

import com.zhoubw.aop.AopAnnotation;
import com.zhoubw.dao.MyDao;
import com.zhoubw.pojo.StudentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MyService {

    @Autowired
    MyDao dao;

    @AopAnnotation
    public void test(){
      log.info("进入service");
    }

    public StudentEntity getStudent(int id){
        StudentEntity student=dao.getStudent(id);
        return student;
    }

}
