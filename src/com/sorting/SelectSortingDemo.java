package com.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSortingDemo {
	public static void main(String[] args) {
		int[] arr = new int[80000];
		for(int i = 0 ; i < 80000; i++) {
			arr[i] = (int)(Math.random() * 8000000);
		}
		
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(s.format(d));
		selectSort(arr);
		Date d2 = new Date();
		System.out.println(s.format(d2));
		
	}
	
	public static void selectSort(int[] arr) {
		
		for(int i = 0; i < arr.length-1 ; i++) {
			//找出来最小的
			int key = i;//记住保留最小值的位置
			int min = arr[i];
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] < min) {
					min = arr[j];
					key = j;
				}
				
			}
			if(key != i) {
				arr[key] = arr[i];
				arr[i] = min;
			}
		}
		
	}
} 
