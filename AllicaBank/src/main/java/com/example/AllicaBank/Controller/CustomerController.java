
package com.example.AllicaBank.Controller;


import com.example.AllicaBank.Controller.Request.CustomerDetailsRequest;
import com.example.AllicaBank.Controller.Response.AccountIDResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.AllicaBank.Service.ServiceCustomerDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;



@RestController
@RequestMapping("/v1/baseURL")
public class CustomerController {

    @Autowired
    ServiceCustomerDetails s;

    //@RequestBody
    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "/StoreCustomerDetails", consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary="Stores the customer details and returns account ID")
    public AccountIDResponse StoreCustomerDetails(@RequestBody CustomerDetailsRequest customer){
        return s.storeCustomerDetails(customer);
    }


}