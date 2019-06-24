package com.sureal.controller;

import com.sureal.pojo.JoinUs;
import com.sureal.service.JoinUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wuxx
 * @date 2019/5/9 15:58
 * @PackageName com.sureal.controller
 * @ClassName JoinUsController
 * @Description
 */
@Controller
public class JoinUsController {
    @Autowired
    private JoinUsService joinUsService;

    @RequestMapping("/joinUs")
    public String joinUs(JoinUs joinUs) {
        joinUsService.add(joinUs);
        return "menu/channel";
    }
}
