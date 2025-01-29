package com.example.AllicaBank.Controller.Request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerDetailsRequest {

    public String FirstName;
    public String LastName;
    LocalDate DOB;
}
