package com.wenbin.cloud.controller;

import com.wenbin.cloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StreamMQController {

    @Resource
    private IMessageProvider provider;

    @GetMapping("sendMessage")
    public String sendMessage(){
        return provider.send();
    }

}
