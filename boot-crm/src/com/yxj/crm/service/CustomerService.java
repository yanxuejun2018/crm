package com.yxj.crm.service;

import com.yxj.crm.pojo.Customer;
import com.yxj.crm.pojo.QueryVo;
import com.yxj.crm.utils.Page;

public interface CustomerService {
    //获取全部数据
    Page<Customer> getCustomerByQueryVo(QueryVo vo);
    //获取 分页

    //获取一个
    Customer getCustomerById(Integer integer);
    //修改
    void updateCustomer(Customer customer);
    //删除
    void deleteCustomer(Integer integer);
}

