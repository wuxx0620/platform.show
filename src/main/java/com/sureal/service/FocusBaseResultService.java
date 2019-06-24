package com.sureal.service;

import com.sureal.dao.FocusBaseResultMapper;
import com.sureal.pojo.FocusBaseResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Wuxx
 * @date 2019/6/14 17:29
 * @PackageName com.sureal.service
 * @ClassName FocusBaseResultService
 */
@Service
public class FocusBaseResultService implements Serializable {
    @Autowired
    private FocusBaseResultMapper focusBaseResultMapper;

    /**
     * 当前用户的焦点信息
     *
     * @param username
     * @param bTime
     * @param eTime
     * @return
     */
    public List<FocusBaseResult> findFocusByUserName(String username,
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
        return focusBaseResultMapper.findFocusByUser(username, bTime, eTime);
    }

    /**
     * 查询最大的焦点信息
     *
     * @param bTime
     * @param eTime
     * @return
     */
    public List<FocusBaseResult> findFocusMax(String bTime, String eTime) {
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
        return focusBaseResultMapper.findFocusMax(bTime, eTime);
    }

    /**
     * 查询平均的焦点信息
     *
     * @param bTime
     * @param eTime
     * @return
     */
    public List<FocusBaseResult> findFocusAvg(String bTime, String eTime) {
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
        return focusBaseResultMapper.findFocusAvg(bTime, eTime);
    }

    /**
     * 根据当前用户自定义的选项进行焦点信息查询
     *
     * @param subjects
     * @param grades
     * @param username
     * @param bTime
     * @param eTime
     * @return
     */
    public List<FocusBaseResult> findFocusBySujectAndGrade(String[] subjects,
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
        return focusBaseResultMapper.findFocusBySujectAndGrade(subjects, grades, username, bTime, eTime);
    }
}
