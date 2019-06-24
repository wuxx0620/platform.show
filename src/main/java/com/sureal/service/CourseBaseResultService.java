package com.sureal.service;

import com.sureal.dao.CourseBaseResultMapper;
import com.sureal.pojo.CourseBaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Wuxx
 * @date 2019/6/3 11:10
 * @PackageName com.sureal.service
 * @ClassName CourseStaticsService
 * @Description
 */
@Service
public class CourseBaseResultService implements Serializable {
    @Autowired
    private CourseBaseResultMapper courseBaseResultMapper;

    /**
     * 学校总数
     *
     * @return
     */
    public Long findAllSchoolNum() {
        return courseBaseResultMapper.findAllSchoolNum();
    }


    /**
     * 查询课程数据
     *
     * @return
     */
    public List<CourseBaseResult> findSchoolAndSubject() {
        return courseBaseResultMapper.findSchoolAndSubject();
    }

    /**
     * 所有课程
     *
     * @return
     */
    public List<CourseBaseResult> findAllSubject() {
        return courseBaseResultMapper.findAllSubject();
    }

    /**
     * 当前用户的课程数量
     *
     * @param username
     * @param bTime
     * @param eTime
     * @return
     */
    public List<CourseBaseResult> findCourseNumByUser(String bTime, String eTime, String username) {
        String defaultBeginTime = "2018-01-01";
        Date time = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String defaultEndTime = dateFormat.format(time);
        if (bTime.isEmpty()) {
            bTime = defaultBeginTime;
        }
        if (eTime.isEmpty()) {
            eTime = defaultEndTime;
        }
        return courseBaseResultMapper.findCourseNumByUser(username, bTime, eTime);
    }

    /**
     * 科目对应科目数量最大值
     *
     * @param bTime
     * @param eTime
     * @return
     */
    public List<CourseBaseResult> findCourseMax(String bTime, String eTime) {
        String defaultBeginTime = "2018-01-01";
        Date time = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String defaultEndTime = dateFormat.format(time);
        if (bTime.isEmpty()) {
            bTime = defaultBeginTime;
        }
        if (eTime.isEmpty()) {
            eTime = defaultEndTime;
        }
        return courseBaseResultMapper.findCourseMax(bTime, eTime);
    }

    /**
     * 科目对应科目数量平均值
     *
     * @param bTime
     * @param eTime
     * @return
     */
    public List<CourseBaseResult> findCourseAvg(String bTime, String eTime) {
        String defaultBeginTime = "2018-01-01";
        Date time = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String defaultEndTime = dateFormat.format(time);
        if (bTime.isEmpty()) {
            bTime = defaultBeginTime;
        }
        if (eTime.isEmpty()) {
            eTime = defaultEndTime;
        }
        return courseBaseResultMapper.findCourseAvg(bTime, eTime);
    }

    /**
     * 根据当前用户自定义的选项进行课程查询
     *
     * @param subjects
     * @param grades
     * @param username
     * @param bTime
     * @param eTime
     * @return
     */
    public List<CourseBaseResult> findCourseNumBySubjcetAndGrade(
            String[] subjects,
            String[] grades,
            String username,
            String bTime,
            String eTime) {
        String defaultBeginTime = "2018-01-01";
        Date time = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String defaultEndTime = dateFormat.format(time);
        if (bTime.isEmpty()) {
            bTime = defaultBeginTime;
        }
        if (eTime.isEmpty()) {
            eTime = defaultEndTime;
        }
        if (subjects == null || subjects.equals("")) {
            String[] subJect = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
            subjects = subJect;
        } else {
            for (int i = 0; i < subjects.length; i++) {
                String str = subjects[i];
                if (str.equals("语文")) {
                    subjects[i] = "1";
                }
                if (str.equals("数学")) {
                    subjects[i] = "2";
                }
                if (str.equals("英语")) {
                    subjects[i] = "3";
                }
                if (str.equals("物理")) {
                    subjects[i] = "4";
                }
                if (str.equals("化学")) {
                    subjects[i] = "5";
                }
                if (str.equals("生物")) {
                    subjects[i] = "6";
                }
                if (str.equals("历史")) {
                    subjects[i] = "7";
                }
                if (str.equals("地理")) {
                    subjects[i] = "8";
                }
                if (str.equals("政治")) {
                    subjects[i] = "9";
                }
            }
        }
        if (grades == null || grades.equals("")) {
            String[] Grade = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
            grades = Grade;
        } else {
            for (int i = 0; i < grades.length; i++) {
                String str = grades[i];
                if (str.equals("一年级")) {
                    grades[i] = "01";
                }
                if (str.equals("二年级")) {
                    grades[i] = "02";
                }
                if (str.equals("三年级")) {
                    grades[i] = "03";
                }
                if (str.equals("四年级")) {
                    grades[i] = "04";
                }
                if (str.equals("五年级")) {
                    grades[i] = "05";
                }
                if (str.equals("六年级")) {
                    grades[i] = "06";
                }
                if (str.equals("七年级")) {
                    grades[i] = "07";
                }
                if (str.equals("八年级")) {
                    grades[i] = "08";
                }
                if (str.equals("九年级")) {
                    grades[i] = "09";
                }
                if (str.equals("高一")) {
                    grades[i] = "10";
                }
                if (str.equals("高二")) {
                    grades[i] = "11";
                }
                if (str.equals("高三")) {
                    grades[i] = "12";
                }
            }
        }
        return courseBaseResultMapper.findCourseNumBySubjcetAndGrade(subjects, grades, username, bTime, eTime);
    }
}
