package com.teng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName: PaymentMain8001
 * @description: PaymentMain8001主启动类
 * @author: teng
 * @create: 2020/3/5 17:30
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
     public static void main(String[] args) {
     SpringApplication.run(ConfigCenterMain3344.class, args);
   }
}
