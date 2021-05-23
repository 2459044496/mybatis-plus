package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.mybatisplus.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user")
    List<User> getAll();

    @Select("select * from user")
    @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = 100000)
    @ResultType(User.class)
    void getAll2(@Param(Constants.WRAPPER) QueryWrapper<User> wrapper, ResultHandler<User> handler);
}
