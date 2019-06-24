package com.sureal.dao;

import com.sureal.pojo.JoinUs;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Wuxx
 * @date 2019/5/9 15:40
 * @PackageName com.sureal.dao
 * @ClassName JoinUsMapper.xml
 * @Description
 */
@Mapper
public interface JoinUsMapper {
    /**
     * 增加
     *
     * @param joinUs
     */
    void add(JoinUs joinUs);
}
