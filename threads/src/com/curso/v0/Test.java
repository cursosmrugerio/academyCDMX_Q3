package com.curso.v0;

public class Test implements Runnable {
	private int i; //OJO

	@Override
	public void run() {
		if (i % 10 == 0) {
			i++;
		}
		for (int x = 0; x < 10; x++, i++) {
			if (x == 4) {
				Thread.yield();
			}
			System.out.println(Thread.currentThread().getName()+ ": "+i + " ");
		}
	}

	public static void main(String[] args) {
		Test n = new Test();
		for (int x = 0; x < 100; x++) {
			new Thread(n).start();
		}
	}
}