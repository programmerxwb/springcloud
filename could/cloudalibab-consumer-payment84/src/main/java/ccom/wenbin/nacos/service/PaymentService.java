package ccom.wenbin.nacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springcloud.entities.CommonResult;

@Component
@FeignClient(value = "nacos-payment-provider")
public interface PaymentService {
    @GetMapping("payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id);
}
