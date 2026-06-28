package com.dxc.bankingapi.controller;


import com.dxc.bankingapi.dto.AccountResponse;
import com.dxc.bankingapi.dto.AmountRequest;
import com.dxc.bankingapi.dto.BalanceResponse;
import com.dxc.bankingapi.dto.TransactionResponse;
import com.dxc.bankingapi.service.BankingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final BankingService bankingService;
    public AccountController(BankingService bankingService)
    {
        this.bankingService = bankingService;
    }


    @PostMapping("/deposit")
    public BalanceResponse deposit(@Valid @RequestBody AmountRequest request){
        return bankingService.deposit(request);
    }

    @PostMapping("/withdraw")
    public BalanceResponse withdraw(@Valid @RequestBody AmountRequest request){
        return bankingService.withdraw(request);
    }

    @GetMapping("/{accountId}")
    public AccountResponse getAccount(@PathVariable Long accountId){
        return bankingService.getAccount(accountId);
    }

    @GetMapping("/{accountId}/transactions")
    public List<TransactionResponse> getTransactionHistory(@PathVariable Long accountId){
        return bankingService.getTransactionHistory(accountId);
    }


}
