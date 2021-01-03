package com.wenbin.sentinel.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import springcloud.entities.CommonResult;

public class CustomerhBlockHandler {
    public static CommonResult handlerException(BlockException ex) {
        return new CommonResult(444, "global Exception------1");
    }

    public static CommonResult handlerException2(BlockException ex) {
        return new CommonResult(444, "global Exception------2");
    }
}
