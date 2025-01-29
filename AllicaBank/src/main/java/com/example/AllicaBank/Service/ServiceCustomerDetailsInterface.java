package com.example.AllicaBank.Service;

import com.example.AllicaBank.Controller.Request.CustomerDetailsRequest;
import com.example.AllicaBank.Controller.Response.AccountIDResponse;

public interface ServiceCustomerDetailsInterface {
    AccountIDResponse storeCustomerDetails(CustomerDetailsRequest c);
}
