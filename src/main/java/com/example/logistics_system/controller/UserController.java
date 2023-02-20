package com.example.logistics_system.controller;

import com.example.logistics_system.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author:沈玲彬
 * @create: 2022-10-10 20:35
 * @Description:
 */
@Controller
public class UserController {
    @Autowired
    IUserService userService;
    private List<Map<String,Object>> list;
    //定义方法，用于注销功能
    @RequestMapping("/index.do")
    public String zreo(HttpSession session){
        //将session中保存的登录用户的个人信息清空
        session.setAttribute("userInfo",null);
        return "index";
    }
    //接收登录页面的用户名和密码
    @RequestMapping("/login.do")
    public String one(@RequestParam String username, @RequestParam String password, @RequestParam String shengfeng, HttpSession session) {
        int userRole=0;
        String url ="";
        Map<String,Object> oMap = null;
        if (shengfeng.equals("管理员")){
            userRole = 1;
            oMap=userService.login(username, password,userRole);
            if (oMap!=null) {
                //表示当前用户登录成功，把该用户的信息存储至session对象，以便于后期功能的使用，
                //以及防止非法用户进行跳过登录页面直接访问主页
                session.setAttribute("userInfo", oMap);
                url =  "home1";
            }else{
                url ="redirect:/index.do";
            }
        }else if (shengfeng.equals("司机")){
            userRole = 2;
            oMap=userService.login(username, password,userRole);
            if (oMap!=null) {
                //表示当前用户登录成功，把该用户的信息存储至session对象，以便于后期功能的使用，
                //以及防止非法用户进行跳过登录页面直接访问主页
                session.setAttribute("userInfo", oMap);
                url =  "home2";
            }else {
                url ="redirect:/index.do";
            }
        }else if (shengfeng.equals("客户")){
            userRole = 3;
            oMap=userService.login(username, password,userRole);
            if (oMap!=null) {
                //表示当前用户登录成功，把该用户的信息存储至session对象，以便于后期功能的使用，
                //以及防止非法用户进行跳过登录页面直接访问主页
                session.setAttribute("userInfo", oMap);
                url =  "home3";
            }else {
                url ="redirect:/index.do";
            }
        }else {
            url = "redirect:/index.do";
        }
        return url;
    }
    @RequestMapping("/home1.do")
    public String home(HttpSession session) {
        //通过判断session对象中是否有保存登录成功之后用户的信息，如果存在，那么该用户是合法用户，否则不存在的话，那么该用户是非法用户
        Object object=session.getAttribute("userInfo");
        String url="";
        if (object!=null) {
            //说明该用户合法用户
            url="home1";
        }else {
            //说明是非法用户,跳转至登录页面
            url="redirect:/index.do";
        }
        return url;
    }

}
