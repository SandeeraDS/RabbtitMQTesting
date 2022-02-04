package com.ds.rabbitmq.rabbtitmqtesting.producer;

import com.ds.rabbitmq.rabbtitmqtesting.entity.Order;
import com.ds.rabbitmq.rabbtitmqtesting.entity.OrderStatus;
import org.aspectj.weaver.ast.Or;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.ds.rabbitmq.rabbtitmqtesting.config.MessageConfig.*;

@RestController
@RequestMapping("/order")
public class OrderProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order,@PathVariable  String restaurantName) throws InterruptedException {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus1 = new OrderStatus(order,"PROGRESS","Order placed successfully in "+restaurantName);
        rabbitTemplate.convertAndSend(DS_EXCHANGE,DS_ROUTING_KEY_01,orderStatus1);
        Thread.sleep(5000);
        OrderStatus orderStatus2 = new OrderStatus(order,"COMPLETED","Order completed successfully in "+restaurantName);
        rabbitTemplate.convertAndSend(DS_EXCHANGE,DS_ROUTING_KEY_02,orderStatus2);
        return "success";
    }
}
