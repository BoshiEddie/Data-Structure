package com.recurision;

public class RecursionDemo {
	public static void main(String[] args) {
		test(5);
		System.out.println(factorial(5));
	}
	
	public static void test(int n) {
		if(n > 2) {
			test(n-1);
		}
//		else {
			System.out.println("n = " + n);
//		}
		
	}
	
	public static int factorial(int n) {
		
		if(n == 1) {
			return 1;
		}
		else {
			return factorial(n-1) * n;
		}
	}
}
