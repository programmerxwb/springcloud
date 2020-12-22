package com.wenbin.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HytrixDashboard9001 {

    public static void main(String[] args) {
        SpringApplication.run(HytrixDashboard9001.class, args);
    }
}
