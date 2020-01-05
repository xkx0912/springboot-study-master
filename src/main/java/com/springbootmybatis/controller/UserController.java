package com.springbootmybatis.controller;

import com.springbootmybatis.empty.UserEmpty;
import com.springbootmybatis.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xkx on 2019/3/9.
 */
@RestController
@RequestMapping("/user")
public class UserController{

    // 主日志
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    // 自定义日志(oneInfo)
    private final static Logger oneInfoLogger = LoggerFactory.getLogger("oneInfo");

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getUserEmpty/{id}")
    @ApiIgnore // swagger 忽略这个接口  用来做跳转jsp页面的
    public Object getUserEmpty(@PathVariable(name = "id") Integer id){
        ModelAndView modelAndView = new ModelAndView("index");
        Map map = new HashMap();
        UserEmpty userEmpty = userService.getUserEmpty(id);
        map.put("id",userEmpty.getId());
        map.put("name",userEmpty.getUserName());
        map.put("password",userEmpty.getUserPassword());
        map.put("createTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(userEmpty.getCreateTime()));
        modelAndView.addObject("map",map);
        modelAndView.addObject("user",userEmpty);
        return modelAndView;
    }

    @GetMapping(value = "/getByUserName/{userName}")
    @ApiOperation(value="根据用户名查询用户", notes="根据用户名查询用户")
    @ApiIgnore // swagger 忽略这个接口(便于其他接口测试)
    public Object getByUserName(HttpServletRequest request, HttpServletResponse response,@PathVariable("userName") String userName){
       // String userName = request.getParameter("userName");
        logger.debug("记录debug日志");
        logger.info("访问了index方法(INFO日志 )");
        logger.error("记录了error错误日志");

        oneInfoLogger.debug("oneInfoLogger记录debug日志");
        oneInfoLogger.info("oneInfoLogger访问了index方法(INFO日志 )");
        oneInfoLogger.error("oneInfoLogger记录了error错误日志");
        return userService.getByUserName(userName);
    }

    @GetMapping(value = "/db2/auto/{id}")
    @ApiOperation(value="根据用户ID查询用户[DB1数据源](mybatisplusz封装方法查询)", notes="根据用户ID查询用户[DB1数据源]")
    public UserEmpty getUserAutoById2(HttpServletRequest request, HttpServletResponse response,
                                         @PathVariable("id") long id){
        return userService.getUserAutoByIdDB1(id);
    }

    @GetMapping(value = "/db2/{id}")
    @ApiOperation(value="根据用户ID查询用户[DB1数据源](mapper.xml中查询)", notes="根据用户ID查询用户[DB1数据源]")
    public UserEmpty getUserById2(HttpServletRequest request, HttpServletResponse response,
                                     @PathVariable("id") long id){
        return userService.getUserByIdDB1(id);
    }
}
