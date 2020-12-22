package com.wenbin.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wenbin.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "default_paymentInfo_TimeoutHandler")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        return orderService.payment_ok(id);
    }

    /*@HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties= {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })*/
    //@HystrixCommand
    @GetMapping("payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id")Integer id){
        return orderService.paymentInfo_Timeout(id);
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "对不起，机房着火了!！";
    }

    public String default_paymentInfo_TimeoutHandler(){
        return "对不起，机房着火了!！(全局)";
    }
}
