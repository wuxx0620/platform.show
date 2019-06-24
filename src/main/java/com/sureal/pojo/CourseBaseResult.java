package com.sureal.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Wuxx
 * @date 2019/6/4 18:31
 * @PackageName com.sureal.pojo
 * @ClassName CourseBaseResult
 */
@Data
public class CourseBaseResult implements Serializable {

    private static final long serialVersionUID = 4798316249512579846L;

    //用户id
//    private String id;
    //学校
//    private String school;
    //学校名称
//    private String schoolName;
    //创建时间
//    private Date creatTime;
    //学科
    private String subject;
    //课程数量
    private Double courseNum;
    //课程数量最大值
    private Double courseNumMax;
    //课程数量平均值
    private Double courseNumAvg;
}
