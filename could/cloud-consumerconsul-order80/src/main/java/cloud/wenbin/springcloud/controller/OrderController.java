package cloud.wenbin.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    private String URL = "http://consul-provider-payment";

    @GetMapping("order")
    public String order() {
        return restTemplate.getForObject(URL + "/payment/consul", String.class);
    }
}
