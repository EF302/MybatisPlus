package com.atguigu.mp.mapper;

import org.springframework.stereotype.Repository;

import com.atguigu.mp.beans.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

//@Repository//为什么不加该注解，也能获取到对应的bean？？？？
public interface UserMapper extends BaseMapper<User>{

}
