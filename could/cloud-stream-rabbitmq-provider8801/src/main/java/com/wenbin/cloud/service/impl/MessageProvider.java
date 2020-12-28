package com.wenbin.cloud.service.impl;

import com.wenbin.cloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;


@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProvider implements IMessageProvider {

    @Resource(name = "output")
    private MessageChannel messageChannel;


    public String send() {
        String str = UUID.randomUUID().toString();
        messageChannel.send(MessageBuilder.withPayload(str).build());
        System.out.println("*****message:" + str);
        return null;
    }
}
