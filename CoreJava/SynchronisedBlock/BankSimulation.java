package com.wipro.assign;

public class BankSimulation {
	public static void main(String[] args) {
		BankAccount account =new BankAccount(1000.00);
		
		Thread t1=new DepositThread(account,500.00);
		Thread t2=new WithDrawThread(account,200.00);
		Thread t3=new DepositThread(account,300.00);
		Thread t4=new WithDrawThread(account,800.00);
		Thread t5=new WithDrawThread(account,500.00);
		
		t1.setName("Thread 1");
		t2.setName("Thread 1");
		t3.setName("Thread 1");
		t4.setName("Thread 1");
		t5.setName("Thread 1");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final Balance: "+account.getBalance());
	}

}
