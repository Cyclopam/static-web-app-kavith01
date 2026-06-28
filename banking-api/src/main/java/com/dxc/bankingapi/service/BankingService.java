package com.dxc.bankingapi.service;
import com.dxc.bankingapi.dto.*;
import com.dxc.bankingapi.entity.BankMaster;
import com.dxc.bankingapi.entity.BankTransaction;
import com.dxc.bankingapi.entity.TransactionType;
import com.dxc.bankingapi.repository.BankMasterRepository;
import com.dxc.bankingapi.exception.BankException;
import com.dxc.bankingapi.repository.BankTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BankingService {

    private final BankMasterRepository bankMasterRepository;

    public BankingService(BankTransactionRepository bankTransactionRepository, final BankMasterRepository bankMasterRepository) {
        this.bankTransactionRepository = bankTransactionRepository;
        this.bankMasterRepository = bankMasterRepository;
    }

    private final BankTransactionRepository bankTransactionRepository;

    @Transactional
    public MessageResponse registerCustomer(RegisterRequest request) {
        if (bankMasterRepository.existsByName(request.getName())) {
            throw new BankException("Username already exists");
        }

        BankMaster customer = new BankMaster(request.getName() ,request.getOpeningBalance(),request.getPassword());
         BankMaster savedCustomer = bankMasterRepository.save(customer);

         BankTransaction transaction = new BankTransaction(savedCustomer.getName(),request.getOpeningBalance(),
                 TransactionType.DEPOSIT ,LocalDateTime.now(),savedCustomer);

         bankTransactionRepository.save(transaction);
         return new MessageResponse("Customer Registered successfully");

    }
    public MessageResponse login(LoginRequest request){
        return bankMasterRepository.findByName(request.getName())
                .filter(customer -> customer.getPwd().equals(request.getPassword()))
                .map(customer -> new MessageResponse("Login Successful"))
                .orElse(new MessageResponse(("Invalid Username or passowrd")));

            }
    @Transactional
    public BalanceResponse deposit(AmountRequest request) {
        BankMaster account = getAccountEntity(request.getAccountId());
        BigDecimal newBalance = account.getBalance().add(request.getAmount());
        account.setBalance((newBalance));
        bankMasterRepository.save(account);

        BankTransaction transaction = new BankTransaction(
                account.getName(),
                request.getAmount(),
                TransactionType.DEPOSIT,
                LocalDateTime.now(),
                account
        );

        bankTransactionRepository.save(transaction);
        return new BalanceResponse("Deposit Successful", newBalance);
    }

    @Transactional
    public BalanceResponse withdraw(AmountRequest request){
        BankMaster account  =getAccountEntity(request.getAccountId());

        if (account.getBalance().compareTo(request.getAmount()) <0){
            throw new BankException("Insufficient Balance");
        }
        BigDecimal newBalance =account.getBalance().subtract(request.getAmount());
        account.setBalance(newBalance);

        bankMasterRepository.save(account);

        BankTransaction transaction = new BankTransaction(account.getName(),request.getAmount(),TransactionType.WITHDRAW,
                LocalDateTime.now(),account);

        bankTransactionRepository.save(transaction);
        return new BalanceResponse("Withdrawl successful" ,newBalance);

        }

        public AccountResponse getAccount(Long accountId) {
            BankMaster account = getAccountEntity(accountId);
            return new AccountResponse(account.getId(), account.getName(), account.getBalance());

        }
        public List<TransactionResponse> getTransactionHistory(Long accountId) {
            if (!bankTransactionRepository.existsById(accountId)) {
                throw new BankException("Account not found");
            }
            return bankTransactionRepository.findByBankMasterIdOrderByTxnDateAsc(accountId)
                    .stream().map(txn -> new TransactionResponse(
                            txn.getId(),
                            txn.getAmount(),
                            txn.getTxnTpe().name(),
                            txn.getTxnDate()
                    )).toList();
        }
        private BankMaster getAccountEntity(Long accountId){
        return bankMasterRepository.findById(accountId)
                .orElseThrow(() ->new BankException("Account not found"));
        }






}
