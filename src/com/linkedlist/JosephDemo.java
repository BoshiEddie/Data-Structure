package com.linkedlist;

public class JosephDemo {
	
	public static void main(String[] args) {
		
	}
	
	
}

class CircleLinkedList{
	
	private Boy first = new Boy(-1);
	
	public void addBoy(int no) {
		
		if(no < 1) {
			System.out.println("no的值不正确");
			
		}
		Boy curBoy = null;
		
		for(int i = 1; i <= no;i++) {
			//根据编号创建Boy的节点
			Boy boy = new Boy(i);
			if(i == 1) {
				
				first = boy;
				
				first.setBoy(first);
				
				curBoy = first;
				
			}else {
				
				curBoy.setBoy(boy);
				
				boy.setBoy(first);
				
				curBoy = boy;
				
			}
			
			
		}
	}
	
}


class Boy{
	
	private int no;
	private Boy next;
	
	public Boy(int no) {
		this.no = no;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public Boy getNext() {
		return next;
	}
	public void setBoy(Boy next) {
		this.next = next;
	}
	
	public String toString() {
		return "Boy [no= " + no;
	}
	
}


