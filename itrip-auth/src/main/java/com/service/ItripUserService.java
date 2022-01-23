package com.service;

import com.po.ItripUser;
import com.utils.ErrorCode;

public interface ItripUserService {


    //查询重复账号
    public ItripUser queryIsRepeat(ItripUser itripUser);

    //注册
    public boolean regist(ItripUser itripUser);


    //登录
    public ItripUser dologin(ItripUser itripUser);
}

