package com.curso.v0;

public class Test0 implements Runnable {
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
		Test0 n = new Test0();
		for (int x = 0; x < 100; x++) {
			new Thread(n).run();
		}
	}
}