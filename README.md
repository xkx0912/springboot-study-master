#springboot-study-master

###springboot整合mybatis-plus 

###整合了简版的swagger接口测试

###支持跳转jsp、使用的是外部Tomcat启动

###2020/01/01:  
    实现全局异常的统一处理,可以对自定的异常以及系统异常进行大致分类处理;
    增加logback日志记录和归类;

###2020/01/05:  
     mybatis-plus druid整合多数据源切换（使用注解 无入侵）: 
         这里大大小小踩了好多坑，所幸一个一个都填上了。
         主要思想就是通过aop + 自定义注解 实现数据源切换，（过程是痛苦的，结果是美妙的）
         目前项目代码可以正常切换数据源使用。
    
###2020/02/06:  
    实现了使用MockMvc编写测试用例