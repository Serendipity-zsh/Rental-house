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
    public boolean addUser1(String email,String password,String ensure,String userName,String pnumber){
        User user1 = new User();
        user1.setEmail(email);
        user1.setPassword(password);
        user1.setEnsure(ensure);
        user1.setUserName(userName);
        user1.setPnumber(pnumber);
        if(email==null||"".equals(email)) {
            throw new RuntimeException("邮箱不能为空！");

        } else if(!password.equals(ensure)){
            throw new RuntimeException("密码不一致！");
        } else if(userdao.queryUserByEmail(email)!=null){
            throw new RuntimeException("该用户已存在！");
        }
        else  {

            try {
                int effectedNum = userdao.insertUser(user1);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加用户信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加用户信息失败:" + e.toString());
            }
                }
    }
    @Transactional
    @Override
    public boolean addUser(User user) {
        if(user.getEmail()!=null&&!"".equals(user.getEmail())&&user.getPassword()==user.getEnsure()&&userdao.queryUserByEmail(user.getEmail())==null){
            throw new RuntimeException("注册失败！");

        }else {

            try {
                int effectedNum = userdao.insertUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加用户信息失败!");
                }
            }catch (Exception e) {
                throw new RuntimeException("添加用户信息失败:" + e.toString());
            }
        }

    }
}
