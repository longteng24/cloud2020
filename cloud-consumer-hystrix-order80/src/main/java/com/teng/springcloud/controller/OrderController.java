package com.teng.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.teng.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: OrderController
 * @description: 订单接口调用支付接口
 * @author: teng
 * @create: 2020/03/2020/3/9  14:31
 **/
@RestController
@DefaultProperties(defaultFallback = "paymentInfo_Global_Handler")
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/get/{id}")
    public String getPaymentById(@PathVariable("id") Long id) {
       //int g = 10 / 0;
        return paymentService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String gettimeout(@PathVariable("id") Integer id) {
        return paymentService.gettimeout(id);
    }


    public String paymentInfo_TimeoutHandler(@PathVariable("id") Integer id) {
        return "我是消费方80，对方支付系统繁忙 请稍后再试  " + id + "haha";
    }

    public String paymentInfo_Global_Handler() {
        return "我是消费方80， 系统故障，请稍后再试  ";
    }


}
