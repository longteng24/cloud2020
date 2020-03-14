package com.teng.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ConfigController
 *
 * http://localhost:3355/actuator/refresh   post   Content-Type  :  application/json 手动刷新
 * @description:
 * @author: teng
 * @create: 2020/03/2020/3/13  10:23
 **/
@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getServerPort() {
        return "当前配置信息 ：" + configInfo;
    }


}
