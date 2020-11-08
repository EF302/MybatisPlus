package com.atguigu.mp.mapper;

import com.atguigu.mp.beans.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author longwanli
 * @since 2020-10-09
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
	
	int deleteAll();
}
