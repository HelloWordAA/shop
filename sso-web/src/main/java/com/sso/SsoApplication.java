package com.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.demo")
@EnableEurekaClient
public class SsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoApplication.class, args);
	}

//	@Bean
//	@LoadBalanced   //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
//	public RestTemplate getRestTemplate(){
//		return  new RestTemplate();
//	}
}


