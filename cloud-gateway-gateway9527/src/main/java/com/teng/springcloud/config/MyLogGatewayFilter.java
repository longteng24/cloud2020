package com.teng.springcloud.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @ClassName: MyLogGatewayFilter
 * @description: 自定义过滤器
 * @author: teng
 * @create: 2020/03/2020/3/13  8:11
 **/
@Component
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("**********come in mylogGateWayFilter :"+new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null) {
            System.out.println("**********用户名为null,非法用户 :"+new Date());
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }


        return chain.filter(exchange);
    }
   /**
    *功能描述  过滤器优先级
    * @author teng
    * @date 2020/3/13
    * @param  * @param
    * @return int
    */
    @Override
    public int getOrder() {
        return 0;
    }
}
