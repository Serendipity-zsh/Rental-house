package com.example.zwf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/api")
public class FileController {
    @RequestMapping("avatar/{name:.+}")
    public void getAvatar(@PathVariable("name") String name, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println("name: " + name);
        String imType = name.substring(name.lastIndexOf('.') + 1);
        System.out.println("imType:" + imType);
        response.setContentType("image/" + imType);
        try {
            FileInputStream fromServer = new FileInputStream(new File("/data/avatar/" + name));
            OutputStream toClient = response.getOutputStream();
            byte[] avatar = new byte[fromServer.available()];
            fromServer.read(avatar);
            toClient.write(avatar);
            toClient.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
