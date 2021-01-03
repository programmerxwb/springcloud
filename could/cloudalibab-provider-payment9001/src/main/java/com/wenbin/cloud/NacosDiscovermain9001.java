package com.wenbin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscovermain9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosDiscovermain9001.class, args);
    }
}
