package com.zhoubw.dao;


import com.zhoubw.jpa.UserRepository;
import com.zhoubw.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private UserRepository userRepository;


    public UserEntity getUser(int id){
        return userRepository.getOne(id);
    }


    public void save(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public void delete(int id){
        userRepository.deleteById(id);
    }

}
