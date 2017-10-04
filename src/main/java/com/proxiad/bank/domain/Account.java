package com.proxiad.bank.domain;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private int value;
	private List<Transaction> transactions;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void addTransactions(Transaction transaction) {
		if (transactions == null) {
			transactions = new ArrayList<Transaction>();
		}
		transactions.add(transaction);
	}

}
