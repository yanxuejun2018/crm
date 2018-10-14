package com.yxj.crm.mapper;

import com.yxj.crm.pojo.Customer;
import com.yxj.crm.pojo.QueryVo;

import java.util.List;

public interface CustomerMapper {
//查询查询条件，分页查询用户列表
    List<Customer> getCustomerByQueryVo(QueryVo vo);
    //获取 分页
    Integer getCountByQueryVo(QueryVo vo);
//获取一个
    Customer getCustomerById(Integer integer);
//修改
    void updateCustomer(Customer customer);
//删除
    void deleteCustomer(Integer integer);
}
