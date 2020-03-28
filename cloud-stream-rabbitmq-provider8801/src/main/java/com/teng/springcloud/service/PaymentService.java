package com.teng.springcloud.service;

import com.teng.springcloud.entities.Payment;

/**
 * @InterfaceName: PaymentService
 * @description:
 * @author: XZQ
 * @create: 2020/3/5 18:18
 **/
public interface PaymentService {
  int create(Payment payment);

  Payment getPaymentById(Long id);
}
