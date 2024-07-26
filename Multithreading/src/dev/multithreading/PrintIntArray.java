package dev.multithreading;

public class PrintIntArray implements Runnable {
	    private final int[] arrayToPrint;

	    public PrintIntArray(int[] arrayToPrint) {
	        this.arrayToPrint = arrayToPrint;
	    }

	    @Override
	    public void run() {
	        for (int element : arrayToPrint) {
	            System.out.println(element);
	        }
	    }
	}

