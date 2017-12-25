package com.xjxspace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


//MyBatis 支持
@MapperScan("com.xjxspace.mapper")
//filter 支持
@ServletComponentScan(basePackages="com.xjxspace.filter")
@SpringBootApplication
public class MainApplicion {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainApplicion.class, args);
	}

}
