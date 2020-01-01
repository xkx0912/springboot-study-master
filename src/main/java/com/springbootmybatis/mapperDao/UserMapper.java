package com.springbootmybatis.mapperDao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springbootmybatis.empty.UserEmpty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xkx on 2019/3/9.
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEmpty> {
    UserEmpty selectByName(@Param("userName") String userName);
}
