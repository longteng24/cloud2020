package com.teng.springcloud.service.impl;

import com.teng.springcloud.entities.Payment;
import com.teng.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: PaymentServiceImpl
 * @description:
 * @author: teng
 * @create: 2020/3/5 18:19
 **/
@Service
public class PaymentServiceImpl implements PaymentService {



  @Override
  public int create(Payment payment) {
    return 5;
   }

  @Override
  public Payment getPaymentById(Long id) {
    return new Payment();
   }
}
