package com.arrayqueue;

public class Circle {
	public static void main(String[] args) {
		CircleArray c = new CircleArray(4);
		
		c.add(1);
		c.add(2);
		c.add(3);
		//这样的定义只能有maxSize-1 个元素可以用
		//因为这样的isFull是错误的
		c.showQueue();
		
		boolean a = c.isEmpty();
		System.out.println("是否是空" + a);
		a = c.isFull();
		System.out.println("是否已满" + a);
		
		int x = c.get();
		System.out.println("取出" + x);
		c.add(4);
		
		c.showQueue();
		System.out.println("第一 " + c.headQueue());
		
		x = c.get();
		System.out.println("取出" + x);
		x = c.get();
		System.out.println("取出" + x);
		x = c.get();
		System.out.println("取出" + x);
//		c.add(5);
	}
}

class CircleArray {
	
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;
	
	public CircleArray(int maxSize) {
		
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
		
	}
	
	public boolean isFull() {
		return rear % maxSize == front;
	}
	
	public boolean isEmpty() {
		return this.rear == this.front;
	}
	
	//添加数据
	public void add(int n) {
		if(this.isFull()) {
			System.out.println("There is no more space available");
		}
		arr[rear]=n;
		rear = (rear+1) % maxSize;
	}
	
	public int get() {
		if(this.isEmpty()) {
			throw new RuntimeException("Queue is now empty");
		}
		//front 是直接指向第一个值的位置的
		//在取值的过程中，front需要往后移送
		//所以呢，不能直接return，否则没有机会
		int head = arr[front];
		//front++; 因为是环形列表，所以指针在移动的时候，需要考虑循环, 列表中的循环就用%，取余；
		front = (front+1) % maxSize;
		
		return head;
	}
	
	public void showQueue() {
		if(this.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		//从front开始遍历，在环形数组中，front和rear没有绝对的大小关系
		for(int i = this.front; i < front+this.size() ;i++) {
			System.out.printf("arr[%d] = %d\n", i%maxSize , arr[i%maxSize]);
		}
		
	}
	
	//求出当前队列有效数据的
	public int size() {
		return (this.rear + this.maxSize - this.front) % this.maxSize;
	}
	
	public int headQueue() {
		if(this.isEmpty()) {
			
			throw new RuntimeException("Queue is empty");
		}
		
		return arr[front];
	}
	
	
	
	
}
