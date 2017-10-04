package com.proxiad.bank.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proxiad.bank.domain.Account;
import com.proxiad.bank.domain.Transaction;

public class TransactionCommand {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionCommand.class);

	private Account account;
	private int value;
	private Date date;

	/**
	 * @return true if the transaction is valid
	 */
	public boolean validateTransaction() {
		if (account != null && date != null && account.getValue() + value > 0) {
			return true;
		}
		LOGGER.warn("Invalid transaction account :{}", account);
		return false;
	}

	public Transaction getTransaction() {
		return new Transaction(value, date);
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
