package dev.multithreading;

import java.util.*;
import java.util.concurrent.*;

public class MultithreadingSum {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int numberOfThreads = Runtime.getRuntime().availableProcessors();

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<Future<Integer>> futures = new ArrayList<>();

        // Split the list and submit tasks
        int chunkSize = (int) Math.ceil((double) numbers.size() / numberOfThreads);
        for (int i = 0; i < numbers.size(); i += chunkSize) {
            List<Integer> sublist = numbers.subList(i, Math.min(i + chunkSize, numbers.size()));
            Callable<Integer> task = () -> sublist.stream().mapToInt(Integer::intValue).sum();
            futures.add(executor.submit(task));
        }

        // Collect the results
        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get();
        }

        // Shutdown the executor
        executor.shutdown();

        System.out.println("Total Sum: " + totalSum);
    }
}
