package com.teng.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @ClassName: PaymentController
 * @description:
 * @author: teng
 * @create: 2020/3/5 19:03
 **/
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {


    @Value(("${server.port}"))
    private String serverPort;
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者1号：----》收到" + message.getPayload() + "\t port:" + serverPort);
    }

}

