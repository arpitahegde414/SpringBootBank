
package com.example.AllicaBank.Controller;

import com.example.AllicaBank.Controller.Request.CustomerDetailsRequest;
import com.example.AllicaBank.Controller.Response.AccountIDResponse;
import com.example.AllicaBank.Service.ServiceCustomerDetails;
import com.example.AllicaBank.Controller.CustomerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

//@WebMvcTest(controllers = CustomerController.class )
class ControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ServiceCustomerDetails serviceCustomerDetails;

    @InjectMocks
    private CustomerController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testStoreCustomerDetails() throws Exception {
        CustomerDetailsRequest request = new CustomerDetailsRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setDOB(java.time.LocalDate.of(1990, 1, 1));

        AccountIDResponse response = new AccountIDResponse();
        response.setAccountID("12345-ABCDE");
        response.setResponseMessage("We have successfully saved the customer details");
        response.setResponseCode("RESP001");

        when(serviceCustomerDetails.storeCustomerDetails(request)).thenReturn(response);

        AccountIDResponse ar = controller.StoreCustomerDetails(request);
        assertEquals(ar.getAccountID(), response.getAccountID());
        assertEquals(ar.getResponseCode(), response.getResponseCode());
        assertEquals(ar.getResponseMessage(), response.getResponseMessage());
    }
}
