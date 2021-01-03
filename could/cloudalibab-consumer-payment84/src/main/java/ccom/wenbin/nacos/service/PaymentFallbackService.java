package ccom.wenbin.nacos.service;

import org.springframework.stereotype.Component;
import springcloud.entities.CommonResult;

@Component
public class PaymentFallbackService implements PaymentService {

    public CommonResult getPayment(Long id) {
        return new CommonResult(444, "服务降级返回");
    }
}
