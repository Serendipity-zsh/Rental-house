package com.example.zwf.web;


import com.example.zwf.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserLoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public Map<String,Object> login (String email, String password,
                                      HttpServletResponse response)
            throws JsonParseException, JsonMappingException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");

        String identity=userService.login(email, password);
        System.out.println("登陆");
        System.out.println("email: " + email);
        System.out.println("password: " + password);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //System.out.println(identity);
        modelMap.put("identity", identity);
        return modelMap;
    }

}
