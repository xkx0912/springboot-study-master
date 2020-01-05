package com.springbootmybatis.mapperDao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springbootmybatis.empty.TeacherEmpty;
import com.springbootmybatis.empty.UserEmpty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xkx on 2019/3/9.
 */
@Mapper
public interface TeacherMapper extends BaseMapper<TeacherEmpty> {
    TeacherEmpty selectByName(@Param("userName") String userName);
}
