package com.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HillSorting {
	public static void main(String[] args) {

		int size = 8000000;
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i ++) {
			
			arr[i] =(int)( Math.random() * 8000000);
			
		}
		
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(s.format(d));
		shellSorting(arr);
//		System.out.println(Arrays.toString(arr));
		Date d2 = new Date();
		System.out.println(s.format(d2));
		
		
	}
	
	public static void hillSorting(int[] arr) {
		
		int i,j;
		int temp;
		int n = arr.length;
		int step = n /2;
		
		while(step >= 1) {
		
			for(i = step ; i < n; i++) {
				
				for(j= i-step; j>=0;j-=step) {
					
					if(arr[j] > arr[j+step]) {
						
						temp = arr[j];
						arr[j] = arr[j+step];
						arr[j+step] = temp;
						
					}
					
				}
			}
			step = step /2;
			
		}
		
//		for(i = 2 ; i < n; i++) {
//			
//			for(j = i -2 ; j >= 0 ; j -= 2) {
//				
//				if(arr[j] > arr[j+2]) {
//					
//					temp = arr[j];
//					arr[j] = arr[j+2];
//					arr[j+2] = temp;
//					
//				}
//				
//			}
//			
//		}
//			
//		for(i = 1 ; i < n; i++) {
//			for(j = i -1 ; j >= 0 ; j -= 1) {
//				
//				if(arr[j] > arr[j+1]) {
//					
//					temp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//					
//				}
//				
//			}
//			
//		}
		
		
		
	}
	
	public static void shellSorting(int[] arr) {
		
		int i,j;
		
		int n = arr.length;
		
		int step = n/2;
		
		while(step >= 1) {
			
			for(i = step; i < n ; i++) {
				
				j = i;
				
				int temp = arr[j];
				
				if(arr[j] < arr[j-step]) {
					
					while(j - step >=0 && temp < arr[j-step]) {
						
						arr[j] = arr[j-step];
						j -= step;
						
					}
					
					arr[j] = temp;
				}
				
			}
			
			step /= 2;
			
		}
		
	}
	
}
