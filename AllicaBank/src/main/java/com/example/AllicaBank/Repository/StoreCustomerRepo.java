package com.example.AllicaBank.Repository;

import com.example.AllicaBank.Controller.Request.CustomerDetailsRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class StoreCustomerRepo {

    List<Customer> customerList = new ArrayList<>();

    public String storeCustomer(CustomerDetailsRequest customerDetailsRequest) throws Exception{

        boolean duplicate = customerList.stream().filter(c->c.getFirstName().equalsIgnoreCase(customerDetailsRequest.getFirstName()) &&
                c.getLastName().equalsIgnoreCase(customerDetailsRequest.getLastName()) &&
                c.getDOB().isEqual(customerDetailsRequest.getDOB())).count() >=1;
        if(!duplicate){
            Customer c = new Customer();
            c.setFirstName(customerDetailsRequest.getFirstName());
            c.setLastName(customerDetailsRequest.getLastName());
            c.setDOB(customerDetailsRequest.getDOB());
            String accountIDString = UUID.randomUUID().toString();
            AccountID id = new AccountID();
            id.setAccountID(accountIDString);
            c.setId(id);
            customerList.add(c);
            return accountIDString;
        }
        else{
            throw new Exception("Duplicate account request");
        }
    }

    //public interface StoreCustomerRepo extends JPARepository<Customer, Long>{}

}
