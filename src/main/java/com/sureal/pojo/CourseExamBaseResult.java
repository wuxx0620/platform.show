package com.sureal.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Wuxx
 * @date 2019/6/18 10:27
 * @PackageName com.sureal.pojo
 * @ClassName CourseExamBaseResult
 */
@Data
public class CourseExamBaseResult implements Serializable {
    //id
    private String id;
    //课程名称
    private String courseName;
    //问题
    private String question;
    //选项A
    private String A;
    //选项B
    private String B;
    //选项C
    private String C;
    //选项D
    private String D;
    //答案
    private String answer;
    //答题正确率
    private String correct;
}
