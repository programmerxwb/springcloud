package com.wenbin.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
// 全局过滤器
public class CustomerFilter implements Ordered, GlobalFilter {
    @Override

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("********come in GlobalFilter");
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null){
            System.err.println("非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    // 设置优先级，数据越小，优先级越高
    public int getOrder() {
        return 0;
    }
}
