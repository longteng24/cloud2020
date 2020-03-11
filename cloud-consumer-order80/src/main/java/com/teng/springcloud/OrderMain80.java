package  com.teng.springcloud;

import com.teng.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName: PaymentMain8001
 * @description: PaymentMain8001主启动类
 * @author: teng
 * @create: 2020/3/5 17:30
 **/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="cloud-payment-service",configuration = MySelfRule.class)
public class OrderMain80 {
     public static void main(String[] args) {
     SpringApplication.run(OrderMain80.class, args);
   }
}
