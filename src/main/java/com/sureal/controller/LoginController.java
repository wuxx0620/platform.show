package com.sureal.controller;

import com.sureal.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpSession;


/**
 * @author Wuxx
 * @date 2019/5/28 15:56
 * @PackageName com.sureal.controller
 * @ClassName LoginController
 * @Description
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login() {
        return "menu/login";
    }


    @RequestMapping("/")
    public String everyWhere() {
        return "menu/login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index/index";
    }

    @RequestMapping("/login/checkLogin")
    public ModelAndView userlogin(@RequestParam(value = "username", required = true) String userName,
                                  @RequestParam(value = "password", required = true) String passWord,
                                  @RequestParam(value = "rememberMe", required = true, defaultValue = "false")
                                          boolean rememberMe, HttpSession session) {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        passWord = MD5Utils.encrypt(userName, passWord);
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
        Subject subject = SecurityUtils.getSubject();
        token.setRememberMe(rememberMe);
        try {
            subject.login(token);
            view.addStaticAttribute("code", 200);
            session.setAttribute("username", userName);
            view.addStaticAttribute("username", subject.getPrincipal());
            view.addStaticAttribute("cookieId", subject.getSession().getId());
            return new ModelAndView(view);
        } catch (AuthenticationException e) {
            view.addStaticAttribute("code", 202);
            return new ModelAndView(view);
        }
    }

    @RequestMapping("/product")
    public String product() {
        return "menu/product";
    }

    @RequestMapping("/about")
    public String about() {
        return "menu/about";
    }

    @RequestMapping("/introduce1")
    public String introduce1() {
        return "menu/introduce1";
    }

    @RequestMapping("/introduce2")
    public String introduce2() {
        return "menu/introduce2";
    }

    @RequestMapping("/introduce3")
    public String introduce3() {
        return "menu/introduce3";
    }

    @RequestMapping("/channel")
    public String channel() {
        return "menu/channel";
    }
}
