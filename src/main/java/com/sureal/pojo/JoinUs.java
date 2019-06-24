package com.sureal.pojo;


import lombok.Data;

import java.io.Serializable;

/**
 * @author Wuxx
 * @date 2019/5/9 15:38
 * @PackageName com.sureal.pojo
 * @ClassName JoinUs
 * @Description
 */
@Data
public class JoinUs implements Serializable {

    private static final long serialVersionUID = 4798316249512579846L;

    private Integer id;
    private String courseName;
    private String company;
    private String name;
    private String phone;
    private String email;

}
