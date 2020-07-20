package com.anz.sample.springbootweb;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.anz.sample.springbootweb.controllers.AccountDetailsController;
import com.anz.sample.springbootweb.models.Account;
import com.anz.sample.springbootweb.models.Transactions;
import com.anz.sample.springbootweb.repositories.AccountRepository;
import com.anz.sample.springbootweb.services.AccountService;
import com.anz.sample.springbootweb.services.TransactionService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = AnzSampleRequirementApplication.class)
@SpringBootTest
public class AccountDetailsControllerTest {
	private MockMvc mockMvc;

	@InjectMocks
	private AccountDetailsController accountDetailsController;

	@Mock
	private AccountService accountService;
	@Mock
	private AccountRepository accountRespository;

	@Mock
	TransactionService transactionService;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(accountDetailsController).build();
	}

	@Test

	public void testAccountDetailsWithException() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/list").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test

	public void testAccountDetails() throws Exception {
		when(accountService.fetchAccountDetails()).thenReturn(getAccountDetails());
		mockMvc.perform(MockMvcRequestBuilders.get("/list").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test

	public void testTransactionsWithException() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/accountNumber/252525252").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test

	public void testTransactions() throws Exception {
		when(transactionService.fetchTransactions(252525252)).thenReturn(getTrasactionDetails());
		mockMvc.perform(MockMvcRequestBuilders.get("/accountNumber/252525252").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testTransactionsNotFoundException() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/accountNumber/252525252").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	private static List<Account> getAccountDetails() {
		List<Account> accounts = new ArrayList<Account>();

		Account al = new Account();
		al.setAccountBalance(123522222.00);
		al.setAccountNumber(2020202020);
		accounts.add(al);
		return accounts;
	}

	private static List<Transactions> getTrasactionDetails() {
		List<Transactions> transactions = new ArrayList<>();
		Transactions transaction = new Transactions();
		transaction.setAccountNumber(252525252);
		transaction.setAccountName("DEBIT");
		transactions.add(transaction);
		return transactions;

	}
}
