package com.service.impl;

import com.mapper.ItripUserMapper;
import com.po.ItripUser;
import com.service.ItripUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
@Transactional
public class ItripUserServiceImpl implements ItripUserService {
    @Resource
    private ItripUserMapper itripUserMapper;
    @Override
    //查询账号是否存在/已注册
    public ItripUser queryIsRepeat(ItripUser itripUser) {
       return itripUserMapper.queryIsRepeate(itripUser);

    }

    @Override
    public boolean regist(ItripUser itripUser) {
        int flag=itripUserMapper.insertUserInfo(itripUser);
        if(flag>0){
            return true;
        }
        return false;
    }

    @Override
    public ItripUser dologin(ItripUser itripUser) {
        return null;
    }
}
