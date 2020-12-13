package com.wenbin.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced // 负载均衡能力，通过微服务名称请求
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
