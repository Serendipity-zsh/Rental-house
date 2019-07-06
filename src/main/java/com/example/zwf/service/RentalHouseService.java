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
     * 增加出租屋信息
     *
     */
    boolean addRentalHouse1(String email, String name, String rname,
                            String location, String area, String price,
                            String number, String oriented, String houseType,
                            String introduction, String wechat);


    /**
     * 更新出租屋信息
     */
    boolean modifyRentalHouse(int id, String email, String name, String rname,
                              String location, String area, String price,
                              String number, String oriented, String houseType,
                              String introduction, String wechat);

    /**
     * 删除出租屋信息
     */
    boolean deleteRentalHouse(int id);

    //    /**
//     * 增加出租屋信息
//     *
//     * @param rentalHouse
//     * @return
//     */
//    boolean addRentalHouse(RentalHouse rentalHouse);
}
