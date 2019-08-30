package com.example.zwf.dao;

import com.example.zwf.entity.RentalHouse;
import com.example.zwf.entity.User;
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
     * 根据价格列出出租屋信息
     */
    List<RentalHouse> queryRentalHouseByOnePrice(int price);


    /**
     * 根据位置列出出租屋信息
     */
    List<RentalHouse> queryRentalHouseByLocation(String location);

    /**
     * 根据面积范围列出出租屋信息
     */
    List<RentalHouse> queryRentalHouseByArea(int minArea, int maxArea);

    /**
     * 根据面积列出出租屋信息
     */
    List<RentalHouse> queryRentalHouseByOneArea(int area);

    /**
     * 通过房客tenantEmail找到与他有关的出租屋状态为待审核和已出租的房屋信息
     * @param tenantEmail
     * @return
     */
    List<RentalHouse> getRentalHouseToTenant(String tenantEmail);

    /**
     * 通过房东找到与他有关的出租屋状态为待审核和已出租的房屋信息
     * @param email
     * @return
     */
    List<RentalHouse> getRentalHouseToLandlord(String email);



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
     * 房客更新出租屋信息
     * 申请租房
     * @param rentalHouse
     * @return
     */
    int updateRentalHouseState1(RentalHouse rentalHouse);

    /**
     * 房客更新出租屋信息
     * 取消申请
     * @param rentalHouse
     * @return
     */
    int cancelRentalHouseState1(RentalHouse rentalHouse);

    /**
     * 房东更新出租屋信息
     *
     * @param rentalHouse
     * @return
     */
    int updateRentalHouseState2(RentalHouse rentalHouse);

    /**
     * 房主更新出租屋信息
     * 拒绝出租
     * @param rentalHouse
     * @return
     */
    int cancelRentalHouseState2(RentalHouse rentalHouse);



    /**
     * 删除出租屋信息
     *
     * @param id
     * @return
     */
    int deleteRentalHouse(int  id);

    /**
     * 上传出租屋图片
     * @param rentalHouse
     * @return
     */
    int updateRentalHouseImage(RentalHouse rentalHouse);

}
