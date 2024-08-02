package dev.multithreading;

public class MultithreadingLambda {

	public static void main(String[] args) {
		
		/**
		 * Lambda Expression
		 */
		Runnable task = () -> {
		    System.out.println("Task is running in a separate thread" );
		};
		new Thread(task).start();
		
		Runnable task1 = createTask("Wow!",1);
		Runnable task2 = createTask("Wow!",2);
		Runnable task3 = createTask("Wow!",3);
		Runnable task4 = createTask("Wow!",4);
		new Thread(task1).start();
        new Thread(task2).start();
		new Thread(task3).start();
        new Thread(task4).start();
        //new Thread(task2).run();
        //new Thread(task2).run();
	}
	
	public static Runnable createTask(String message, int threadNumber) {
        return () -> {
        	for (int i = 1; i <=3; i++) {
        		System.out.println(message + i + " from Thread " + threadNumber);
        		if (threadNumber == 4) {
					throw new RuntimeException();
				}
        		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.err.println("Task was interrupted");
	                Thread.currentThread().interrupt(); // Restore the interrupted status
				}
			}
            
        };
    }
}
