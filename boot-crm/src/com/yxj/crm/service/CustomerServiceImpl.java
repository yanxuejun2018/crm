package com.yxj.crm.service;

import com.yxj.crm.mapper.CustomerMapper;
import com.yxj.crm.pojo.Customer;
import com.yxj.crm.pojo.QueryVo;
import com.yxj.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl  implements CustomerService{
    @Autowired
    private CustomerMapper customerMapper;



    @Override
    public Page<Customer> getCustomerByQueryVo(QueryVo vo) {

//        查询总记录数
        Integer vo1 = customerMapper.getCountByQueryVo(vo);
//        计算分页从那条开始
        vo.setStart((vo.getPage()-1)*vo.getRows());
        //        查询每页的数据
        List<Customer> queryVo = customerMapper.getCustomerByQueryVo(vo);
        Page<Customer> page = new Page<Customer>(vo1,vo.getPage(),vo.getRows(),queryVo);
        return  page;
    }
//根据id查询用户信息
    @Override
    public Customer getCustomerById(Integer integer) {
        return customerMapper.getCustomerById(integer);
    }

    //修改
    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);

    }
//删除
    @Override
    public void deleteCustomer(Integer integer) {
            customerMapper.deleteCustomer(integer);
    }
}
