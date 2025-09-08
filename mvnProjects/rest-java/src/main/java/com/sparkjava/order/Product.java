package com.sparkjava.order;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private UUID UUID; // not necessary
    private String name;
    private double cost;
    private double count;
}
