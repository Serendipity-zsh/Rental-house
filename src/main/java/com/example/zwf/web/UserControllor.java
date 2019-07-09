package com.example.zwf.web;

import com.example.zwf.entity.User;
import com.example.zwf.service.UserService;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
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
    @RequestMapping(value = "/getUserByEmail", method = RequestMethod.GET)
    private Map<String, Object> getUserByEmail(String message , HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        User user = userService.getUserByEmail(message);
        System.out.println(message);
        modelMap.put("message", user);
        return modelMap;
    }

    @RequestMapping(value = "/updateByEmail", method = RequestMethod.POST)
    public boolean updateByEmail(String email,String password,String name,
                                 String number,String nickname,String hobby,
                                 String wechat,String type,String ID, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        System.out.println("通过email更改用户信息");
        System.out.println("email: " + email);
        System.out.println("name: " + name);
        System.out.println("number: " + number);
        System.out.println("nickname: " + nickname);
        System.out.println("hobby: " + hobby);
        System.out.println("wechat: " + wechat);
        System.out.println("type: " + type);
        System.out.println("ID: " + ID);
        boolean flag = userService.modifyUser(email,password,name,number,nickname,hobby,wechat,type,ID);
        return flag;
    }
    /**
     * 上传出租屋的文件
     */
    @RequestMapping(value = "/uploadHead",method = RequestMethod.PUT)
    public Map<String, Object> uploadHead(
            @RequestParam("file") MultipartFile file, HttpServletResponse response) throws JsonMappingException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<>();
        if (file.isEmpty()) {
            System.out.println("文件为空");
            modelMap.put("message", "文件为空");
            return modelMap;
        }
        String path = "F:/z-w-f-demo/Rental-house/src/main/resources/static/User/";
        File serverFile = new File(path + file.getOriginalFilename());
        File dir = new File(path);
        System.out.println("开始上传");
        if (!dir.exists()) {
            dir.mkdir();
        }
//        if (serverFile.exists()) {
//            System.out.println("图片已经存在");
//            modelMap.put("message", "图片已经存在");
//            return modelMap;
//        }
        try {
            file.transferTo(serverFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传失败");
            modelMap.put("message", "上传失败");
            return modelMap;
        }
        System.out.println("localhost:8082/F:/z-w-f-demo/Rental-house/src/main/resources/static/User/"
                + file.getOriginalFilename());

        System.out.println("上传成功");
        modelMap.put("message", "F:/z-w-f-demo/Rental-house/src/main/resources/static/User/"
                + file.getOriginalFilename());
        return modelMap;
    }

}
