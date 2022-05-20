package com.example.catalogservice.payload;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdsSourceDto {

    private  String name;

    private boolean isActive=true;
}
