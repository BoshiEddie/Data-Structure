package com.recurision;

public class Queen8 {
	
	int maxSize = 8;
	int[] arr = new int[maxSize];
	
	public static void main(String[] args) {
		
		Queen8 queen = new Queen8();
		
		queen.check(0);
		
	}
	
	//编写方法,放置第n个皇后
	private void check(int n) {
		if(n == maxSize) {
			print();
			return;
		}
		
		for(int i = 0 ; i < maxSize ; i++) {
			//先把当前的皇后，放到该行的第1列
			arr[n] = i;
			//判断当将皇后放置在i时，是否冲突
			if(judge(n)) {
				check(n+1);
			}
			
			//如果冲突，就继续执行arr[n] = i;
		}
	}
	
	
	//将皇后摆放的位置,打印出来
	private void print() {
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("(%d,%d) ",i,arr[i]);
		}
		System.out.println();
	}
	/**
	 * 
	 * 
	 * @param n 表示第n个皇后
	 * **/
	//当我们放置第n个皇后的时候，就去检测该皇后是否与前面的皇后摆放是否冲突
	private boolean judge(int n) {
		for(int i = 0; i < n ; i++) {
			//在同一列上			在同一斜线上，斜率为1的话就是在一条斜线上
			//列差等于行差
			if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n]-arr[i])) {
				return false;
			}
		}
		return true;
	}
	
}
