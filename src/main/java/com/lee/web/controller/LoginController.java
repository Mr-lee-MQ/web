package com.lee.web.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lee.web.entity.Login;
import com.lee.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

@Autowired LoginService loginService;

    @RequestMapping("/")
    public String hello(){
        return "index";
    }


    @RequestMapping("/user/login")
    public String login(
            Login login,
            Model model,
            HttpSession session) {

            //如果账号密码正确跳转到index
            Login getUser = loginService.getByUsername(login.getUsername());
            if (getUser != null && StringUtils.equals(login.getPassword(), getUser.getPassword())) {
                session.setAttribute("loginUser",login.getUsername());
                return "redirect:/main.html";
            }else {
            //告诉用户，登陆失败
            model.addAttribute("msg","账号或者密码错误");
            return "index";
        }

        }



//        //具体的业务逻辑
//        if("admin".equals(username) &&"123456".equals(password)){
//
//            //登陆成功后，生成session
//            session.setAttribute("loginUser",username);
//            return "redirect:/main.html";
//
//        }else {
//            //告诉用户，登陆失败
//            model.addAttribute("msg","账号或者密码错误");
//            return "index";
//        }



    //用户注销
    @RequestMapping("/user/loginout")
    public String logout(HttpSession session){
    session.invalidate();
    return "redirect:/index.html";
    }
}
