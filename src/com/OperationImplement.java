package com;

import java.util.HashMap;
import java.util.Map;

public class OperationImplement implements OperationInterface{
	ATM atm = new ATM(); 
	Map<Integer, String> ministatement = new HashMap<>(); 
	@Override
	public void viewBalance() {
		System.out.println("Your available balance: "+atm.getBalance()); 
	}
	public void withdrawAmount(int withdrawAmount) {
		if (withdrawAmount>0) {
			if (withdrawAmount<=atm.getBalance()) {
				ministatement.put(withdrawAmount, "Amount Withdrawal");
				atm.setBalance(atm.getBalance()-withdrawAmount); 
				System.out.println("Your updated balance: "+atm.getBalance()); 
				atm.setWithdraw(withdrawAmount);
			}
			else {
				System.out.println("Insufficient amount of fund! Please try again");
			}
		}
		else {
            System.out.println("Please enter the amount in multipal of 500");
        }
	}
	public void depositAmount(int depositAmount) {
		atm.setBalance(atm.getBalance()+depositAmount);
		atm.setDeposit(depositAmount);
		System.out.println("Your update balance: "+atm.getBalance()); 
	}
	public void ViewMiniStatement() {
		System.out.println("Balance:\t\t"+atm.getBalance()); 
		System.out.println("Withdraw Amount:\t"+atm.getWithdraw()); 
		System.out.println("Deposit Amount:\t\t"+atm.getDeposit()); 
	}
}
