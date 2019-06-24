package com.sureal.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Wuxx
 * @date 2019/6/17 15:37
 * @PackageName com.sureal.pojo
 * @ClassName correctBaseResult
 */
@Data
public class CorrectBaseResult implements Serializable {
    //学科
    private String subject;
    //答题正确率
    private double correct;
    //答题正确率平均值
    private Double correctAvg;
    //答题正确率最大值
    private Double correctMax;
}
