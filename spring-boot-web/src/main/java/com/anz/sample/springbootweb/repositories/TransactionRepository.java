package com.anz.sample.springbootweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.sample.springbootweb.models.Transactions;


@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Integer> {

	List<Transactions> findByAccountNumber(Integer accountNumber);
}
