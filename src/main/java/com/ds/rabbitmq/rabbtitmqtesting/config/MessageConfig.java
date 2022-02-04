package com.ds.rabbitmq.rabbtitmqtesting.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    public static final String DS_QUEUE_01 = "ds_queue_01";
    public static final String DS_QUEUE_02 = "ds_queue_02";
    public static final String DS_EXCHANGE = "ds_exchange";
    public static final String DS_ROUTING_KEY_01 = "ds_routing_key_01";
    public static final String DS_ROUTING_KEY_02 = "ds_routing_key_02";

    @Bean
    public Queue Queue1(){
        return new Queue(DS_QUEUE_01);
    }
    @Bean
    public Queue Queue2(){
        return new Queue(DS_QUEUE_02);
    }
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(DS_EXCHANGE);
    }
    @Bean
    public Binding binding1(@Qualifier("Queue1") Queue queue, Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(DS_ROUTING_KEY_01).noargs();
    }

    @Bean
    public Binding binding2(@Qualifier("Queue2") Queue queue, Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(DS_ROUTING_KEY_02).noargs();
    }


    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template (ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
