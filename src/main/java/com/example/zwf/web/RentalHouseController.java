package com.example.zwf.web;

import com.example.zwf.entity.RentalHouse;
import com.example.zwf.service.RentalHouseService;
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
import java.util.List;
import java.util.Map;

@RestController
public class RentalHouseController {
    @Autowired
    RentalHouseService rentalHouseService;

    /**
     * 列出所有出租屋的信息
     */
    @RequestMapping(value = "/getRentalHouseList", method = RequestMethod.GET)
    private Map<String, Object> getRentalHouseList(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RentalHouse> list = rentalHouseService.getRentalHouseList();
        System.out.println("所有出租屋信息：" + list);
        modelMap.put("message", list);
        return modelMap;
    }

    /**
     * 根据email列出出租屋的信息
     */
    @RequestMapping(value = "/getRentalHouseByEmail", method = RequestMethod.GET)
    private Map<String, Object> getRentalHouseByEmail(String email, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<>();
        List<RentalHouse> list = rentalHouseService.getRentalHouseByEmail(email);
        System.out.println("email为" + email + "的出租屋信息：" + list);
        modelMap.put("message", list);
        return modelMap;
    }

    /**
     * 添加出租屋信息
     */
    @RequestMapping(value = "addRentalHouse", method = RequestMethod.POST)
    public Map<String, Object> addRentalHouse(String email, String name, String rname,
                                     String location, int area, int price,
                                     String number, String oriented, String houseType,
                                     String introduction, String wechat,
                                     HttpServletResponse response)
            throws JsonMappingException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        boolean judge = rentalHouseService.addRentalHouse1(email, name, rname, location, area, price, number,
                oriented, houseType, introduction, wechat);
        System.out.println("添加出租屋信息");

        System.out.println("email: " + email);
        System.out.println("name: " + name);
        System.out.println("rname: " + rname);
        System.out.println("location: " + location);
        System.out.println("area: " + area);
        System.out.println("price: " + price);
        System.out.println("number: " + number);
        System.out.println("oriented: " + oriented);
        System.out.println("houseType: " + houseType);
        System.out.println("introduction: " + introduction);
        System.out.println("wechat: " + wechat);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", judge);
        return modelMap;
    }

    /**
     * 删除出租屋信息
     */

    @RequestMapping(value = "/deleteRentalHouse", method = RequestMethod.DELETE)
    private Map<String, Object> deleteRentalHouse(int id) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        System.out.println("删除出租屋信息：" + "id = " + id);
        modelMap.put("success", rentalHouseService.deleteRentalHouse(id));
        return modelMap;
    }

    /**
     * 更新出租屋信息
     */
    @RequestMapping(value = "updateRentalHouse", method = RequestMethod.POST)
    private Map<String, Object> updateRentalHouse(int id, String email, String name, String rname,
                                                  String location, int area, int price,
                                                  String number, String oriented, String houseType,
                                                  String introduction, String wechat,
                                                  HttpServletResponse response) throws JsonMappingException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        boolean judge = rentalHouseService.modifyRentalHouse(id, email, name, rname, location, area, price, number,
                oriented, houseType, introduction, wechat);
        System.out.println("更新出租屋信息");
        System.out.println("id: " + id);
        System.out.println("email: " + email);
        System.out.println("name: " + name);
        System.out.println("rname: " + rname);
        System.out.println("location: " + location);
        System.out.println("area: " + area);
        System.out.println("price: " + price);
        System.out.println("number: " + number);
        System.out.println("oriented: " + oriented);
        System.out.println("houseType: " + houseType);
        System.out.println("introduction: " + introduction);
        System.out.println("wechat: " + wechat);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", judge);
        return modelMap;
    }

    /**
     * 上传出租屋图片
     */
    @RequestMapping(value = "/uploadRentalHouse",method = RequestMethod.PUT)
    public Map<String, Object> uploadRentalHouse(
            @RequestParam("file") MultipartFile file, HttpServletResponse response) throws JsonMappingException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<>();
        if (file.isEmpty()) {
            System.out.println("文件为空");
            modelMap.put("message", "文件为空");
            return modelMap;
        }
        String path = "F:/z-w-f-demo/Rental-house/src/main/resources/static/";
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
            return modelMap;
        }
        System.out.println("localhost:8082F:/z-w-f-demo/Rental-house/src/main/resources/static/" + file.getOriginalFilename());
        modelMap.put("message", "F:/z-w-f-demo/Rental-house/src/main/resources/static/" + file.getOriginalFilename());

        return modelMap;
    }

    /**
     * 根据价格范围列出出租屋信息
     */
    @RequestMapping(value = "/getRentalHouseByPrice", method = RequestMethod.GET)
    public List<RentalHouse> getRentalHouseByPrice(int minPrice, int maxPrice,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<>();
        List<RentalHouse> list = rentalHouseService.getRentalHouseByPrice(minPrice, maxPrice);
        System.out.println("价格在"+minPrice+"--"+maxPrice+"之间的出租屋: ");
        System.out.println(list);
        modelMap.put(" ",list);
        int a=list.size();
        System.out.println(a);
        return list;
    }

    /**
     * 根据位置列出出租屋信息
     */
    @RequestMapping(value = "/getRentalHouseByLocation", method = RequestMethod.GET)
    public Map<String, Object> getRentalHouseByLocation(String location,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<>();
        List<RentalHouse> list = rentalHouseService.getRentalHouseByLocation(location);
        System.out.println("位置在：" + location + "的出租屋: ");
        System.out.println(list);
        modelMap.put("message", list);
        return modelMap;
    }

    /**
     * 根据面积范围列出出租屋信息
     */
    @RequestMapping(value = "/getRentalHouseByArea", method = RequestMethod.GET)
    public Map<String, Object> getRentalHouseByArea(int minArea, int maxArea,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<>();
        List<RentalHouse> list = rentalHouseService.getRentalHouseByArea(minArea, maxArea);
        System.out.println("面积在"+minArea+"--"+maxArea+"之间的出租屋: ");
        System.out.println(list);
        modelMap.put("message", list);
        return modelMap;
    }
}
