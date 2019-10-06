# Rental-house
2019暑期综合实训，出租屋管理系统
## API 文档

1. 用户登录，返回用户身份
类型：get
接口：/login

2. 用户注册
类型：post
接口：/register

3. 删除出租屋信息
类型：post
接口：/deleteRentalHouseById

4. 列出所有出租屋的信息
类型：get
接口：/getRentalHouseList

5. 根据email列出出租屋的信息
类型：get
接口：/getRentalHouseByEmail

6. 添加出租屋信息
类型：post
接口：/addRentalHouse

7. 更新出租屋信息
类型：post
接口：/updateRentalHouse

8. 根据价格范围列出出租屋信息
类型：get
接口：/getRentalHouseByPrice

9. 根据价格范围列出出租屋信息
类型：get
接口：/getRentalHouseByPrice1

10. 根据位置列出出租屋信息
类型：get
接口：/getRentalHouseByLocation

11. 根据面积范围列出出租屋信息
类型：get
接口：/getRentalHouseByArea

12. 根据Id显示出租屋信息
类型：get
接口：/getRentalHouseById

13. 泛式搜索
类型：get
接口：/getRentalHouseByGeneric

14. 房客更新出租屋状态：未出租——待审核
类型：post
接口：/updateRentalHouseState1

15. 房东更新出租屋状态：待审核——已出租
类型：post
接口：/updateRentalHouseState2

16. 房客获取申请过的出租屋信息
类型：get
接口：/getRentalHouseToTenant

17. 房东获取被申请过的出租屋信息
类型：get
接口：/getRentalHouseToLandlord

18. 房客取消申请,更新出租屋状态：待审核——未出租
类型：post
接口：/cancelRentalHouseState1

19. 房主拒绝申请,更新出租屋状态：待审核——审核失败
类型：post
接口：/cancelRentalHouseState2

20. 通过email获取用户信息:
类型：get
接口：/getUserByEmail
前端：email   
后台：json串的user

21. 通过email更改用户信息
类型：get
接口：/updateByEmail
前端：String email,String password,String name,
     String number,String nickname,String hobby,
     String wechat,String type,String ID
后台：boolean

22. 上传文件
类型：put
接口：/uploadHead
前端：MultipartFile
后台：url

23. 用户登陆
类型：get
接口：/login
前端：String email, String password
后台：json串的identity

24. 读取文件
类型：无
接口："avatar/{name:.+}"
前端：文件名
