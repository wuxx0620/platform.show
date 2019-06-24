package com.sureal.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sureal.dao.CourseListBaseResultMapper;
import com.sureal.pojo.CourseListBaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wuxx
 * @date 2019/6/18 11:08
 * @PackageName com.sureal.service
 * @ClassName CourseListBaseResultService
 */
@Service
public class CourseListBaseResultService {
    @Autowired
    private CourseListBaseResultMapper courseListBaseResultMapper;

    /**
     * 查询所有课程列表(分页)
     *
     * @return
     */
    public PageInfo<CourseListBaseResult> findAllCourse(Integer currentPage, Integer pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数
        PageHelper.startPage(currentPage, pageSize);
        List<CourseListBaseResult> allCourse = courseListBaseResultMapper.findAllCourse();
        PageInfo<CourseListBaseResult> pageInfo = new PageInfo<>(allCourse);
        return pageInfo;
    }
}
