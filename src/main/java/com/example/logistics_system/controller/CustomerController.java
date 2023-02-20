package com.example.logistics_system.controller;

import com.example.logistics_system.Util.Util;
import com.example.logistics_system.dao.ICustomerDao;
import com.example.logistics_system.pojo.CustomerDto;
import com.example.logistics_system.pojo.Customers;
import com.example.logistics_system.pojo.DriverDto;
import com.example.logistics_system.pojo.Drivers;
import com.example.logistics_system.service.ICustomerService;
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
 * @create: 2022-10-16 15:58
 * @Description:
 */
@Controller
public class CustomerController {
    private List<Customers> oList;
    @Autowired
    ICustomerDao customerDao;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IUserService userService;
    //管理员询所有用户信息
    @RequestMapping("/khxx.do")
    public ModelAndView selectAll(@RequestParam(defaultValue = "1", name = "ym") int ym){
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = customerService.all();
        PageInfo<Customers> info =
                new PageInfo<Customers>(oList);
        ModelAndView mav = new ModelAndView();
        mav.addObject("customers",info);
        mav.setViewName("customer1");
        return mav;
    }
    //司机查询所有用户
    @RequestMapping("/dkhxx.do")
    public ModelAndView driverSelectAll(@RequestParam(defaultValue = "1", name = "ym") int ym){
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = customerService.all();
        PageInfo<Customers> info =
                new PageInfo<Customers>(oList);
        ModelAndView mav = new ModelAndView();
        mav.addObject("customers",info);
        mav.setViewName("customer2");
        return mav;
    }
    @RequestMapping("/addCustomer.do")
    public String addCustomer(){
        return "addCustomer";
    }
    @RequestMapping("/AddCustomer.do")
    public String AddCustomer(CustomerDto customerDto){
        customerDto.setUserRole(Util.CUSTOMERUSERROLE);
        customerDto.setPassword("11111111");
        int i1 = userService.addLogin(customerDto);
        Integer loginId = customerDto.getId();
        customerDto.setLoginId(loginId);
        int i2 = customerService.add(customerDto);
        String url ="";
        if (i1 > 0 && i2 > 0) {
            //添加成功，跳转至用户列表页面
            url = "redirect:/khxx.do";
        } else {
            //添加失败，刷新添加页面，重新添加
            url = "redirect:/khxx.do";
        }
        return url;
    }
    @RequestMapping("/DeleteCustomer.do")
    public String Delete(@RequestParam int id){
        Customers customer = customerDao.getLoginId(id);
        Integer loginId = customer.getLoginId();
        int i1 = userService.deleteLogin(loginId);
        int i2 = customerService.delete(id);
        String url ="";
        if (i1 > 0 && i2 > 0) {
            //删除成功，跳转至用户列表页面
            url = "redirect:/khxx.do";
        }
        return url;
    }
    //模糊查询
    @RequestMapping("/searchCustomer.do")
    public ModelAndView searchAdmin(@RequestParam String search,@RequestParam(defaultValue = "1", name = "ym") int ym){
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = customerService.search(search);
        PageInfo<Customers> info =
                new PageInfo<Customers>(oList);
        ModelAndView mav = new ModelAndView();

        mav.addObject("searchCustomers", info);
        mav.setViewName("searchCustomer1");
        return mav;
    }
    //司机搜索客户
    @RequestMapping("/driverSearchCustomer.do")
    public ModelAndView driverSearchCustomer(@RequestParam String search,@RequestParam(defaultValue = "1", name = "ym") int ym){
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = customerService.search(search);
        PageInfo<Customers> info =
                new PageInfo<Customers>(oList);
        ModelAndView mav = new ModelAndView();

        mav.addObject("searchCustomers", info);
        mav.setViewName("searchCustomer2");
        return mav;
    }
    //司机模糊查询
    @RequestMapping("/customerSearchCustomer.do")
    public ModelAndView customerSearchCustomer(@RequestParam String search,@RequestParam(defaultValue = "1", name = "ym") int ym){
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = customerService.search(search);
        PageInfo<Customers> info =
                new PageInfo<Customers>(oList);
        ModelAndView mav = new ModelAndView();

        mav.addObject("searchCustomers", info);
        mav.setViewName("searchCustomer2");
        return mav;
    }
    @RequestMapping("/cgrxx.do")
    public ModelAndView personal(@RequestParam("userName") String userName){
        CustomerDto personal = customerService.personal(userName);
        System.out.println(personal);
        ModelAndView mav = new ModelAndView();
        mav.addObject("personal",personal);
        mav.setViewName("personalCustomer");
        return mav;
    }
    //客户个人修改信息
    @RequestMapping("/CustomerUpdate.do")
    public ModelAndView CustomerUpdate(@RequestParam String userName){
        ModelAndView mav = new ModelAndView();
        CustomerDto personal = customerService.personal(userName);
        mav.addObject("customer",personal);
        mav.setViewName("updatePersonalCustomer");
        return mav;
    }
    @RequestMapping("/customerUpdate.do")
    public String customerUpdate(@RequestParam int id,
                               @RequestParam String name,
                               @RequestParam String userName,
                               @RequestParam String password,
                               @RequestParam int gender,
                               @RequestParam int ordersNumber,
                               @RequestParam String phone,
                               @RequestParam String address,
                               HttpSession session){
        Customers customer = customerDao.getLoginId(id);
        Integer loginId = customer.getLoginId();
        System.out.println(loginId);
        CustomerDto customerTable = new CustomerDto(loginId, id,name,userName,password,gender,ordersNumber,phone,address);
        System.out.println(customerTable);
        CustomerDto loginTable = new CustomerDto(userName,password,loginId);
        System.out.println(loginTable);
        int i1 = customerService.update(customerTable);
        int i2 = userService.updateLogin(loginTable);
        Map<String,Object> oMap = userService.login(userName, password, 3);
        System.out.println(oMap);
        session.setAttribute("userInfo", oMap);
        String url="";
        System.out.println(i1);
        System.out.println(i2);
        if (i1>0 && i2>0) {
            //修改成功
            url="redirect:/cgrxx.do?userName="+userName;
        }else {
            //修改失败
            url="redirect:/cgrxx.do?userName="+userName;
        }
        return url;
    }
    @RequestMapping("/UpdateCustomerPassword.do")
    public ModelAndView UpdateCustomerPassword(@RequestParam String userName){
        ModelAndView mav = new ModelAndView();
        CustomerDto personal = customerDao.personal(userName);
        mav.setViewName("updateCustomerPassword");
        mav.addObject("customer",personal);
        return mav;
    }
    @RequestMapping("/updateCustomerPassword.do")
    public String updateDriverPassword(@RequestParam String password,@RequestParam int id){
        Customers customer = customerDao.getLoginId(id);
        String name = customer.getName();
        String userName = customer.getUserName();
        Integer gender = customer.getGender();
        Integer ordersNumber = customer.getOrdersNumber();
        String phone = customer.getPhone();
        String address = customer.getAddress();
        Integer loginId = customer.getLoginId();
        CustomerDto customerTable = new CustomerDto(loginId, id,name,userName,password,gender,ordersNumber,phone,address);
        CustomerDto loginTable = new CustomerDto(userName,password,loginId);
        int i1 = userService.updateLogin(loginTable);
        int i2 = customerService.update(customerTable);
        String url="";
        if (i1>0 && i2>0) {
            //修改成功
            url="redirect:/cgrxx.do?userName="+userName;
        }else {
            //修改失败
            url="redirect:/cgrxx.do?userName="+userName;
        }
        return url;
    }
}
