package dev.ace.vt;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class VTPerformanceV2 {

	public static void main(String[] args) throws InterruptedException {
		Set<String> poolNames = ConcurrentHashMap.newKeySet();
		Set<String> pThreadsNames = ConcurrentHashMap.newKeySet();
		
		List<Thread> threads = IntStream.range(0, 100000).mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
			String poolName = readPoolName();
			poolNames.add(poolName);
			String workerName = readWorkerName();
			pThreadsNames.add(workerName);
			//System.out.println("Thread Name: " + workerName);
		})).toList();
		
		Instant begin = Instant.now();
		threads.forEach(Thread::start);
		for (Thread thread : threads) {
			thread.join();
		}
		
		Instant end = Instant.now();
		System.out.println("Time = " + Duration.between(begin, end).toMillis() + "ms");
		System.out.println("# core = " + Runtime.getRuntime().availableProcessors());
		System.out.println("# Pools = " + poolNames.size());
		System.out.println("# Platform threads = " + pThreadsNames.size());

	}

	private static String readWorkerName() {
		String name = Thread.currentThread().toString();
		int i1 = name.indexOf("@ForkJoinPool");
		int i2 = name.indexOf("worker");
		String pool = name.substring(i1,i2);
		return pool;
	}

	private static String readPoolName() {
		String name = Thread.currentThread().toString();
		int i1 = name.indexOf("worker");
		String pt = name.substring(i1);
		return pt;
	}

}
