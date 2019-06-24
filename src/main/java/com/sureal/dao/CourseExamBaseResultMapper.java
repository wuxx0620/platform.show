package com.sureal.dao;

import com.sureal.pojo.CourseExamBaseResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Wuxx
 * @date 2019/6/18 10:31
 * @PackageName com.sureal.dao
 * @ClassName CourseExamBaseResultMapper
 */
@Mapper
public interface CourseExamBaseResultMapper {
    /**
     * 查询所有的课堂小测
     *
     * @return
     */
    List<CourseExamBaseResult> findAllCourseExam();

    /**
     * 根据课程id值查询课堂测试数据
     *
     * @param courseId
     * @return
     */
    List<CourseExamBaseResult> findCourseExamByCourseId(String courseId);
}
