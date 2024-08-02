package dev.multithreading;

public class MultithreadingRunnable {

	public static void main(String[] args) {
		/**
		MultithreadThing myThread = new MultithreadThing();
		MultithreadThing myThread2 = new MultithreadThing();
		
		//myThread.start();
		//myThread2.start();
		
		myThread.run();
		myThread2.run(); */
		
		for (int i = 1; i <=4; i++) {
			MultithreadThing myThing = new MultithreadThing(i);
			Thread myThread = new Thread(myThing);
			myThread.start();
			/**
			try {
				//if (i == 2) {
					myThread.join();
				//}
			} catch (InterruptedException e) {
			}*/
		}
		//int x =1; 
		//x = x/0;
		//throw new ArithmeticException("Lucas calculou errado");
	}

}
class MultithreadThing implements Runnable { // extends Thread {
	private int threadNumber;
	public MultithreadThing(int threadNumber) {
		this.threadNumber = threadNumber;
	}
	
	@Override
	public void run() { // Must be implement
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + " from thread " + threadNumber);
			//if (threadNumber == 4) {
			//	throw new RuntimeException();
			//}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}

