package com.wenbin.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springcloud.entities.CommonResult;
import springcloud.entities.Payment;

import java.util.HashMap;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    public static HashMap<Long, Payment> hashMap = new HashMap<Long, Payment>();

    static {
        hashMap.put(1L, new Payment(1L, "-----------------1"));
        hashMap.put(2L, new Payment(2L, "-----------------2"));
        hashMap.put(3L, new Payment(3L, "-----------------3"));
    }

    @GetMapping("payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {

        return new CommonResult(200, "OK,port:" + port, hashMap.get(id));
    }
}
