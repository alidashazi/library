package com.hao.service;

import com.hao.pojo.Admin;

public interface AdminService {
    //查询管理员密码
    String selectPassword(String adminname);
    //修改密码
    int updatePassword(Admin admin);
    //查看个人信息
    Admin selectByAdminname(String adminname);
}
