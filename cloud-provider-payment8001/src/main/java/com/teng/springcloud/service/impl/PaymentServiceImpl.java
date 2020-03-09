package com.teng.springcloud.service.impl;

import com.teng.springcloud.dao.PaymentDao;
import com.teng.springcloud.entities.Payment;
import com.teng.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: PaymentServiceImpl
 * @description:
 * @author: teng
 * @create: 2020/3/5 18:19
 **/
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
