package com.hao.pojo;

public class User {
    private String username;
    private String password;
    private String usernumber;
    private int day;
    private int overday;

    public User(String username, String password, String usernumber, int day, int overday) {
        this.username = username;
        this.password = password;
        this.usernumber = usernumber;
        this.day = day;
        this.overday = overday;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getUsernumber() {
        return usernumber;
    }
    public int getDay() {
        return day;
    }
    public int getOverday() {
        return overday;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setOverday(int overday) {
        this.overday = overday;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usernumber='" + usernumber + '\'' +
                ", day=" + day +
                ", overday=" + overday +
                '}';
    }
}
