package com.atguigu.mp.beans;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

//已经配置了全局表前缀，MybatisPlus默认使用实体类的类名到数据库中找对应的表没问题
public class Employee extends Model<Employee> {
	
	//这里继承Model，已经在实现方法pkVal中，指明主键属性，
	//不用再使用注解@TableId(value="id" , type =IdType.AUTO)
	private Integer id ;   //  int 
	private String  lastName; 
	private String  email ;
	//性别：0代表男，1代表女
	private Integer gender; 
	private Integer age ;
	//数据库中无相应字段对应，可把该属性设置为不映射数据库字段
	@TableField(exist=false)
	private Double salary ; 
	
	/**
	 * 指定当前实体类的主键属性
	 */
	@Override
	protected Serializable pkVal() {
		return id;
	}
	
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
