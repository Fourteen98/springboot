package com.example.demo.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResponse {
    private String name;
    private int age;
}
