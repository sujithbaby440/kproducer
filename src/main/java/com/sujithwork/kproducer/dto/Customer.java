package com.sujithwork.kproducer.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    private int id;
    private String name;
    private String email;
    private String contactNo;
}
