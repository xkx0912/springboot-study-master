package com.springbootmybatis.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springbootmybatis.empty.UserEmpty;
import com.springbootmybatis.mapperDao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xkx on 2019/3/9.
 */
@Service
public class UserService extends ServiceImpl<UserMapper,UserEmpty> {
    @Autowired
    private UserMapper userMapper;

    public UserEmpty getUserEmpty(Integer id){
        return userMapper.selectById(1);
    }

    public Object getByUserName(String userName) {
        return userMapper.selectByName(userName);
    }
}
