package com.wenbin.springcloud.controller;

import com.wenbin.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springcloud.entities.CommonResult;
import springcloud.entities.Payment;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "consumer/payment/{id}")
    public CommonResult<Payment> getPaymentByid(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentByid(id);
    }

    @GetMapping("consumer/payment/lb")
    public String getPayMentPort(){
        return paymentFeignService.getPayMentPort();
    }

    @GetMapping("consumer/payment/feign")
    public String paymentFeignTimeOut(){
        return paymentFeignService.paymentFeignTimeOut();
    }
}
