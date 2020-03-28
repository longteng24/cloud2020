package com.teng.springcloud.controller;

import com.teng.springcloud.entities.CommonResult;
import com.teng.springcloud.entities.Payment;
import com.teng.springcloud.service.IMessageProvider;
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
 * @author: teng
 * @create: 2020/3/5 19:03
 **/
@RestController
public class SendMessaggeController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value="/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}

