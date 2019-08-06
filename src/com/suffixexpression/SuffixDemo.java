package com.suffixexpression;

import java.util.Stack;

public class SuffixDemo {
	public static void main(String [] args) {
		String expression = "1+(2+3)*4-5";
		
		Stack<String> s1 = new Stack<String>();//运算符栈
		Stack<String> s2 = new Stack<String>();//储存最后需要输出的结果
		
		//基本原则
		//如果遇到，操作数，直接压入s2
		//如果遇到运算符，则与s1中栈顶运算符进行优先级的比较
		//如果s1为空，或者栈顶的运算符为左括号，则直接将此运算符压入栈中
		
		//否则，如果优先级比栈顶的运算符高，也将运算符压入s1中，
		//否则，将s1栈顶的运算符弹出，压入s2，然后再次重复
		
		//如果有左括号，则将其直接压入，如果有右括号，将运算符依次弹出，直到遇到左括号为止
		//重复以上步骤，直到遍历到最后一个字符
		
		//最后将s1中剩余的运算符弹出，压入s2
		
		char ch =' ';
		
		for(int i = 0 ; i < expression.length(); i++) {
			//遍历String的每一个字符
			ch = expression.substring(i, i+1).charAt(0);
			
			
			if(isOpe(ch)) {
				if(s1.isEmpty()) {
					//如果运算符号为空，则直接将该符号压入到s1中
					s1.push(ch+"");
				}else {
					//如果运算符栈中有其他的运算符，要与之进行比较优先级
					
				}
				
				
				
			}else {
				s2.push(ch+"");
			}
			
			
		}
		
		
	}
	
	public static boolean isOpe(int ch) {
		
		return ch == '+' || ch == '-' || ch == '*'  || ch == '/' || ch == '(' || ch == ')';
		
	}
	
	public static int priority(int ch) {
		
		if(ch == '+' || ch == '-') {
			return 1;
		}else if(ch == '*' || ch == '/') {
			return 2;
		}else {
			throw new RuntimeException("Sorry, I don't know");
		}
		
	}
}
