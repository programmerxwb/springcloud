package com.wenbin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {
    @Value("${user.name}")
    private String name;

    @Value("${server.port}")
    private String port;

    @GetMapping("/client/name")
    public String getName(){
        return this.name + "----" + this.port;
    }
}
