package com.anz.sample.springbootweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anz.sample.springbootweb.models.Transactions;

@Repository

public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
	@Query(value = "select id ,debit_amount, credit_amount ,account_number,account_name,currency,transaction_narrative,transaction_type from transaction t where t.account_number =:accountNumber", nativeQuery = true)
	List<Transactions> findByAccountNumber(Integer accountNumber);
}
