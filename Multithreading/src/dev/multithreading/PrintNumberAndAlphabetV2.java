package dev.multithreading;

public class PrintNumberAndAlphabetV2 {
	    public static void main(String[] args) throws InterruptedException {
	        // Alphanumeric array from A to J
	        String[] alphanumericArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	        
	        // Integer array from 1 to 10
	        int[] integerArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	        
	        // Create threads
	        Thread alphanumericThread = new Thread(new PrintStringArray(alphanumericArray));
	        Thread integerThread = new Thread(new PrintIntArray(integerArray));

	        // Start the alphanumeric thread first
	        alphanumericThread.start();
	        // Start the integer thread
	        integerThread.start();

	        // Wait for the alphanumeric thread to finish before starting the integer thread
	        alphanumericThread.join();


	        // Wait for the integer thread to finish
	        integerThread.join();
	    }
	}

