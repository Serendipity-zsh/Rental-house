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

    private String imagePath;


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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private RentalHouse set;

        private ConditionBuilder where;

        public UpdateBuilder set(RentalHouse set){
            this.set = set;
            return this;
        }

        public RentalHouse getSet(){
            return this.set;
        }

        public UpdateBuilder where(ConditionBuilder where){
            this.where = where;
            return this;
        }

        public ConditionBuilder getWhere(){
            return this.where;
        }

        public UpdateBuilder build(){
            return this;
        }
    }

    public static class QueryBuilder extends RentalHouse {
        /**
         * 需要返回的列
         */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<String> emailList;

        public List<String> getEmailList(){return this.emailList;}


        private List<String> fuzzyEmail;

        public List<String> getFuzzyEmail(){return this.fuzzyEmail;}

        private List<String> rightFuzzyEmail;

        public List<String> getRightFuzzyEmail(){return this.rightFuzzyEmail;}
        private List<String> nameList;

        public List<String> getNameList(){return this.nameList;}


        private List<String> fuzzyName;

        public List<String> getFuzzyName(){return this.fuzzyName;}

        private List<String> rightFuzzyName;

        public List<String> getRightFuzzyName(){return this.rightFuzzyName;}
        private List<String> rnameList;

        public List<String> getRnameList(){return this.rnameList;}


        private List<String> fuzzyRname;

        public List<String> getFuzzyRname(){return this.fuzzyRname;}

        private List<String> rightFuzzyRname;

        public List<String> getRightFuzzyRname(){return this.rightFuzzyRname;}
        private List<String> locationList;

        public List<String> getLocationList(){return this.locationList;}


        private List<String> fuzzyLocation;

        public List<String> getFuzzyLocation(){return this.fuzzyLocation;}

        private List<String> rightFuzzyLocation;

        public List<String> getRightFuzzyLocation(){return this.rightFuzzyLocation;}
        private List<String> areaList;

        public List<String> getAreaList(){return this.areaList;}


        private List<String> fuzzyArea;

        public List<String> getFuzzyArea(){return this.fuzzyArea;}

        private List<String> rightFuzzyArea;

        public List<String> getRightFuzzyArea(){return this.rightFuzzyArea;}
        private List<String> priceList;

        public List<String> getPriceList(){return this.priceList;}


        private List<String> fuzzyPrice;

        public List<String> getFuzzyPrice(){return this.fuzzyPrice;}

        private List<String> rightFuzzyPrice;

        public List<String> getRightFuzzyPrice(){return this.rightFuzzyPrice;}
        private List<String> numberList;

        public List<String> getNumberList(){return this.numberList;}


        private List<String> fuzzyNumber;

        public List<String> getFuzzyNumber(){return this.fuzzyNumber;}

        private List<String> rightFuzzyNumber;

        public List<String> getRightFuzzyNumber(){return this.rightFuzzyNumber;}
        private List<String> orientedList;

        public List<String> getOrientedList(){return this.orientedList;}


        private List<String> fuzzyOriented;

        public List<String> getFuzzyOriented(){return this.fuzzyOriented;}

        private List<String> rightFuzzyOriented;

        public List<String> getRightFuzzyOriented(){return this.rightFuzzyOriented;}
        private List<String> houseTypeList;

        public List<String> getHouseTypeList(){return this.houseTypeList;}


        private List<String> fuzzyHouseType;

        public List<String> getFuzzyHouseType(){return this.fuzzyHouseType;}

        private List<String> rightFuzzyHouseType;

        public List<String> getRightFuzzyHouseType(){return this.rightFuzzyHouseType;}
        private List<String> introductionList;

        public List<String> getIntroductionList(){return this.introductionList;}


        private List<String> fuzzyIntroduction;

        public List<String> getFuzzyIntroduction(){return this.fuzzyIntroduction;}

        private List<String> rightFuzzyIntroduction;

        public List<String> getRightFuzzyIntroduction(){return this.rightFuzzyIntroduction;}
        private List<String> wechatList;

        public List<String> getWechatList(){return this.wechatList;}


        private List<String> fuzzyWechat;

        public List<String> getFuzzyWechat(){return this.fuzzyWechat;}

        private List<String> rightFuzzyWechat;

        public List<String> getRightFuzzyWechat(){return this.rightFuzzyWechat;}
        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder idBetWeen(Integer idSt,Integer idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public QueryBuilder idGreaterEqThan(Integer idSt){
            this.idSt = idSt;
            return this;
        }
        public QueryBuilder idLessEqThan(Integer idEd){
            this.idEd = idEd;
            return this;
        }


        public QueryBuilder id(Integer id){
            setId(id);
            return this;
        }

        public QueryBuilder idList(Integer ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public QueryBuilder idList(List<Integer> id){
            this.idList = id;
            return this;
        }

        public QueryBuilder fetchId(){
            setFetchFields("fetchFields","id");
            return this;
        }

        public QueryBuilder excludeId(){
            setFetchFields("excludeFields","id");
            return this;
        }

        public QueryBuilder fuzzyEmail (List<String> fuzzyEmail){
            this.fuzzyEmail = fuzzyEmail;
            return this;
        }

        public QueryBuilder fuzzyEmail (String ... fuzzyEmail){
            this.fuzzyEmail = solveNullList(fuzzyEmail);
            return this;
        }

        public QueryBuilder rightFuzzyEmail (List<String> rightFuzzyEmail){
            this.rightFuzzyEmail = rightFuzzyEmail;
            return this;
        }

        public QueryBuilder rightFuzzyEmail (String ... rightFuzzyEmail){
            this.rightFuzzyEmail = solveNullList(rightFuzzyEmail);
            return this;
        }

        public QueryBuilder email(String email){
            setEmail(email);
            return this;
        }

        public QueryBuilder emailList(String ... email){
            this.emailList = solveNullList(email);
            return this;
        }

        public QueryBuilder emailList(List<String> email){
            this.emailList = email;
            return this;
        }

        public QueryBuilder fetchEmail(){
            setFetchFields("fetchFields","email");
            return this;
        }

        public QueryBuilder excludeEmail(){
            setFetchFields("excludeFields","email");
            return this;
        }

        public QueryBuilder fuzzyName (List<String> fuzzyName){
            this.fuzzyName = fuzzyName;
            return this;
        }

        public QueryBuilder fuzzyName (String ... fuzzyName){
            this.fuzzyName = solveNullList(fuzzyName);
            return this;
        }

        public QueryBuilder rightFuzzyName (List<String> rightFuzzyName){
            this.rightFuzzyName = rightFuzzyName;
            return this;
        }

        public QueryBuilder rightFuzzyName (String ... rightFuzzyName){
            this.rightFuzzyName = solveNullList(rightFuzzyName);
            return this;
        }

        public QueryBuilder name(String name){
            setName(name);
            return this;
        }

        public QueryBuilder nameList(String ... name){
            this.nameList = solveNullList(name);
            return this;
        }

        public QueryBuilder nameList(List<String> name){
            this.nameList = name;
            return this;
        }

        public QueryBuilder fetchName(){
            setFetchFields("fetchFields","name");
            return this;
        }

        public QueryBuilder excludeName(){
            setFetchFields("excludeFields","name");
            return this;
        }

        public QueryBuilder fuzzyRname (List<String> fuzzyRname){
            this.fuzzyRname = fuzzyRname;
            return this;
        }

        public QueryBuilder fuzzyRname (String ... fuzzyRname){
            this.fuzzyRname = solveNullList(fuzzyRname);
            return this;
        }

        public QueryBuilder rightFuzzyRname (List<String> rightFuzzyRname){
            this.rightFuzzyRname = rightFuzzyRname;
            return this;
        }

        public QueryBuilder rightFuzzyRname (String ... rightFuzzyRname){
            this.rightFuzzyRname = solveNullList(rightFuzzyRname);
            return this;
        }

        public QueryBuilder rname(String rname){
            setRname(rname);
            return this;
        }

        public QueryBuilder rnameList(String ... rname){
            this.rnameList = solveNullList(rname);
            return this;
        }

        public QueryBuilder rnameList(List<String> rname){
            this.rnameList = rname;
            return this;
        }

        public QueryBuilder fetchRname(){
            setFetchFields("fetchFields","rname");
            return this;
        }

        public QueryBuilder excludeRname(){
            setFetchFields("excludeFields","rname");
            return this;
        }

        public QueryBuilder fuzzyLocation (List<String> fuzzyLocation){
            this.fuzzyLocation = fuzzyLocation;
            return this;
        }

        public QueryBuilder fuzzyLocation (String ... fuzzyLocation){
            this.fuzzyLocation = solveNullList(fuzzyLocation);
            return this;
        }

        public QueryBuilder rightFuzzyLocation (List<String> rightFuzzyLocation){
            this.rightFuzzyLocation = rightFuzzyLocation;
            return this;
        }

        public QueryBuilder rightFuzzyLocation (String ... rightFuzzyLocation){
            this.rightFuzzyLocation = solveNullList(rightFuzzyLocation);
            return this;
        }

        public QueryBuilder location(String location){
            setLocation(location);
            return this;
        }

        public QueryBuilder locationList(String ... location){
            this.locationList = solveNullList(location);
            return this;
        }

        public QueryBuilder locationList(List<String> location){
            this.locationList = location;
            return this;
        }

        public QueryBuilder fetchLocation(){
            setFetchFields("fetchFields","location");
            return this;
        }

        public QueryBuilder excludeLocation(){
            setFetchFields("excludeFields","location");
            return this;
        }

        public QueryBuilder fuzzyArea (List<String> fuzzyArea){
            this.fuzzyArea = fuzzyArea;
            return this;
        }

        public QueryBuilder fuzzyArea (String ... fuzzyArea){
            this.fuzzyArea = solveNullList(fuzzyArea);
            return this;
        }

        public QueryBuilder rightFuzzyArea (List<String> rightFuzzyArea){
            this.rightFuzzyArea = rightFuzzyArea;
            return this;
        }

        public QueryBuilder rightFuzzyArea (String ... rightFuzzyArea){
            this.rightFuzzyArea = solveNullList(rightFuzzyArea);
            return this;
        }

        public QueryBuilder area(int area){
            setArea(area);
            return this;
        }

        public QueryBuilder areaList(String ... area){
            this.areaList = solveNullList(area);
            return this;
        }

        public QueryBuilder areaList(List<String> area){
            this.areaList = area;
            return this;
        }

        public QueryBuilder fetchArea(){
            setFetchFields("fetchFields","area");
            return this;
        }

        public QueryBuilder excludeArea(){
            setFetchFields("excludeFields","area");
            return this;
        }

        public QueryBuilder fuzzyPrice (List<String> fuzzyPrice){
            this.fuzzyPrice = fuzzyPrice;
            return this;
        }

        public QueryBuilder fuzzyPrice (String ... fuzzyPrice){
            this.fuzzyPrice = solveNullList(fuzzyPrice);
            return this;
        }

        public QueryBuilder rightFuzzyPrice (List<String> rightFuzzyPrice){
            this.rightFuzzyPrice = rightFuzzyPrice;
            return this;
        }

        public QueryBuilder rightFuzzyPrice (String ... rightFuzzyPrice){
            this.rightFuzzyPrice = solveNullList(rightFuzzyPrice);
            return this;
        }

        public QueryBuilder price(int price){
            setPrice(price);
            return this;
        }

        public QueryBuilder priceList(String ... price){
            this.priceList = solveNullList(price);
            return this;
        }

        public QueryBuilder priceList(List<String> price){
            this.priceList = price;
            return this;
        }

        public QueryBuilder fetchPrice(){
            setFetchFields("fetchFields","price");
            return this;
        }

        public QueryBuilder excludePrice(){
            setFetchFields("excludeFields","price");
            return this;
        }

        public QueryBuilder fuzzyNumber (List<String> fuzzyNumber){
            this.fuzzyNumber = fuzzyNumber;
            return this;
        }

        public QueryBuilder fuzzyNumber (String ... fuzzyNumber){
            this.fuzzyNumber = solveNullList(fuzzyNumber);
            return this;
        }

        public QueryBuilder rightFuzzyNumber (List<String> rightFuzzyNumber){
            this.rightFuzzyNumber = rightFuzzyNumber;
            return this;
        }

        public QueryBuilder rightFuzzyNumber (String ... rightFuzzyNumber){
            this.rightFuzzyNumber = solveNullList(rightFuzzyNumber);
            return this;
        }

        public QueryBuilder number(String number){
            setNumber(number);
            return this;
        }

        public QueryBuilder numberList(String ... number){
            this.numberList = solveNullList(number);
            return this;
        }

        public QueryBuilder numberList(List<String> number){
            this.numberList = number;
            return this;
        }

        public QueryBuilder fetchNumber(){
            setFetchFields("fetchFields","number");
            return this;
        }

        public QueryBuilder excludeNumber(){
            setFetchFields("excludeFields","number");
            return this;
        }

        public QueryBuilder fuzzyOriented (List<String> fuzzyOriented){
            this.fuzzyOriented = fuzzyOriented;
            return this;
        }

        public QueryBuilder fuzzyOriented (String ... fuzzyOriented){
            this.fuzzyOriented = solveNullList(fuzzyOriented);
            return this;
        }

        public QueryBuilder rightFuzzyOriented (List<String> rightFuzzyOriented){
            this.rightFuzzyOriented = rightFuzzyOriented;
            return this;
        }

        public QueryBuilder rightFuzzyOriented (String ... rightFuzzyOriented){
            this.rightFuzzyOriented = solveNullList(rightFuzzyOriented);
            return this;
        }

        public QueryBuilder oriented(String oriented){
            setOriented(oriented);
            return this;
        }

        public QueryBuilder orientedList(String ... oriented){
            this.orientedList = solveNullList(oriented);
            return this;
        }

        public QueryBuilder orientedList(List<String> oriented){
            this.orientedList = oriented;
            return this;
        }

        public QueryBuilder fetchOriented(){
            setFetchFields("fetchFields","oriented");
            return this;
        }

        public QueryBuilder excludeOriented(){
            setFetchFields("excludeFields","oriented");
            return this;
        }

        public QueryBuilder fuzzyHouseType (List<String> fuzzyHouseType){
            this.fuzzyHouseType = fuzzyHouseType;
            return this;
        }

        public QueryBuilder fuzzyHouseType (String ... fuzzyHouseType){
            this.fuzzyHouseType = solveNullList(fuzzyHouseType);
            return this;
        }

        public QueryBuilder rightFuzzyHouseType (List<String> rightFuzzyHouseType){
            this.rightFuzzyHouseType = rightFuzzyHouseType;
            return this;
        }

        public QueryBuilder rightFuzzyHouseType (String ... rightFuzzyHouseType){
            this.rightFuzzyHouseType = solveNullList(rightFuzzyHouseType);
            return this;
        }

        public QueryBuilder houseType(String houseType){
            setHouseType(houseType);
            return this;
        }

        public QueryBuilder houseTypeList(String ... houseType){
            this.houseTypeList = solveNullList(houseType);
            return this;
        }

        public QueryBuilder houseTypeList(List<String> houseType){
            this.houseTypeList = houseType;
            return this;
        }

        public QueryBuilder fetchHouseType(){
            setFetchFields("fetchFields","houseType");
            return this;
        }

        public QueryBuilder excludeHouseType(){
            setFetchFields("excludeFields","houseType");
            return this;
        }

        public QueryBuilder fuzzyIntroduction (List<String> fuzzyIntroduction){
            this.fuzzyIntroduction = fuzzyIntroduction;
            return this;
        }

        public QueryBuilder fuzzyIntroduction (String ... fuzzyIntroduction){
            this.fuzzyIntroduction = solveNullList(fuzzyIntroduction);
            return this;
        }

        public QueryBuilder rightFuzzyIntroduction (List<String> rightFuzzyIntroduction){
            this.rightFuzzyIntroduction = rightFuzzyIntroduction;
            return this;
        }

        public QueryBuilder rightFuzzyIntroduction (String ... rightFuzzyIntroduction){
            this.rightFuzzyIntroduction = solveNullList(rightFuzzyIntroduction);
            return this;
        }

        public QueryBuilder introduction(String introduction){
            setIntroduction(introduction);
            return this;
        }

        public QueryBuilder introductionList(String ... introduction){
            this.introductionList = solveNullList(introduction);
            return this;
        }

        public QueryBuilder introductionList(List<String> introduction){
            this.introductionList = introduction;
            return this;
        }

        public QueryBuilder fetchIntroduction(){
            setFetchFields("fetchFields","introduction");
            return this;
        }

        public QueryBuilder excludeIntroduction(){
            setFetchFields("excludeFields","introduction");
            return this;
        }

        public QueryBuilder fuzzyWechat (List<String> fuzzyWechat){
            this.fuzzyWechat = fuzzyWechat;
            return this;
        }

        public QueryBuilder fuzzyWechat (String ... fuzzyWechat){
            this.fuzzyWechat = solveNullList(fuzzyWechat);
            return this;
        }

        public QueryBuilder rightFuzzyWechat (List<String> rightFuzzyWechat){
            this.rightFuzzyWechat = rightFuzzyWechat;
            return this;
        }

        public QueryBuilder rightFuzzyWechat (String ... rightFuzzyWechat){
            this.rightFuzzyWechat = solveNullList(rightFuzzyWechat);
            return this;
        }

        public QueryBuilder wechat(String wechat){
            setWechat(wechat);
            return this;
        }

        public QueryBuilder wechatList(String ... wechat){
            this.wechatList = solveNullList(wechat);
            return this;
        }

        public QueryBuilder wechatList(List<String> wechat){
            this.wechatList = wechat;
            return this;
        }

        public QueryBuilder fetchWechat(){
            setFetchFields("fetchFields","wechat");
            return this;
        }

        public QueryBuilder excludeWechat(){
            setFetchFields("excludeFields","wechat");
            return this;
        }
        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
                List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public RentalHouse build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<String> emailList;

        public List<String> getEmailList(){return this.emailList;}


        private List<String> fuzzyEmail;

        public List<String> getFuzzyEmail(){return this.fuzzyEmail;}

        private List<String> rightFuzzyEmail;

        public List<String> getRightFuzzyEmail(){return this.rightFuzzyEmail;}
        private List<String> nameList;

        public List<String> getNameList(){return this.nameList;}


        private List<String> fuzzyName;

        public List<String> getFuzzyName(){return this.fuzzyName;}

        private List<String> rightFuzzyName;

        public List<String> getRightFuzzyName(){return this.rightFuzzyName;}
        private List<String> rnameList;

        public List<String> getRnameList(){return this.rnameList;}


        private List<String> fuzzyRname;

        public List<String> getFuzzyRname(){return this.fuzzyRname;}

        private List<String> rightFuzzyRname;

        public List<String> getRightFuzzyRname(){return this.rightFuzzyRname;}
        private List<String> locationList;

        public List<String> getLocationList(){return this.locationList;}


        private List<String> fuzzyLocation;

        public List<String> getFuzzyLocation(){return this.fuzzyLocation;}

        private List<String> rightFuzzyLocation;

        public List<String> getRightFuzzyLocation(){return this.rightFuzzyLocation;}
        private List<String> areaList;

        public List<String> getAreaList(){return this.areaList;}


        private List<String> fuzzyArea;

        public List<String> getFuzzyArea(){return this.fuzzyArea;}

        private List<String> rightFuzzyArea;

        public List<String> getRightFuzzyArea(){return this.rightFuzzyArea;}
        private List<String> priceList;

        public List<String> getPriceList(){return this.priceList;}


        private List<String> fuzzyPrice;

        public List<String> getFuzzyPrice(){return this.fuzzyPrice;}

        private List<String> rightFuzzyPrice;

        public List<String> getRightFuzzyPrice(){return this.rightFuzzyPrice;}
        private List<String> numberList;

        public List<String> getNumberList(){return this.numberList;}


        private List<String> fuzzyNumber;

        public List<String> getFuzzyNumber(){return this.fuzzyNumber;}

        private List<String> rightFuzzyNumber;

        public List<String> getRightFuzzyNumber(){return this.rightFuzzyNumber;}
        private List<String> orientedList;

        public List<String> getOrientedList(){return this.orientedList;}


        private List<String> fuzzyOriented;

        public List<String> getFuzzyOriented(){return this.fuzzyOriented;}

        private List<String> rightFuzzyOriented;

        public List<String> getRightFuzzyOriented(){return this.rightFuzzyOriented;}
        private List<String> houseTypeList;

        public List<String> getHouseTypeList(){return this.houseTypeList;}


        private List<String> fuzzyHouseType;

        public List<String> getFuzzyHouseType(){return this.fuzzyHouseType;}

        private List<String> rightFuzzyHouseType;

        public List<String> getRightFuzzyHouseType(){return this.rightFuzzyHouseType;}
        private List<String> introductionList;

        public List<String> getIntroductionList(){return this.introductionList;}


        private List<String> fuzzyIntroduction;

        public List<String> getFuzzyIntroduction(){return this.fuzzyIntroduction;}

        private List<String> rightFuzzyIntroduction;

        public List<String> getRightFuzzyIntroduction(){return this.rightFuzzyIntroduction;}
        private List<String> wechatList;

        public List<String> getWechatList(){return this.wechatList;}


        private List<String> fuzzyWechat;

        public List<String> getFuzzyWechat(){return this.fuzzyWechat;}

        private List<String> rightFuzzyWechat;

        public List<String> getRightFuzzyWechat(){return this.rightFuzzyWechat;}

        public ConditionBuilder idBetWeen(Integer idSt,Integer idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public ConditionBuilder idGreaterEqThan(Integer idSt){
            this.idSt = idSt;
            return this;
        }
        public ConditionBuilder idLessEqThan(Integer idEd){
            this.idEd = idEd;
            return this;
        }


        public ConditionBuilder idList(Integer ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public ConditionBuilder idList(List<Integer> id){
            this.idList = id;
            return this;
        }

        public ConditionBuilder fuzzyEmail (List<String> fuzzyEmail){
            this.fuzzyEmail = fuzzyEmail;
            return this;
        }

        public ConditionBuilder fuzzyEmail (String ... fuzzyEmail){
            this.fuzzyEmail = solveNullList(fuzzyEmail);
            return this;
        }

        public ConditionBuilder rightFuzzyEmail (List<String> rightFuzzyEmail){
            this.rightFuzzyEmail = rightFuzzyEmail;
            return this;
        }

        public ConditionBuilder rightFuzzyEmail (String ... rightFuzzyEmail){
            this.rightFuzzyEmail = solveNullList(rightFuzzyEmail);
            return this;
        }

        public ConditionBuilder emailList(String ... email){
            this.emailList = solveNullList(email);
            return this;
        }

        public ConditionBuilder emailList(List<String> email){
            this.emailList = email;
            return this;
        }

        public ConditionBuilder fuzzyName (List<String> fuzzyName){
            this.fuzzyName = fuzzyName;
            return this;
        }

        public ConditionBuilder fuzzyName (String ... fuzzyName){
            this.fuzzyName = solveNullList(fuzzyName);
            return this;
        }

        public ConditionBuilder rightFuzzyName (List<String> rightFuzzyName){
            this.rightFuzzyName = rightFuzzyName;
            return this;
        }

        public ConditionBuilder rightFuzzyName (String ... rightFuzzyName){
            this.rightFuzzyName = solveNullList(rightFuzzyName);
            return this;
        }

        public ConditionBuilder nameList(String ... name){
            this.nameList = solveNullList(name);
            return this;
        }

        public ConditionBuilder nameList(List<String> name){
            this.nameList = name;
            return this;
        }

        public ConditionBuilder fuzzyRname (List<String> fuzzyRname){
            this.fuzzyRname = fuzzyRname;
            return this;
        }

        public ConditionBuilder fuzzyRname (String ... fuzzyRname){
            this.fuzzyRname = solveNullList(fuzzyRname);
            return this;
        }

        public ConditionBuilder rightFuzzyRname (List<String> rightFuzzyRname){
            this.rightFuzzyRname = rightFuzzyRname;
            return this;
        }

        public ConditionBuilder rightFuzzyRname (String ... rightFuzzyRname){
            this.rightFuzzyRname = solveNullList(rightFuzzyRname);
            return this;
        }

        public ConditionBuilder rnameList(String ... rname){
            this.rnameList = solveNullList(rname);
            return this;
        }

        public ConditionBuilder rnameList(List<String> rname){
            this.rnameList = rname;
            return this;
        }

        public ConditionBuilder fuzzyLocation (List<String> fuzzyLocation){
            this.fuzzyLocation = fuzzyLocation;
            return this;
        }

        public ConditionBuilder fuzzyLocation (String ... fuzzyLocation){
            this.fuzzyLocation = solveNullList(fuzzyLocation);
            return this;
        }

        public ConditionBuilder rightFuzzyLocation (List<String> rightFuzzyLocation){
            this.rightFuzzyLocation = rightFuzzyLocation;
            return this;
        }

        public ConditionBuilder rightFuzzyLocation (String ... rightFuzzyLocation){
            this.rightFuzzyLocation = solveNullList(rightFuzzyLocation);
            return this;
        }

        public ConditionBuilder locationList(String ... location){
            this.locationList = solveNullList(location);
            return this;
        }

        public ConditionBuilder locationList(List<String> location){
            this.locationList = location;
            return this;
        }

        public ConditionBuilder fuzzyArea (List<String> fuzzyArea){
            this.fuzzyArea = fuzzyArea;
            return this;
        }

        public ConditionBuilder fuzzyArea (String ... fuzzyArea){
            this.fuzzyArea = solveNullList(fuzzyArea);
            return this;
        }

        public ConditionBuilder rightFuzzyArea (List<String> rightFuzzyArea){
            this.rightFuzzyArea = rightFuzzyArea;
            return this;
        }

        public ConditionBuilder rightFuzzyArea (String ... rightFuzzyArea){
            this.rightFuzzyArea = solveNullList(rightFuzzyArea);
            return this;
        }

        public ConditionBuilder areaList(String ... area){
            this.areaList = solveNullList(area);
            return this;
        }

        public ConditionBuilder areaList(List<String> area){
            this.areaList = area;
            return this;
        }

        public ConditionBuilder fuzzyPrice (List<String> fuzzyPrice){
            this.fuzzyPrice = fuzzyPrice;
            return this;
        }

        public ConditionBuilder fuzzyPrice (String ... fuzzyPrice){
            this.fuzzyPrice = solveNullList(fuzzyPrice);
            return this;
        }

        public ConditionBuilder rightFuzzyPrice (List<String> rightFuzzyPrice){
            this.rightFuzzyPrice = rightFuzzyPrice;
            return this;
        }

        public ConditionBuilder rightFuzzyPrice (String ... rightFuzzyPrice){
            this.rightFuzzyPrice = solveNullList(rightFuzzyPrice);
            return this;
        }

        public ConditionBuilder priceList(String ... price){
            this.priceList = solveNullList(price);
            return this;
        }

        public ConditionBuilder priceList(List<String> price){
            this.priceList = price;
            return this;
        }

        public ConditionBuilder fuzzyNumber (List<String> fuzzyNumber){
            this.fuzzyNumber = fuzzyNumber;
            return this;
        }

        public ConditionBuilder fuzzyNumber (String ... fuzzyNumber){
            this.fuzzyNumber = solveNullList(fuzzyNumber);
            return this;
        }

        public ConditionBuilder rightFuzzyNumber (List<String> rightFuzzyNumber){
            this.rightFuzzyNumber = rightFuzzyNumber;
            return this;
        }

        public ConditionBuilder rightFuzzyNumber (String ... rightFuzzyNumber){
            this.rightFuzzyNumber = solveNullList(rightFuzzyNumber);
            return this;
        }

        public ConditionBuilder numberList(String ... number){
            this.numberList = solveNullList(number);
            return this;
        }

        public ConditionBuilder numberList(List<String> number){
            this.numberList = number;
            return this;
        }

        public ConditionBuilder fuzzyOriented (List<String> fuzzyOriented){
            this.fuzzyOriented = fuzzyOriented;
            return this;
        }

        public ConditionBuilder fuzzyOriented (String ... fuzzyOriented){
            this.fuzzyOriented = solveNullList(fuzzyOriented);
            return this;
        }

        public ConditionBuilder rightFuzzyOriented (List<String> rightFuzzyOriented){
            this.rightFuzzyOriented = rightFuzzyOriented;
            return this;
        }

        public ConditionBuilder rightFuzzyOriented (String ... rightFuzzyOriented){
            this.rightFuzzyOriented = solveNullList(rightFuzzyOriented);
            return this;
        }

        public ConditionBuilder orientedList(String ... oriented){
            this.orientedList = solveNullList(oriented);
            return this;
        }

        public ConditionBuilder orientedList(List<String> oriented){
            this.orientedList = oriented;
            return this;
        }

        public ConditionBuilder fuzzyHouseType (List<String> fuzzyHouseType){
            this.fuzzyHouseType = fuzzyHouseType;
            return this;
        }

        public ConditionBuilder fuzzyHouseType (String ... fuzzyHouseType){
            this.fuzzyHouseType = solveNullList(fuzzyHouseType);
            return this;
        }

        public ConditionBuilder rightFuzzyHouseType (List<String> rightFuzzyHouseType){
            this.rightFuzzyHouseType = rightFuzzyHouseType;
            return this;
        }

        public ConditionBuilder rightFuzzyHouseType (String ... rightFuzzyHouseType){
            this.rightFuzzyHouseType = solveNullList(rightFuzzyHouseType);
            return this;
        }

        public ConditionBuilder houseTypeList(String ... houseType){
            this.houseTypeList = solveNullList(houseType);
            return this;
        }

        public ConditionBuilder houseTypeList(List<String> houseType){
            this.houseTypeList = houseType;
            return this;
        }

        public ConditionBuilder fuzzyIntroduction (List<String> fuzzyIntroduction){
            this.fuzzyIntroduction = fuzzyIntroduction;
            return this;
        }

        public ConditionBuilder fuzzyIntroduction (String ... fuzzyIntroduction){
            this.fuzzyIntroduction = solveNullList(fuzzyIntroduction);
            return this;
        }

        public ConditionBuilder rightFuzzyIntroduction (List<String> rightFuzzyIntroduction){
            this.rightFuzzyIntroduction = rightFuzzyIntroduction;
            return this;
        }

        public ConditionBuilder rightFuzzyIntroduction (String ... rightFuzzyIntroduction){
            this.rightFuzzyIntroduction = solveNullList(rightFuzzyIntroduction);
            return this;
        }

        public ConditionBuilder introductionList(String ... introduction){
            this.introductionList = solveNullList(introduction);
            return this;
        }

        public ConditionBuilder introductionList(List<String> introduction){
            this.introductionList = introduction;
            return this;
        }

        public ConditionBuilder fuzzyWechat (List<String> fuzzyWechat){
            this.fuzzyWechat = fuzzyWechat;
            return this;
        }

        public ConditionBuilder fuzzyWechat (String ... fuzzyWechat){
            this.fuzzyWechat = solveNullList(fuzzyWechat);
            return this;
        }

        public ConditionBuilder rightFuzzyWechat (List<String> rightFuzzyWechat){
            this.rightFuzzyWechat = rightFuzzyWechat;
            return this;
        }

        public ConditionBuilder rightFuzzyWechat (String ... rightFuzzyWechat){
            this.rightFuzzyWechat = solveNullList(rightFuzzyWechat);
            return this;
        }

        public ConditionBuilder wechatList(String ... wechat){
            this.wechatList = solveNullList(wechat);
            return this;
        }

        public ConditionBuilder wechatList(List<String> wechat){
            this.wechatList = wechat;
            return this;
        }

        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
                List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public ConditionBuilder build(){return this;}
    }

    public static class Builder {

        private RentalHouse obj;

        public Builder(){
            this.obj = new RentalHouse();
        }

        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Builder email(String email){
            this.obj.setEmail(email);
            return this;
        }
        public Builder name(String name){
            this.obj.setName(name);
            return this;
        }
        public Builder rname(String rname){
            this.obj.setRname(rname);
            return this;
        }
        public Builder location(String location){
            this.obj.setLocation(location);
            return this;
        }
        public Builder area(int area){
            this.obj.setArea(area);
            return this;
        }
        public Builder price(int price){
            this.obj.setPrice(price);
            return this;
        }
        public Builder number(String number){
            this.obj.setNumber(number);
            return this;
        }
        public Builder oriented(String oriented){
            this.obj.setOriented(oriented);
            return this;
        }
        public Builder houseType(String houseType){
            this.obj.setHouseType(houseType);
            return this;
        }
        public Builder introduction(String introduction){
            this.obj.setIntroduction(introduction);
            return this;
        }
        public Builder wechat(String wechat){
            this.obj.setWechat(wechat);
            return this;
        }
        public RentalHouse build(){return obj;}
    }

}
