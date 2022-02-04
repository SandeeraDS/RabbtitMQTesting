package com.ds.rabbitmq.rabbtitmqtesting.consumer;

import com.ds.rabbitmq.rabbtitmqtesting.entity.OrderStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import static com.ds.rabbitmq.rabbtitmqtesting.config.MessageConfig.DS_QUEUE_01;
import static com.ds.rabbitmq.rabbtitmqtesting.config.MessageConfig.DS_QUEUE_02;

@Configuration
public class User {
    private static final Logger logger = LogManager.getLogger(User.class);

    @RabbitListener(queues = DS_QUEUE_01)
    public void consumeMessageFromQueue1(OrderStatus orderStatus) {
        logger.info("");
        logger.info("");
        logger.info("---------------------------------------------------------------------------------");
        logger.info("-------------------------------Order Placed Status-------------------------------");
        logger.info(orderStatus);
        logger.info("---------------------------------------------------------------------------------");
    }

    @RabbitListener(queues = DS_QUEUE_02)
    public void consumeMessageFromQueue2(OrderStatus orderStatus) {
        logger.info("");
        logger.info("");
        logger.info("---------------------------------------------------------------------------------");
        logger.info("----------------------------Order Completed Status-------------------------------");
        logger.info(orderStatus);
        logger.info("---------------------------------------------------------------------------------");
    }
}
