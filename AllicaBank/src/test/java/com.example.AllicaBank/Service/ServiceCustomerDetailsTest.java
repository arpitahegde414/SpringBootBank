package com.example.AllicaBank.Service;

import com.example.AllicaBank.Controller.Request.CustomerDetailsRequest;
import com.example.AllicaBank.Controller.Response.AccountIDResponse;
import com.example.AllicaBank.Repository.StoreCustomerRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ServiceCustomerDetailsTest {

    @Mock
    private StoreCustomerRepo storeCustomerRepo;

    @InjectMocks
    private ServiceCustomerDetails serviceCustomerDetails;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testStoreCustomerDetails_Success() throws Exception {
        CustomerDetailsRequest request = new CustomerDetailsRequest();
        request.setFirstName("Jane");
        request.setLastName("Doe");
        request.setDOB(java.time.LocalDate.of(1995, 5, 15));

        String accountID = "98765-XYZ";
        when(storeCustomerRepo.storeCustomer(request)).thenReturn(accountID);

        AccountIDResponse response = serviceCustomerDetails.storeCustomerDetails(request);

        assertEquals("98765-XYZ", response.getAccountID());
        assertEquals("We have successfully saved the customer details", response.getResponseMessage());
        assertEquals("RESP001", response.getResponseCode());
    }

    @Test
    void testStoreCustomerDetails_DuplicateException() throws Exception {
        CustomerDetailsRequest request = new CustomerDetailsRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setDOB(java.time.LocalDate.of(1990, 1, 1));

        when(storeCustomerRepo.storeCustomer(request)).thenThrow(new Exception("Duplicate account request"));

        AccountIDResponse response = serviceCustomerDetails.storeCustomerDetails(request);

        assertEquals("ERR001", response.getResponseCode());
        assertEquals("We couldnt store customer details because: Duplicate account request", response.getResponseMessage());
    }
}
