package dev.multithreading;

public class PrintNumberAndAlphabet {
    public static void main(String[] args) throws InterruptedException {
        // Alphanumeric array from A to J
        String[] alphanumericArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        
        // Integer array from 1 to 10
        String[] integerArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        
        // Create threads
        Thread alphanumericThread = new Thread(new PrintArray(alphanumericArray));
        Thread integerThread = new Thread(new PrintArray(integerArray));

        // Start the alphanumeric thread first
        alphanumericThread.start();
        // Wait for the alphanumeric thread to finish before starting the integer thread
        alphanumericThread.join();

        // Start the integer thread
        integerThread.start();
        // Wait for the integer thread to finish
        integerThread.join();
    }
}
