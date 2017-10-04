package com.proxiad.bank.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.proxiad.bank.domain.Account;
import com.proxiad.bank.domain.Transaction;
import com.proxiad.bank.service.BankService;
import com.proxiad.bank.service.TransactionCommand;

@Service
public class BankServiceImpl implements BankService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BankServiceImplTest.class);

	private void withdrawal(TransactionCommand transactionCommand) {
		if (transactionCommand.validateTransaction()) {
			Account account = transactionCommand.getAccount();
			account.setValue(account.getValue() + transactionCommand.getValue());
			Transaction transaction = transactionCommand.getTransaction();
			account.addTransactions(transaction);
		} else {
			// TODO Handle Exception
			LOGGER.warn("unauthorized transaction");
		}
	}

	private void deposit(TransactionCommand transactionCommand) {
		if (transactionCommand.validateTransaction()) {
			Account account = transactionCommand.getAccount();
			account.setValue(account.getValue() + transactionCommand.getValue());
			Transaction transaction = transactionCommand.getTransaction();
			account.addTransactions(transaction);
		} else {
			// TODO Handle Exception
			LOGGER.warn("unauthorized transaction");

		}
	}

	public void printStatement(Account account) {
		String transactionName = "";
		for (Transaction transaction : account.getTransactions()) {
			if (transaction.getValue() > 0) {
				transactionName = "deposit";
			} else {
				transactionName = "withdrawal";
			}
			LOGGER.debug("{} date: {}, value : {} ", transactionName, transaction.getDate().toString(),
					transaction.getValue());
		}
		LOGGER.debug("Current balance {} ", account.getValue());
	}

	public void processTransaction(TransactionCommand transactionCommand) {
		if (transactionCommand.getValue() > 0) {
			LOGGER.debug("deposit ");
			deposit(transactionCommand);
		} else {
			LOGGER.debug("withdrawal ");
			withdrawal(transactionCommand);
		}

	}

}
