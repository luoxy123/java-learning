package com.lxy.demo.user.mapper;

import com.lxy.demo.user.UserEntity;

import java.util.List;

    public interface UserDao {
        List<UserEntity> getAll();

        UserEntity getOne(long id);

        void insert(UserEntity user);

        void update(UserEntity user);

        void delete(long id);
    }


