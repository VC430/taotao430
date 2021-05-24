# 内容管理

# 内容分类管理
进行类别的增删改查
taotao-content-interface 写相应的接口
taotao-content-service 写实现类
taotao-manager-web 实现controller层
taotao-manager-dao 对应的mysqlmapper

# 实现增删改查内容
taotao-content-interface 写相应的接口
taotao-content-service 写实现类
taotao-manager-web 实现controller层

# redis
在com.taotao.jedis.service下创建接口类JedisClient
然后在content-service下创建接口的两个实体类，一个单机，一个集群

applicationContext-jedis.xml配置集群信息
修改taotao-content-service工程下的ContentServiceImpl.java中的getContentListByCid方法,
首先查询缓存，如果缓存中存在的话，就直接将结果返回给前台展示，查询缓存不能影响业务流程

同时对增删改查都进行缓存