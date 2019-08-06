package com.linkedlist;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		
		HeroNode2 hero1 = new HeroNode2(1,"Tony Stark","Iron Man");
		HeroNode2 hero2 = new HeroNode2(2,"Chris Evis","Captian America");
		HeroNode2 hero3 = new HeroNode2(3,"Thor","God of Thunder");
		
		DoubleLinkedList s = new DoubleLinkedList();
		s.add(hero1);
		s.list();
		s.add(hero3);
		s.list();
		s.add(hero2);
		s.list();
		s.add(hero2);
		s.list();
		
		s.delete(2);
		s.list();
		s.delete(2);
		s.list();
		
		s.add(hero2);
		HeroNode2 hero4 = new HeroNode2(2,"Lang","Ant Man");
		s.list();
		s.update(hero4);
		s.list();
		
		s.delete(3);
		s.list();
		
		s.add(hero3);
		s.list();
	}
}

//创建双向列表的类
class DoubleLinkedList{
	
	private HeroNode2 head = new HeroNode2(0,"",""); 
	
	public HeroNode2 getHead() {
		return head;
	}
	
	public void list() {
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		
		HeroNode2 temp = head.next;
		while(true) {
			
			if(temp == null) {
				break;
			}
			
			System.out.println(temp);
			temp = temp.next;
		}
		
	}
	
	public void add(HeroNode2 heronode) {
		
		HeroNode2 temp = head;
		
		boolean flag = false;
		
		boolean mid = false;
		
		while(true) {
			
			if(heronode.no == temp.no) {
				System.out.println("该节点已存在");
				break;
			}
			
			if(temp.next ==null) {
				flag = true;
				break;
			}
			
			if(temp.next.no > heronode.no) {
				mid = true;
				flag = true;
				break;
				
			}
			
			temp = temp.next;
			
		}

		if(flag) {
			
			heronode.next = temp.next;
			
			temp.next = heronode;
			
			heronode.pre = temp;
			
			if(mid) {
				
				heronode.next.pre = heronode;
				
			}
			
		}
		
	}
	
	public void delete(int no) {
		
		if(head.next == null) {
			System.out.println("链表为空");
			return;
			
		}
		
		HeroNode2 temp = head.next;
		
		boolean flag = false;
		
		while(true) {
			
			if(temp == null) {
				break;
			}
			
			if(temp.no == no) {
				
				flag = true;
				break;
			}
			
			temp = temp.next;
			
		}
		
		if(flag) {
			
			temp.pre.next = temp.next;
			//空指针异常
			if(temp.next != null) {
			
				temp.next.pre = temp.pre;
			}
		}else {
			System.out.println("未找到");
		}
		
	}
	
	
	public void update(HeroNode2 heronode) {
		
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		
		HeroNode2 temp = head;
		boolean flag = false;
		
		while(true) {
			
			if(temp.next == null) {
				break;
			}
			
			if(temp.next.no == heronode.no) {
				flag = true;
				break;
			}
			
			temp = temp.next;
			
		}
		
		if(flag) {
			
			temp.next.name = heronode.name;
			
			temp.next.nickname = heronode.nickname;
			
		}
		
	}
	
	
}

class HeroNode2{
	
	int no;
	String name;
	String nickname;
	HeroNode2 next;//指向下一个节点
	HeroNode2 pre;//指向上一个节点
	
	public HeroNode2(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
 		this.nickname = nickname;
	}
	
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ",nickname=" + nickname+"]";
	}
	
}