package com.wenbin.springcloud.controller;

import com.sun.jndi.toolkit.url.Uri;
import com.wenbin.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springcloud.entities.CommonResult;
import springcloud.entities.Payment;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;

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

    @GetMapping(value = "consumer/paymen/fotEntity/{id}")
    public CommonResult getPaymentByidEntity(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> forObject = restTemplate.getForEntity(PAYMENT_URL + "/payment/" + id, CommonResult.class);
        if(forObject.getStatusCode().is2xxSuccessful()){
        return forObject.getBody();
        }else{
            return new CommonResult(500,"fatal");
        }
    }

    @GetMapping("payment/lb")
    public String getPaymentLb(){

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(serviceInstances == null || serviceInstances.size() <= 0){
            return "error";
        }
        ServiceInstance serviceInstance = loadBalancer.instatces(serviceInstances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
