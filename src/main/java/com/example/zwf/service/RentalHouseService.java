package com.example.zwf.service;

import com.example.zwf.entity.RentalHouse;

import java.util.List;

public interface RentalHouseService {

    /**
     * 获取出租屋的列表
     * @return
     */
    List<RentalHouse> getRentalHouseList();

    /**
     * 通过email获取出租屋信息
     *
     * @param email
     * @return
     */
    List<RentalHouse> getRentalHouseByEmail(String email);

    /**
     * 根据Id获取出租屋信息
     */
    RentalHouse getRentalHouseById(int id);

    /**
     * 根据价格范围获取出租屋信息
     */
    List<RentalHouse> getRentalHouseByPrice(int minPrice, int maxPrice);

    /**
     * 根据价格获取出租屋信息
     * @param price
     * @return
     */
    List<RentalHouse> getRentalHouseByOnePrice(int price);

    /**
     * 根据位置列出出租屋信息
     */
    List<RentalHouse> getRentalHouseByLocation(String location);

    /**
     * 根据面积范围列出出租屋信息
     */
    List<RentalHouse> getRentalHouseByArea(int minArea, int maxArea);

    /**
     * 根据面积获取出租屋信息
     * @param area
     * @return
     */
    List<RentalHouse> getRentalHouseByOneArea(int area);

    /**
     * 房东获取被申请过的出租屋信息
     * @param tenantEmail
     * @return
     */
    List<RentalHouse> getRentalHouseToLandlord(String tenantEmail);

    /**
     * 房客获取申请过的出租屋信息
     * @param email
     * @return
     */
    List<RentalHouse> getRentalHouseToTenant(String email);

    /**
     * 增加出租屋信息
     *
     */
    boolean addRentalHouse1(String email, String name, String rname,
                            String location, int area, int price,
                            String number, String oriented, String houseType,
                            String introduction, String wechat);


    /**
     * 更新出租屋信息
     */
    boolean modifyRentalHouse(int id, String email, String name, String rname,
                              String location, int area, int price,
                              String number, String oriented, String houseType,
                              String introduction, String wechat);

    /**
     * 房客改变房屋状态
     * 申请租房
     * @param tenantEmail
     * @param id
     * @return
     */
    boolean updateRentalHouseState1(String tenantEmail,int id);

    /**
     * 房客改变房屋状态
     * 取消申请
     * @param id
     * @return
     */
    boolean cancelRentalHouseState1(int id);

    /**
     * 房东改变房屋状态
     * @param id
     * @return
     */
    boolean updateRentalHouseState2(int id);

    /**
     * 房主更新出租屋信息
     * 拒绝出租
     * @param id
     * @return
     */
    boolean cancelRentalHouseState2(int id);


    /**
     * 删除出租屋信息
     * @param id
     * @return
     */
    boolean deleteRentalHouse(int id);


    /**
     * 保存出租屋图片
     * @param id
     * @param rentalHouseImageUrl
     * @return
     */
    boolean modifyRentalHouseImage(int id,String rentalHouseImageUrl);
}
