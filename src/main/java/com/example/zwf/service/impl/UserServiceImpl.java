package com.example.zwf.service.impl;

import com.example.zwf.dao.UserDao;
import com.example.zwf.entity.User;
import com.example.zwf.service.UserService;
import com.sun.xml.internal.bind.v2.model.core.ID;
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

    /**
     * 登陆
     * @param email
     * @param password
     * @return
     */
    @Override
    public String login(String email, String password) {
        String identity = userdao.selectUser(email,password);
        if (!userdao.queryUserByEmail(email).getPassword().equals(password)) {
            System.out.println("密码错误");
            return "密码错误";
        }else {
            if (identity != null){
                if (identity.equals("tenant")) {
                    System.out.println("房客登陆");
                    return identity;
                } else if (identity.equals("landlord")) {
                    System.out.println("房东登陆");
                    return identity;
                }
                return identity;
            }else {
                System.out.println("用户未知");
                return null;
            }
        }
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
    @Transactional
    @Override
    public boolean modifyUser(String email,String password,String name,
                              String number,String nickname,String hobby,
                              String wechat,String type,String ID){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setEnsure(password);
        user.setName(name);
        user.setNumber(number);
        user.setNickname(nickname);
        user.setHobby(hobby);
        user.setWechat(wechat);
        user.setType(type);
        user.setID(ID);

        if (email!= null && !"".equals(email))

        {
            try {
                int effectedNum = userdao.updateUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    System.out.println("更新用户失败");
                    throw new RuntimeException("更新用户失败!");
                }
            } catch (Exception e) {
                System.out.println("更新用户信息失败");
                throw new RuntimeException("更新用户信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("email为空！请填写email");
        }
    }
}
