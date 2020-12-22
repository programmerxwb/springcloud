package com.wenbin.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "id:" + String.valueOf(id);
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_Timeout(Integer id) throws InterruptedException {
        Thread.sleep(3000);
        //int a = 10/0;
        return "线程池：" + Thread.currentThread().getName() + "TimeOUt  id:" + id + "耗时3秒";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "对不起，机房着火了！";
    }

    // 服务熔断

    @HystrixCommand(fallbackMethod = "paymentCricuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),   // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  // 时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")  // 失败率达到多少次后熔断
    })
    public String paymentCricuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("运行时异常！");
        }

        String num = UUID.randomUUID().toString();

        return Thread.currentThread().getName() + "-----" + num;
    }

    public String paymentCricuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id不可以是负数";
    }
}
