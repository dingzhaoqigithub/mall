package com.mapper;


import com.po.ItripUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
/*
 * 用户注册登录
 * */
public interface ItripUserMapper {
    //查重账号
    public ItripUser queryIsRepeate(ItripUser itripUser);

    //增加用户
    public int insertUserInfo(ItripUser itripUser);

    //查询用户信息
    public ItripUser queryUserInfo(ItripUser itripUser);
}
