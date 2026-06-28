package com.dxc.bankingapi.repository;

import com.dxc.bankingapi.entity.BankMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankMasterRepository extends JpaRepository<BankMaster, Long>
{
  Optional<BankMaster> findByName(String name);
  boolean existsByName(String name);
}
