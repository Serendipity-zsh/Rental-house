package com.example.zwf.web;

import com.example.zwf.entity.User;
import com.example.zwf.service.UserService;
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
public class UserControllor {
    @Autowired
    UserService userService;

    /**
     * 通过email获取用户信息
     *
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
     * @param ID
     * @param response
     * @return
     */
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
     * @param file
     * @param response
     * @return
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "/uploadHead",method = RequestMethod.POST)
    public Map<String, Object> uploadHead(
            @RequestParam("file") MultipartFile file, String string,HttpServletResponse response) throws JsonMappingException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println(file.getOriginalFilename());
        System.out.println(string);
        Map<String, Object> modelMap = new HashMap<>();
        boolean judge = false;
        if (file.isEmpty()) {
            System.out.println("文件为空");
            modelMap.put("message", "文件为空");
            judge = false;
            modelMap.put("success", judge);
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
            judge = false;
            modelMap.put("success", judge);
            return modelMap;
        }

        judge = true;
        modelMap.put("message", "http://a4ea60e7.ngrok.io/avatar/"
                + file.getOriginalFilename());
        modelMap.put("success", judge);
        System.out.println(modelMap);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Date date = new Date();
        System.out.println("上传时间：" + simpleDateFormat.format(date));
        System.out.println("上传成功");
        return modelMap;
    }



    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map<String, String> upload(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file");

        String rootDir = request.getRealPath("/");
        String relatDir = File.separator+"resources"+File.separator+"bussiness"
                +File.separator+"uploadPath"+File.separator+"houseKeeping_imgs";

        //文件夹不存在则创建
        File fdir = new File(rootDir+relatDir);
        if (!fdir.exists()) { fdir.mkdirs(); }

        String oriName = file.getOriginalFilename();
        String newName = System.currentTimeMillis()+"_"+oriName;
        File tempFile = new File(fdir.getPath()+File.separator+newName);
        file.transferTo(tempFile);
        Map<String, String> result = new HashMap<>();
        result.put("oriName", oriName);
        result.put("realName", tempFile.getName());
        result.put("relatPath", relatDir+File.separator+newName);
        return result;
    }

}
