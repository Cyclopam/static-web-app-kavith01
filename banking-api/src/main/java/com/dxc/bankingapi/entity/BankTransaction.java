package com.dxc.bankingapi.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bank_transaction")
public class BankTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100 )
    private String name;

    @Column(nullable = false,precision = 10 , scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "txn_type" , nullable= false, length = 20 )
    private TransactionType txnTpe;

    @Column(name = "txn_date", nullable = false)
    private LocalDateTime txnDate;


    public BankTransaction( String name, BigDecimal amount, TransactionType txnTpe, LocalDateTime txnDate, BankMaster bankMaster) {
        this.name = name;
        this.amount = amount;
        this.txnTpe = txnTpe;
        this.txnDate = txnDate;
        this.bankMaster = bankMaster;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="acc_id", nullable =false)
    private BankMaster bankMaster;

    public BankTransaction() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getTxnTpe() {
        return txnTpe;
    }

    public void setTxnTpe(TransactionType txnTpe) {
        this.txnTpe = txnTpe;
    }

    public LocalDateTime getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(LocalDateTime txnDate) {
        this.txnDate = txnDate;
    }

    public BankMaster getBankMaster() {
        return bankMaster;
    }

    public void setBankMaster(BankMaster bankMaster) {
        this.bankMaster = bankMaster;
    }
}
