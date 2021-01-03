package ccom.wenbin.nacos.controller;

import ccom.wenbin.nacos.service.PaymentService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloud.entities.CommonResult;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    private String service_url = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback",exceptionsToTrace = {NullPointerException.class})
    public CommonResult fallback(@PathVariable("id") Long id) {

        if (id == 4) {
            throw new IllegalArgumentException("参数异常");
        } else if(id == 5 ){
            throw new NullPointerException();
        }else{
            return restTemplate.getForObject(service_url + "/payment/" + id, CommonResult.class);
        }
    }

    public CommonResult handlerFallback(Long id, Throwable e) {
        return new CommonResult(444, "机房着火了" + e.getMessage());
    }

    //--------------openfeign

    @Resource
    private PaymentService paymentService;
    @GetMapping("feign/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        return paymentService.getPayment(id);
    }


}
