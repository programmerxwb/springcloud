package springcloud.controlser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springcloud.entities.CommonResult;
import springcloud.entities.Payment;
import springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果是" + result);
        if (result > 0) {
            return new CommonResult(200, "success,prot:" + serverPort, result);
        }
        return new CommonResult(444, "fial");
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

    @GetMapping(value = "payment/discovery")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        for (String str : list) {
            log.info("element-----" + str);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : instances) {
            log.info(serviceInstance.getHost() + "\t" + serviceInstance.getInstanceId() + "\t" + serviceInstance.getPort());
        }
        return this.discoveryClient;
    }

    @GetMapping("payment/lb")
    public String getPayMentPort() {
        return serverPort;
    }

    @GetMapping("payment/get")
    public String getPayment() {
        return "this is payment/get";
    }

    @GetMapping("payment/feign")
    public String paymentFeignTimeOut() throws InterruptedException {
        Thread.sleep(3000);
        return "success";
    }
}
