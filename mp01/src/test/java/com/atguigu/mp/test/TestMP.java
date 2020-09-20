package com.atguigu.mp.test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	private EmployeeMapper employeeMapper = 
			ioc.getBean("employeeMapper",EmployeeMapper.class);
	
	/**
	 * 条件构造器  删除操作：delete
	 */
	@Test
	public void testEntityWrapperDelete() {
		
		Integer result = employeeMapper.delete(
					new EntityWrapper<Employee>()
					.eq("last_name", "Tom")
					.eq("age", 22)
				);
		System.out.println("result："+result);
	}
	
	
	/**
	 * 条件构造器  修改操作：update
	 */
	@Test
	public void testEntityWrapperUpdate() {
		
//		Employee employee = new Employee();
//		employee.setLastName("苍老师");
//		employee.setEmail("cls@sina.com");
//		employee.setGender(0);
//		
//		// 把名字为tom、年龄为20的记录修改
//		int result = employeeMapper.update(employee, 
//					new EntityWrapper<Employee>()
//					.eq("last_name", "Tom")
//					.eq("age", 20)
//					);
//		System.out.println("result:"+result);
	}
	
	/**
	 * 条件构造器   查询操作：selectPage、selectList
	 */
	@Test
	public void testEntityWrapperSelect() {
		
		// 我们需要分页查询tbl_employee表中，年龄在18~50之间且性别为男且姓名为Tom的所有用户
		// 虽然Map也可以封装多条件查询，但是一般也仅仅用于简单且具体的多条件查询
		// 注意：条件构造器中的条件字段与数据库中的字段一致！
//		Page<Employee> page = new Page<Employee>(1,3);
//		// 注意：page参数不能为null
//		List<Employee> emps = employeeMapper.selectPage(page,new EntityWrapper<Employee>()
//				.between("age", 18, 50)
//				.eq("gender", 1)
//				.eq("last_name", "Tom"));
//		System.out.println(emps);
	
		//使用条件构造器Condition实现：没有泛型参数，可以调用静态方法create()快速得到一个condition对象
//		Page<Employee> page = new Page<Employee>(1,3);
//		// 注意：page参数不能为null
//		List<Employee> emps = employeeMapper.selectPage(page,Condition.create()
//				.between("age", 18, 50)
//				.eq("gender", 1)
//				.eq("last_name", "Tom"));
//		System.out.println(emps);
		
		
		// 查询tbl_employee表中， 性别为女、名字中带有"老师" 或者  邮箱中带有"a"
//		List<Employee> emps = employeeMapper.selectList(
//				new EntityWrapper<Employee>()
//				.eq("gender", 0)
//				.like("last_name", "老师")
////				.or()    // SQL: (gender = ? AND last_name LIKE ? OR email LIKE ? )   
//				.orNew()   // SQL: (gender = ? AND last_name LIKE ?) OR (email LIKE ?) 
//				.like("email", "a"));
//		System.out.println(emps);
		
		
		// 查询性别为女的, 根据age进行排序(asc/desc), 简单分页
		List<Employee> emps  = employeeMapper.selectList(
				new EntityWrapper<Employee>()
				.eq("gender", 0)
				.orderBy("age")//默认为升序
				//倒序，需要传入一个List集合参数
//				.orderDesc(Arrays.asList(new String [] {"age"}))
				//也可在orderBy的同时，借助last方法，手动拼接一个字符串到查询结尾，有sql注入的风险！
//				.last("desc")
				//简单分页：limit是MySQL内置函数，其作用用于限制查询结果的条数，第一个参数为偏移量，第二个参数为记录条数限制
				.last("desc limit 1,2")
				);
		System.out.println(emps);
		
	}
	
	
	/**
	 * 通用删除操作：deleteById、deleteByMap、deleteBatchIds
	 */
	@Test
	public void testCommonDelete() {
		
		//1 .根据id进行删除
//		Integer result = employeeMapper.deleteById(13);
//		System.out.println("result: " + result );
		
		//2. 根据条件进行删除
//		Map<String,Object> columnMap = new HashMap<>();
//		columnMap.put("last_name", "MP");
//		columnMap.put("email", "mp@atguigu.com");
//		Integer result = employeeMapper.deleteByMap(columnMap);
//		System.out.println("result: " + result );
		
		//3. 批量删除
//		List<Integer> idList = new ArrayList<>();
//		idList.add(3);
//		idList.add(4);
//		idList.add(5);
//		Integer result = employeeMapper.deleteBatchIds(idList);
//		System.out.println("result: " + result );
	}
	
	
	/**
	 * 通用查询操作：selectById()、selectOne()、selectBatchIds()、selectByMap、selectPage()
	 */
	@Test
	public void  testCommonSelect() {
		//1. 通过id查询
//		Employee employee = employeeMapper.selectById(6);
//		System.out.println(employee);
		
		//2. 通过多个列进行查询：id + lastName，注意：查询结果只能有一个，有多个结果会报错！
//		Employee  employee = new Employee();
//		employee.setId(6);
//		employee.setLastName("龙万里");
//		employee.setGender(0);
//		
//		Employee result = employeeMapper.selectOne(employee);
//		System.out.println("result: " +result );
		
		
		//3. 通过多个id进行查询    <foreach>
//		List<Integer> idList = new ArrayList<>();
//		idList.add(4);
//		idList.add(5);
//		idList.add(6);
//		idList.add(7);
//		List<Employee> emps = employeeMapper.selectBatchIds(idList);
//		System.out.println(emps);
		
		//4. 通过Map封装条件查询：主要用于多条件查询
		//注意：此时map的key应与数据库的字段名一致！
//		Map<String,Object> columnMap = new HashMap<>();
//		columnMap.put("last_name", "tom");
//		columnMap.put("gender", 1);
//		
//		List<Employee> emps = employeeMapper.selectByMap(columnMap);
//		System.out.println(emps);
		
		//5. 分页查询
//		Page page = new Page(2,3);//设置当前页为2，每页数据为3条
//		List<Employee> emps = employeeMapper.selectPage(page, null);
//		System.out.println(emps);
	}
	
	
	/**
	 * 通用更新操作：updateById()、全字段更新updateAllColumnById()
	 */
	@Test
	public void testCommonUpdate() {
		
		//初始化修改对象
		Employee employee = new Employee();
		employee.setId(6);
		employee.setLastName("龙万里");
		employee.setEmail("lwl@sina.com");
		employee.setGender(0);
		//employee.setAge(23);
		
		//Integer result = employeeMapper.updateById(employee);
		//全字段更新
		Integer result = employeeMapper.updateAllColumnById(employee);
		
		System.out.println("result: " + result );
	}
	
	
	/**
	 * 通用插入操作：insert()、全字段插入insertAllColumn()
	 */
	@Test
	public void testCommonInsert() {
		
		//初始化Employee对象
		Employee employee  = new Employee();
		employee.setLastName("longwanli");
		employee.setEmail("longwanli@atguigu.com");
		//employee.setGender(1);
		//employee.setAge(22);
		//salary字段，数据库中没有，对应的实体类中已经设置了忽略！
		employee.setSalary(20000.0);
		
		//两种插入方法：
		// （1）insert方法在插入时， 会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现到SQL语句中
		//Integer result = employeeMapper.insert(employee);  
		
		//（2）全字段插入：insertAllColumn方法在插入时， 不管属性是否非空， 属性所对应的字段都会出现到SQL语句中. 
		Integer result = employeeMapper.insertAllColumn(employee);
		
		System.out.println("result: " + result );
		
		//注意：在MyBatisPlus中，进行插入操作后，自动将主键值回写到实体类中！
		//获取当前数据在数据库中的主键值
		Integer key = employee.getId();
		System.out.println("key:" + key );
	}
	
	
	/**
	 * 初步数据源配置、连接情况测试
	 * @throws Exception
	 */
	@Test
	public void testDataSource() throws Exception {
		DataSource ds  = ioc.getBean("dataSource",DataSource.class);
		System.out.println("数据源："+ds);
		Connection conn = ds.getConnection();
		System.out.println("连接："+conn);
	}

	
	
}
