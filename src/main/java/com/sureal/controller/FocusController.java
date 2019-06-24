package com.sureal.controller;

import com.sureal.common.SubjectType;
import com.sureal.pojo.FocusBaseResult;
import com.sureal.service.CourseBaseResultService;
import com.sureal.service.FocusBaseResultService;
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
 * @date 2019/6/14 10:38
 * @PackageName com.sureal.controller
 * @ClassName FocusController
 */
@Controller
@RequestMapping("focus")
public class FocusController {
    @Autowired
    private FocusBaseResultService focusBaseResultService;

    @Autowired
    private CourseBaseResultService courseBaseResultService;

    @RequestMapping(value = "/focusNumChart")
    public String focusNumChart(Model model) {
        String bTime = "";
        String eTime = "";
        //学校总数
        long schoolNum = courseBaseResultService.findAllSchoolNum();
        model.addAttribute("schoolNum", schoolNum);
        List<FocusBaseResult> focusMax = focusBaseResultService.findFocusMax(bTime, eTime);
        Map<String, FocusBaseResult> data = new HashMap<>(16);
        if (focusMax != null && !focusMax.isEmpty()) {
            for (FocusBaseResult FocusMax : focusMax) {
                data.put(FocusMax.getSubject(), FocusMax);
            }
        }
        List<FocusBaseResult> focusBaseResultListMax = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            FocusBaseResult focus = new FocusBaseResult();
            focus.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                focus.setFocusMax(data.get(type.getCode()).getFocusMax());
            } else {
                focus.setFocusMax((double) 0);
            }
            focusBaseResultListMax.add(focus);
        }
        //
        model.addAttribute("focusMax", focusBaseResultListMax);
        List<FocusBaseResult> focusAvg = focusBaseResultService.findFocusAvg(bTime, eTime);
        if (focusAvg != null && !focusAvg.isEmpty()) {
            for (FocusBaseResult FocusAvg : focusAvg) {
                data.put(FocusAvg.getSubject(), FocusAvg);
            }
        }
        List<FocusBaseResult> focusBaseResultListAvg = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            FocusBaseResult focus = new FocusBaseResult();
            focus.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                focus.setFocusAvg(formatData(data.get(type.getCode()).getFocusNum()) / schoolNum);
            } else {
                focus.setFocusAvg((double) 0);
            }
            focusBaseResultListAvg.add(focus);
        }
        //
        model.addAttribute("focusAvg", focusBaseResultListAvg);
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        List<FocusBaseResult> focusByUserList = focusBaseResultService.findFocusByUserName(bTime, eTime, username);
        for (FocusBaseResult focusByUser : focusByUserList) {
            data.put(focusByUser.getSubject(), focusByUser);
        }
        List<FocusBaseResult> focusListByUser = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            FocusBaseResult focus = new FocusBaseResult();
            focus.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                focus.setFocusNum(data.get(type.getCode()).getFocusNum());
            } else {
                focus.setFocusNum((double) 0);
            }
            focusListByUser.add(focus);
        }
        model.addAttribute("focusByUser", focusListByUser);
        return "focus/focusNumChart";
    }

    @RequestMapping(value = "/focusNumTable")
    public String focusNumTable(Model model) {
        String bTime = "";
        String eTime = "";
        //学校总数
        long schoolNum = courseBaseResultService.findAllSchoolNum();
        model.addAttribute("schoolNum", schoolNum);
        List<FocusBaseResult> focusMax = focusBaseResultService.findFocusMax(bTime, eTime);
        Map<String, FocusBaseResult> data = new HashMap<>(16);
        if (focusMax != null && !focusMax.isEmpty()) {
            for (FocusBaseResult FocusMax : focusMax) {
                data.put(FocusMax.getSubject(), FocusMax);
            }
        }
        List<FocusBaseResult> focusBaseResultListMax = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            FocusBaseResult focus = new FocusBaseResult();
            focus.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                focus.setFocusMax(data.get(type.getCode()).getFocusMax());
            } else {
                focus.setFocusMax((double) 0);
            }
            focusBaseResultListMax.add(focus);
        }
        //
        model.addAttribute("focusMax", focusBaseResultListMax);
        List<FocusBaseResult> focusAvg = focusBaseResultService.findFocusAvg(bTime, eTime);
        if (focusAvg != null && !focusAvg.isEmpty()) {
            for (FocusBaseResult FocusAvg : focusAvg) {
                data.put(FocusAvg.getSubject(), FocusAvg);
            }
        }
        List<FocusBaseResult> focusBaseResultListAvg = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            FocusBaseResult focus = new FocusBaseResult();
            focus.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                focus.setFocusAvg(formatData(data.get(type.getCode()).getFocusNum()) / schoolNum);
            } else {
                focus.setFocusAvg((double) 0);
            }
            focusBaseResultListAvg.add(focus);
        }
        //
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        List<FocusBaseResult> focusByUserList = focusBaseResultService.findFocusByUserName(bTime, eTime, username);
        for (FocusBaseResult focusByUser : focusByUserList) {
            data.put(focusByUser.getSubject(), focusByUser);
        }
        List<FocusBaseResult> focusListByUser = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            FocusBaseResult focus = new FocusBaseResult();
            focus.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                focus.setFocusNum(data.get(type.getCode()).getFocusNum());
            } else {
                focus.setFocusNum((double) 0);
            }
            focusListByUser.add(focus);
        }
        for (FocusBaseResult focus : focusListByUser) {
            for (FocusBaseResult max : focusBaseResultListMax) {
                if (focus.getSubject().equals(max.getSubject())) {
                    focus.setFocusMax(max.getFocusMax());
                }
            }
            for (FocusBaseResult avg : focusBaseResultListAvg) {
                if (focus.getSubject().equals(avg.getSubject())) {
                    focus.setFocusAvg(avg.getFocusAvg());
                }
            }
        }
        model.addAttribute("focusByUser", focusListByUser);
        return "focus/focusNumTable";
    }

    @RequestMapping(value = "/focusData", method = RequestMethod.POST)
    public @ResponseBody
    List<FocusBaseResult> focusData(
            @RequestParam(value = "subjects", required = false) String[] subjects,
            @RequestParam(value = "grades", required = false) String[] grades,
            @RequestParam(value = "bTime", required = false, defaultValue = "") String bTime,
            @RequestParam(value = "eTime", required = false, defaultValue = "") String eTime,
            @RequestParam(value = "username", required = false) String username) {
        Long schoolNum = courseBaseResultService.findAllSchoolNum();
        List<FocusBaseResult> focusBySubjectAndGrade =
                focusBaseResultService.findFocusBySujectAndGrade(subjects, grades, bTime, eTime, username);
        List<FocusBaseResult> focusMax = focusBaseResultService.findFocusMax(bTime, eTime);
        List<FocusBaseResult> focusAvg = focusBaseResultService.findFocusAvg(bTime, eTime);
        Map<String, FocusBaseResult> data = new HashMap<>(16);
        Map<String, FocusBaseResult> dataMax = new HashMap<>(16);
        Map<String, FocusBaseResult> dataAvg = new HashMap<>(16);
        if (focusBySubjectAndGrade != null && !focusBySubjectAndGrade.isEmpty()) {
            for (FocusBaseResult focusBaseResult : focusBySubjectAndGrade) {
                data.put(focusBaseResult.getSubject(), focusBaseResult);
            }
        }
        if (focusMax != null && !focusMax.isEmpty()) {
            for (FocusBaseResult focusBaseResultMax : focusMax) {
                dataMax.put(focusBaseResultMax.getSubject(), focusBaseResultMax);
            }
        }
        if (focusAvg != null && !focusAvg.isEmpty()) {
            for (FocusBaseResult focusBaseResultAvg : focusAvg) {
                dataAvg.put(focusBaseResultAvg.getSubject(), focusBaseResultAvg);
            }
        }
        List<List<FocusBaseResult>> focusListStaticsLine = new ArrayList<>();
        List<FocusBaseResult> focusStaticsLine = new ArrayList<>();
        List<FocusBaseResult> focusStaticsLineMax = new ArrayList<>();
        List<FocusBaseResult> focusStaticsLineAvg = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            FocusBaseResult focusBaseResult = new FocusBaseResult();
            FocusBaseResult focusBaseResultMax = new FocusBaseResult();
            FocusBaseResult focusBaseResultAvg = new FocusBaseResult();
            focusBaseResult.setSubject(type.getView());
            focusBaseResultMax.setSubject(type.getView());
            focusBaseResultAvg.setSubject(type.getView());
            //
            if (data.containsKey(type.getCode())) {
                focusBaseResult.setFocusNum(data.get(type.getCode()).getFocusNum());
            } else {
                focusBaseResult.setFocusNum((double) 0);
            }
            focusStaticsLine.add(focusBaseResult);
            //
            if (dataMax.containsKey(type.getCode())) {
                focusBaseResultMax.setFocusMax(dataMax.get(type.getCode()).getFocusMax());
            } else {
                focusBaseResultMax.setFocusMax((double) 0);
            }
            focusStaticsLineMax.add(focusBaseResultMax);
            //
            if (dataAvg.containsKey(type.getCode())) {
                focusBaseResultAvg.setFocusAvg(formatData(dataAvg.get(type.getCode()).getFocusAvg() / schoolNum));
            } else {
                focusBaseResultAvg.setFocusAvg((double) 0);
            }
            focusStaticsLineAvg.add(focusBaseResultAvg);
            //添加到集合中
            focusListStaticsLine.add(focusStaticsLine);
            focusListStaticsLine.add(focusStaticsLineMax);
            focusListStaticsLine.add(focusStaticsLineAvg);
        }
        List<FocusBaseResult> ObjectList = new ArrayList<>();
        ObjectList.addAll(focusListStaticsLine.get(0));
        ObjectList.addAll(focusListStaticsLine.get(1));
        ObjectList.addAll(focusListStaticsLine.get(2));
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
