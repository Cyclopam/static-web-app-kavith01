package com.dxc.bankingapi.repository;

import com.dxc.bankingapi.entity.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long>
{
 List<BankTransaction> findByBankMasterIdOrderByTxnDateAsc(Long accountId);


}
