package com.wenbin.springcloud.controlser;

import com.wenbin.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springcloud.entities.CommonResult;
import springcloud.entities.Payment;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果是" + result);
        if (result > 0) {
            return new CommonResult(200, "success port:" + serverPort, result);
        }
        return new CommonResult(444, "faile");
    }

    @GetMapping(value = "payment/{id}")
    public CommonResult getPaymentByid(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("插入结果是" + result);
        if (result != null) {
            return new CommonResult(200, "success", result);
        }
        return new CommonResult(444, "faile");
    }

    @GetMapping("payment/lb")
    public String getPayMentPort(){
        return serverPort;
    }

    @GetMapping("payment/get")
    public String getPayment(){
        return "this is payment/get";
    }

    @GetMapping("payment/feign")
    public String paymentFeignTimeOut() throws InterruptedException {
        Thread.sleep(3000);
        return "success";
    }
}
