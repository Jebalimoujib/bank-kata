package com.proxiad.bank.service;

import com.proxiad.bank.domain.Account;

public interface BankService {

//	void withdrawal(TransactionCommand transactionCommand);
//
//	void deposit(TransactionCommand transactionCommand);

	void processTransaction(TransactionCommand transactionCommand);

	void printStatement(Account account);
}
