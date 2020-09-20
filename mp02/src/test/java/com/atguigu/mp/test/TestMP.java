package com.atguigu.mp.test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

public class TestMP {
	
	private ApplicationContext ioc = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
	
	/**
	 * AR  分页复杂查询操作
	 */
	@Test
	public void  testARPage() {
		
		Employee employee = new Employee();
		
		Page<Employee> page = employee.selectPage(new Page<>(1, 3), 
				new EntityWrapper<Employee>().like("last_name", "老"));
		//得到分页结果
		List<Employee> emps = page.getRecords();
		System.out.println(emps);
	}
	
	
	/**
	 * AR 删除操作
	 * 
	 * 注意: 删除不存在的数据 逻辑上也是属于成功的. 
	 */
	@Test
	public void testARDelete() {
		
		Employee employee = new Employee();
		
		//根据id删除
		//boolean result = employee.deleteById(2);
		//等价
//		employee.setId(2);
//		boolean result = employee.deleteById();
//		System.out.println("result:" +result );
		
		//条件构造器 模糊删除
//		boolean result = employee.delete(new EntityWrapper<Employee>().like("last_name", "小"));
//		System.out.println(result );
	}
	
	
	/**
	 * AR 查询操作
	 */
	@Test
	public void testARSelect() {
		
		Employee employee = new Employee();
		
		//根据id查询
//		Employee result = employee.selectById(6);
		//等价：
//		employee.setId(6);
//		Employee result = employee.selectById();
//		System.out.println(result );
		
		//查询全部
//		List<Employee> emps = employee.selectAll();
//		System.out.println(emps);
		
		//条件构造器 模糊查询
//		List<Employee > emps= employee.selectList(new EntityWrapper<Employee>()
//				.like("last_name", "老师"));
//		System.out.println(emps);
		
		//条件构造器 统计查询
//		Integer result = employee.selectCount(new EntityWrapper<Employee>().eq("gender", 0));
//		System.out.println("result: " +result );
		
	}
	
	
	/**
	 * AR 修改操作
	 */
	@Test
	public void testARUpdate() {
		
//		Employee employee = new Employee();
//		employee.setId(9);
//		employee.setLastName("宋老湿");
//		employee.setEmail("sls@atguigu.com");
//		employee.setGender(1);
//		employee.setAge(35);
//		
//		
//		boolean result = employee.updateById();
//		System.out.println("result:" +result );
	}
	
	
	/**
	 * AR  插入操作
	 */
	@Test
	public void  testARInsert() {
		
//		Employee employee = new Employee();
//		employee.setLastName("宋老师");
//		employee.setEmail("sls@atguigu.com");
//		employee.setGender(1);
//		employee.setAge(35);
//		
//		boolean result = employee.insert();
//		System.out.println("result:" +result );
	}
}
