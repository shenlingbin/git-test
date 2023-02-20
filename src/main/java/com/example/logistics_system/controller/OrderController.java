package com.example.logistics_system.controller;

import com.example.logistics_system.dao.IOrderDao;
import com.example.logistics_system.pojo.Admin;
import com.example.logistics_system.pojo.Orders;
import com.example.logistics_system.service.IOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:沈玲彬
 * @create: 2022-10-16 20:23
 * @Description:
 */
@Controller
public class OrderController {
    @Autowired
    private IOrderService orderService;

    private List<Orders> oList;
    @Autowired
    private IOrderDao orderDao;
    //管理员查询所有信息
    @RequestMapping("/ddxx.do")
    public ModelAndView getAll(@RequestParam(defaultValue = "1", name = "ym") int ym) {
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = orderService.all();
        PageInfo<Orders> info =
                new PageInfo<Orders>(oList);
        ModelAndView mav = new ModelAndView();
        mav.addObject("orders", info);
        mav.setViewName("order1");
        return mav;
    }
    //司机查询所有订单信息
    @RequestMapping("/dddxx.do")
    public ModelAndView driverGetAll(@RequestParam(defaultValue = "1", name = "ym") int ym) {
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = orderService.all();
        PageInfo<Orders> info =
                new PageInfo<Orders>(oList);
        ModelAndView mav = new ModelAndView();
        mav.addObject("orders", info);
        mav.setViewName("order2");
        return mav;
    }
    //模糊查询
    @RequestMapping("/searchOrders.do")
    public ModelAndView adminSearch(@RequestParam String search,@RequestParam(defaultValue = "1", name = "ym") int ym){
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = orderService.search(search);
        PageInfo<Orders> info =
                new PageInfo<Orders>(oList);
        ModelAndView mav = new ModelAndView();

        mav.addObject("searchOrders", info);
        mav.setViewName("searchOrder1");
        return mav;
    }
    //模糊查询
    @RequestMapping("/driverSearchOrders.do")
    public ModelAndView driverSearch(@RequestParam String search,@RequestParam(defaultValue = "1", name = "ym") int ym){
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = orderService.search(search);
        PageInfo<Orders> info =
                new PageInfo<Orders>(oList);
        ModelAndView mav = new ModelAndView();

        mav.addObject("searchOrders", info);
        mav.setViewName("searchOrder2");
        return mav;
    }
    @RequestMapping("/customerSearchOrders.do")
    public ModelAndView Customersearch(@RequestParam String search,@RequestParam(defaultValue = "1", name = "ym") int ym){
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = orderService.search(search);
        PageInfo<Orders> info =
                new PageInfo<Orders>(oList);
        ModelAndView mav = new ModelAndView();

        mav.addObject("searchOrders", info);
        mav.setViewName("searchOrder3");
        return mav;
    }
    //客户根据用户名查看自己的订单
    @RequestMapping("/cddxx.do")
    public ModelAndView customerGetAll(@RequestParam(defaultValue = "1", name = "ym") int ym,@RequestParam String userName){
        //设置当前显示的页数和每页上显示的条数
        PageHelper.startPage(ym, 4);
        oList = orderService.personalOrder(userName);
        PageInfo<Orders> info =
                new PageInfo<Orders>(oList);
        ModelAndView mav = new ModelAndView();
        mav.addObject("personalOrders", info);
        mav.setViewName("personalOrder");
        return mav;
    }
    //根据id删除订单
    @RequestMapping("/DeleteOrder.do")
    public String delete(@RequestParam int id) {
        Orders order = orderDao.order(id);
        String orderUser = order.getOrderUser();
        String url = "";
        //将用户id传输给service，并要求返回int类型的结果
        int i = orderService.delete(id);
        if (i > 0) {
            //删除成功，跳转至用户列表页面
            url = "redirect:/cddxx.do?userName="+orderUser;
        }
        return url;
    }
    @RequestMapping("/UpdateOrder.do")
    public ModelAndView UpdateOrder(@RequestParam int id){
        Orders order = orderDao.order(id);
        System.out.println(order);
        ModelAndView mav = new ModelAndView();
        mav.addObject("order",order);
        mav.setViewName("updateOrder");
        return mav;
    }
    @RequestMapping("/updateOrder.do")
    public String updateOrder(@RequestParam int id,
                              @RequestParam String productNumber,
                              @RequestParam String productName,
                              @RequestParam String productUnit,
                              @RequestParam String deliverman){
        Orders order = orderDao.order(id);
        String orderUser = order.getOrderUser();
        Orders orders = new Orders(id,productName, productNumber, productUnit, deliverman);
        int i = orderService.update(orders);
        String url = "";
        if(i>0){
            url = "redirect:/cddxx.do?userName="+orderUser;
        }
        return url;
    }
    @RequestMapping("/AddOrder.do")
    public String AddOrder(){
        return "addOrder";
    }
    @RequestMapping("/addOrder.do")
    public String addOrder(Orders order){
        String orderUser = order.getOrderUser();
        System.out.println(orderUser);
        int i = orderService.add(order);
        String url ="";
        if(i>0){
            url = "redirect:/cddxx.do?userName="+orderUser;
        }
        return url;
    }
}
