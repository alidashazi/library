package com.hao.service;

import com.hao.dao.AdminMapper;
import com.hao.pojo.Admin;

public class AdminServiceImpl implements AdminService{

    private AdminMapper adminMapper;
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public String selectPassword(String adminname) {
        return adminMapper.selectPassword(adminname);
    }

    @Override
    public int updatePassword(Admin admin) {
        return adminMapper.updatePassword(admin);
    }

    @Override
    public Admin selectByAdminname(String adminname) {
        return adminMapper.selectByAdminname(adminname);
    }
}
