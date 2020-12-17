package com.wenbin.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springcloud.entities.CommonResult;
import springcloud.entities.Payment;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "payment/{id}")
    public CommonResult getPaymentByid(@PathVariable("id") Long id);

    @GetMapping("payment/lb")
    public String getPayMentPort();

    @GetMapping("payment/feign")
    public String paymentFeignTimeOut();

}
