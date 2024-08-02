package dev.multithreading;

import java.util.Arrays;
import java.util.List;

/**
 * Provides parallel processing capabilities using the `parallelStream()` method, enabling parallel execution of stream operations.
 * 
 */
public class J8StreamAPI {

	public static void main(String[] args) {
		// Example of using parallelStream
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int sum = numbers.parallelStream()
		                 .filter(n -> n % 2 == 0)
		                 .mapToInt(Integer::intValue)
		                 .sum();
		System.out.println("Sum of even numbers: " + sum);
		//
		List<String> messages = Arrays.asList(
	            "Task 1 is running in a separate thread",
	            "Task 2 is running in a separate thread",
	            "Task 3 is running in a separate thread"
	        );
	    // Process each message in parallel
	    messages.parallelStream().forEach(J8StreamAPI::runTask);
	    //
	    List<String[]> pockets = Arrays.asList(
	            new String[]{"STATUS CHANGERS", "RUNES", "KEY ITEMS", "TROPHIES"},
	            new String[]{"POTION", "SUPER POTION", "FULL HEAL"},
	            new String[]{"ARMOR+", "ATTACK+", "EXP+", "HEALTH+", "DISPELL+"},
	            new String[]{"QUEST ITEMS", "STORY ITEMS", "JOURNAL"},
	            new String[]{"TROPHIES"}
	        );
		pockets.parallelStream().forEach(J8StreamAPI::runTask);
		//
		List<Task> tasks = Arrays.asList(
	            new Task("Task 1 is running in a separate thread", new String[]{"STATUS CHANGERS", "RUNES", "KEY ITEMS", "TROPHIES"}),
	            new Task("Task 2 is running in a separate thread", new String[]{"POTION", "SUPER POTION", "FULL HEAL"}),
	            new Task("Task 3 is running in a separate thread", new String[]{"ARMOR+", "ATTACK+", "EXP+", "HEALTH+", "DISPELL+"}),
	            new Task("Task 4 is running in a separate thread", new String[]{"QUEST ITEMS", "STORY ITEMS", "JOURNAL"}),
	            new Task("Task 5 is running in a separate thread", new String[]{"TROPHIES"})
	        );
	    tasks.parallelStream().forEach(J8StreamAPI::runTask);
	}
	public static void runTask(String message) {
        try {
            Thread.sleep(1000); // Sleep for 1000 milliseconds
            System.out.println(message);
        } catch (InterruptedException e) {
            System.err.println("Task was interrupted");
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
    }
	
	public static void runTask(String[] pocket) {
        try {
        	Thread.sleep(1000); // Sleep for 1000 milliseconds
            System.out.println(Arrays.toString(pocket));
        } catch (InterruptedException e) {
            System.err.println("Task was interrupted");
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
    }
	public static void runTask(Task task) {
        try {
            Thread.sleep(1000); // Sleep for 1000 milliseconds
            System.out.println(task.getMessage() + ": " + Arrays.toString(task.getPocket()));
        } catch (InterruptedException e) {
            System.err.println("Task was interrupted");
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
    }
}
class Task {
    private final String message;
    private final String[] pocket;

    public Task(String message, String[] pocket) {
        this.message = message;
        this.pocket = pocket;
    }

    public String getMessage() {
        return message;
    }

    public String[] getPocket() {
        return pocket;
    }
}
