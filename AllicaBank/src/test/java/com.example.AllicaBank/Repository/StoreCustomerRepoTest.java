package com.example.AllicaBank.Repository;

import com.example.AllicaBank.Controller.Request.CustomerDetailsRequest;
import com.example.AllicaBank.Controller.Response.AccountIDResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StoreCustomerRepoTest {

    private StoreCustomerRepo storeCustomerRepo;

    @BeforeEach
    void setUp() {
        storeCustomerRepo = new StoreCustomerRepo();
    }

    @Test
    void testStoreCustomer_Success() throws Exception {
        CustomerDetailsRequest request = new CustomerDetailsRequest();
        request.setFirstName("Alice");
        request.setLastName("Wonderland");
        request.setDOB(LocalDate.of(2000, 4, 12));

        String accountID = storeCustomerRepo.storeCustomer(request);

        assertEquals(36, accountID.length()); // UUID length
    }

    @Test
    void testStoreCustomer_DuplicateException() throws Exception {
        CustomerDetailsRequest request = new CustomerDetailsRequest();
        request.setFirstName("Bob");
        request.setLastName("Builder");
        request.setDOB(LocalDate.of(1995, 8, 20));

        storeCustomerRepo.storeCustomer(request); // First insert

        Exception exception = assertThrows(Exception.class, () -> storeCustomerRepo.storeCustomer(request));
        assertEquals("Duplicate account request", exception.getMessage());
    }
}