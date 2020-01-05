package com.springbootmybatis.controller;

import com.springbootmybatis.empty.TeacherEmpty;
import com.springbootmybatis.empty.UserEmpty;
import com.springbootmybatis.service.TeacherService;
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
@RequestMapping("/teacher")
public class TeacherController {

    // 主日志
    private final static Logger logger = LoggerFactory.getLogger(TeacherController.class);

    // 自定义日志(oneInfo)
    private final static Logger oneInfoLogger = LoggerFactory.getLogger("oneInfo");

    @Autowired
    private TeacherService teacherService;

    @GetMapping(value = "/db2/{id}")
    @ApiOperation(value="根据用户ID查询用户[DB2数据源]", notes="根据用户ID查询用户[DB2ddddd数据源]")
    @ResponseBody
    public TeacherEmpty getUserById2(HttpServletRequest request, HttpServletResponse response,
                                     @PathVariable("id") long id){
        return teacherService.getUserByIdDB2(id);
    }
}
