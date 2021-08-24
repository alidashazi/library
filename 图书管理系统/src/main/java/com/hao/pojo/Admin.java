package com.hao.pojo;

public class Admin {
    private String adminname;
    private String adminpassword;
    private String adminnumber;

    public Admin(String adminname, String adminpassword, String adminnumber) {
        this.adminname = adminname;
        this.adminpassword = adminpassword;
        this.adminnumber = adminnumber;
    }

    public String getAdminname() {
        return adminname;
    }
    public String getAdminpassword() {
        return adminpassword;
    }
    public String getAdminnumber() {
        return adminnumber;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }
    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }
    public void setAdminnumber(String adminnumber) {
        this.adminnumber = adminnumber;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminname='" + adminname + '\'' +
                ", adminpassword='" + adminpassword + '\'' +
                ", adminnumber='" + adminnumber + '\'' +
                '}';
    }
}
