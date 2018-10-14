package com.yxj.crm.controller;


import com.yxj.crm.pojo.BaseDict;
import com.yxj.crm.pojo.Customer;
import com.yxj.crm.pojo.QueryVo;
import com.yxj.crm.service.BaseDictService;
import com.yxj.crm.service.CustomerService;
import com.yxj.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 客户信息请求请求处理
 *
 * @author Steven
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private BaseDictService dictService;

    @Autowired
    private CustomerService service;


    @Value("${customer_from_type}")
    private String customer_from_type;

    @Value("${customer_industry_type}")
    private String customer_industry_type;

    @Value("${customer_level_type}")
    private String customer_level_type;

    @RequestMapping("/list")
    public String list(Model model, QueryVo vo) {

        // 查询来源
        List<BaseDict> fromType = dictService.getBaseDictByCode(customer_from_type);
        // 查询行业
        List<BaseDict> industryType = dictService.getBaseDictByCode(customer_industry_type);
        // 查询级别
        List<BaseDict> levelType = dictService.getBaseDictByCode(customer_level_type);

        // 设置数据模型返回
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        // 查询分页数据
        Page<Customer> page = service.getCustomerByQueryVo(vo);
        //返回分页数据
        model.addAttribute("page", page);


        return "customer";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Customer edit(Integer id) {
        Customer byId = service.getCustomerById(id);
        return byId;
    }

    //修改数据
    @RequestMapping("update")
    @ResponseBody
    public String update(Customer customer) {
        String msg = "1";
        try {
            service.updateCustomer(customer);
            msg = "0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    //删除用户信息
    @RequestMapping("/dalete")
    public String dalete(Integer id) {
        String msg = "1";
        try {
            service.deleteCustomer(id);
            msg = "0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @RequestMapping("/myTag")
    public String myTage() {
        return "myTag";
    }
}
