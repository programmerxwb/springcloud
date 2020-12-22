package com.wenbin.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements OrderService{
    public String payment_ok(Integer id) {
        return "着火了！";
    }

    public String paymentInfo_Timeout(Integer id) {
        return "疫情了";
    }
}
