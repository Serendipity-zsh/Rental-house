package com.example.zwf.service;

import com.example.zwf.entity.User;

public interface UserService {

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
     * @param
     * @return
     */
    boolean addUser(String email,String password,
                     String ensure,String name,String number,
                     String identity);

    /**
     *用户登录
     */
    String login(String email,String password);

    /**
     * 修改用户信息
     * @param email
     * @param password
     * @param name
     * @param number
     * @param nickname
     * @param hobby
     * @param wecaht
     * @param type
     * @param idCard
     * @return
     */

    boolean modifyUser(String email,String password,String name,
                       String number,String nickname,String hobby,
                       String wecaht,String type,String idCard);

    /**
     * 上传/更新用户头像
     * @param avatarUrl
     * @param email
     * @return
     */
    boolean modifyUserAvatar(String email,String avatarUrl);

}
