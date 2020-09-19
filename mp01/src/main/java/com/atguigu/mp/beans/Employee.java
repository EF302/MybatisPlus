package com.atguigu.mp.beans;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

//虽然MybatisPlus会默认使用实体类的类名到数据库中找对应的表，但数据库中的表名一般会加固定前缀
@TableName(value="tbl_employee")
public class Employee {
	
	/*
	 * @TableId:
	 * 	 value: 指定表中的主键列的列名， 如果实体属性名与列名一致，可以省略不指定. 
	 *   type: 指定主键策略. 
	 * 注意：MyBatisPlus中，映射的实体类中如果不指定主键策略，会报数据类型不匹配异常mismatch
	 */
	@TableId(value="id" , type =IdType.AUTO)
	//性别：0代表男，1代表女
	private Integer id ;   
	@TableField(value = "last_name")
	private String  lastName; 
	private String  email ;
	private Integer gender; 
	private Integer age ;
	//数据库中无相应字段对应，可把该属性设置为不映射数据库字段
	@TableField(exist=false)
	private Double salary ; 
	
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + ", age="
				+ age + "]";
	} 
	
	
}
