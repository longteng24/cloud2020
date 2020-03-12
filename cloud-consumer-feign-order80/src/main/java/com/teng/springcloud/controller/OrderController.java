package com.teng.springcloud.controller;

import com.teng.springcloud.entities.CommonResult;
import com.teng.springcloud.entities.Payment;
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
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String gettimeout(){
        return paymentService.gettimeout();
    }


}
