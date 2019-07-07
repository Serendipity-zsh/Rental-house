package com.example.zwf.service.impl;

import com.example.zwf.dao.RentalHouseDao;
import com.example.zwf.entity.RentalHouse;
import com.example.zwf.service.RentalHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalHouseServiceImpl implements RentalHouseService {

    @Autowired
    private RentalHouseDao rentalHouseDao;
    /**
     * 获取带出租屋的列表
     * @return
     */
    @Override
     public List<RentalHouse> getRentalHouseList() {
        return rentalHouseDao.queryRentalHouse();
    }

    /**
     * 通过email获取出租屋信息
     *
     * @param email
     * @return
     */

    @Override
     public List<RentalHouse> getRentalHouseByEmail(String email) {
        return rentalHouseDao.queryRentalHouseByEmail(email);
    }

    /**
     * 根据价格范围获取出租屋信息
     */
    @Override
    public List<RentalHouse> getRentalHouseByPrice(int minPrice, int maxPrice) {
        return rentalHouseDao.queryRentalHouseByPrice(minPrice, maxPrice);
    }

    /**
     * 根据位置列出出租屋信息
     */
    @Override
    public List<RentalHouse> getRentalHouseByLocation(String location) {
        return rentalHouseDao.queryRentalHouseByLocation(location);
    }

    /**
     * 根据面积范围列出出租屋信息
     */
    @Override
    public List<RentalHouse> getRentalHouseByArea(int minArea, int maxArea) {
        return rentalHouseDao.queryRentalHouseByArea(minArea, maxArea);
    }

    /**
     * 增加出租屋信息
     *
     */
    @Override
    public boolean addRentalHouse1(String email, String name, String rname,
                            String location, int area, int price,
                            String number, String oriented, String houseType,
                            String introduction, String wechat) {
        RentalHouse rentalHouse = new RentalHouse();
        rentalHouse.setId(0);
        rentalHouse.setEmail(email);
        rentalHouse.setName(name);
        rentalHouse.setRname(rname);
        rentalHouse.setLocation(location);
        rentalHouse.setArea(area);
        rentalHouse.setPrice(price);
        rentalHouse.setNumber(number);
        rentalHouse.setOriented(oriented);
        rentalHouse.setHouseType(houseType);
        rentalHouse.setIntroduction(introduction);
        rentalHouse.setWechat(wechat);
        if(rentalHouse.getId()==null||
                "".equals(rentalHouse.getEmail())||
                "".equals(rentalHouse.getName())||
                "".equals(rentalHouse.getRname())||
                "".equals(rentalHouse.getLocation())||
                rentalHouse.getArea()<=0||
                rentalHouse.getPrice()<=0||
                "".equals(rentalHouse.getNumber())||
                "".equals(rentalHouse.getOriented())||
                "".equals(rentalHouse.getHouseType())||
                "".equals(rentalHouse.getIntroduction())||
                "".equals(rentalHouse.getWechat())){
            System.out.println("某个信息为空，添加出租屋失败！");
            throw new RuntimeException("添加出租屋失败！");

        }else {
            try {
                int effectedNum = rentalHouseDao.insertRentalHouse(rentalHouse);
                if (effectedNum > 0) {
                    return true;
                } else {
                    System.out.println("1添加出租屋失败！");
                    throw new RuntimeException("添加出租屋信息失败!");
                }
            }catch (Exception e) {
                System.out.println("2添加出租屋失败！");
                throw new RuntimeException("添加出租屋信息失败:" + e.toString());
            }
        }
    }


    /**
     * 更新出租屋信息
     */
    @Override
    public boolean modifyRentalHouse(int id, String email, String name, String rname,
                                     String location, int area, int price,
                                     String number, String oriented, String houseType,
                                     String introduction, String wechat) {

        RentalHouse rentalHouse = new RentalHouse();
        rentalHouse.setId(id);
        rentalHouse.setEmail(email);
        rentalHouse.setName(name);
        rentalHouse.setRname(rname);
        rentalHouse.setLocation(location);
        rentalHouse.setArea(area);
        rentalHouse.setPrice(price);
        rentalHouse.setNumber(number);
        rentalHouse.setOriented(oriented);
        rentalHouse.setHouseType(houseType);
        rentalHouse.setIntroduction(introduction);
        rentalHouse.setWechat(wechat);
        if(rentalHouse.getId()==null||
                "".equals(rentalHouse.getEmail())||
                "".equals(rentalHouse.getName())||
                "".equals(rentalHouse.getRname())||
                "".equals(rentalHouse.getLocation())||
                rentalHouse.getArea()<=0||
                rentalHouse.getPrice()<=0||
                "".equals(rentalHouse.getNumber())||
                "".equals(rentalHouse.getOriented())||
                "".equals(rentalHouse.getHouseType())||
                "".equals(rentalHouse.getIntroduction())||
                "".equals(rentalHouse.getWechat())){
            System.out.println("更新出租屋信息失败！");
            throw new RuntimeException("更新出租屋信息失败！");

        }else {

            try {
                int effectedNum = rentalHouseDao.updateRentalHouse(rentalHouse);
                if (effectedNum > 0) {
                    return true;
                } else {
                    System.out.println("更新出租屋信息失败！");
                    throw new RuntimeException("更新出租屋信息失败!");
                }
            }catch (Exception e) {
                System.out.println("更新出租屋信息失败！");
                throw new RuntimeException("更新出租屋信息失败:" + e.toString());
            }
        }
    }

    /**
     * 删除出租屋信息
     */
    @Override
    public boolean deleteRentalHouse(int id) {
        int effectedNum=rentalHouseDao.deleteRentalHouse(id);
        if (effectedNum > 0) {
            return true;
        } else {
            System.out.println("删除出租屋信息失败!");
            throw new RuntimeException("删除出租屋信息失败!");
        }
    }


//    /**
//     * 增加出租屋信息
//     *
//     * @param rentalHouse
//     * @return
//     */
//    public boolean addRentalHouse(RentalHouse rentalHouse) {
//        if(rentalHouse.getId()==null||
//                "".equals(rentalHouse.getEmail())||
//                "".equals(rentalHouse.getName())||
//                "".equals(rentalHouse.getRname())||
//                "".equals(rentalHouse.getLocation())||
//                "".equals(rentalHouse.getArea())||
//                "".equals(rentalHouse.getPrice())||
//                "".equals(rentalHouse.getNumber())||
//                "".equals(rentalHouse.getOriented())||
//                "".equals(rentalHouse.getHouseType())||
//                "".equals(rentalHouse.getIntroduction())||
//                "".equals(rentalHouse.getWechat())){
//            throw new RuntimeException("添加出租屋失败！");
//
//        }else {
//
//            try {
//                int effectedNum = rentalHouseDao.insertRentalHouse(rentalHouse);
//                if (effectedNum > 0) {
//                    return true;
//                } else {
//                    throw new RuntimeException("添加出租屋信息失败!");
//                }
//            }catch (Exception e) {
//                throw new RuntimeException("添加出租屋信息失败:" + e.toString());
//            }
//        }
//    }
}
