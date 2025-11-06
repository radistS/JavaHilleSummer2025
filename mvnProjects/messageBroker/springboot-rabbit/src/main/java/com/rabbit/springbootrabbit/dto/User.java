package com.rabbit.springbootrabbit.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
}
