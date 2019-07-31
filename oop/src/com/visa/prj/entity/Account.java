package com.visa.prj.entity;
/**
 * This is a class to represent account business data.
 * It allows to credit and debit amount.
 * 
 * @author pradeep
 * @version 1.0
 */

public class Account {
	private double balance; // state of object

	
	/**
	 * method to credit amount into account
	 * 
	 * @param amt amount to be credited
	 */
	public void deposit(double amt) { // public void deposit(Account this, double amt)
		this.balance += amt;					// this.balance += amt;
	}
	
	/**
	 * method returns the current balance in account
	 * @return the current balance
	 */
	public double getBalance() {
		return this.balance;
	}
}
