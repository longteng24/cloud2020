package com.teng.springcloud.controller;

import com.teng.springcloud.entities.CommonResult;
import com.teng.springcloud.entities.Payment;
import com.teng.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: PaymentController
 * @description:
 * @author: XZQ
 * @create: 2020/3/5 19:03
 **/
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/hystrix/ok/{id}")
    String paymentInfo_Ok(@PathVariable("id") Integer id){
        String result= paymentService.paymentInfo_Ok(id);
        return result;
    }
    @GetMapping("/hystrix/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable("id")Integer id){
        String result=paymentService.paymentInfo_Timeout(id);
        return result;
    }
}

