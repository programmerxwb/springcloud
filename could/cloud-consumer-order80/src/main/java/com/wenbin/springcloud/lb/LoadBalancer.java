package com.wenbin.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
    ServiceInstance instatces(List<ServiceInstance> serviceInstances);
}
