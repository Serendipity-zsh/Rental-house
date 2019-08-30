package com.example.zwf.dao;

import com.example.zwf.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
//    /**
//     * 列出用户列表
//     *
//     * @return userList
//     */
//    List<User> queryUser();

    /**
     * 根据email列出具体用户
     *
     * @return user
     */
    User queryUserByEmail(String email);

    /**
     * 插入用户信息
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 上传/更新用户头像
     * @param user
     * @return
     */
    int updateUserAvatar(User user);



    /**
     * 根据email和pasword找到用户
     * @return Student
     */
    String selectUser(String email,String password);


}
