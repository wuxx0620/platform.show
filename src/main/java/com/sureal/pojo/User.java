package com.sureal.pojo;


import lombok.Data;

import java.io.Serializable;

/**
 * @author Wuxx
 * @date 2019/4/16 18:20
 * @PackageName com.sureal.pojo
 * @ClassName User
 * @Description
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 4798316249512579846L;

    private String userid;
    private String username;
    private String password;
    private String schoolname;
    private Integer isDelete;

}
