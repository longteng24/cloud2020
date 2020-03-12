package com.teng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ClassName: PaymentMain8001
 * @description: PaymentMain8001主启动类
 * @author: teng
 * @create: 2020/3/5 17:30
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashMain9001 {
     public static void main(String[] args) {
     SpringApplication.run(HystrixDashMain9001.class, args);
   }
}
