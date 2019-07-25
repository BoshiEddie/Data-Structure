package com.linkedlist;

public class LinkedList {
	public static void main(String args[]) {
		
		//测试
		HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
		HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
		HeroNode hero3 = new HeroNode(3,"吴用","智多星");
		HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
		HeroNode hero5 = new HeroNode(5,"李逵","黑旋风");
		
		//创建列表
		SingleLinkedList s = new SingleLinkedList();
		
		s.add(hero1);
		s.add(hero3);
		s.add(hero4);
		s.list();

		s.addIn(hero2);
		s.list();
		
		s.addIn(hero5);
		s.list();
	}
}

//定义single linkedlist 来管理节点？

class SingleLinkedList{
	
	//定义一个头节点，并且不要动，为了单列表的遍历方便，头节点并不存放具体的数据
	 private HeroNode head = new HeroNode(0,"","");
	 
	 //添加节点到单项列表
	 //当不不考虑编号顺序时
	 //1.找到当前列表的最后一个节点
	 //2.将最后这个节点的next指向 新的节点
	 public void add(HeroNode heroNode) {
		 //因为head节点不能动，所以我们需要一个辅助的指针
		 HeroNode temp = head;
		 //遍历列表，找到最后
		 
		 while(true) {
			 //直到找到链表的最后
			 if(temp.next == null) {
				 break;
			 }
			 //如果没有找到最后，就将temp后移；
			 temp = temp.next;
		 }
		 //当退出循环之后，temp就指向了链表的最后
		 temp.next = heroNode;
		 
	 }
	 //
	 public void update() {
		 
	 }
	 
	 //显示链表
	 public void list() {
		 if(head.next == null) {
			 System.out.println("The linked list is empty");
			 return;
		 }
		 HeroNode temp = head.next;
		 while(true) {
			 
			 if(temp == null) {
				 break;
			 }
			 
			 System.out.println(temp);
			 //将temp往后移动
			 temp = temp.next;
			 
		 }
		 
	 }
	 
	 //只能加在中间的节点，如果是最新的节点则无法添加
	 public void addIn(HeroNode heroNode) {
		 HeroNode temp = head;
		 //判断是不是已经添加了编号
		 boolean flag = false;
		 
		 while(true) {
			 
			 if(temp.next == null) {//说明temp已经在链表的最后
				 break;
			 }
			 if(temp.next.no > heroNode.no) {//位置找到了，就在temp的后面
				 break;
			 }else if(temp.next.no == heroNode.no) {//希望添加的heroNode的编号已经添加
				 flag = true;
				 break;
			 }
			 temp = temp.next;//后移就是在遍历
			 
		 }
		 
		 if(flag) {//不能添加，编号重复
			 System.out.printf("编号%d已经存在\n",heroNode.no);
		 }else {
			 	
			 heroNode.next = temp.next;
			 temp.next = heroNode;
		 }
		 
		 
	 }
	 
}


class HeroNode {
	public int no;
	public String name;
	public String nikename;
	public HeroNode next;
	
	public HeroNode(int no, String name, String nikename) {
		this.no = no;
		this.name = name;
		this.nikename = nikename;
		
	}
	
	//为了先显示方便，重写toString
	@Override
	public String toString() {
		return "HeroNode [no=" + this.no + ", name=" + this.name + ", nikename=" + this.nikename + "]";
	}
}