package com.hao.service;

import com.hao.dao.BookMapper;
import com.hao.dao.UserMapper;
import com.hao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUserById(String username) {
        return userMapper.deleteUserById(username);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User queryUserById(String username) {
        return userMapper.queryUserById(username);
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public int queryAllRows() {
        return userMapper.queryAllRows();
    }

    @Override
    public String selectPassword(String username) {
        return userMapper.selectPassword(username);
    }
}
