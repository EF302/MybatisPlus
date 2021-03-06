package com.atguigu.mp.service.impl;

import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.atguigu.mp.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
	
	//ServiceImpl中有baseMapper属性对象，不用再进行mapper的注入.
	
	/**
	 * EmployeeServiceImpl继承了ServiceImpl
	 * 1. 在ServiceImpl中已经完成Mapper对象的注入（即ServiceImpl中有Mapper对象属性）,直接在EmployeeServiceImpl中进行使用
	 * 2. 在ServiceImpl中也帮我们提供了常用的CRUD方法， 基本的一些CRUD方法在Service中不需要我们自己定义. 
	 */
}
