package com.dxc.bankingapi.dto;

import java.math.BigDecimal;

public class AccountResponse {

    private Long  id;
    private String name;

    public AccountResponse(Long id, String name, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    private BigDecimal balance;

}
