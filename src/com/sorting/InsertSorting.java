package com.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSorting {
	public static void main(String[] args) {
		
		//扑克牌问题，解决了
		//与前面个两种算法不同，前面两种算法是要元素的互换，这个是先更替，再把原来的替换

		int size = 80000;
		
		int[] arr = new int[size];
		for(int i = 0 ; i < size;i++) {
			arr[i] = (int)(Math.random() * 8000000);
		}
		
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(s.format(d));
		insertSorting(arr);
		Date d2 = new Date();
		System.out.println(s.format(d2));
		
	}
	
	public static void insertSorting(int[] arr) {
	
		int n = arr.length;
		
		int i,j;
		int target;
		//第一个元素直接算为一个有序的数组
		for(i = 1 ; i < n ; i++) {
			j =i;
			target = arr[i];
			
			while(j>0 && target < arr[j-1]) {
				
				arr[j]=arr[j-1];
				j--;
				
			}
			
			if(i!=j) {
				arr[j] = target;
			}
		}
		
	}
	
}
