package com.linkedlist;

public class LinkedList {
	public static void main(String args[]) {
		
		//测试
		HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
		HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
		HeroNode hero3 = new HeroNode(3,"吴用","智多星");
		HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
		HeroNode hero5 = new HeroNode(5,"李逵","黑旋风");
		HeroNode hero6 = new HeroNode(2,"诸葛亮","卧龙");
		
		//创建列表
		SingleLinkedList s = new SingleLinkedList();
		System.out.println("----------ADD----------");
		s.add(hero1);
		s.add(hero3);
		s.add(hero4);
		s.list();

		System.out.println("---------ADDIN-----------");
		s.addIn(hero2);
		s.list();
		System.out.println("该单链表的有效个数为" + numberOfNode(s.getHead()));
		
		System.out.println("----------ADDIN----------");
		s.addIn(hero5);
		s.list();
		
		System.out.println("----------UPDATE----------");
		s.update(hero6);
		s.list();
		
		System.out.println("----------DELETE----------");
		s.delete(5);
		s.list();
		System.out.println("该单链表的有效个数为" + numberOfNode(s.getHead()));
		s.delete(2);
		s.list();
		s.delete(2);
		
		System.out.println("----------Number----------");
		System.out.println("该单链表的有效个数为" + numberOfNode(s.getHead()));
		
		System.out.println("----------Get Number From Back----------");
		s.list();
		HeroNode b = getBack(1, s);
		System.out.println(b);
		
		System.out.println("----------Reverse LinkedList----------");
		s.list();
		reverse(s.getHead());
		s.list();
	
		
		
	}
	
	//单链表的反转
	public static void reverse(HeroNode head) {
		
		if(head.next == null || head.next.next == null) {
			return;
		}
		
		HeroNode cur = head.next;
		
		HeroNode next = null;
		
		HeroNode reversehead = new HeroNode(0,"","");
		
		while(cur != null) {
			//先让next指向cur的next，保留原来列表指针的记录
			next = cur.next;
			//取出节点让节点接入reversehead
			cur.next = reversehead.next;
			
			reversehead.next = cur;
			
			cur = next;
			
		}
		
		head.next = reversehead.next;
		
	}
	
	//查找链表中的倒数第n个节点【新浪面试】
	//需要Param 是index
	//index代表的是倒数第n个数据
	//先把链表从头遍历一遍，得到节点个数
	//得到size-index，再遍历到（size-index），就得到了倒数第index的节点
	public static HeroNode getBack(int index, SingleLinkedList s) {
		
		int size = numberOfNode(s.getHead());
		
		System.out.println(size);
		
		return s.search((size-index+1)); 
		
	}
	
	
	//获取到单链表节点的个数（单链表的有效个数）
	public static int numberOfNode(HeroNode h) {
		
		HeroNode temp = h;
		int number = 0;
		while(true) {
			if(temp.next == null) {
				break;
			}
			
			temp = temp.next;
			number++;
		}
		
		return number;
		
	}
	
}

//定义single linkedlist 来管理节点？

class SingleLinkedList{
	
	//定义一个头节点，并且不要动，为了单列表的遍历方便，头节点并不存放具体的数据
	 private HeroNode head = new HeroNode(0,"","");
	 
	 public HeroNode getHead() {
		 return head;
	 }
	 //查找
	 public HeroNode search(int index) {//index是在链表中的位置，而不是no
		 //指针直接指向第一个节点，忽略头节点
		 HeroNode temp = head.next;
		 //是否找到编号为index的节点
		 boolean flag = false;
		 //定义链表weizhi
		 int x = 0;
		 //遍历循环
		 while(true) {
			 x++;
			 //便利到最后一个元素
			 if(temp== null) {
				 break;
			 }
			 //找到所需节点
			 //index 这里不是Node的no，是在链表中的位置
			 if(x == index) {
				 flag = true;
				 break;
			 }
			 //指针向后移动
			 temp = temp.next;
		 }
		 
		 if(flag) {//如果找到所需节点
			 return temp;
		 }else {
			 return null;
		 }
		 
	 }
	 
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
	 //根据node的编号来进行修改
	 //根据newHeroNode的no来更改链表中的的内容
	 public void update(HeroNode newHeroNode) {
		 //判断链表是否为空
		 if(head.next == null) {
			 System.out.println("链表为空");
			 return;
		 }
		 
		 //遍历链表，找到需要更换的node
		 boolean flag = false;
		 HeroNode temp = head.next;
		 
		 while(true) {
			 
			 if(temp == null) {
				 break;
			 }
			 
			 if(temp.no == newHeroNode.no) {
				 flag = true;
				 break;
			 }
			 temp = temp.next;
		 }
		 
		 if(flag) {
			 temp.name = newHeroNode.name;
			 temp.nikename = newHeroNode.nikename;
		 }else {
			 System.out.printf("编号%d不存在\n",newHeroNode.no);
		 }
		 
		 
		 
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
	 //删除
	 public void delete(int deleteNodeNo) {
		 HeroNode temp = head;
		 
		 boolean flag = false;//标志是否找到删除节点
		 
		 while(true) {
			 
			 if(temp.next == null) {//说明链表的已经到了最后
				 break;
			 }
			 
			 if(temp.next.no == deleteNodeNo) {//说明节点已经被找到了
				 flag = true;
				 break;
			 }
			 
			 temp = temp.next;
		 }
		 
		 if(flag) {//说明找到节点
			 
//			 if(temp.next.next == null) {
//				 temp.next = null;
//			 }else {
//				 temp.next = temp.next.next;
//			 }如果是结尾，那temp next next是null，不用进行逻辑判断
			 
			 temp.next = temp.next.next;
			 
			 
		 }else {
			 System.out.printf("没有找到编号为%d的节点\n",deleteNodeNo);
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