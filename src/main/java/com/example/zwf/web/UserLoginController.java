package com.example.zwf.web;


import com.example.zwf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserLoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public Map<String, Object> login (String email, String password){
        boolean login=userService.login(email, password);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",login);
        return modelMap;
    }

}
