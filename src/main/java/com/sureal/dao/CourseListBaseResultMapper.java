package com.sureal.dao;

import com.sureal.pojo.CourseListBaseResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Wuxx
 * @date 2019/6/18 10:24
 * @PackageName com.sureal.dao
 * @ClassName CourseListBaseResultMapper
 */
@Mapper
public interface CourseListBaseResultMapper {

    /**
     * 查询所有课程列表
     *
     * @return
     */
    List<CourseListBaseResult> findAllCourse();
}
