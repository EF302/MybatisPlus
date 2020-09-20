package com.atguigu.mp.mapper;

import com.atguigu.mp.beans.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * Mapper接口
 * 	
 * 基于Mybatis：在Mapper接口中编写CRUD相关的方法、提供Mapper接口所对应的SQL映射文件以及方法对应的SQL语句. 
 * 
 * 基于MP：让XxxMapper接口继承 BaseMapper接口即可.
 * 	BaseMapper<T>: 泛型指定的就是当前Mapper接口所操作的实体类类型 
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
	/**
	 * Mybatis的插入方法要实现主键自增，需要在SQL语句中添加：
	 * 	主键自增useGeneratedKeys以及keyProperty（指定一个属性来接收主键值）属性来设置。
	 */
    //   Integer  insertEmployee(Employee employee );
	//   <insert useGeneratedKeys="true" keyProperty="id" > SQL语句...</insert>
}
