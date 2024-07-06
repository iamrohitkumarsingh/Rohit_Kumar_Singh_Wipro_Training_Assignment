package com.wipro.assign;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Counter counter = new Counter();
	        ImmutableData data = new ImmutableData(100); // Shared immutable data

	        Runnable incrementTask = () -> {
	            for (int i = 0; i < 1000; i++) {
	                counter.increment();
	            }
	            System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter.getCount());
	        };

	        Runnable decrementTask = () -> {
	            for (int i = 0; i < 1000; i++) {
	                counter.decrement();
	            }
	            System.out.println(Thread.currentThread().getName() + " decremented counter to: " + counter.getCount());
	        };

	        // Create and start multiple threads for incrementing and decrementing the counter
	        Thread incrementThread1 = new Thread(incrementTask, "IncrementThread-1");
	        Thread incrementThread2 = new Thread(incrementTask, "IncrementThread-2");
	        Thread decrementThread1 = new Thread(decrementTask, "DecrementThread-1");
	        Thread decrementThread2 = new Thread(decrementTask, "DecrementThread-2");

	        incrementThread1.start();
	        incrementThread2.start();
	        decrementThread1.start();
	        decrementThread2.start();

	        // Wait for all threads to finish
	        try {
	            incrementThread1.join();
	            incrementThread2.join();
	            decrementThread1.join();
	            decrementThread2.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Final counter value
	        System.out.println("Final counter value: " + counter.getCount());

	        // Demonstrate immutable data sharing
	        System.out.println("Immutable data value: " + data.getValue());

	}

}
