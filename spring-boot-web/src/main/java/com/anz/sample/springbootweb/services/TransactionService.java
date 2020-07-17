package com.anz.sample.springbootweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.sample.springbootweb.models.Transactions;
import com.anz.sample.springbootweb.repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	public List<Transactions> fetchTransactions(Integer accountNumber){
		return transactionRepository.findByAccountNumber(accountNumber);
	}

}
