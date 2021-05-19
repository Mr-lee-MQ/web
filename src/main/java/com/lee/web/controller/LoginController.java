package com.lee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session){

        //具体的业务逻辑
        if("admin".equals(username) &&"123456".equals(password)){

            //登陆成功后，生成session
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";

        }else {
            //告诉用户，登陆失败
            model.addAttribute("msg","账号或者密码错误");
            return "index";
        }
    }

    //用户注销
    @RequestMapping("/user/loginout")
    public String logout(HttpSession session){
    session.invalidate();
    return "redirect:/index.html";
    }
}
