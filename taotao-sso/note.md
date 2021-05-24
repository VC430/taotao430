# 单点登录模块
这个工程是个pom（聚合）工程，包含两个子模块，taotao-sso-interface、taotao-sso-service。


## 判断用户数据是否合法
Service层 ：UserServiceImpl.TaotaoResult checkUserData(String data, int type);
Controller层 :UserController

## 单点登录用户注册
Service层 ：UserServiceImpl.TaotaoResult register(TbUser tbUser);
Controller层 : UserController.register

## 没有把用户登录信息存在session当中，而是存放到了Redis当中

## 登录
Service层 ：在UserService接口类中添加登录接口，UserServiceImpl类来实现添加的登录接口
Controller层 :
把token保存到cookie当中，为了方便的操作cookie，封装一个工具类，由于该工具类有可能被多个服务使用，因此把该工具类放到utils

## 通过token获取用户信息
UserServiceImpl类中实现getUserByToken方法
## 安全退出
在UserService接口类中添加安全退出的接口 TaotaoResult logout(String token);
UserServiceImpl类中实现logout接口