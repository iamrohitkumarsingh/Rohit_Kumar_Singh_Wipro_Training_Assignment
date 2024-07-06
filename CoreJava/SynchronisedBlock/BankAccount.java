package com.wipro.assign;

public class BankAccount {
	
	private double balance;

	public BankAccount(double initialbalance) {
		this.balance = initialbalance;
	}
	
	public synchronized void deposit(double amount) {
		if(amount>0) {
			balance += amount;
			System.out.println(Thread.currentThread().getName()+" deposited "+amount+", new balance:"+balance);
			
		}
	}
	
	public synchronized void withdraw(double amount) {
		if(amount>0 && amount<=balance) {
			balance-=amount;
			System.out.println(Thread.currentThread().getName()+" withdrew "+amount+", new balance:"+balance);
			
		}else {
			System.out.println(Thread.currentThread().getName()+" attempted to withdraw:"+amount+", insufficient ammount");
		}
	}
	public synchronized double getBalance() {
		return balance;
	}

}
