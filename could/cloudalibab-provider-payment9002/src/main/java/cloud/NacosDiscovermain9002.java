package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscovermain9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosDiscovermain9002.class, args);
    }
}
