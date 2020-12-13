package com.wenbin.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springcloud.entities.CommonResult;
import springcloud.entities.Payment;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "consumer/payment/create")
    public CommonResult create(Payment payment) {
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        return commonResult;
    }

    @GetMapping(value = "consumer/payment/{id}")
    public CommonResult<Payment> getPaymentByid(@PathVariable("id") Long id){
        CommonResult forObject = restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
        return forObject;
    }
}
