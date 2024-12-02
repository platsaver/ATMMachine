package com;

public class ATM {
	private int balance; 
	private int depositBalance; 
	private int withdrawBalance; 
	
	public int getBalance() {
		return balance; 
	}
	public void setBalance(int balance) {
		this.balance = balance; 
	}
	public int getDeposit() {
		return depositBalance; 
	}
	public void setDeposit(int depositBalance) {
		this.depositBalance = depositBalance; 
	}
	public int getWithdraw() {
		return withdrawBalance; 
	}
	public void setWithdraw(int withdrawBalance) {
		this.withdrawBalance = withdrawBalance; 
	}
}
