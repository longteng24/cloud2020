package com.teng.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName: PaymentFallbackService
 * @description: 实现降级
 * @author: teng
 * @create: 2020/03/2020/3/12  12:05
 **/
@Component
public class PaymentFallbackService   implements  PaymentService{
    @Override
    public String getPaymentById(Long id) {
        return "PaymentFallbackService  fall  getPaymentById  gg";
    }

    @Override
    public String gettimeout(Integer id) {
        return "PaymentFallbackService  fall  gettimeout  gg";
    }
}
