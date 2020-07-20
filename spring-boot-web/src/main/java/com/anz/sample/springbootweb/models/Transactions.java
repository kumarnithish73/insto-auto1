package com.anz.sample.springbootweb.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable= false, updatable=false)
	private int id;
	
	private Double debitAmount;
	@Column
	private Double creditAmount;
	@Column
	private String transactionType;
	@Column
	private Date transactionNarrative;
	@Column
	private Integer accountNumber;
	@Column
	private String accountName;
	@Column
	private String currency;

	public Transactions() {
		super();
	}
	public Transactions(Double debitAmount, Double creditAmount, String transactionType, Date transactionNarrative,
			Integer accountNumber, String accountName, String currency) {
		super();
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.transactionType = transactionType;
		this.transactionNarrative = transactionNarrative;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.currency = currency;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(Date transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/*
	 * public Account getAccount() { return account; }
	 * 
	 * public void setAccount(Account account) { this.account = account; }
	 */

}
