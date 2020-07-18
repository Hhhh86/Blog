package com.hyp.service;

import com.hyp.pojo.User;

/**
 * @ProjectName blog
 * @ClassName UserService
 * @create 2020-07-10 16:28
 * @Author by hyp
 */
public interface UserService {
    //检查用户名密码
    User checkUser(String username,String password);
}
