package com.dxc.bankingapi.controller;


import com.dxc.bankingapi.dto.LoginRequest;
import com.dxc.bankingapi.dto.MessageResponse;
import com.dxc.bankingapi.dto.RegisterRequest;
import com.dxc.bankingapi.service.BankingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final BankingService bankingService;
    public CustomerController(BankingService bankingService){
        this.bankingService = bankingService;
    }

    @PostMapping("/register")
    public MessageResponse registerCustomer(@Valid @RequestBody RegisterRequest request){
        return bankingService.registerCustomer(request);

    }

    @PostMapping("/login")
    public MessageResponse login(@Valid @RequestBody LoginRequest request){
        return bankingService.login(request);
    }

}
