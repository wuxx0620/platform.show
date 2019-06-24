package com.sureal.service;

import com.sureal.dao.UserMapper;
import com.sureal.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author Wuxx
 * @date 2019/4/18 15:55
 * @PackageName com.sureal.service
 * @ClassName UserService
 * @Description
 */
@Service
public class UserService implements Serializable {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }
}
