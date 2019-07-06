package com.example.zwf.web;

import com.example.zwf.entity.User;
import com.example.zwf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserControllor {
    @Autowired
    UserService userService;
    /**
     * 通过email获取用户信息
     *
     * @return
     */
    @RequestMapping(value = "/getuserbyemail", method = RequestMethod.GET)
    private Map<String, Object> getUserByEmail(String message , HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        User user = userService.getUserByEmail(message);
        System.out.println(message);
        modelMap.put("message", user);
        return modelMap;
    }

    /**
     *修改用户信息
     */
    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    private Map<String,Object> modifyUser(String email, String password,String ensure,String name,String number, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<>();
        boolean judge = userService.modifyUser(email,password, ensure, name, number);
        System.out.println("修改用户信息");

        System.out.println("email: "+email);
        System.out.println("password: " + password);
        System.out.println("ensure: " + ensure);
        System.out.println("name: " + name);
        System.out.println("number: " + number);
        modelMap.put("success", judge);
        return modelMap;
    }

}
