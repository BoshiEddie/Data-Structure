package stack;

public class StackDemo {
	public static void main(String[] args) {
		
		ArrayStack astack = new ArrayStack(5);
		
		astack.isEmpty();
		astack.isFull();
		
		astack.push(1);
		astack.push(2);
		astack.push(3);
		astack.push(4);
		astack.push(5);
		
		System.out.println(astack.isEmpty());
		System.out.println(astack.isFull());

		astack.list();
		
		System.out.println(astack.pop());
		System.out.println(astack.pop());
		System.out.println(astack.pop());
		System.out.println(astack.pop());
		System.out.println(astack.pop());
		System.out.println(astack.pop());
		
		
	}
}


//定义一个类表示栈结构
class ArrayStack{
	
	private int maxSize;  //栈的大小
	private int[] stack;  //数组模拟栈
	private int top = -1; //初始化栈顶
	
	//maxSize
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		this.stack = new int[this.maxSize];
	}
	//栈满
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	//栈空
	public boolean isEmpty() {
		return top == -1;
	}
	//增加数据
	public void push(int value) {
		
		if(this.isFull()) {
			System.out.println("no more space available");
			return;
		}
		
		top++;
 		stack[top] = value;
		
	}
	
	//将栈顶的数据返回
	public int pop() {
		if(isEmpty()) {
//			System.out.println("nothing is here, what you want");
			//抛出异常
			throw new RuntimeException("nothing is here, what you want?"); 
		}
		int value = stack[top];
		top--;
		return value;
	}
	
	public void list() {
		//判断栈是否为空
		if(isEmpty()) {
			System.out.println("nothing is here");
			return;
		}
		
		for(int i = top; i >=0 ; i--) {
			
			System.out.printf("stack[%d] = %d\n",i,stack[i]);
			
		}
	}
	
}
