package com.dxc.bankingapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {
    private Long id;
    private BigDecimal amount;
    private String txnType;

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getTxnType() {
        return txnType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public TransactionResponse(Long id, BigDecimal amount, String txnType, LocalDateTime date) {
        this.id = id;
        this.amount = amount;
        this.txnType = txnType;
        this.date = date;
    }

    private LocalDateTime date;

}
