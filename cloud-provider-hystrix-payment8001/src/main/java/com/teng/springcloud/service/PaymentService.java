package com.teng.springcloud.service;

/**
 * @InterfaceName: PaymentService
 * @description:
 * @author: XZQ
 * @create: 2020/3/5 18:18
 **/
public interface PaymentService {
  String paymentInfo_Ok(Integer id);

  String paymentInfo_Timeout(Integer id);
}
