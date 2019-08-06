package com.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbingSortingDemo {
	public static void main(String[] args) {
		
		int[] arr = new int[80000];
		
		for(int i = 0 ; i < 80000 ; i++) {
			
			arr[i] = (int) (Math.random() * 8000000);
		}
		
		Date d = new Date();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simpleFormat.format(d);
		System.out.println(date);
		bubble(arr);
		Date d2 = new Date();
		date = simpleFormat.format(d2);
		System.out.println(date);
		
		
		
		
		//第一趟排序，就是将最大的数排在最后
//		for(int i = 0 ; i < arr.length -1 ; i++) {
//			//如果发现前面的数比后面的数大，则交换
//			if(arr[i] > arr[i+1]) {
//				temp = arr[i];
//				arr[i] = arr[i+1];
//				arr[i+1] = temp;
//			}
//		}
//		System.out.println("第一趟排序后的数组");
//		System.out.println(Arrays.toString(arr));
//		
//		//第二趟排序，将第二大的数排在倒数第二位
//		for(int i = 0 ; i < arr.length -2 ; i++) {
//			//如果发现前面的数比后面的数大，则交换
//			if(arr[i] > arr[i+1]) {
//				temp = arr[i];
//				arr[i] = arr[i+1];
//				arr[i+1] = temp;
//			}
//		}
//		
//		System.out.println("第二趟排序后的数组");
//		System.out.println(Arrays.toString(arr));
//		
//		for(int i = 0 ; i < arr.length -3 ; i++) {
//			//如果发现前面的数比后面的数大，则交换
//			if(arr[i] > arr[i+1]) {
//				temp = arr[i];
//				arr[i] = arr[i+1];
//				arr[i+1] = temp;
//			}
//		}
//		
//		System.out.println("第三趟排序后的数组");
//		System.out.println(Arrays.toString(arr));
//		
//		for(int i = 0 ; i < arr.length -4 ; i++) {
//			//如果发现前面的数比后面的数大，则交换
//			if(arr[i] > arr[i+1]) {
//				temp = arr[i];
//				arr[i] = arr[i+1];
//				arr[i+1] = temp;
//			}
//		}
//		System.out.println("第四趟排序后的数组");
//		System.out.println(Arrays.toString(arr));
	}
	
	public static void bubble(int[] arr) {
		//设定一个临时变量，作为交换变量时的中介
		int temp = 0;
		for(int i = 0 ; i < arr.length - 1 ;i ++) {
			boolean flag = false;
			for(int j = 0 ; j < arr.length - 1 -i; j++) {
				
				if(arr[j] > arr[j+1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
				}
			}
			
			if(!flag) {
				break;
			}
		}
	}
	
	
}
