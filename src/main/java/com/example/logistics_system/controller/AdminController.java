package com.example.logistics_system.controller;

import com.example.logistics_system.Util.Util;
import com.example.logistics_system.dao.IAdminDao;
import com.example.logistics_system.pojo.Admin;
import com.example.logistics_system.pojo.UserDto;
import com.example.logistics_system.service.IAdminService;
import com.example.logistics_system.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author:沈玲彬
 * @create: 2022-10-11 20:53
 * @Description:
 */
@Controller
public class AdminController {
    @Autowired
    private IAdminService adminService;
    private List<UserDto> oList;
    private Map<String, Object> oMap;
    @Autowired
    private IUserService userService;
    @Autowired
    private IAdminDao adminDao;
    //查询所有管理员信息
    @RequestMapping("/glyxx.do")
    public ModelAndView getAll(@RequestParam(defaultValue = "1", name = "ym") int ym) {
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = adminService.all();
        PageInfo<UserDto> info =
                new PageInfo<UserDto>(oList);
        ModelAndView mav = new ModelAndView();

        mav.addObject("admins", info);
        mav.setViewName("admin");
        return mav;
    }

    //定义方法，用于打开添加管理员的页面
    @RequestMapping("/addAdmin.do")
    public String addAdmin() {
        return "addAdmin";
    }

    @RequestMapping("/AddAdmin.do")
    public String AddAdmin(UserDto userDto) {
        System.out.println(userDto);
        String url = "";
        userDto.setUserRole(Util.ADMINUSERROLE);
////        userDto.setPassWord("00000000");
        int i2 = userService.addLogin(userDto);
        int LoginId = userDto.getId();
        userDto.setLoginId(LoginId);
        int i1 = adminService.add(userDto);

        if (i1 > 0 && i2 > 0) {
            //添加成功，跳转至用户列表页面
            url = "redirect:/glyxx.do";
        } else {
            //添加失败，刷新添加页面，重新添加
            url = "redirect:/addAdmin.do";
        }
        return url;
    }

    //定义方法，用于根据管理员的id执行删除功能
    @RequestMapping("/DeleteAdmin.do")
    public String delete(@RequestParam int id) {
        String url = "";
        //将用户id传输给service，并要求返回int类型的结果
        Admin admin = adminDao.getById(id);
        int i1 = adminService.delete(id);
        int loginId = admin.getLoginId();
        int i2 = userService.deleteLogin(loginId);
        if (i1 > 0 && i2 > 0) {
            //删除成功，跳转至用户列表页面
            url = "redirect:/glyxx.do";
        }
        return url;
    }
    @RequestMapping("/UpdateAdmin.do")
    public ModelAndView UpdateAdmin(@RequestParam int index) {
        //根据下标从list集合中获得要修改的管理员
        System.out.println(index);
        UserDto userDto=oList.get(index);
        System.out.println(userDto);
        ModelAndView mav=new ModelAndView();
        mav.addObject("admin", userDto);
        mav.setViewName("updateAdmin");
        return mav;
    }
    //定义方法，接收下标，根据下标获得要修改的信息
    @RequestMapping("/updateAdmin.do")
    public String updateAdmin(@RequestParam int id,@RequestParam String userName,@RequestParam String password) {
        Admin admin = adminDao.getById(id);
        int loginId = admin.getLoginId();
        UserDto userDto2 =new UserDto(loginId,userName,password,1);
        int i2 = userService.updateLogin(userDto2);
        UserDto userDto1 =new UserDto(id,userName,password,1,loginId);
        int i1 = adminService.update(userDto1);
        String url="";
        if (i1>0 && i2>0) {
            //修改成功
            url="redirect:/glyxx.do";
        }else {
            //修改失败
            url="redirect:/glyxx.do";
        }
        return url;
    }
    //模糊查询管理员信息
    @RequestMapping("/searchAdmin.do")
    public ModelAndView searchAdmin(@RequestParam String search,@RequestParam(defaultValue = "1", name = "ym") int ym){
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = adminService.search(search);
        PageInfo<UserDto> info =
                new PageInfo<UserDto>(oList);
        ModelAndView mav = new ModelAndView();

        mav.addObject("searchAdmins", info);
        mav.setViewName("searchAdmin");
        return mav;
    }
}
