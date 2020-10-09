package com.atguigu.mp.test;

import javax.swing.text.DefaultStyledDocument.AttributeUndoableEdit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class TestMP {

	/**
	 * 代码生成 示例代码
	 */
	@Test
	public void testGenerator() {
		// 1. 全局配置
		GlobalConfig config = new GlobalConfig();
		config.setActiveRecord(true) // 是否支持AR模式
				.setAuthor("longwanli") // 作者
				.setOutputDir("F:\\SSM框架学习\\MyBatis_Plus\\mp03\\src\\main\\java") // 生成路径
				.setFileOverride(true) // 文件覆盖
				.setIdType(IdType.AUTO) // 主键策略
				//%s 会自动填充表实体属性
				.setServiceName("%sService") // 设置生成的service接口的名字的首字母是否为I，IEmployeeService
				.setBaseResultMap(true) // 在mapper.xml中生成基本的resultMap
				.setBaseColumnList(true); // 在mapper.xml中生成基本的表列名封装sql片段

		// 2. 数据源配置
		DataSourceConfig dsConfig = new DataSourceConfig();
		dsConfig.setDbType(DbType.MYSQL) // 设置数据库类型
				.setDriverName("com.mysql.jdbc.Driver")
				.setUrl("jdbc:mysql://localhost:3306/mp?characterEncoding=utf8")
				.setUsername("root")
				.setPassword("123456");

		// 3. 策略配置
		StrategyConfig stConfig = new StrategyConfig();
		stConfig.setCapitalMode(true) // 全局大写命名
				.setDbColumnUnderline(true) // 指定表名、字段名是否使用下划线
				.setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
				.setTablePrefix("tbl_") //设置表前缀，多个前缀用String数组封装即可
				//排除某些表用setExclude()
				.setInclude("tbl_employee"); // 生成的表，多个表用String数组封装即可

		// 4. 包名策略配置
		PackageConfig pkConfig = new PackageConfig();
		pkConfig.setParent("com.atguigu.mp")
				.setMapper("mapper")
				.setService("service")
				.setController("controller")
				.setEntity("beans")
				.setXml("mapper");

		// 5. 整合配置
		AutoGenerator ag = new AutoGenerator();

		ag.setGlobalConfig(config)
		  .setDataSource(dsConfig)
		  .setStrategy(stConfig)
		  .setPackageInfo(pkConfig);

		// 6. 执行
		ag.execute();
	}

}
