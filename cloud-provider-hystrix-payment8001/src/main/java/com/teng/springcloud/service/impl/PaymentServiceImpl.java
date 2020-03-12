package com.teng.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.teng.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: PaymentServiceImpl
 * @description:
 * @author: teng
 * @create: 2020/3/5 18:19
 **/
@Service
public class PaymentServiceImpl implements PaymentService {


    @Override
    public String paymentInfo_Ok(Integer id) {
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_Ok:"+id+"......haha";

    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "15000")
    })
    public String paymentInfo_Timeout(Integer id) {

      //  int age = 10 / 0;
        try {
          TimeUnit.MILLISECONDS.sleep(1800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_Timeout:"+id+".....haha";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "15000"),
            @HystrixProperty(name="circuitBreaker.enabled", value = "true"),  //开启熔断
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "10"),   //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //窗口期时间
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value = "60")   //失败率达到多少时
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 5) {
            throw new RuntimeException("id  不能小于5");
        }

        return "线程池："+Thread.currentThread().getName()+"paymentCircuitBreaker:"+id+".......haha";
    }
    public String paymentCircuitBreakerHandler(Integer id) {
        return "id不能小于5，请稍后再试..id"+id+".....haha";
    }
    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池："+Thread.currentThread().getName()+"： 8001运行出错 ,paymentInfo_TimeoutHandler:"+id+"..........haha";
    }
}
