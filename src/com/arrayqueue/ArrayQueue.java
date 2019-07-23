package com.arrayqueue;

public class ArrayQueue {
	public static void main(String[] args) {
		//1.这种情况下，这种实现方法，数组用一次就不能用了，需要优化，没有达到复用的效果
		//优化的方式就是一个环形队列
		//2.front++ 和 front+1 是不一样的，front++（front = front + 1）作用于整个array
		//而front+1只是在数值上变化，front本身并没有任何变化
		ArrayQue a = new ArrayQue(6);
		a.addQueue(6);
		a.addQueue(1);
		a.addQueue(2);
		a.addQueue(3);
		a.addQueue(4);
		a.addQueue(5);
		a.showQueue();
		System.out.println("Front1: "+a.headQueue());
		System.out.println("Front2: "+a.headQueue());
		System.out.println("Get: " + a.getQueue());
		System.out.println("Front3: "+a.headQueue());
		System.out.println("Front4: "+a.headQueue());
	}
	
	
	public static void info(ArrayQue a) {
		System.out.println("isFull: " + a.isFull()); 
		System.out.println("isEmpty: " + a.isEmpty());
		System.out.println("Number: " + a.getQueue());
		System.out.println("Front: " + a.headQueue());
	
	}
	
}

class ArrayQue {
	private int maxSize;//数组的最大容量
	private int front;//队列头
	private int rear;//队列尾
	private int[] arr;//用于存放数据，模拟队列
	
	//创建队列的构造器
	public ArrayQue(int maxSize) {
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
		this.front = -1;//指向队列头部的前一个位置不包含数据
		this.rear = -1;//指向队列尾的具体的数据包含队列尾的最后一个数据
	}
	
	public int getFront() {
		return this.front; 
	}
	
	public int getRear() {
		return this.rear;
	}
	
	//判断队列是否已经满
	public boolean isFull() {
		return this.rear == this.maxSize - 1;
	}
	
	//判断队列是否为空
	public boolean isEmpty() {
		return this.rear == this.front;
	}
	
	//添加数据
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("No more space available ");
			return;
		}
		
		this.rear++;
		
		arr[rear] = n;
		
	}
	
	//获取数据
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("Nothing here");
		}
		
		this.front++;//front 后移
		return arr[front];
	}
	
	//显示所有数据
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("Nothing here");
			return;
		}
		for(int i = 0; i <= rear; i++) {
			System.out.printf("arr[%d] = %d\n",i,arr[i]);
		}
	}
	
	//显示头部数据是多少
	public int headQueue() {
		if(isEmpty()) {
			System.out.println("Nothing here");
			throw new RuntimeException();
		}
		return arr[front+1];
	}
	
	
	
}

