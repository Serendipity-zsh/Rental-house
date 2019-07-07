package com.example.zwf.service.impl;

import com.example.zwf.dao.UserDao;
import com.example.zwf.entity.User;
import com.example.zwf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userdao;

    @Override
    public User getUserByEmail(String email) {
        return userdao.queryUserByEmail(email);
    }
    @Override
    public boolean login(String email, String password) {
        User user = userdao.selectUser(email,password);
        if (user != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean addUser(String email, String password, String ensure,
                           String name, String number, String identity) {
        User user1 = new User();
        user1.setEmail(email);
        user1.setPassword(password);
        user1.setEnsure(ensure);
        user1.setName(name);
        user1.setNumber(number);
        user1.setIdentity(identity);
        if (email == null || "".equals(email)) {
            System.out.println("邮箱不能为空！");
            throw new RuntimeException("邮箱不能为空！");

        } else if (!password.equals(ensure)) {
            System.out.println("密码不一致！");
            throw new RuntimeException("密码不一致！");
        } else if (userdao.queryUserByEmail(email) != null) {
            System.out.println("该用户已存在");
            throw new RuntimeException("该用户已存在！");
        } else {

            try {
                int effectedNum = userdao.insertUser(user1);
                if (effectedNum > 0) {
                    return true;
                } else {
                    System.out.println("添加用户信息失败!");
                    throw new RuntimeException("添加用户信息失败!");
                }
            } catch (Exception e) {
                System.out.println("添加用户信息失败!");
                throw new RuntimeException("添加用户信息失败:" + e.toString());
            }
        }
    }
//    @Transactional
//    @Override
//    public boolean addUser(User user) {
//        if(user.getEmail()!=null&&!"".equals(user.getEmail())&&user.getPassword()==user.getEnsure()&&userdao.queryUserByEmail(user.getEmail())==null){
//            System.out.println("注册失败！");
//            throw new RuntimeException("注册失败！");
//
//        }else {
//
//            try {
//                int effectedNum = userdao.insertUser(user);
//                if (effectedNum > 0) {
//                    return true;
//                } else {
//                    System.out.println("添加用户信息失败!");
//                    throw new RuntimeException("添加用户信息失败!");
//                }
//            }catch (Exception e) {
//                System.out.println("添加用户信息失败!");
//                throw new RuntimeException("添加用户信息失败:" + e.toString());
//            }
//        }
//
//    }
    @Override
    public boolean modifyUser(String email,String password, String ensure,String name,String number) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setEnsure(ensure);
        user.setName(name);
        user.setNumber(number);
        if(!password.equals(ensure)){
            System.out.println("输入密码不一致！");
            throw new RuntimeException("输入密码不一致！");
        }
        else  {

            try {
                int effectedNum = userdao.updateUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    System.out.println("修改用户信息失败!");
                    throw new RuntimeException("修改用户信息失败!");
                }
            } catch (Exception e) {
                System.out.println("修改用户信息失败!");
                throw new RuntimeException("修改用户信息失败:" + e.toString());
            }
        }
    }
}
