package com.sparkjava.order;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {
    private UUID uuid;
    private Timestamp createAt;
    private Timestamp updateAt;
    private double cost;
    private List<Product> products = new ArrayList<>();
}
