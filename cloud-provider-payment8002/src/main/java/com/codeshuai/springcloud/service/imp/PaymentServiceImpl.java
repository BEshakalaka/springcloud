package com.codeshuai.springcloud.service.imp;

import com.codeshuai.springcloud.dao.PaymentDao;
import com.codeshuai.springcloud.entities.Payment;
import com.codeshuai.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/11/19 1:42
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
