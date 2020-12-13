package com.wenbin.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import springcloud.entities.Payment;

@Mapper
public interface PayMetDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
