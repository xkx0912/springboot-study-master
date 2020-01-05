package com.springbootmybatis.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springbootmybatis.empty.TeacherEmpty;
import com.springbootmybatis.mapperDao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xkx on 2019/3/9.
 */
@Service
public class TeacherService extends ServiceImpl<TeacherMapper,TeacherEmpty> {
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 根据数据源不同  查询不同的数据库数据(DB2数据源)
     * @param id
     * @return
     */
    public TeacherEmpty getUserByIdDB2(long id) {
        return teacherMapper.selectById(id);
    }
}
