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
     * 通过区域Id获取区域信息
     *
     * @return
     */
    @RequestMapping(value = "/getuserbyemail", method = RequestMethod.GET)
    private Map<String, Object> getUserByEmail(String message , HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取区域信息
        User user = userService.getUserByEmail(message);
        System.out.println(message);
        modelMap.put("message", user);
        return modelMap;
    }
}
