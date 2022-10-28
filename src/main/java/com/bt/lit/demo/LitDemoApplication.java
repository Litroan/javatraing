package com.bt.lit.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bt.lit.demo", "com.bt.lit.demo.controller", "com.bt.lit.demo.model", "com.bt.lit.demo.vo" })
@EntityScan(basePackages = { "com.bt.lit.demo", "com.bt.lit.demo.controller", "com.bt.lit.demo.model", "com.bt.lit.demo.vo" })
public class LitDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LitDemoApplication.class, args);
	}

}
