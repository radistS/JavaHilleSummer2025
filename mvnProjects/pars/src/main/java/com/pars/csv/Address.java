package com.pars.csv;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class Address {
    @CsvBindByPosition(position = 3)
    private String street;
    @CsvBindByPosition(position = 4)
    private String city;
    @CsvBindByPosition(position = 5)
    private String zip;

}
