package com.teng.springcloud.controller;

import com.teng.springcloud.entities.CommonResult;
import com.teng.springcloud.entities.Payment;
import com.teng.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
//    log.info("插入数据的ID:\t" + payment.getId());
//    log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,端口：" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
//    log.info("***查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询数据成功,端口：" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录", null);
        }
    }
    @GetMapping(value = "/lb")
    public String getLoadBalance(){


        return  serverPort;
    }


    @GetMapping(value = "/feign/timeout")
    public String gettimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return  serverPort;
    }

}

