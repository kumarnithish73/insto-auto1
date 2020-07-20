package com.anz.sample.springbootweb;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.anz.sample.springbootweb.models.Account;
import com.anz.sample.springbootweb.models.Transactions;
import com.anz.sample.springbootweb.repositories.AccountRepository;
import com.anz.sample.springbootweb.repositories.TransactionRepository;
import com.anz.sample.springbootweb.services.AccountService;
import com.anz.sample.springbootweb.services.TransactionService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AnzSampleRequirementApplication.class)
@SpringBootTest
public class AnzSampleRequirementApplicationTests {

	@Autowired
	private AccountService accountService;
	@MockBean
	private AccountRepository accountRepository;
	@Autowired
	private TransactionService transactionService;
	@MockBean
	private TransactionRepository transactionRepository;

	@Test
	public void fetchAccountDetails() {

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		when(accountRepository.findAll())
				.thenReturn(Stream
						.of(new Account(25282589, "SAVINGS", "DEBIT", date, "EUR", 0.0),
								new Account(25282589, "SAVINGS", "DEBIT", date, "EUR", 12.0))
						.collect(Collectors.toList()));
		assertEquals(2, accountService.fetchAccountDetails().size());
	}

	@Test
	public void fetchTransactionDetails() {
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		when(transactionRepository.findByAccountNumber(25282589)).thenReturn(Stream
				.of(new Transactions(2500.00, 3500.00, "Savings", date, 25282589, "EUR", "DEBIT"),
						new Transactions(2500.00, 3500.00, "Savings", date, 25282589, "EUR", "DEBIT"))
				.collect(Collectors.toList()));
		assertEquals(2, transactionService.fetchTransactions(25282589).size());
	}

}
