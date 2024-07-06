package com.wipro.assign;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplexCalculation implements Callable<Integer> {
	private int taskId;
	
	public ComplexCalculation(int taskId) {
		this.taskId=taskId;
	}

	@Override
	public Integer call() throws Exception {
		int result=0;
		for(int i=0;i<1000000;i++) {
			result+=i;
		}
		System.out.println("Task "+taskId+" completed. Result: "+result);
		return result;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numThreads=3;
		ExecutorService executor=Executors.newFixedThreadPool(numThreads);
		for(int i=0;i<5;i++) {
			Callable<Integer> task=new ComplexCalculation(i);
			executor.submit(task);
		}
		executor.shutdown();
	}

}
