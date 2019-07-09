package com.example.zwf.dao;

import com.example.zwf.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    /**
     * 列出用户列表
     *
     * @return userList
     */
    List<User> queryUser();

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
     * 删除用户信息
     *
     * @param email
     * @return
     */
    int deleteUser(String  email);

    /**
     * 根据email和pasword找到用户
     * @return Student
     */
    User selectUser(String email,String password);


}
