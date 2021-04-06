package com.zhoubw.dao;


import com.zhoubw.jpa.StudentRepository;
import com.zhoubw.pojo.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyDao{

    @Autowired
    private StudentRepository studentRepository;


    public StudentEntity getStudent(int id){
        return studentRepository.getOne(id);
    }

    public void save(StudentEntity student){
        studentRepository.save(student);
    }

    public void delete(int id){
        studentRepository.deleteById(id);
    }

}
