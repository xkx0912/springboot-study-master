package com.springbootmybatis.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springbootmybatis.annotation.DataSource;
import com.springbootmybatis.common.enums.DataSourceEnum;
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

    /**
     * 根据数据源不同  查询不同的数据库数据(DB1数据源)(plus中封装方法查询)
     * @param id
     * @return
     */
    public UserEmpty getUserAutoByIdDB1(long id) {
        return userMapper.selectById(id);
    }

    /**
     * 根据数据源不同  查询不同的数据库数据(DB1数据源)(mapper.xml文件中查询)
     * @param id
     * @return
     */
    public UserEmpty getUserByIdDB1(long id) {
        return userMapper.getUserById(id);
    }



    /**
     * 根据数据源不同  查询不同的数据库数据(DB2数据源)(plus中封装方法查询)
     * @param id
     * @return
     */
    @DataSource(DataSourceEnum.DB2)
    public UserEmpty getUserAutoByIdDB2(long id) {
        return userMapper.selectById(id);
    }

    /**
     * 根据数据源不同  查询不同的数据库数据(DB2数据源)(mapper.xml文件中查询)
     * @param id
     * @return
     */
    @DataSource(DataSourceEnum.DB2)
    public UserEmpty getUserByIdDB2(long id) {
        return userMapper.getUserById(id);
    }
}
