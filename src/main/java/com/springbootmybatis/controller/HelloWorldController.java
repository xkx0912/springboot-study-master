package com.springbootmybatis.controller;

import com.springbootmybatis.common.enums.CommonEnum;
import com.springbootmybatis.common.exception.BizException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xkx on 2019/12/29.
 */
@RestController
@Api(value = "测试全局异常")
public class HelloWorldController {

    @ApiOperation(value="测试接口", notes="测试接口")
    @GetMapping("/hellow")
    public String hellow(@RequestParam("name") String name){
        return "hellow " + name;
    }

    @ApiOperation(value="自定义全局异常测试", notes="自定义全局异常测试")
    @GetMapping("/exception")
    public Boolean exceptionApi(@RequestParam("name") String name){
        if ("aaaa" == "aaaa"){
            throw new BizException(CommonEnum.SERVER_BUSY.getResultCode(), "服务器正忙");
        }
        return true;
    }

    @ApiOperation(value="空异常测试", notes="空异常")
    @GetMapping("/nullException")
    public Boolean nullException(){
        int i = 11/0;
        return true;
    }
}
