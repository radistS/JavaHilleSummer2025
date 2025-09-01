package com.pars.csv;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class Student {
    @CsvBindByPosition(position = 0)
    private String id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private String phone;

    private Address address;

}
