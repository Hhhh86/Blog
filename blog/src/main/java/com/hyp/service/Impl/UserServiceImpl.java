package com.hyp.service.Impl;

import com.hyp.dao.UserRepository;
import com.hyp.pojo.User;
import com.hyp.service.UserService;
import com.hyp.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName blog
 * @ClassName UserServiceImpl
 * @create 2020-07-10 16:30
 * @Author by hyp
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
