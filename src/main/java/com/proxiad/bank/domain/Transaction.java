package com.proxiad.bank.domain;

import java.util.Date;
import java.util.List;

public class Transaction {

	private int value;
	private Date date;

	public Transaction(int value, Date date) {
		super();
		this.value = value;
		this.date = date;
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
