package com.example.zwf.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 *
 *  @author
 */
public class RentalHouse implements Serializable {

    private static final long serialVersionUID = 1562374169173L;

    /**
     * 主键
     *
     * isNullAble:0
     */
    private Integer id;

    /**
     *
     * isNullAble:0
     */
    private String email;

    /**
     *
     * isNullAble:0
     */
    private String name;

    /**
     *
     * isNullAble:0
     */
    private String rname;

    /**
     *
     * isNullAble:0
     */
    private String location;

    /**
     *
     * isNullAble:0
     */
    private int area;

    /**
     *
     * isNullAble:0
     */
    private int price;

    /**
     *
     * isNullAble:0
     */
    private String number;

    /**
     *
     * isNullAble:0
     */
    private String oriented;

    /**
     *
     * isNullAble:0
     */
    private String houseType;

    /**
     *
     * isNullAble:0
     */
    private String introduction;

    /**
     *
     * isNullAble:0
     */
    private String wechat;

    private String imageUrl;

    private String state;

    private String tenantEmail;

    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setEmail(String email){this.email = email;}

    public String getEmail(){return this.email;}

    public void setName(String name){this.name = name;}

    public String getName(){return this.name;}

    public void setRname(String rname){this.rname = rname;}

    public String getRname(){return this.rname;}

    public void setLocation(String location){this.location = location;}

    public String getLocation(){return this.location;}

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumber(String number){this.number = number;}

    public String getNumber(){return this.number;}

    public void setOriented(String oriented){this.oriented = oriented;}

    public String getOriented(){return this.oriented;}

    public void setHouseType(String houseType){this.houseType = houseType;}

    public String getHouseType(){return this.houseType;}

    public void setIntroduction(String introduction){this.introduction = introduction;}

    public String getIntroduction(){return this.introduction;}

    public void setWechat(String wechat){this.wechat = wechat;}

    public String getWechat(){return this.wechat;}

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    @Override
    public String toString() {
        return "RentalHouse{" +
                "id='" + id + '\'' +
                "email='" + email + '\'' +
                "name='" + name + '\'' +
                "rname='" + rname + '\'' +
                "location='" + location + '\'' +
                "area='" + area + '\'' +
                "price='" + price + '\'' +
                "number='" + number + '\'' +
                "oriented='" + oriented + '\'' +
                "houseType='" + houseType + '\'' +
                "introduction='" + introduction + '\'' +
                "wechat='" + wechat + '\'' +
                '}';
    }

}
