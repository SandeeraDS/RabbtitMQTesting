package com.ds.rabbitmq.rabbtitmqtesting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderStatus {
    private Order order;
    private String status; //progress, completed
    private String message;

}
