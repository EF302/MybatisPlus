package com.atguigu.mp.beans;

import com.baomidou.mybatisplus.annotations.KeySequence;

//将@keySequence定义在父类中，可实现多个子类对应的多个表，且共用一个Sequence，就不用在每个实体类中都配置@keySequence
@KeySequence(value="seq_user",clazz=Integer.class)
public abstract class Parent {

}
