package com.sureal.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Wuxx
 * @date 2019/6/14 12:43
 * @PackageName com.sureal.pojo
 * @ClassName FocusBaseResultService
 */
@Data
public class FocusBaseResult implements Serializable {
    //学科
    private String subject;
    //焦点信息数量
    private double focusNum;
    //焦点信息平均数量
    private double focusAvg;
    //焦点信息最大数量
    private double focusMax;
}
