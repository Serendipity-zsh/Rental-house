package com.example.zwf.web;

import com.example.zwf.util.StaticConstant;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class FileController {
    /**
     * 显示用户头像
     * @param name
     * @param response
     */
    @RequestMapping("avatar/{name:.+}")
    public void getAvatar(@PathVariable("name") String name,
                          HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println("显示头像");
        System.out.println("name: " + name);
        String imType = name.substring(name.lastIndexOf('.') + 1);
        System.out.println("imType:" + imType);
        response.setContentType("image/" + imType);
        try {
            FileInputStream fromServer = new FileInputStream(
                    new File(StaticConstant.AVATAR_PATH + name));
            OutputStream toClient = response.getOutputStream();
            byte[] avatar = new byte[fromServer.available()];
            fromServer.read(avatar);
            toClient.write(avatar);
            System.out.println("图片读取成功");
            toClient.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示出租屋图片
     * @param name
     * @param response
     */
    @RequestMapping("rentalHouseImage/{name:.+}")
    public void getRentalHouse(@PathVariable("name") String name,
                          HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println("显示出租屋图片");
        System.out.println("name: " + name);
        String imType = name.substring(name.lastIndexOf('.') + 1);
        System.out.println("imType:" + imType);
        response.setContentType("image/" + imType);
        try {
            FileInputStream fromServer = new FileInputStream(
                    new File(StaticConstant.HOUSE_PATH + name));
            OutputStream toClient = response.getOutputStream();
            byte[] avatar = new byte[fromServer.available()];
            fromServer.read(avatar);
            toClient.write(avatar);
            System.out.println("图片读取成功");
            toClient.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
