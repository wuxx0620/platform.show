package com.sureal.controller;

import com.github.pagehelper.PageInfo;
import com.sureal.pojo.CourseListBaseResult;
import com.sureal.service.CourseListBaseResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Wuxx
 * @date 2019/6/18 11:27
 * @PackageName com.sureal.controller
 * @ClassName CourseListBaseResultController
 */
@Controller
@RequestMapping(value = "courseList")
public class CourseListController {
    @Autowired
    private CourseListBaseResultService courseListBaseResultService;


    @GetMapping(value = "/findAllCourse")
    public String findAllCourse(
            Model model,
            @RequestParam(defaultValue = "1", value = "pageNum") Integer currentPage,
            @RequestParam(defaultValue = "7", value = "pageSize") Integer pageSize) {
        PageInfo<CourseListBaseResult> allCourse = courseListBaseResultService.findAllCourse(currentPage, pageSize);
        model.addAttribute("pageInfo", allCourse);
        return "course/courseList";
    }
}
