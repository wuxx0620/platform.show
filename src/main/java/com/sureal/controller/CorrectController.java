package com.sureal.controller;

import com.sureal.common.SubjectType;
import com.sureal.pojo.CorrectBaseResult;
import com.sureal.service.CorrectBaseResultService;
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
 * @date 2019/6/17 16:04
 * @PackageName com.sureal.controller
 * @ClassName CorrectController
 */
@Controller
@RequestMapping("correct")
public class CorrectController {

    @Autowired
    private CorrectBaseResultService correctBaseResultService;

    @Autowired
    private CourseBaseResultService courseBaseResultService;

    @RequestMapping(value = "/correctNumChart")
    public String correctNumChart(Model model) {
        String bTime = "";
        String eTime = "";
        //学校总数
        long schoolNum = courseBaseResultService.findAllSchoolNum();
        List<CorrectBaseResult> correctMax = correctBaseResultService.findCorrectMax(bTime, eTime);
        Map<String, CorrectBaseResult> data = new HashMap<>(16);
        if (correctMax != null && !correctMax.isEmpty()) {
            for (CorrectBaseResult CorrectMax : correctMax) {
                data.put(CorrectMax.getSubject(), CorrectMax);
            }
        }
        List<CorrectBaseResult> correctBaseResultListMax = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            CorrectBaseResult correct = new CorrectBaseResult();
            correct.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                correct.setCorrectMax(data.get(type.getCode()).getCorrectMax());
            } else {
                correct.setCorrectMax((double) 0);
            }
            correctBaseResultListMax.add(correct);
        }
        //
        model.addAttribute("correctMax", correctBaseResultListMax);
        List<CorrectBaseResult> correctAvg = correctBaseResultService.findCorrectAvg(bTime, eTime);
        if (correctAvg != null && !correctAvg.isEmpty()) {
            for (CorrectBaseResult CorrectAvg : correctAvg) {
                data.put(CorrectAvg.getSubject(), CorrectAvg);
            }
        }
        List<CorrectBaseResult> correctBaseResultListAvg = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            CorrectBaseResult correct = new CorrectBaseResult();
            correct.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                correct.setCorrectAvg(formatData(data.get(type.getCode()).getCorrectAvg()) / schoolNum);
            } else {
                correct.setCorrectAvg((double) 0);
            }
            correctBaseResultListAvg.add(correct);
        }
        //
        model.addAttribute("correctAvg", correctBaseResultListAvg);
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        List<CorrectBaseResult> correctByUserList = correctBaseResultService.findCorrectByUser(bTime, eTime, username);
        for (CorrectBaseResult correctByUser : correctByUserList) {
            data.put(correctByUser.getSubject(), correctByUser);
        }
        List<CorrectBaseResult> correctListByUser = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            CorrectBaseResult correct = new CorrectBaseResult();
            correct.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                correct.setCorrect(data.get(type.getCode()).getCorrect());
            } else {
                correct.setCorrect((double) 0);
            }
            correctListByUser.add(correct);
        }
        model.addAttribute("correctByUser", correctListByUser);
        return "correct/correctNumChart";
    }

    @RequestMapping(value = "/correctNumTable")
    public String correctNumTable(Model model) {
        String bTime = "";
        String eTime = "";
        //学校总数
        long schoolNum = courseBaseResultService.findAllSchoolNum();
        List<CorrectBaseResult> correctMax = correctBaseResultService.findCorrectMax(bTime, eTime);
        Map<String, CorrectBaseResult> data = new HashMap<>(16);
        if (correctMax != null && !correctMax.isEmpty()) {
            for (CorrectBaseResult CorrectMax : correctMax) {
                data.put(CorrectMax.getSubject(), CorrectMax);
            }
        }
        List<CorrectBaseResult> correctBaseResultListMax = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            CorrectBaseResult correct = new CorrectBaseResult();
            correct.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                correct.setCorrectMax(data.get(type.getCode()).getCorrectMax());
            } else {
                correct.setCorrectMax((double) 0);
            }
            correctBaseResultListMax.add(correct);
        }
        //
        model.addAttribute("correctMax", correctBaseResultListMax);
        List<CorrectBaseResult> correctAvg = correctBaseResultService.findCorrectAvg(bTime, eTime);
        if (correctAvg != null && !correctAvg.isEmpty()) {
            for (CorrectBaseResult CorrectAvg : correctAvg) {
                data.put(CorrectAvg.getSubject(), CorrectAvg);
            }
        }
        List<CorrectBaseResult> correctBaseResultListAvg = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            CorrectBaseResult correct = new CorrectBaseResult();
            correct.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                correct.setCorrectAvg(formatData(data.get(type.getCode()).getCorrectAvg()) / schoolNum);
            } else {
                correct.setCorrectAvg((double) 0);
            }
            correctBaseResultListAvg.add(correct);
        }
        //
        model.addAttribute("correctAvg", correctBaseResultListAvg);
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        List<CorrectBaseResult> correctByUserList = correctBaseResultService.findCorrectByUser(bTime, eTime, username);
        for (CorrectBaseResult correctByUser : correctByUserList) {
            data.put(correctByUser.getSubject(), correctByUser);
        }
        List<CorrectBaseResult> correctListByUser = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            CorrectBaseResult correct = new CorrectBaseResult();
            correct.setSubject(type.getView());
            if (data.containsKey(type.getCode())) {
                correct.setCorrect(data.get(type.getCode()).getCorrect());
            } else {
                correct.setCorrect((double) 0);
            }
            correctListByUser.add(correct);
        }
        for (CorrectBaseResult correct : correctListByUser) {
            for (CorrectBaseResult max : correctBaseResultListMax) {
                if (correct.getSubject().equals(max.getSubject())) {
                    correct.setCorrectMax(max.getCorrectMax());
                }
            }
            for (CorrectBaseResult avg : correctBaseResultListAvg) {
                if (correct.getSubject().equals(avg.getSubject())) {
                    correct.setCorrectAvg(avg.getCorrectAvg());
                }
            }
        }
        model.addAttribute("correctByUser", correctListByUser);
        return "correct/correctNumTable";
    }

    @RequestMapping(value = "/correctData", method = RequestMethod.POST)
    public @ResponseBody
    List<CorrectBaseResult> correctData(
            @RequestParam(value = "subjects", required = false) String[] subjects,
            @RequestParam(value = "grades", required = false) String[] grades,
            @RequestParam(value = "bTime", required = false, defaultValue = "") String bTime,
            @RequestParam(value = "eTime", required = false, defaultValue = "") String eTime,
            @RequestParam(value = "username", required = false) String username) {
        Long schoolNum = courseBaseResultService.findAllSchoolNum();
        List<CorrectBaseResult> correctBySubjectAndGrade =
                correctBaseResultService.findCorrectBySujectAndGrade(subjects, grades, bTime, eTime, username);
        List<CorrectBaseResult> correctMax = correctBaseResultService.findCorrectMax(bTime, eTime);
        List<CorrectBaseResult> correctAvg = correctBaseResultService.findCorrectAvg(bTime, eTime);
        Map<String, CorrectBaseResult> data = new HashMap<>(16);
        Map<String, CorrectBaseResult> dataMax = new HashMap<>(16);
        Map<String, CorrectBaseResult> dataAvg = new HashMap<>(16);
        if (correctBySubjectAndGrade != null && !correctBySubjectAndGrade.isEmpty()) {
            for (CorrectBaseResult correctBaseResult : correctBySubjectAndGrade) {
                data.put(correctBaseResult.getSubject(), correctBaseResult);
            }
        }
        if (correctMax != null && !correctMax.isEmpty()) {
            for (CorrectBaseResult correctBaseResultMax : correctMax) {
                dataMax.put(correctBaseResultMax.getSubject(), correctBaseResultMax);
            }
        }
        if (correctAvg != null && !correctAvg.isEmpty()) {
            for (CorrectBaseResult correctBaseResultAvg : correctAvg) {
                dataAvg.put(correctBaseResultAvg.getSubject(), correctBaseResultAvg);
            }
        }
        List<List<CorrectBaseResult>> correctListStaticsLine = new ArrayList<>();
        List<CorrectBaseResult> correctStaticsLine = new ArrayList<>();
        List<CorrectBaseResult> correctStaticsLineMax = new ArrayList<>();
        List<CorrectBaseResult> correctStaticsLineAvg = new ArrayList<>();
        for (SubjectType type : SubjectType.values()) {
            CorrectBaseResult correctBaseResult = new CorrectBaseResult();
            CorrectBaseResult correctBaseResultMax = new CorrectBaseResult();
            CorrectBaseResult correctBaseResultAvg = new CorrectBaseResult();
            correctBaseResult.setSubject(type.getView());
            correctBaseResultMax.setSubject(type.getView());
            correctBaseResultAvg.setSubject(type.getView());
            //
            if (data.containsKey(type.getCode())) {
                correctBaseResult.setCorrect(data.get(type.getCode()).getCorrect());
            } else {
                correctBaseResult.setCorrect((double) 0);
            }
            correctStaticsLine.add(correctBaseResult);
            //
            if (dataMax.containsKey(type.getCode())) {
                correctBaseResultMax.setCorrectMax(dataMax.get(type.getCode()).getCorrectMax());
            } else {
                correctBaseResultMax.setCorrectMax((double) 0);
            }
            correctStaticsLineMax.add(correctBaseResultMax);
            //
            if (dataAvg.containsKey(type.getCode())) {
                correctBaseResultAvg.setCorrectAvg(formatData(dataAvg.get(type.getCode()).getCorrectAvg() / schoolNum));
            } else {
                correctBaseResultAvg.setCorrectAvg((double) 0);
            }
            correctStaticsLineAvg.add(correctBaseResultAvg);
            //添加到集合中
            correctListStaticsLine.add(correctStaticsLine);
            correctListStaticsLine.add(correctStaticsLineMax);
            correctListStaticsLine.add(correctStaticsLineAvg);
        }
        List<CorrectBaseResult> ObjectList = new ArrayList<>();
        ObjectList.addAll(correctListStaticsLine.get(0));
        ObjectList.addAll(correctListStaticsLine.get(1));
        ObjectList.addAll(correctListStaticsLine.get(2));
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
