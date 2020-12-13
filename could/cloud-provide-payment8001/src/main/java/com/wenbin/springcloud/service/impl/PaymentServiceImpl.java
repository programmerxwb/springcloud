package com.wenbin.springcloud.service.impl;

import com.wenbin.springcloud.dao.PayMetDao;
import com.wenbin.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import springcloud.entities.Payment;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PayMetDao payMetDao;

    public int create(Payment payment) {
        return payMetDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return payMetDao.getPaymentById(id);
    }
}
