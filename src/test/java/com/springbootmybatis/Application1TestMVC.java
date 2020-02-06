package com.springbootmybatis;

import com.alibaba.fastjson.JSON;
import com.springbootmybatis.empty.UserEmpty;
import com.springbootmybatis.empty.option.UserOption;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by xkx on 2020/2/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // 注入MockMvc
@WebAppConfiguration
public class Application1TestMVC {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    /**
     *
     * @throws Exception
     * @功能描述  通过链接传值 ， 接受string 返回值
     */
    @Test
    public void testString() throws Exception {
        //准备请求url  不用带ip、端口、项目名称等 直接写接口的映射地址就可以了
        String url = "/user/db2/auto/1";

        /* 构建request 发送请求GET请求
         * MockMvcRequestBuilders 中有很多 请求方式。像get、post、put、delete等等
         */
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON)) // 断言返回结果是json
                .andReturn();// 得到返回结果

        MockHttpServletResponse response = mvcResult.getResponse();
        //拿到请求返回码
        int status = response.getStatus();
        //拿到结果
        String contentAsString = response.getContentAsString();

        System.err.println(status);
        System.err.println(contentAsString);
    }

    /**
     *
     * @throws Exception
     * @功能描述  传递post请求和 bean类型对象 ，接受 返回值
     */
    @Test
    public void postTest() throws Exception {
        // uri
        String uri = "/user/db2/save/user-option";

        UserOption userOption = new UserOption();
        userOption.setUserName("name3testsave");
        userOption.setUserPassword("pwd3testsave");

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(userOption))
                .accept(MediaType.APPLICATION_JSON)) // 断言返回结果是json
                .andReturn();// 得到返回结果

        MockHttpServletResponse response = mvcResult.getResponse();
        //拿到请求返回码
        int status = response.getStatus();
        //拿到结果
        String contentAsString = response.getContentAsString();

        System.err.println(status);
        System.err.println(contentAsString);
    }

}
