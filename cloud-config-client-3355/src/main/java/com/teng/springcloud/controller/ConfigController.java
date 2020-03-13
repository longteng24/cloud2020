package com.teng.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ConfigController
 * @description:
 * @author: teng
 * @create: 2020/03/2020/3/13  10:23
 **/
@RestController
public class ConfigController {

    @Value("${foo}")
    private String configInfo;

    @GetMapping("/hi")
    public String getServerPort() {
        return "当前配置信息 ：" + configInfo;
    }


}
