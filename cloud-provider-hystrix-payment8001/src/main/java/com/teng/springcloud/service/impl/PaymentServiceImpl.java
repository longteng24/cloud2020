package com.teng.springcloud.service.impl;

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
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_Ok:"+id+"haha";

    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        int timeNum = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_Timeout:"+id+"haha";
    }
}
