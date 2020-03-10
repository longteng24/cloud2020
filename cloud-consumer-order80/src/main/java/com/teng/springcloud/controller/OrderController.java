package  com.teng.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.teng.springcloud.entities.CommonResult;
import com.teng.springcloud.entities.Payment;

import javax.annotation.Resource;

/**
 * @ClassName: OrderController
 * @description: 订单接口调用支付接口
 * @author: teng
 * @create: 2020/03/2020/3/9  14:31
 **/
@RestController
public class OrderController {
    //    private final static String PAYMENT_URL = "http://localhost:8001";
    private final static String PAYMENT_URL = "http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class,id);
    }
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment  payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }

}
