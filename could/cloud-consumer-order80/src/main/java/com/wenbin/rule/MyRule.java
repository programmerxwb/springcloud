package com.wenbin.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 配置
@Configuration
public class MyRule {
    @Bean
    public IRule getRule(){
        return new RandomRule();
    }
}
