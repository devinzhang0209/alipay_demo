package com.devin.alipay_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.devin.alipay_demo.dao")
@SpringBootApplication
public class AlipayDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlipayDemoApplication.class, args);
	}

}
