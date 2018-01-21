package com.lxy.demo.user.mapper;

import com.lxy.demo.user.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

    public interface UserDao {
        List<UserEntity> getAll();

        UserEntity getOne(long id);

        UserEntity getUser(@Param("username") String username,@Param("password") String password);

        void insert(UserEntity user);

        void update(UserEntity user);

        void delete(long id);
    }


