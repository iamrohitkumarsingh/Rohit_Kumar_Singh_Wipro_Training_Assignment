package com.wipro.assign;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Prime {

	static class PrimeTask implements Callable<List<Integer>> {
		private final int start;
		private final int end;

		public PrimeTask(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public List<Integer> call() {
			List<Integer> primes = new ArrayList<>();
			for (int i = start; i <= end; i++) {
				if (isPrime(i)) {
					primes.add(i);
				}
			}
			return primes;
		}

		private boolean isPrime(int number) {
			if (number <= 1) {
				return false;
			}
			for (int i = 2; i <= Math.sqrt(number); i++) {
				if (number % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int maxNumber = 100; // Adjust this to the desired maximum number
		int numThreads = 4; // Adjust the number of threads

		ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
		List<Future<List<Integer>>> futures = new ArrayList<>();

		int range = maxNumber / numThreads;
		for (int i = 0; i < numThreads; i++) {
			int start = i * range + 1;
			int end = (i == numThreads - 1) ? maxNumber : (i + 1) * range;
			PrimeTask task = new PrimeTask(start, end);
			futures.add(executorService.submit(task));
		}
		CompletableFuture<Void> fileWriteFuture = CompletableFuture.runAsync(() -> {
			List<Integer> allPrimes = new ArrayList<>();
			for (Future<List<Integer>> future : futures) {
				try {
					allPrimes.addAll(future.get());
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
			writePrimesToFile(allPrimes, "primes.txt");
		});

		fileWriteFuture.thenRun(() -> System.out.println("Prime numbers written to file successfully."));

		executorService.shutdown();
	}
	private static void writePrimesToFile(List<Integer> primes, String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (int prime : primes) {
				writer.write(prime + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
