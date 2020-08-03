#### 一、搭建基本环境
***
* 导入数据库文件
* 创建JavaBean封装数据
* 整合Mybatis操作数据库
* 配置数据源信息
* 使用注解版的Mybatis

#### 二、快速体验缓存
***
* 开启启用注解的缓存@EnableCaching
* 标注注解即可
@Cacheable
@CacheEvict
@CachePut


#### 三、自定义缓存管理器

    /**
     * SpringBoot 1.0版本
     * @param redisTemplate
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager(RedisTemplate<Object, Employee> redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        //设置缓存过期时间
        cacheManager.setDefaultExpiration(10000);
        return cacheManager;
    }
    
 * 问题
 1、5 known properties: "lastName", "id", "email", "dId", "gender"]
 部门获取缓存时使用了员工缓存管理器
 
 2、@Primary 设置主管理器
 
 3、代码实现 注入缓存管理
    deptCacheManage.getCache("dept);
    dept.put("dept_1","1");
    @Quelifier 预选管理器
 
 
 
 
 
 
 
 
 
 
 
 
 
 