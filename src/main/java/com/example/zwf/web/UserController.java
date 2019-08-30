package com.example.zwf.web;

import com.example.zwf.entity.User;
import com.example.zwf.service.UserService;
import com.example.zwf.util.StaticConstant;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 通过email获取信息
     * @param email
     * @param response
     * @return
     */
    @RequestMapping(value = "/getUserByEmail", method = RequestMethod.GET)
    private Map<String, Object> getUserByEmail(String email, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        User user = userService.getUserByEmail(email);
        System.out.println("获取用户"+email+"的信息");
        modelMap.put("message", user);
        return modelMap;
    }

    /**
     * 通过email更改用户信息
     * @param email
     * @param password
     * @param name
     * @param number
     * @param nickname
     * @param hobby
     * @param wechat
     * @param type
     * @param idCard
     * @param response
     * @return
     */
    @RequestMapping(value = "/updateByEmail", method = RequestMethod.POST)
    public boolean updateByEmail(String email,String password,String name,
                                 String number,String nickname,String hobby,
                                 String wechat,String type,String idCard, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        System.out.println("通过email更改用户信息");
        System.out.println("email: " + email);
        System.out.println("name: " + name);
        System.out.println("number: " + number);
        System.out.println("nickname: " + nickname);
        System.out.println("hobby: " + hobby);
        System.out.println("wechat: " + wechat);
        System.out.println("type: " + type);
        System.out.println("idCard: " + idCard);
        boolean flag = userService.modifyUser(email,password,name,number,
                nickname,hobby,wechat,type,idCard);
        return flag;
    }

    /**
     * 上传用户头像
     * @param file
     * @param response
     * @return
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "/uploadHead",method = RequestMethod.POST)
    public Map<String, Object> uploadHead(
            @RequestParam("file") MultipartFile file, String email,
            HttpServletResponse response) throws JsonMappingException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println("用户："+email+"上传头像："+file.getOriginalFilename());
        Map<String, Object> modelMap = new HashMap<>();
        boolean judge = false;
        if (file.isEmpty()) {
            System.out.println("文件为空");
            modelMap.put("message", "文件为空");
            judge = false;
            modelMap.put("success", judge);
            return modelMap;
        }
        String path = StaticConstant.AVATAR_PATH;
        File serverFile = new File(path + file.getOriginalFilename());
        File dir = new File(path);
        System.out.println("开始上传");
        if (!dir.exists()) {
            dir.mkdir();
        }
        try {
            file.transferTo(serverFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传失败");
            modelMap.put("message", "上传失败");
            judge = false;
            modelMap.put("success", judge);
            return modelMap;
        }

        judge = true;
        String url = StaticConstant.AVATAR_URL;
        modelMap.put("message", url
                + file.getOriginalFilename());
        String avatarUrl = url + file.getOriginalFilename();
        modelMap.put("success", judge);
        System.out.println(modelMap);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Date date = new Date();
        System.out.println("上传时间：" + simpleDateFormat.format(date));
        System.out.println("上传成功");
        userService.modifyUserAvatar(email, avatarUrl);
        return modelMap;
    }


}
