package com.example.zwf.service.impl;

import com.example.zwf.dao.RentalHouseDao;
import com.example.zwf.entity.RentalHouse;
import com.example.zwf.service.RentalHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * 根据Id获取出租屋信息
     */
    @Override
    public RentalHouse getRentalHouseById(int id) {
        return rentalHouseDao.queryRentalHouseById(id);
    }

    /**
     * 根据价格范围获取出租屋信息
     */
    @Override
    public List<RentalHouse> getRentalHouseByPrice(int minPrice, int maxPrice) {
        return rentalHouseDao.queryRentalHouseByPrice(minPrice, maxPrice);
    }

    /**
     * 根据价格获取出租屋信息
     * @param price
     * @return
     */
    @Override
    public List<RentalHouse> getRentalHouseByOnePrice(int price) {
        return rentalHouseDao.queryRentalHouseByOnePrice(price);
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
     * 根据面积列出出租屋信息
     * @param area
     * @return
     */
    @Override
    public List<RentalHouse> getRentalHouseByOneArea(int area) {
        return rentalHouseDao.queryRentalHouseByOneArea(area);
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
        rentalHouse.setState("未出租");
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
     * 房客更新出租屋状态：未出租——待审核
     * 申请租房
     * @param tenantEmail
     * @param id
     * @return
     */
    @Override
    public boolean updateRentalHouseState1(String tenantEmail,int id){
        RentalHouse rentalHouse = new RentalHouse();
        rentalHouse.setId(id);
        rentalHouse.setTenantEmail(tenantEmail);
        rentalHouse.setState("待审核");
        if(id> 0&& tenantEmail!= null && !"".equals(tenantEmail)){
            try {
                int effectedNum = rentalHouseDao.updateRentalHouseState1(rentalHouse);
                if (effectedNum > 0) {
                    return true;
                } else {
                    System.out.println("用户更改出租屋状态失败!");
                    throw new RuntimeException("用户更改出租屋状态失败!");
                }
            } catch (Exception e) {
                System.out.println("用户更改出租屋状态失败:" + e.toString());
                throw new RuntimeException("用户更改出租屋状态失败:" + e.toString());
            }
        }else {
            System.out.println("有信息为空！请填全信息");
            throw new RuntimeException("有信息为空！请填全信息");
        }
    }

    /**
     * 房客更新出租屋状态：待审核——未出租
     * 取消申请
     * @param id
     * @return
     */
    @Override
    public boolean cancelRentalHouseState1(int id){
        RentalHouse rentalHouse = new RentalHouse();
        rentalHouse.setId(id);
        rentalHouse.setState("未出租");
        if(id> 0){
            try {
                int effectedNum = rentalHouseDao.cancelRentalHouseState1(rentalHouse);
                if (effectedNum > 0) {
                    return true;
                } else {
                    System.out.println("用户更改出租屋状态失败!");
                    throw new RuntimeException("用户更改出租屋状态失败!");
                }
            } catch (Exception e) {
                System.out.println("用户更改出租屋状态失败:" + e.toString());
                throw new RuntimeException("用户更改出租屋状态失败:" + e.toString());
            }
        }else {
            System.out.println("有信息为空！请填全信息");
            throw new RuntimeException("有信息为空！请填全信息");
        }
    }

    /**
     * 房东更新出租屋状态：待审核——已出租
     * @param id
     * @return
     */
    @Override
    public  boolean updateRentalHouseState2(int id){
        RentalHouse rentalHouse = new RentalHouse();
        rentalHouse.setId(id);
        rentalHouse.setState("已出租");
        if(id> 0){
            try {
                int effectedNum = rentalHouseDao.updateRentalHouseState1(rentalHouse);
                if (effectedNum > 0) {
                    return true;
                } else {
                    System.out.println("房东更改出租屋状态失败!");
                    throw new RuntimeException("房东更改出租屋状态失败!");
                }
            } catch (Exception e) {
                System.out.println("房东更改出租屋状态失败:" + e.toString());
                throw new RuntimeException("房东更改出租屋状态失败:" + e.toString());
            }
        }else {
            System.out.println("有信息为空！请填全信息");
            throw new RuntimeException("有信息为空！请填全信息");
        }
    }

    /**
     * 房主更新出租屋状态：待审核——审核失败
     * 拒绝申请
     * @param id
     * @return
     */
    @Transactional
    @Override
    public boolean cancelRentalHouseState2(int id){
        RentalHouse rentalHouse = new RentalHouse();
        rentalHouse.setId(id);
        rentalHouse.setTenantEmail(null);
        rentalHouse.setState("审核失败");
        if (id > 0) {
            try {
                int effectedNum = rentalHouseDao.cancelRentalHouseState2(rentalHouse);
                if (effectedNum > 0) {
                    return true;
                } else {
                    System.out.println("房主更改出租屋状态失败!");
                    throw new RuntimeException("房主更改出租屋状态失败!");
                }
            } catch (Exception e) {
                System.out.println("房主更改出租屋状态失败:" + e.toString());
                throw new RuntimeException("房主更改出租屋状态失败:" + e.toString());
            }
        } else {
            System.out.println("有信息为空！请填全信息");
            throw new RuntimeException("有信息为空！请填全信息");
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

    /**
     * 房东获取被申请过的出租屋信息
     * @param email
     * @return
     */
    @Override
    public List<RentalHouse> getRentalHouseToLandlord(String email) {
        return rentalHouseDao.getRentalHouseToLandlord(email);
    }

    /**
     * 房客获取申请过的出租屋信息
     * @param tenantEmail
     * @return
     */
    @Override
    public List<RentalHouse> getRentalHouseToTenant(String tenantEmail) {
        return rentalHouseDao.getRentalHouseToTenant(tenantEmail);
    }

    /**
     * 上传出租屋图片
     * @param id
     * @param rentalHouseImageUrl
     * @return
     */
    @Override
    public boolean modifyRentalHouseImage(int id,String rentalHouseImageUrl) {
        RentalHouse rentalHouse = new RentalHouse();
        rentalHouse.setId(id);
        rentalHouse.setImageUrl(rentalHouseImageUrl);
        if (id > 0) {
            try {
                int effectedNum = rentalHouseDao.updateRentalHouseImage(rentalHouse);
                if (effectedNum > 0) {
                    return true;
                } else {
                    System.out.println("更新出租屋图片失败");
                    throw new RuntimeException("更新出租屋图片失败!");
                }
            } catch (Exception e) {
                System.out.println("更新出租屋图片失败");
                System.out.println(e.toString());
                throw new RuntimeException("更新出租屋图片失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("id为空！");
        }
    }
}
