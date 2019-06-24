package com.sureal.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Wuxx
 * @date 2019/6/18 10:22
 * @PackageName com.sureal.pojo
 * @ClassName CourseListBaseResult
 */
@Data
public class CourseListBaseResult implements Serializable {
    //id
    private String id;
    //课程名称
    private String courseName;
    //焦点信息
    private String focus;
}
