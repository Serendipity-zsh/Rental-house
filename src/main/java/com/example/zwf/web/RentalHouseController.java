package com.example.zwf.web;

import com.example.zwf.entity.RentalHouse;
import com.example.zwf.service.RentalHouseService;
import com.example.zwf.util.StaticConstant;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class RentalHouseController {
    @Autowired
    RentalHouseService rentalHouseService;


    /**
     * 列出所有出租屋的信息
     * @param response
     * @return list
     */
    @RequestMapping(value = "/getRentalHouseList", method = RequestMethod.GET)
    private List<RentalHouse> getRentalHouseList(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RentalHouse> list = rentalHouseService.getRentalHouseList();
        System.out.println("所有未出租的出租屋信息共有" + list.size() + "条");
        System.out.println(list);
        //modelMap.put("message", list);
        return list;
    }

    /**
     * 根据email列出出租屋的信息
     * @param email
     * @param response
     * @return list
     */
    @RequestMapping(value = "/getRentalHouseByEmail", method = RequestMethod.GET)
    private List<RentalHouse> getRentalHouseByEmail(String email, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<>();
        String reallEmail=email.substring(email.lastIndexOf('=')+1);
        List<RentalHouse> list = rentalHouseService.getRentalHouseByEmail(reallEmail);
        System.out.println("共查询到"+list.size()+"条email为" + reallEmail + "的出租屋信息: ");
        System.out.println(list);
        return list;
    }


    /**
     * 根据Id显示出租屋信息
     * @param messageId
     * @param response
     * @return rentalHouse
     */
    @RequestMapping(value = "/getRentalHouseById", method = RequestMethod.GET)
    private RentalHouse getRentalHouseById(String messageId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        String string = messageId.substring(messageId.lastIndexOf("=" )+1);
        int id = Integer.parseInt(string);
        RentalHouse rentalHouse = rentalHouseService.getRentalHouseById(id);
        System.out.println("根据Id查询出租屋信息");
        System.out.println("ID=" + id);
        System.out.println(rentalHouse);
        return rentalHouse;
    }

    /**
     * 添加出租屋信息
     * @param email
     * @param name
     * @param rname
     * @param location
     * @param area
     * @param price
     * @param number
     * @param oriented
     * @param houseType
     * @param introduction
     * @param wechat
     * @param response
     * @return judge
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "addRentalHouse", method = RequestMethod.POST)
    public boolean addRentalHouse(String email, String name, String rname,
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
        return judge;
    }


    /**
     * 删除出租屋信息
     * @param id
     * @param response
     * @return judge
     * @throws JsonMappingException
     * @throws IOException
     */

    @RequestMapping(value = "/deleteRentalHouseById", method = RequestMethod.POST)
    private boolean deleteRentalHouseById(int id,HttpServletResponse response)
            throws JsonMappingException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        System.out.println("删除id为"+id+"的出租屋信息" );
        boolean judge = rentalHouseService.deleteRentalHouse(id);
        //modelMap.put("success", rentalHouseService.deleteRentalHouse(id));
        return judge;
    }


    /**
     * 更新出租屋信息
     * @param id
     * @param email
     * @param name
     * @param rname
     * @param location
     * @param area
     * @param price
     * @param number
     * @param oriented
     * @param houseType
     * @param introduction
     * @param wechat
     * @param response
     * @return judge
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "updateRentalHouse", method = RequestMethod.POST)
    private boolean updateRentalHouse(int id, String email, String name, String rname,
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
        //Map<String, Object> modelMap = new HashMap<String, Object>();
        //modelMap.put("success", judge);
        return judge;
    }

    /**
     * 根据价格范围列出出租屋信息
     * 前端传一个带连接符'-'的字符串
     * @param price
     * @param response
     * @return list
     */
    @RequestMapping(value = "/getRentalHouseByPrice", method = RequestMethod.GET)
    public List<RentalHouse> getRentalHouseByPrice(String price,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<>();
        System.out.println(price);
        String s[] = price.split("-");
        int minPrice = Integer.parseInt(s[0]);
        int maxPrice = Integer.parseInt(s[1]);
        List<RentalHouse> list = rentalHouseService.getRentalHouseByPrice(minPrice, maxPrice);
        System.out.println("共查询到"+list.size()+"条价格在"+minPrice+"--"+maxPrice+"之间的出租屋信息: ");
        System.out.println(list);
        modelMap.put(" ",list);
        return list;
    }

    /**
     * 根据价格范围列出出租屋信息
     * 前端传两个表示价格的字符串
     * @param onePrice
     * @param twoPrice
     * @param response
     * @return
     */
    @RequestMapping(value = "/getRentalHouseByPrice1", method = RequestMethod.GET)
    public List<RentalHouse> getRentalHouseByPrice1(String onePrice,String twoPrice,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> modelMap = new HashMap<>();
        //System.out.println(price);
        int minPrice = Integer.parseInt(onePrice);
        int maxPrice = Integer.parseInt(twoPrice);
        List<RentalHouse> list = rentalHouseService.getRentalHouseByPrice(minPrice, maxPrice);
        System.out.println("共查询到"+list.size()+"条价格在"+minPrice+"--"+maxPrice+"之间的出租屋信息: ");
        System.out.println(list);
        modelMap.put(" ",list);
        return list;
    }


    /**
     * 根据位置列出出租屋信息
     * @param location
     * @param response
     * @return list
     */
    @RequestMapping(value = "/getRentalHouseByLocation", method = RequestMethod.GET)
    public List<RentalHouse> getRentalHouseByLocation(String location,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //Map<String, Object> modelMap = new HashMap<>();
        List<RentalHouse> list = rentalHouseService.getRentalHouseByLocation(location);
        System.out.println("共查询到"+list.size()+"条位置在:" + location + "的出租屋信息: ");
        System.out.println(list);
        //modelMap.put("message", list);
        return list;
    }


    /**
     * 根据面积范围列出出租屋信息
     * @param area
     * @param response
     * @return list
     */
    @RequestMapping(value = "/getRentalHouseByArea", method = RequestMethod.GET)
    public List<RentalHouse> getRentalHouseByArea(String area,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //Map<String, Object> modelMap = new HashMap<>();
        String s[] = area.split("-");
        int minArea = Integer.parseInt(s[0]);
        int maxArea = Integer.parseInt(s[1]);
        List<RentalHouse> list = rentalHouseService.getRentalHouseByArea(minArea, maxArea);
        System.out.println("共查询到"+list.size()+"条面积在"+minArea+"--"+maxArea+"之间的出租屋信息: ");
        System.out.println(list);
        //modelMap.put("message", list);
        return list;
    }

    /**
     * 简单泛型搜索
     * @param generic
     * @param response
     * @return
     */
    @RequestMapping(value = "/getRentalHouseByGeneric", method = RequestMethod.GET)
    public List<RentalHouse> getRentalHouseByGeneric(String generic,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println("输入搜索数据: " + generic);
        boolean judge;
        List<RentalHouse> list;
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(generic);
        if (!isNum.matches()) {
            judge = false;
            System.out.println("不是数字");
        } else {
            judge = true;
            System.out.println("是数字");
        }

        if (judge) {
            int a = Integer.parseInt(generic);
            list = rentalHouseService.getRentalHouseByOneArea(a);
            list.addAll(rentalHouseService.getRentalHouseByOnePrice(a));
            System.out.println("查询到"+list.size()+"条出租屋信息: ");
            System.out.println(list);
            return list;
        } else {
            list = rentalHouseService.getRentalHouseByLocation(generic);
            System.out.println("查询到"+list.size()+"条出租屋信息: ");
            System.out.println(list);
            return list;
        }
    }

    /**
     * 房客申请租房
     * 房客更新出租屋状态：未出租——待审核
     * @param id
     * @param response
     * @return
     */

    @RequestMapping(value = "/updateRentalHouseState1", method = RequestMethod.POST)
    private boolean updateRentalHouseState1(String tenantEmail,String id,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println(tenantEmail);
        System.out.println("email为" + tenantEmail + "的房客申请Id=" + id + "的出租屋");
        boolean judge=rentalHouseService.updateRentalHouseState1(tenantEmail,Integer.parseInt(id));
        return judge;
    }

    /**
     * 房客取消申请
     * 更新出租屋状态：待审核——未出租
     * @param id
     * @param response
     * @return
     */
    @RequestMapping(value = "cancelRentalHouseState1", method = RequestMethod.POST)
    private boolean cancelRentalHouseState1(String id,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println("房客取消对Id="+id+"的出租屋的申请");
        boolean judge = rentalHouseService.cancelRentalHouseState1(Integer.parseInt(id));
        return judge;
    }
    /**
     * 房东同意申请
     * 房东更新出租屋状态：待审核——已出租
     * @param id
     * @param response
     * @return
     */
    @RequestMapping(value = "/updateRentalHouseState2", method = RequestMethod.POST)
    private boolean updateRentalHouseState2(String id,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println("房东同意出租Id="+id+"出租屋");
        boolean judge=rentalHouseService.updateRentalHouseState2(Integer.parseInt(id));
        return judge;
    }
    /**
     * 房主拒绝申请
     * 更新出租屋状态：待审核——审核失败
     * @param id
     * @param response
     * @return
     */
    @RequestMapping(value = "cancelRentalHouseState2", method = RequestMethod.POST)
    private boolean cancelRentalHouseState2(String id,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        String tenantEmail = rentalHouseService.getRentalHouseById(Integer.parseInt(id)).getTenantEmail();
        System.out.println("房主拒绝email="+tenantEmail+"的房客对Id="+id+"的出租屋的申请");
        boolean judge = rentalHouseService.cancelRentalHouseState2(Integer.parseInt(id));
        return judge;
    }

    /**
     *房客获取申请过的出租屋信息
     *@param tenantEmail
     *@param response
     *@return
     */
    @RequestMapping(value = "/getRentalHouseToTenant", method = RequestMethod.GET)
    private List<RentalHouse> getRentalHouseToTenant(String tenantEmail,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        List<RentalHouse> list = rentalHouseService.getRentalHouseToTenant(tenantEmail);
        System.out.println("获取房客" + tenantEmail + "申请过的出租屋信息");
        System.out.println(list);
        return list;
    }

    /**
     * 房东获取被申请过的出租屋信息
     * @param email
     * @param response
     * @return
     */
    @RequestMapping(value = "/getRentalHouseToLandlord", method = RequestMethod.GET)
    private List<RentalHouse> getRentalHouseToLandlord(String email,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println("email: " + email);
        List<RentalHouse> list = rentalHouseService.getRentalHouseToLandlord(email);
        System.out.println("获取房客email为" + email + "申请过的出租屋信息");
        System.out.println(list);
        return list;
    }

    /**
     * 上传出租屋图片
     * @param file
     * @param id
     * @param response
     * @return
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "/uploadRentalHouseImage",method = RequestMethod.POST)
    public Map<String, Object> uploadRentalHouseImage(
            @RequestParam("file") MultipartFile file, @RequestParam("id") String id,
            HttpServletResponse response) throws JsonMappingException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");

        System.out.println("为Id=" + id + "的出租屋" + "上传图片：" + file.getOriginalFilename());
        Map<String, Object> modelMap = new HashMap<>();
        boolean judge = false;
        if (file.isEmpty()) {
            System.out.println("文件为空");
            modelMap.put("message", "文件为空");
            judge = false;
            modelMap.put("success", judge);
            return modelMap;
        }
        String path = StaticConstant.HOUSE_PATH;
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
        String url = StaticConstant.RENTAL_HOUSE_URL;
        modelMap.put("message", url
                + file.getOriginalFilename());
        String rentalHouseImageUrl = url + file.getOriginalFilename();
        modelMap.put("success", judge);
        System.out.println(modelMap);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Date date = new Date();
        System.out.println("上传时间：" + simpleDateFormat.format(date));
        System.out.println("上传成功");
        boolean uploadImage = rentalHouseService.modifyRentalHouseImage(Integer.parseInt(id), rentalHouseImageUrl);
        System.out.println("保存出租屋图片情况：" + uploadImage);
        return modelMap;
    }



}
