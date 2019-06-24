package com.sureal.dao;

import com.sureal.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Wuxx
 * @date 2019/4/18 15:33
 * @PackageName com.sureal.dao
 * @ClassName UserMapper
 * @Description
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    User findByUserName(String username);

    /**
     * 添加用户
     *
     * @param user
     */
    void save(User user);
}
