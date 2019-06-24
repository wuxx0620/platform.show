package com.sureal.service;

import com.sureal.dao.JoinUsMapper;
import com.sureal.pojo.JoinUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author Wuxx
 * @date 2019/5/9 15:47
 * @PackageName com.sureal.service
 * @ClassName JoinUsService
 * @Description
 */
@Service
public class JoinUsService implements Serializable {
    @Autowired
    private JoinUsMapper joinUsMapper;

    /**
     * 增加
     *
     * @param joinUs
     */
    public void add(JoinUs joinUs) {
        joinUsMapper.add(joinUs);
    }
}
