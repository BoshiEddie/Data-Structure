package stack;

public class StackDemo2 {
	public static void main(String[] args) {
		
		
		
	}
}


class LinkedListStack{
	
	private int maxSize;
	private SingleLinkedList stack;
	private Node top;
	
	public LinkedListStack(int maxSize) {
		
		this.maxSize = maxSize;
		
		this.stack = new SingleLinkedList(this.maxSize);
		
		top = stack.head;
		
	}
	
	public boolean isEmpty() {
		return top.getNext() == null;
	}
	
	public boolean isFull() {
		return stack.number() == maxSize;
	}
	
	public void push(Node n) {
		
		if(isFull()) {
			
			System.out.println("No space here");
			return;
		}
		
		stack.add(n);
		top = top.getNext();
	}
	
	public Node pop(){
		
		if(isEmpty()) {
			throw new RuntimeException("Nothing here");
		}
		
		Node temp = top;
		
		while(true) {
			
		}
		
	}
	
}

class SingleLinkedList{
	
	Node head = new Node(0,"");
	int maxSize;
	
	public SingleLinkedList(int maxSize) {
		this.maxSize = maxSize;
		
	}

	
	public int number() {
		
		Node temp = head;
		
		int number = 0;
		
		while(true) {
			
			if(temp.getNext() == null) {
				break;
			}
			
			number++;
			temp = temp.getNext();
		}
		
		return number;
		
	}
	
	
	public void add(Node node) {
		
		if(this.number() > maxSize) {
			return;
		}
		
		Node temp = head;
		
		while(true) {
			
			if(temp.getNext() == null) {
				break;
			}
			
			temp = temp.getNext();
			
		}
		
		temp.setNext(node);
	}
	
	public void list() {
		
		Node temp = head;
		
		while(true) {
			
			if(temp.getNext() == null) {
				break;
			}
			
			System.out.println(temp);
			
			temp = temp.getNext();
			
			
		}
		
	}
	
}

class Node{
	private int no;
	private String value;
	private Node next;
	
	public Node(int no, String value) {
		this.no = no;
		this.value = value;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public int getNo() {
		return this.no;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Node [ no = "+ this.no + ", value = " + this.value;
	}
	
}
