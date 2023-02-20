package com.example.logistics_system.controller;

import com.example.logistics_system.Util.Util;
import com.example.logistics_system.dao.IDriverDao;
import com.example.logistics_system.dao.IUserDao;
import com.example.logistics_system.pojo.DriverDto;
import com.example.logistics_system.pojo.Drivers;
import com.example.logistics_system.service.IDriverService;
import com.example.logistics_system.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author:沈玲彬
 * @create: 2022-10-14 19:54
 * @Description:
 */
@Controller
public class DriverController {
    @Autowired
    IDriverService driverService;
    private List<DriverDto> oList;
    @Autowired
    private IUserService userService;
    @Autowired
    IUserDao userDao;
    @Autowired
    IDriverDao driverDao;
    @RequestMapping("/sjxx.do")
    public ModelAndView getAll(@RequestParam(defaultValue = "1", name = "ym") int ym){
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = driverService.all();
        PageInfo<DriverDto> info =
                new PageInfo<DriverDto>(oList);
        ModelAndView mav = new ModelAndView();

        mav.addObject("drivers", info);
        mav.setViewName("driver");
        return mav;
    }
    @RequestMapping("/addDriver.do")
    public String addDriver(){
        return "addDriver";
    }
    @RequestMapping("/AddDriver.do")
    public String AddDriver(DriverDto driverDto){
        String url ="";
        driverDto.setUserRole(Util.DRIVERUSERROLE);
        driverDto.setPassword("00000000");
        int i2 = userService.addLogin(driverDto);
        int LoginId = driverDto.getId();
        driverDto.setLoginId(LoginId);
        int i1 =driverService.add(driverDto);
        if (i1 > 0 && i2 > 0) {
            //添加成功，跳转至用户列表页面
            url = "redirect:/sjxx.do";
        } else {
            //添加失败，刷新添加页面，重新添加
            url = "redirect:/sjxx.do";
        }
        return url;
    }
    //模糊查询司机信息
    @RequestMapping("/searchDriver.do")
    public ModelAndView searchAdmin(@RequestParam String search,@RequestParam(defaultValue = "1", name = "ym") int ym){
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = driverService.search(search);
        PageInfo<DriverDto> info =
                new PageInfo<DriverDto>(oList);
        ModelAndView mav = new ModelAndView();

        mav.addObject("searchDrivers", info);
        mav.setViewName("searchDriver");
        return mav;
    }
    @RequestMapping("/DeleteDriver.do")
    public String delete(@RequestParam int id) {
        String url = "";
        //将用户id传输给service，并要求返回int类型的结果
        Drivers driver = driverDao.getById(id);
        int i1 = driverService.delete(id);
        int loginId = driver.getLoginId();
        int i2 = userService.deleteLogin(loginId);
        if (i1 > 0 && i2 > 0) {
            //删除成功，跳转至用户列表页面
            url ="redirect:/sjxx.do";
        }else {
            System.out.println(i1);
        }
        return url;
    }
    //根据id修改
    @RequestMapping("/UpdateDriver.do")
    public ModelAndView UpdateDriver(@RequestParam int id){
        ModelAndView mav = new ModelAndView();
        Drivers driver = driverDao.getById(id);
        mav.addObject("driver",driver);
        mav.setViewName("updateDriver");
        return mav;
    }
    @RequestMapping("/updateDriver.do")
    public String updateDriver(@RequestParam int id,
                                @RequestParam String name,
                               @RequestParam String userName,
                               @RequestParam int gender,
                               @RequestParam int age,
                               @RequestParam String phone,
                               @RequestParam String carType,
                               @RequestParam String path){
        Drivers driver = driverDao.getById(id);
        Integer loginId = driver.getLoginId();
        DriverDto driverTable = new DriverDto(loginId, id, name,userName,"00000000",gender,age,phone,carType,path);
        System.out.println(driverTable);
        DriverDto loginTable = new DriverDto(userName,loginId,"00000000");
        System.out.println(loginTable);
        int i1 = driverService.update(driverTable);
        int i2 = userService.updateLogin(loginTable);
        String url="";
        System.out.println(i1);
        System.out.println(i2);
        if (i1>0 && i2>0) {
            //修改成功
            url="redirect:/sjxx.do";
        }else {
            //修改失败
            url="redirect:/sjxx.do";
        }
        return url;
    }
    //司机查看自己信息
    @RequestMapping("/sjgrxx.do")
    public ModelAndView personal(@RequestParam String userName){
        ModelAndView mav = new ModelAndView();
        DriverDto personal = driverService.personal(userName);
        mav.addObject("personal",personal);
        mav.setViewName("personal");
        return mav;
    }
    //司机个人修改信息
    @RequestMapping("/DriverUpdate.do")
    public ModelAndView DriverUpdate(@RequestParam String userName){
        ModelAndView mav = new ModelAndView();
        DriverDto personal = driverDao.personal(userName);
        mav.addObject("driver",personal);
        mav.setViewName("updatePersonalDriver");
        return mav;
    }
    @RequestMapping("/driverUpdate.do")
    public String driverUpdate(@RequestParam int id,
                               @RequestParam String name,
                               @RequestParam String userName,
                               @RequestParam String password,
                               @RequestParam int gender,
                               @RequestParam int age,
                               @RequestParam String phone,
                               @RequestParam String carType,
                               @RequestParam String path,
                               HttpSession session){

        Drivers driver = driverDao.getById(id);
        Integer loginId = driver.getLoginId();
        DriverDto driverTable = new DriverDto(loginId, id,name,userName,password,gender,age,phone,carType,path);
        System.out.println(driverTable);
        DriverDto loginTable = new DriverDto(userName,loginId,password);
        System.out.println(loginTable);
        int i1 = driverService.update(driverTable);
        int i2 = userService.updateLogin(loginTable);
        Map<String,Object> oMap = userService.login(userName, password, 2);
        System.out.println(oMap);
        session.setAttribute("userInfo", oMap);
        String url="";
        System.out.println(i1);
        System.out.println(i2);
        if (i1>0 && i2>0) {
            //修改成功
            url="redirect:/sjgrxx.do?userName="+userName;
        }else {
            //修改失败
            url="redirect:/sjgrxx.do?userName="+userName;
        }
        return url;
    }
    //司机修改密码
    @RequestMapping("/UpdateDriverPassword.do")
    public ModelAndView UpdateDriverPassword(@RequestParam String userName){
        ModelAndView mav = new ModelAndView();
        DriverDto personal = driverDao.personal(userName);
        mav.setViewName("updateDriverPassword");
        mav.addObject("driver",personal);
        return mav;
    }
    @RequestMapping("/updateDriverPassword.do")
    public String updateDriverPassword(@RequestParam String password,@RequestParam int id){
        Drivers driver = driverDao.getById(id);
        String name = driver.getName();
        String userName = driver.getUserName();
        Integer gender = driver.getGender();
        Integer age = driver.getAge();
        String phone = driver.getPhone();
        String carType = driver.getCarType();
        String path = driver.getPath();
        Integer loginId = driver.getLoginId();

        DriverDto driverTable = new DriverDto(loginId, id,name,userName,password,gender,age,phone,carType,path);
        DriverDto loginTable = new DriverDto(userName,loginId,password);
        int i1 = userService.updateLogin(loginTable);
        int i2 = driverService.update(driverTable);
        String url="";
        if (i1>0 && i2>0) {
            //修改成功
            url="redirect:/sjgrxx.do?userName="+userName;
        }else {
            //修改失败
            url="redirect:/sjgrxx.do?userName="+userName;
        }
        return url;
    }
}
