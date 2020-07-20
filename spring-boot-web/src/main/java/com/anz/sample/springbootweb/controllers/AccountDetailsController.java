package com.anz.sample.springbootweb.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.anz.sample.springbootweb.exceptions.AccountDetailsNotFoundException;
import com.anz.sample.springbootweb.models.Account;
import com.anz.sample.springbootweb.models.Transactions;
import com.anz.sample.springbootweb.services.AccountService;
import com.anz.sample.springbootweb.services.TransactionService;


@RestController

@Api(value = "wholesaleaccount", description = "Operations pertaining to Whole sale Accounts and transactions")

public class AccountDetailsController {

	@Autowired
	AccountService accountService;
	@Autowired
	TransactionService transactionService;

	@ApiOperation(value = "View a list of Accounts", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 404, message = "Details not found") })
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Account> fetchAccountDetails(Model model) {
		List<Account> accounts = accountService.fetchAccountDetails();
		if (CollectionUtils.isEmpty(accounts)) {
			throw new AccountDetailsNotFoundException("No accounts found");
		}
		return accounts;
	}

	@ApiOperation(value = "View list of transactions performed", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 404, message = "Details not found") })
	
	@RequestMapping(value = "/accountNumber/{accountNumber}", method = RequestMethod.GET, produces = "application/json")
	public List<Transactions> fetchTransactionsList(@PathVariable Integer accountNumber, Model model) {
		List<Transactions> transactions = transactionService.fetchTransactions(accountNumber);
		if (CollectionUtils.isEmpty(transactions)) {
			throw new AccountDetailsNotFoundException("Account number not found");
		}
		return transactions;
	}
}
