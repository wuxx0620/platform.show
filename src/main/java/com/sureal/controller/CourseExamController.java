package com.sureal.controller;

import com.github.pagehelper.PageInfo;
import com.sureal.pojo.CourseExamBaseResult;
import com.sureal.service.CourseExamBaseResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Wuxx
 * @date 2019/6/18 16:34
 * @PackageName com.sureal.controller
 * @ClassName CourseExamController
 */
@Controller
@RequestMapping("courseExam")
public class CourseExamController {

    @Autowired
    private CourseExamBaseResultService courseExamBaseResultService;

    @GetMapping(value = "/findCourseExamByCourseId")
    public String findCourseExamByCourseId(
            Model model,
            @RequestParam(defaultValue = "1", value = "pageNum") Integer currentPage,
            @RequestParam(defaultValue = "7", value = "pageSize") Integer pageSize,
            String courseId) {
        PageInfo<CourseExamBaseResult> courseExamByCourseId = courseExamBaseResultService.findCourseExamByCourseId(currentPage, pageSize, courseId);
        model.addAttribute("pageInfo", courseExamByCourseId);
        model.addAttribute("courseId", courseId);
        return "course/courseExam";
    }
}
