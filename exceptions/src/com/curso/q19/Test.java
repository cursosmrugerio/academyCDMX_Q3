package com.curso.q19;

public class Test {
	
	int[] array = {1, 2, 3, 4, 5};
	
	public static void main(String[] args) throws InterruptedException {
		new Test().go(1);
	}
	
	void go(int x) throws InterruptedException {
		array[x % 5] = x++;
		System.out.println(x);
		Thread.sleep(1);
		go(x);
	}

}

//x  

//1   array[1]  = 1

//2   array[2]  = 2

//3   array[3]  = 3

//4   array[4]  = 4

//5   array[0]  = 5

//6   array[1]  = 6

//7   array[2]  = 7

//8
//......

//10 array[0] = 10 
//......
//15 array[0] = 15 
