package com.example.zwf.web;

import com.example.zwf.entity.RentalHouse;
import com.example.zwf.service.RentalHouseService;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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
    private Map<String, Object> getRentalHouseByEmail(String email,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<>();
        List<RentalHouse> list = rentalHouseService.getRentalHouseByEmail(email);
        System.out.println("email为"+email+"的出租屋信息：" + list);
        modelMap.put("message", list);
        return modelMap;
    }
    /**
     * 添加出租屋信息
     */
    @RequestMapping(value = "addRentalHouse1", method = RequestMethod.POST)
    public Map<String, Object> login ( String email, String name, String rname,
                                      String location, String area, String price,
                                      String number, String oriented, String houseType,
                                      String introduction, String wechat,
                                      HttpServletResponse response)
            throws  JsonMappingException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        boolean judge = rentalHouseService.addRentalHouse1(email,name,rname,location,area,price,number,
                oriented,houseType,introduction,wechat);
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
        modelMap.put("success",judge);
        return modelMap;
    }

    /**
     * 删除出租屋信息
     */

    @RequestMapping(value= "/deleteRentalHouse", method = RequestMethod.DELETE)
    private Map<String, Object> deleteRentalHouse(int id) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        System.out.println("删除出租屋信息："+"id = "+id);
        modelMap.put("success", rentalHouseService.deleteRentalHouse(id));
        return modelMap;
    }
    /**
     * 更新出租屋信息
     */
    @RequestMapping(value = "updateRentalHouse", method = RequestMethod.POST)
    private Map<String,Object> updateRentalHouse( int id, String email, String name, String rname,
                                                  String location, String area, String price,
                                                  String number, String oriented, String houseType,
                                                  String introduction, String wechat,
                                                  HttpServletResponse response) throws JsonMappingException,IOException{
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

}
