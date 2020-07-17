package com.anz.sample.springbootweb.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.anz.sample.springbootweb.models.Account;
import com.anz.sample.springbootweb.models.Transactions;
import com.anz.sample.springbootweb.services.AccountService;
import com.anz.sample.springbootweb.services.TransactionService;

@RestController
@RequestMapping("/accounts")
@Api(value = "wholesaleaccount", description = "Operations pertaining to Whole sale Accounts and transactions")

public class AccountDetailsController {

	@Autowired
	AccountService accountService;
	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Account> fetchAccountDetails(Model model) {
		return accountService.fetchAccountDetails();

	}

	@RequestMapping(value = "/accountNumber/{accountNumber}", method = RequestMethod.GET, produces = "application/json")
	public List<Transactions> fetchTransactionsList(@PathVariable Integer accountNumber, Model model) {
		return transactionService.fetchTransactions(accountNumber);

	}
}
