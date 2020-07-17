package com.anz.sample.springbootweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.sample.springbootweb.models.Account;
import com.anz.sample.springbootweb.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public List<Account> fetchAccountDetails(){
		return accountRepository.findAll();
	}

}
