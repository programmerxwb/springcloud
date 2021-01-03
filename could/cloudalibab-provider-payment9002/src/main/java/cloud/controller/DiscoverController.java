package cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoverController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/nocas/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "this is nocas, serverPort: " + port;
    }
}
