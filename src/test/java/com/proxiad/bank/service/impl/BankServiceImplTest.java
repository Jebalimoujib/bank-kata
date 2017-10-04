package com.proxiad.bank.service.impl;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.proxiad.bank.ApplicationConfig;
import com.proxiad.bank.domain.Account;
import com.proxiad.bank.service.BankService;
import com.proxiad.bank.service.TransactionCommand;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BankServiceImplTest {

	@Autowired
	private BankService bankService;

	@Test
	public void test() {
		Account account = new Account();
		TransactionCommand transactionCommand = new TransactionCommand();
		transactionCommand.setAccount(account);
		transactionCommand.setDate(new Date());
		transactionCommand.setValue(100);
		bankService.processTransaction(transactionCommand);
		bankService.processTransaction(transactionCommand);
		transactionCommand.setValue(-50);
		bankService.processTransaction(transactionCommand);
		bankService.printStatement(account);
	}

}
