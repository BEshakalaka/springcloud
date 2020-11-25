package com.codeshuai.springcloud.dao;

import com.codeshuai.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/11/19 1:27
 */
@Mapper
public interface PaymentDao {

    /**
     * 写操作
     */
    public int create(Payment payment);

    /**
     * 读操作
     */
    public Payment getPaymentById(@Param("id") Long id);
}
