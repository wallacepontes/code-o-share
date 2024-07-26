package dev.multithreading.virtualthread;

public class VirtualThreadApplication {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread platformThread = Thread.ofPlatform().unstarted(() -> System.out.println(Thread.currentThread()));
		platformThread.start(); // To start the thread
		
		Thread virtualThread = Thread.ofVirtual().unstarted(() -> System.out.println(Thread.currentThread()));
		virtualThread.start();
		
		platformThread.join();
		
		virtualThread.join();
		
		System.out.println("Class" + virtualThread.getClass());
		
		
	}

}
