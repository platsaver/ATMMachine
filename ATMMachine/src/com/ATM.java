package com;

public class ATM {
	private int balance; 
	private int depositBalance; 
	private int withdrawBalance; 
	
	int getBalance() {
		return balance; 
	}
	void setBalance(int balance) {
		this.balance = balance; 
	}
	int getDeposit() {
		return depositBalance; 
	}
	void setDeposit(int depositBalance) {
		this.depositBalance = depositBalance; 
	}
	int getWithdraw() {
		return withdrawBalance; 
	}
	void setWithdraw(int withdrawBalance) {
		this.withdrawBalance = withdrawBalance; 
	}
}
