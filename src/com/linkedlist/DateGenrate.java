package com.linkedlist;
import java.util.ArrayList;
import java.util.Random;


public class DateGenrate {
	
	public static void main(String[] args) {
	
		int sch_area;
		int sch_id;
		int grade;
		
		Random rand = new Random();
		//什么类型的考试
		int typeCode = rand.nextInt(5);
		
		ArrayList<String> course = new ArrayList<>();
		course.add("语文");
		course.add("数学");
		course.add("英语");
		course.add("物理");
		course.add("化学");
		course.add("生物");
		course.add("地理");
		course.add("历史");
		course.add("政治");
		
		
		
	}
}
