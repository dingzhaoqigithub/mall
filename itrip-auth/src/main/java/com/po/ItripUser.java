package com.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItripUser {
    private Long id;
    private int code;//手机或者邮箱注册code操作码
    private String usercode;//手机号或者邮箱号
    private String userpassword;

    private Integer usertype = 0;//是否激活

    private Long flatid;

    private String username;

    private String wechat;

    private String qq;

    private String weibo;

    private String baidu;

    private Date creationdate;

    private Long createdby;

    private Date modifydate;

    private Long modifiedby;

    private Integer activated;

}
