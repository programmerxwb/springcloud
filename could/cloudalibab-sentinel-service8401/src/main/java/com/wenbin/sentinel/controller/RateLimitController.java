package com.wenbin.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wenbin.sentinel.myhandler.CustomerhBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.entities.CommonResult;
import springcloud.entities.Payment;

@RestController
public class RateLimitController {
    @GetMapping("byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerException")
    public CommonResult byResource() {
        return new CommonResult(200, "按参数名限流OK", new Payment(2020L, "serial001"));
    }

    public CommonResult handlerException(BlockException e) {
        return new CommonResult(444, e.getClass().getCanonicalName() + "服务不可用");
    }

    @GetMapping("retelimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按照url测试ok", new Payment(2020L, "serial002"));
    }

    @GetMapping("retelimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerhBlockHandler.class, blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "客户自定义测试ok", new Payment(2020L, "serial003"));
    }
}
