package com.example.AllicaBank.Repository;

import lombok.Setter;
import lombok.Getter;
//import org.springframework.boot.autoconfigure.domain.Entity;
//import jakarta.persistence.*;

import java.time.LocalDate;

@Getter
@Setter
//@Entity
public class Customer{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public AccountID id;
    public String FirstName;
    public String LastName;
    public LocalDate DOB;
}