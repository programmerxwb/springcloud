package cloud.wenbin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class zkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(zkMain80.class,args);
    }
}
