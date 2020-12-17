package cloud.wenbin.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentCpntroller {
    @Value("${server.port}")
    private String port;

    @GetMapping("payment/consul")
    public String paymentConsult(){
        return "port:"+port+"\t"+ UUID.randomUUID().toString();
    }
}
