package com.wenbin.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {
    int a = 0;

    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        System.out.println(Thread.currentThread().getName() + "------" + System.currentTimeMillis());
        return "------testB";
    }

    @GetMapping("testThread")
    public String testThread() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return "----testThread";
    }

    @GetMapping("testD")
    public String testD() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println(System.currentTimeMillis());
        return "----testD";
    }

    @GetMapping("testE")
    public String testE() {
        if (a++ % 2 == 0) {
            int b = 10 / 0;
        }
        System.out.println(a);
        return "----testD";
    }

    @GetMapping("testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2) {
        return p1 + "-----" + p2;
    }

    public String deal_testHotKey(String p1, String p2, BlockException e) {
        return "机房着火了！";

    }
}
