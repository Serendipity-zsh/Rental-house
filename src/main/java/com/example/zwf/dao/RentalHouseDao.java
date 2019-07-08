package com.example.zwf.dao;

import com.example.zwf.entity.RentalHouse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 *  @author
 */
public interface RentalHouseDao {


    /**
     * 列出出租屋列表
     *
     * @return userList
     */
    List<RentalHouse> queryRentalHouse();

    /**
     * 根据email列出出租屋信息
     *
     * @return user
     */
    List<RentalHouse> queryRentalHouseByEmail(String email);

    /**
     * 根据出租屋id查找出租屋信息
     * @param id
     * @return
     */
    RentalHouse queryRentalHouseById(int id);


    /**
     * 根据价格范围列出出租屋信息
     */
    List<RentalHouse> queryRentalHouseByPrice(int minPrice, int maxPrice);

    /**
     * 根据位置列出出租屋信息
     */
    List<RentalHouse> queryRentalHouseByLocation(String location);

    /**
     * 根据面积范围列出出租屋信息
     */
    List<RentalHouse> queryRentalHouseByArea(int minArea, int maxArea);

    /**
     * 插入出租屋信息
     *
     * @param rentalHouse
     * @return
     */
    int insertRentalHouse(RentalHouse rentalHouse);

    /**
     * 更新出租屋信息
     *
     * @param rentalHouse
     * @return
     */
    int updateRentalHouse(RentalHouse rentalHouse);

    /**
     * 删除出租屋信息
     *
     * @param id
     * @return
     */
    int deleteRentalHouse(int  id);

//    /**
//     * 根据email和pasword找到用户
//     * @return Student
//     */
//    User selectRentalHouse(String email,String password);

}
