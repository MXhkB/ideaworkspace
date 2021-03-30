package com.kingdee.dianxin.user;

public class User {
    //成员id
    private String userid;
    //成员名称
    private String name;
    //成员所属部门id
    private Integer department;
    //手机号码
    private String mobile;
    //邮箱
    private String email;
    //职务信息
    private String position;
    //性别
    private String gender;

    public User(){};
    public User(String userid, String name, Integer department, String mobile,
            String email, String position, String gender) {
        super();
        this.userid = userid;
        this.name = name;
        this.department = department;
        this.mobile = mobile;
        this.email = email;
        this.position = position;
        this.gender = gender;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartment() {
        return department;
    }
    public void setDepartment(Integer department) {
        this.department = department;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "User [userid=" + userid + ", name=" + name + ", department="
                + department + ", mobile=" + mobile + ", email=" + email
                + ", position=" + position + ", gender=" + gender + "]";
    }

    public String toJson(){
         String str="{\"userid\": %s,\"name\": %s,\"department\": [1],\"mobile\": %s,\"email\": %s,\"gender\": %s}";

        return String.format(str,this.userid,this.name,this.mobile,this.email,this.gender);
    }


}