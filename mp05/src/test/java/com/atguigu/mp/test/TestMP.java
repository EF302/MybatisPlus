package com.atguigu.mp.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.beans.User;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.atguigu.mp.mapper.UserMapper;
import com.baomidou.mybatisplus.plugins.Page;

public class TestMP {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

	EmployeeMapper employeeMapper = ctx.getBean("employeeMapper", EmployeeMapper.class);
	
	UserMapper userMapper = ctx.getBean("userMapper", UserMapper.class);

	/**
	 * 测试Oracle 主键 Sequence
	 */
	@Test
	public void testOracle() {
		User user = new User();
		user.setLogicFlag(1);
		user.setName("OracleSEQ");
		userMapper.insert(user);
	}

	/**
	 * 测试公共字段填充
	 */
	@Test
	public void testMetaObjectHandler() {
		User user = new User();
		// user.setName("Tom");//不设置name值，让其自动填充

		user.setId(5);
		user.setLogicFlag(1);
		
		userMapper.insert(user);
		//userMapper.updateById(user);
	}

	/**
	 * 测试逻辑删除
	 */
	@Test
	public void testLogicDelete() {

		Integer result = userMapper.deleteById(2);
		System.out.println("result:" +result );

		//逻辑删除后，尝试查询：失败
//		User user = userMapper.selectById(1);
//		System.out.println(user);
	}

	/**
	 * 测试自定义全局操作
	 */
	@Test
	public void testMySqlInjector() {
		Integer result = employeeMapper.deleteAll();
		System.out.println("result: " + result);
	}

}
