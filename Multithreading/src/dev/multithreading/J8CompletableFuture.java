package dev.multithreading;

import java.util.concurrent.CompletableFuture;

/**
 * A flexible Future implementation that allows combining multiple asynchronous 
 * tasks and handling results and errors in a more streamlined way.
 */
public class J8CompletableFuture {

	public static void main(String[] args) {
		// Example of using CompletableFuture
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
		    // Simulate long-running task
		    try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		    System.out.println("Task completed");
		});

		future.thenRun(() -> System.out.println("Continuation task"));
	}

}
