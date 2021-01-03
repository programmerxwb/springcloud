package com.wenbin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/nocas/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(SERVICE_URL + "/payment/nocas/" + id, String.class);
    }

}
