package dev.multithreading;

public class Multithreading {

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
			try {
				//if (i == 2) {
					myThread.join();
				//}
			} catch (InterruptedException e) {
			}
		}
		//int x =1; 
		//x = x/0;
		//throw new ArithmeticException("Lucas calculou errado");
	}

}
