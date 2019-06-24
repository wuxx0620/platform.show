package com.sureal.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sureal.dao.CourseExamBaseResultMapper;
import com.sureal.pojo.CourseExamBaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wuxx
 * @date 2019/6/18 15:45
 * @PackageName com.sureal.service
 * @ClassName CourseExamBaseResultService
 */
@Service
public class CourseExamBaseResultService {
    @Autowired
    private CourseExamBaseResultMapper courseExamBaseResultMapper;

    public PageInfo<CourseExamBaseResult> findCourseExamByCourseId(Integer pageNum, Integer pageSize, String courseId) {
        PageHelper.startPage(pageNum, pageSize);
        List<CourseExamBaseResult> courseExamByList = courseExamBaseResultMapper.findCourseExamByCourseId(courseId);
        PageInfo<CourseExamBaseResult> pageInfo = new PageInfo<>(courseExamByList);
        return pageInfo;
    }
}
