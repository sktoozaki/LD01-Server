package com.kk.server.service;

/**
 * Created by KK on 2015/12/9.
 */
public class UserServiceImp implements UserService{
    private String DRIVER="com.mysql.jdbc.Driver";
    private String URL="jdbc:mysql://localhost:3306/admin_user";
    private String USER="root";
    private String PASS="root";
    String MODIFY="update user set nickname=?,department=?,signature=?,birthmonth=?,birthday=? where name=?";
    String APPROVAL="update user set approval=1 where name=?";
    String SELECT="select * from user where name=?";
    String INSERT="insert into user(name,password,department,nickname,signature,birthmonth,birthday,status,permission,approval) values(?,?,?,?,?,?,?,?,?,?)";



    @Override
    public void userLogin() {

    }

    @Override
    public void userRegister() {

    }
}
