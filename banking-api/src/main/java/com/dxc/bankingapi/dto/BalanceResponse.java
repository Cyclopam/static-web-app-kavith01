package com.dxc.bankingapi.dto;

import java.math.BigDecimal;

public class BalanceResponse {
    private String message;
    private BigDecimal balance;

    public String getMessage() {
        return message;
    }

    public BigDecimal getBalance() {
        return balance;
    }
     public BalanceResponse()
     {

     }
    public BalanceResponse(String message, BigDecimal balance) {
        this.message = message;
        this.balance = balance;
    }

}
