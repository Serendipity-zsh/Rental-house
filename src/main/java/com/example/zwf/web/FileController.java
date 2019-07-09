package com.example.zwf.web;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileController {
    @RequestMapping("avatar/{name:.+}")
    public void getAvatar(@PathVariable("name") String name,
                          HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println("name: " + name);
        String imType = name.substring(name.lastIndexOf('.') + 1);
        System.out.println("imType:" + imType);
        response.setContentType("image/" + imType);
        try {
            FileInputStream fromServer = new FileInputStream(
                    new File("F:/z-w-f-demo/Rental-house/src/main/resources/static/RentalHouse/" + name));
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


//    /**
//     * 上传出租屋的文件
//     */
//    @RequestMapping(value = "/uploadRentalHouse",method = RequestMethod.PUT)
//    public Map<String, Object> uploadRentalHouse(
//            @RequestParam("file") MultipartFile file, HttpServletResponse response) throws JsonMappingException, IOException {
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        Map<String, Object> modelMap = new HashMap<>();
//        if (file.isEmpty()) {
//            System.out.println("文件为空");
//            modelMap.put("message", "文件为空");
//            return modelMap;
//        }
//        String path = "F:/z-w-f-demo/Rental-house/src/main/resources/static/RentalHouse/";
//        File serverFile = new File(path + file.getOriginalFilename());
//        File dir = new File(path);
//        System.out.println("开始上传");
//        if (!dir.exists()) {
//            dir.mkdir();
//        }
//        try {
//            file.transferTo(serverFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("上传失败");
//            modelMap.put("message", "上传失败");
//            return modelMap;
//        }
//        System.out.println("localhost:8082/F:/z-w-f-demo/Rental-house/src/main/resources/static/RentalHouse/"
//                + file.getOriginalFilename());
//        System.out.println("上传成功");
//
//        String name = file.getOriginalFilename();
//        System.out.println("name: " + name);
//        String imType = name.substring(name.lastIndexOf('.') + 1);
//        System.out.println("imType:" + imType);
//        response.setContentType("image/" + imType);
//        try {
//            FileInputStream fromServer = new FileInputStream(
//                    new File("F:/z-w-f-demo/Rental-house/src/main/resources/static/RentalHouse/" + name));
//            OutputStream toClient = response.getOutputStream();
//            byte[] avatar = new byte[fromServer.available()];
//            fromServer.read(avatar);
//            toClient.write(avatar);
//            toClient.flush();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        modelMap.put("message", "F:/z-w-f-demo/Rental-house/src/main/resources/static/RentalHouse/"
//                + file.getOriginalFilename());
//
//        return modelMap;
//    }

//    /**
//     * 上传出租屋的文件
//     */
//    @RequestMapping(value = "/uploadRentalHouse",method = RequestMethod.PUT)
//    public void uploadRentalHouse(
//            @RequestParam("file") MultipartFile file, HttpServletResponse response) throws JsonMappingException, IOException {
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        Map<String, Object> modelMap = new HashMap<>();
//        if (file.isEmpty()) {
//            System.out.println("文件为空");
//            modelMap.put("message", "文件为空");
////            return modelMap;
//        }
//        String path = "F:/z-w-f-demo/Rental-house/src/main/resources/static/RentalHouse/";
//        File serverFile = new File(path + file.getOriginalFilename());
//        File dir = new File(path);
//        System.out.println("开始上传");
//        if (!dir.exists()) {
//            dir.mkdir();
//        }
//        try {
//            file.transferTo(serverFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("上传失败");
//            modelMap.put("message", "上传失败");
////            return modelMap;
//        }
//        System.out.println("上传成功");
//        System.out.println("图片路径为: " +
//                "localhost:8082/F:/z-w-f-demo/Rental-house/src/main/resources/static/RentalHouse/"
//                + file.getOriginalFilename());
//
//        /**
//         * 根据上传图片，把图片显示出来
//         */
//        String name = file.getOriginalFilename();
//        System.out.println("name: " + name);
//        String imType = name.substring(name.lastIndexOf('.') + 1);
//        System.out.println("imType:" + imType);
//        response.setContentType("image/" + imType);
//        try {
//            FileInputStream fromServer = new FileInputStream(
//                    new File(
//                            "F:/z-w-f-demo/Rental-house/src/main/resources/static/RentalHouse/"
//                                    + name));
//            OutputStream toClient = response.getOutputStream();
//            byte[] avatar = new byte[fromServer.available()];
//            fromServer.read(avatar);
//            toClient.write(avatar);
//            toClient.flush();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////        modelMap.put("message", "F:/z-w-f-demo/Rental-house/src/main/resources/static/RentalHouse/"
////                + file.getOriginalFilename());
//
////        return modelMap;
    }
