package com.yao.example.current;

/**
 * java并发编程艺术-串行和并行那个快
 */
public class ConcurrencyTest {
	private static final long count = 10001;

	public static void main(String[] args) throws InterruptedException {
		concurrency();
		serial();
	}


	private static void concurrency() throws InterruptedException {
		long startTime = System.currentTimeMillis();
		Thread thread = new Thread(() -> {
			int a = 0;
			for (long i = 0; i < count; i++) {
				a += 5;
			}
		});
		thread.start();
		int b = 0;
		for (long i = 0; i < count; i++) {
			b--;
		}
		long time = System.currentTimeMillis() - startTime;
		thread.join();
		System.out.println("concurrency:" + time + "ms,b=" + b);
	}

	private static void serial() {
		long start = System.currentTimeMillis();
		int a = 0;
		for (long i = 0; i < count; i++) {
			a += 5;
		}
		int b = 0;
		for (long i = 0; i < count; i++) {
			b--;
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("serial:" + time + "ms,b=" + b);
	}
}
