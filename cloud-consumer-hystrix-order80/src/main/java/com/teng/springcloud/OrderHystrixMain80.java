package com.teng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: PaymentMain8001
 * @description: PaymentMain8001主启动类
 * @author: teng
 * @create: 2020/3/5 17:30
 **/
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain80 {
     public static void main(String[] args) {
     SpringApplication.run(OrderHystrixMain80.class, args);
   }
}
