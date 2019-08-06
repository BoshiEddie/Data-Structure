package com.linkedlist;

import java.util.Random;


public class IncrementDemo {
	public static void main(String[] args) {
		
		Random rand = new Random();
		int date = 1;
		int times = rand.nextInt(4) + 5;
		for(int i = 0; i < times; i++) {
			date += rand.nextInt(4);
			date += 2;
			System.out.printf("第%d天\n",date);
			
			if(date > 30) {
				break;
			}			
		}
		
	}
}
