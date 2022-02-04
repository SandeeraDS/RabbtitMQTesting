package com.ds.rabbitmq.rabbtitmqtesting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Order {

    private String orderId;
    private String name;
    private double quantity;
    private double price;
}
