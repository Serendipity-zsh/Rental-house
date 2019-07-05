package com.example.zwf.service;

import com.example.zwf.entity.User;

public interface UserService {
//    /**
//     * 获取用户列表
//     * @return
//     */
//    List<User> getUserList();

    /**
     * 通过email获取用户信息
     *
     * @param email
     * @return
     */
    User getUserByEmail(String email);

    /**
     * 增加用户信息
     *
     * @param user
     * @return
     */
    boolean addUser(User user);


    /**
     * 增加用户信息
     *
     * @param
     * @return
     */
    boolean addUser1(String email,String password,String ensure,String name,String number,boolean identity);

    /**
     *用户登录
     */
    boolean login(String email,String password);
}
