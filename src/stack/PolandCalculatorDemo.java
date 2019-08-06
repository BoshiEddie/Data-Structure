package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandCalculatorDemo {
	
	public static void main(String[] args) {
		//波兰表达式
		//( 3 + 4 ) * 5 - 6
		//1 + ( ( 7 - 4 ) * 5 ) - 6 + 7
		String expression = "1 + ( 7 - 4 ) * 5 - 6 + 7";
		
		int result = calculate(parseSuffixExpression(getListString(expression)));
		
		System.out.println(result);
		
	}
	
	public static List<String> getListString(String expression){
		String[] split = expression.split(" ");
		List<String> list = new ArrayList<>();
		for(String s : split) {
			list.add(s);
		}
		
		return list;
	}
	
	public static int calculate(List<String> ls) {
		
		Stack<String> stack = new Stack<String>();
		for(String elem : ls) {
			if(elem.matches("\\d+")) {
				stack.push(elem);
			}else {
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;
				
				if(elem.equals("+")) {
					res = num1 + num2;
				}else if(elem.equals("-")) {
					res = num1 - num2;
				}else if(elem.equals("*")) {
					res = num1 * num2;
				}else if(elem.equals("/")){
					res = num1 / num2;
				}else {
					throw new RuntimeException("运算符有误");
				}
				stack.push(res+"");
				
			}
		}
		
		return Integer.parseInt(stack.pop());
		
	}
	
	public static List<String> parseSuffixExpression(List<String> ls) {
		
		Stack<String> sl = new Stack<String>();//运算符号栈
		List<String> lss = new ArrayList<String>();//列表代替栈存储结果
		
		for(String ss : ls) {
			
			if(ss.matches("\\d+")) {
				lss.add(ss);
			}else {
				if(sl.isEmpty()||sl.peek().equals("(")||ss.equals("(")) {
					sl.push(ss);
				}else if(ss.equals(")")){
					while(!sl.peek().equals("(")) {
						lss.add(sl.pop());
					}
					sl.pop();
				}else{
					if(priority(ss) > priority(sl.peek())) {
						sl.push(ss);
					}else {
						lss.add(sl.pop());
						sl.push(ss);
					}
				}
				
			}
			
		}
		
		while(sl.size()!=0) {
			lss.add(sl.pop());
		}
		
		String suffixExpression = "";
		for(String s : lss) {
			suffixExpression += s+" ";
		}
		System.out.println(suffixExpression);
		return lss;
	}
	
	public static int priority(String s) {
		
		if(s.equals("+") || s.equals("-")) {
			return 1;
		}else if(s.equals("*") || s.equals("/")){
			return 2;
		}else if(s.equals("(")) {
			return 0;
		}
		else {
			System.out.println("I don't know" + s);
			return -1;
		}
	}
}






