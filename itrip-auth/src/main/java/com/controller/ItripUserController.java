package com.controller;

import com.po.Dto;
import com.po.ItripUser;
import com.service.ItripUserService;
import com.utils.DtoUtil;
import com.utils.MD5Util;
import com.utils.SMSUtil;
import com.utils.vo.ItripUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = "ItripUserController", description = "用户注册管理")
@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class ItripUserController {
    private Jedis jedis = new Jedis("127.0.0.1", 6379);

    @Resource
    private ItripUserService itripUserService;

    @ApiOperation(value = "通过手机号注册")
    @RequestMapping(value = "/registerbyphone", method = RequestMethod.POST)
    public Dto registerByPhone(@RequestBody ItripUserVO itripUserVO, HttpServletRequest httpServletRequest) {
        try {
            ItripUser itripUser = new ItripUser();
            itripUser.setUsercode(itripUserVO.getUserCode());
            itripUser.setUsername(itripUserVO.getUserName());
            itripUser.setUserpassword(itripUserVO.getUserPassword());
            itripUser.setUsertype(0);
            itripUser.setActivated(0);
            ItripUser oldUser = itripUserService.queryIsRepeat(itripUser);
            System.out.println("111111");
            if (oldUser == null) {//该用户没有注册
                //处理密码md5加密加盐

                itripUser.setUserpassword(MD5Util.getMd5(itripUser.getUserpassword(), 32));

                //添加用户
                boolean flag = itripUserService.regist(itripUser);
                if (flag) {
                    //发送验证码
                    String checkcode = SMSUtil.testcheck(itripUser.getUsercode());
                    //将验证码存到redis中
                    jedis.setex(itripUser.getUsercode(), 120, checkcode);
                    return DtoUtil.returnSuccess();


                }


                //发送短信验证码


            }
        } catch (Exception e) {
            return DtoUtil.returnFail(e.getMessage(), "30000");
        }
        System.out.println("11222");
        return null;
    }

}





