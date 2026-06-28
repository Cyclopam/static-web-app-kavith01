package com.dxc.bankingapi.entity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import org.hibernate.annotations.DialectOverride;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(
        name="bank_master",
        uniqueConstraints={@UniqueConstraint(columnNames ="name")}
)
public class BankMaster {
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getPwd() {
        return pwd;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100 , unique = true)
    private String name;

    @Column(nullable = false,precision = 10 , scale = 2)
    private BigDecimal balance;

    @Column(nullable = false,length = 255 )
    private String pwd;

    @OneToMany(mappedBy = "bankMaster" ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BankTransaction> transactions = new ArrayList<>();

    public BankMaster(){

    }

    public List<BankTransaction> getTransactions() {
        return transactions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setTransactions(List<BankTransaction> transactions) {
        this.transactions = transactions;
    }

    public BankMaster(String name, BigDecimal balance , String pwd){
        this.name = name;
        this.balance = balance;
        this.pwd = pwd;

    }



}
