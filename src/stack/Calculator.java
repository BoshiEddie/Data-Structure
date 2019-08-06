package stack;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String expression = sc.nextLine();

		ArrStack num = new ArrStack(10);//存放数字
		ArrStack ope = new ArrStack(10);//存放计算符号
		
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';
		String keepNum = "";
		
		//循环的扫描expression
		
		while(true) {
			//依次将得到expression的每一项
			ch = expression.substring(index, index+1).charAt(0);
			//判断ch是什么
			if(ope.isOperation(ch)) {
				//如果是计算符,则查看ope里是否是空的
				if(ope.isEmpty()) {
					ope.push(ch);
				}else {
					//如果里面有之前的计算符，则需要比较是连个符的优先级别
					//如果，ch的优先级大于栈中的计算符，则直接将ch加入栈中
					if(ope.priority(ch) >= ope.priority(ope.peak())) {
						ope.push(ch);
					}else {
						//如果ch的优先级比之前的低，则需要计算之前的计算符
						oper = ope.pop();
						num2 = num.pop();
						num1 = num.pop();
						res = num.calCulate(num1, num2, oper);
						num.push(res);
						ope.push(ch);
					}
				}
			}else {
				//如果是数字
//				num.push(ch-48);
				//如果是数字，因为有可能为多位数，则需要对后面的位置上的字符进行判断
				//如果发现后面还是数的话，则需要一个字符串来进行拼接
				
				keepNum += ch;
				//判断下一个字符是不是数字，如果是数字则继续扫描，如果是运算符，则直接入栈
				while(true) {
					//如果ch是最后一位，则直接入站
					if(index == expression.length()-1) {
						num.push(Integer.parseInt(keepNum));
						keepNum ="";
						break;
					}{
						if(ope.isOperation(expression.substring(index+1, index+2).charAt(0))){
							num.push(Integer.parseInt(keepNum));
							keepNum = "";
							break;
						}else {
							index++;
							keepNum += expression.substring(index, index+1).charAt(0);
						}
					}
				}
			}
			if(index < expression.length()-1) {
				index++;
			}else {
				break;
			}
		}
		while(true) {
			//如果符号栈为空，则说明计算完成
			if(ope.isEmpty()) {
				break;
			}
			num1 = num.pop();
			System.out.println("num1=" + num1);
			num2 = num.pop();
			System.out.println("num2=" + num2);
			oper = ope.pop();
			res = num.calCulate(num1, num2, oper);
			System.out.println("res=" + res);
			num.push(res);
		}
		System.out.println(num.peak());
	}
	
}


class ArrStack{
	
	private int maxSize;  //栈的大小
	private int[] stack;  //数组模拟栈
	private int top = -1; //初始化栈顶
	
	//maxSize
	public ArrStack(int maxSize) {
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
	
	
	public int peak() {
		
		if(isEmpty()) {
			throw new RuntimeException("Nothing is here");
		}
		
		return stack[top];
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
	
	public int priority(int operation) {
		
		if(operation == '*' || operation == '/') {
			return 1;
		}else if(operation == '+' || operation == '-') {
			return 0;
		}else {
			return -1;
		}
		
	}
	
	public boolean isOperation(int operation) {
		return operation == '*' || operation == '/' || operation == '+' || operation == '-'; 
	}
	
	//计算方法
	public int calCulate(int a, int b, int oper) {
		int res = 0;//用于存放计算的结果
		switch(oper) {
		
		case '+':
			res = a + b;
			break;
		case '-':
			res = b - a;
			break;
		case '*':
			res = a * b;
			break;
		case '/':
			res = b / a;
			break;
			
		default:
			break;
		}
		
		return res;
		
		
	}
	
}