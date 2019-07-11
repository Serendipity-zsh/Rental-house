package com.example.zwf.web;



import com.example.zwf.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    /**
     * 用户注册
     * @param email
     * @param password
     * @param ensure
     * @param name
     * @param number
     * @param identity
     * @param response
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value= "/register", method = RequestMethod.POST)
    public Map<String, Object> register(String email,String password,String ensure,String name,String number,String identity, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println(identity+"注册");
        System.out.println("邮箱："+email+"       密码"+password);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",userService.addUser(email,password,ensure,name,number,identity));
        return modelMap;
    }
}
