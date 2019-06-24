package com.sureal.controller;

import com.sureal.common.SubjectType;
import com.sureal.pojo.CourseBaseResult;
import com.sureal.service.CourseBaseResultService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wuxx
 * @date 2019/6/5 16:06
 * @PackageName com.sureal.controller
 * @ClassName Course
 */
@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseBaseResultService courseBaseResultService;

    @RequestMapping(value = "/courseNumChart")
    public String courseNumChart(Model model) {
        String bTime = "";
        String eTime = "";
        //查询所有课程数量对应的科目最多的数据
        List<CourseBaseResult> courseNumMax = courseBaseResultService.findCourseMax(bTime, eTime);
        Map<String, CourseBaseResult> data = new HashMap<>(16);
        if (courseNumMax != null && !courseNumMax.isEmpty()) {
            for (CourseBaseResult CourseNumMax : courseNumMax) {
                data.put(CourseNumMax.getSubject(), CourseNumMax);
            }
        }
        List<CourseBaseResult> courseBaseResultListMax = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            CourseBaseResult course = new CourseBaseResult();
            course.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                course.setCourseNumMax(data.get(type.getCode()).getCourseNumMax());
            } else {
                course.setCourseNumMax((double) 0);
            }
            courseBaseResultListMax.add(course);
        }
        model.addAttribute("courseNumMax", courseBaseResultListMax);
        //学校总数
        long schoolNum = courseBaseResultService.findAllSchoolNum();
        model.addAttribute("schoolNum", schoolNum);
        //查询所有课程数量对应的科目平均
        List<CourseBaseResult> courseNumAvg = courseBaseResultService.findCourseAvg(bTime, eTime);
        if (courseNumAvg != null && !courseNumAvg.isEmpty()) {
            for (CourseBaseResult CourseNumAvg : courseNumAvg) {
                data.put(CourseNumAvg.getSubject(), CourseNumAvg);
            }
        }
        List<CourseBaseResult> courseBaseResultListAvg = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            CourseBaseResult course = new CourseBaseResult();
            course.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                course.setCourseNumAvg(formatData(data.get(type.getCode()).getCourseNumAvg()) / schoolNum);
            } else {
                course.setCourseNumAvg((double) 0);
            }
            courseBaseResultListAvg.add(course);
        }
        model.addAttribute("courseNumAvg", courseBaseResultListAvg);
        //当前用户课程数据
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        List<CourseBaseResult> courseNumByUserList = courseBaseResultService.findCourseNumByUser(bTime, eTime, username);
        for (CourseBaseResult courseNumByUser : courseNumByUserList) {
            data.put(courseNumByUser.getSubject(), courseNumByUser);
        }
        List<CourseBaseResult> courseNumListByUser = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            CourseBaseResult course = new CourseBaseResult();
            course.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                course.setCourseNum(data.get(type.getCode()).getCourseNum());
            } else {
                course.setCourseNum((double) 0);
            }
            courseNumListByUser.add(course);
        }
        model.addAttribute("courseNumByUser", courseNumListByUser);
        return "course/courseNumChart";
    }

    @RequestMapping(value = "/courseNumTable")
    public String courseNumTable(Model model) {
        String bTime = "";
        String eTime = "";
        //查询所有课程数量对应的科目最多的数据
        List<CourseBaseResult> courseNumMax = courseBaseResultService.findCourseMax(bTime, eTime);
        Map<String, CourseBaseResult> data = new HashMap<>(16);
        if (courseNumMax != null && !courseNumMax.isEmpty()) {
            for (CourseBaseResult CourseNumMax : courseNumMax) {
                data.put(CourseNumMax.getSubject(), CourseNumMax);
            }
        }
        List<CourseBaseResult> courseBaseResultListMax = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            CourseBaseResult course = new CourseBaseResult();
            course.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                course.setCourseNumMax(data.get(type.getCode()).getCourseNumMax());
            } else {
                course.setCourseNumMax((double) 0);
            }
            courseBaseResultListMax.add(course);
        }
        //学校总数
        long schoolNum = courseBaseResultService.findAllSchoolNum();
        model.addAttribute("schoolNum", schoolNum);
        //查询所有课程数量对应的科目平均
        List<CourseBaseResult> courseNumAvg = courseBaseResultService.findCourseAvg(bTime, eTime);
        if (courseNumAvg != null && !courseNumAvg.isEmpty()) {
            for (CourseBaseResult CourseNumAvg : courseNumAvg) {
                data.put(CourseNumAvg.getSubject(), CourseNumAvg);
            }
        }
        List<CourseBaseResult> courseBaseResultListAvg = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            CourseBaseResult course = new CourseBaseResult();
            course.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                course.setCourseNumAvg(formatData(data.get(type.getCode()).getCourseNumAvg()) / schoolNum);
            } else {
                course.setCourseNumAvg((double) 0);
            }
            courseBaseResultListAvg.add(course);
        }
        //当前用户课程数据
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        List<CourseBaseResult> courseNumByUserList = courseBaseResultService.findCourseNumByUser(bTime, eTime, username);
        for (CourseBaseResult courseNumByUser : courseNumByUserList) {
            data.put(courseNumByUser.getSubject(), courseNumByUser);
        }
        List<CourseBaseResult> courseNumListByUser = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            CourseBaseResult course = new CourseBaseResult();
            course.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                course.setCourseNum(data.get(type.getCode()).getCourseNum());
            } else {
                course.setCourseNum((double) 0);
            }
            courseNumListByUser.add(course);
        }
        for (CourseBaseResult course : courseNumListByUser) {
            for (CourseBaseResult max : courseBaseResultListMax) {
                if (course.getSubject().equals(max.getSubject())) {
                    course.setCourseNumMax(max.getCourseNumMax());
                }
            }
            for (CourseBaseResult avg : courseBaseResultListAvg) {
                if (course.getSubject().equals(avg.getSubject())) {
                    course.setCourseNumAvg(avg.getCourseNumAvg());
                }
            }
        }
        model.addAttribute("courseNumByUser", courseNumListByUser);
        return "course/courseNumTable";
    }

    /**
     * 页面请求数据
     *
     * @param subjects
     * @param grades
     * @param bTime
     * @param eTime
     * @param username
     * @return
     */
    @RequestMapping(value = "/courseNumData", method = RequestMethod.POST)
    public @ResponseBody
    List<CourseBaseResult> courseNumData(
            @RequestParam(value = "subjects", required = false) String[] subjects,
            @RequestParam(value = "grades", required = false) String[] grades,
            @RequestParam(value = "bTime", required = false, defaultValue = "") String bTime,
            @RequestParam(value = "eTime", required = false, defaultValue = "") String eTime,
            @RequestParam(value = "username", required = false) String username) {

        Long schoolNum = courseBaseResultService.findAllSchoolNum();
        List<CourseBaseResult> courseNumBySubjcetAndGrade =
                courseBaseResultService.findCourseNumBySubjcetAndGrade(subjects, grades, username, bTime, eTime);
        List<CourseBaseResult> courseMax = courseBaseResultService.findCourseMax(bTime, eTime);
        List<CourseBaseResult> courseAvg = courseBaseResultService.findCourseAvg(bTime, eTime);
        Map<String, CourseBaseResult> data = new HashMap<>(16);
        Map<String, CourseBaseResult> dataMax = new HashMap<>(16);
        Map<String, CourseBaseResult> dataAvg = new HashMap<>(16);
        if (courseNumBySubjcetAndGrade != null && !courseNumBySubjcetAndGrade.isEmpty()) {
            for (CourseBaseResult courseBaseResult : courseNumBySubjcetAndGrade) {
                data.put(courseBaseResult.getSubject(), courseBaseResult);
            }
        }
        if (courseMax != null && !courseMax.isEmpty()) {
            for (CourseBaseResult courseBaseResultMax : courseMax) {
                dataMax.put(courseBaseResultMax.getSubject(), courseBaseResultMax);
            }
        }
        if (courseAvg != null && !courseAvg.isEmpty()) {
            for (CourseBaseResult courseBaseResultAvg : courseAvg) {
                dataAvg.put(courseBaseResultAvg.getSubject(), courseBaseResultAvg);
            }
        }
        List<List<CourseBaseResult>> courseListStaticsLine = new ArrayList<>();
        List<CourseBaseResult> courseStaticsLine = new ArrayList<>();
        List<CourseBaseResult> courseStaticsLineMax = new ArrayList<>();
        List<CourseBaseResult> courseStaticsLineAvg = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            CourseBaseResult courseBaseResult = new CourseBaseResult();
            CourseBaseResult courseBaseResultMax = new CourseBaseResult();
            CourseBaseResult courseBaseResultAvg = new CourseBaseResult();
            courseBaseResult.setSubject(type.getView());
            courseBaseResultMax.setSubject(type.getView());
            courseBaseResultAvg.setSubject(type.getView());
            //当前用户选择所查询的课程数量
            if (data.containsKey(type.getCode())) {
                courseBaseResult.setCourseNum(data.get(type.getCode()).getCourseNum());
            } else {
                courseBaseResult.setCourseNum((double) 0);
            }
            courseStaticsLine.add(courseBaseResult);
            //课程最大值
            if (dataMax.containsKey(type.getCode())) {
                courseBaseResultMax.setCourseNumMax(dataMax.get(type.getCode()).getCourseNumMax());
            } else {
                courseBaseResultMax.setCourseNumMax((double) 0);
            }
            courseStaticsLineMax.add(courseBaseResultMax);
            //课程的平均值
            if (dataAvg.containsKey(type.getCode())) {
                courseBaseResultAvg.setCourseNumAvg(formatData(dataAvg.get(type.getCode()).getCourseNumAvg() / schoolNum));
            } else {
                courseBaseResultAvg.setCourseNumAvg((double) 0);
            }
            courseStaticsLineAvg.add(courseBaseResultAvg);
            //添加到集合中
            courseListStaticsLine.add(courseStaticsLine);
            courseListStaticsLine.add(courseStaticsLineMax);
            courseListStaticsLine.add(courseStaticsLineAvg);
        }
        List<CourseBaseResult> ObjectList = new ArrayList<>();
        ObjectList.addAll(courseListStaticsLine.get(0));
        ObjectList.addAll(courseListStaticsLine.get(1));
        ObjectList.addAll(courseListStaticsLine.get(2));
        return ObjectList;
    }


    /**
     * 格式转换
     *
     * @param num
     * @return
     */
    public Double formatData(Double num) {
        BigDecimal temp = new BigDecimal(num);
        return temp.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
