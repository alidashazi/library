package com.hao.service;

import com.hao.pojo.User;

import java.util.List;

public interface UserService {
    //增加一个用户
    int addUser(User user);
    //根据username删除一个User
    int deleteUserById(String username);
    //更新user
    int updateUser(User user);
    //根据id查询,返回一个Book
    User queryUserById(String usernmae);
    //查询全部Book,返回list集合
    List<User> queryAllUser();
    //查询数据库行数
    int queryAllRows();

    //查询密码
    String selectPassword(String username);
}
