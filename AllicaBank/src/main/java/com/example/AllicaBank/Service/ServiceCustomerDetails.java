package com.example.AllicaBank.Service;

import com.example.AllicaBank.Controller.Request.CustomerDetailsRequest;
import com.example.AllicaBank.Repository.AccountID;
import com.example.AllicaBank.Controller.Response.AccountIDResponse;
import com.example.AllicaBank.Repository.StoreCustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCustomerDetails implements ServiceCustomerDetailsInterface{
    @Autowired
    private StoreCustomerRepo storeCustomerRepo;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public AccountIDResponse storeCustomerDetails(CustomerDetailsRequest c){
        AccountIDResponse ar = new AccountIDResponse();
        try{
            String aID = storeCustomerRepo.storeCustomer(c);
            //Customer customer = new Customer();
            //customer.setFirstName();
            //customer.setLastName();
            //customer.setDOB();
            //storeCustomerRepo.save(customer);
            ar.setAccountID(aID);
            ar.setResponseMessage("We have successfully saved the customer details");
            ar.setResponseCode("RESP001");
        }
        catch (Exception e){
            logger.error("An error has occurred while storing the customer data: ", e.getMessage());
            ar.setResponseMessage("We couldnt store customer details because: "+e.getMessage());
            ar.setResponseCode("ERR001");
        }
        return ar;
    }
}