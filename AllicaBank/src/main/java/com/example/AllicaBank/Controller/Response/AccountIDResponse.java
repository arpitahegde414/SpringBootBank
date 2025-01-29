package com.example.AllicaBank.Controller.Response;

import com.example.AllicaBank.Repository.AccountID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountIDResponse {

    String accountID;
    String responseMessage;
    String responseCode;
}
