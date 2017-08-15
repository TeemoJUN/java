package one;

import java.util.Iterator;

/*
 * 
 * ˫����У������
 * 
 * */

public class Dequeue<Item> implements Iterable<Item> {

	
	private Node first;//����ߵ�ͷ�ڵ�
	private Node last;//���ұߵ�β�ڵ�
	private int N;//��¼��ǰ�ж��ٵĽڵ㱻����
	
	public Dequeue(){
		
	}
	
	private class Node{
		private Node pre;
		private Node next;
		private Item item;
	}
	
	//���ش����ڵ����
	public int size(){
		return N;
	}
	//�Ƿ�Ϊ��
	private boolean isEmpty(){
		return N==0;
	}
	//���
	public void pushLeft(Item item){
		if(isEmpty()){
			first=new Node();
			first.item=item;
			last=first;
		}
		else{
			Node oldFirst=first;
			first=new Node();
			first.item=item;
			first.next=oldFirst;
			oldFirst.pre=first;
		}
		N++;
	}
	//�ҽ�
	public void pushRight(Item item){
		if(isEmpty()){
			last=new Node();
			last.item=item;
			first=last;
		}else{
			Node oldLast=last;
			last=new Node();
			last.item=item;
			last.pre=oldLast;
			oldLast.next=last;
		}
		N++;
	}
	//���
	public Item popLeft() throws Exception{
		//��Ϊ��ʱ����
		if(isEmpty()){
			throw new Exception("û����");
		}
		Item item=first.item;
		first=first.next;
		if(N==1){
			first=last=null;//��ֻ��һ���ڵ�ʱҲ׼������ʱ��last��firstͬʱ��null
		}
		else{
			first.pre=null;//����ǰһ���ڵ�
		}
		N--;
		return item;
	}
	//�ҳ���ͬ��
	public Item popRight() throws Exception{
		if(isEmpty()){
			throw new Exception("û����");
		}
		Item item=last.item;
		last=last.pre;
		if(N==1){
			first=last=null;
		}
		else{
			last.next=null;
		}
		N--;
		return item;
	}
	
	public void print(){
		Node current=first;
		while(current!=null){
			System.out.print(current.item+"  ");
			current=current.next;
		}
		System.out.println();
	}

	
	//���������
	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>(){
			Node current=first;
			@Override
			public boolean hasNext() {
				return current!=null;
			}

			@Override
			public Item next() {
				Item item=current.item;
				current=current.next;
				return item;
			}
		};
	}
	
	//���������
	public Iterable<Item> reverseIterator(){
		return new Iterable<Item>(){
			@Override
			public Iterator<Item> iterator() {
				return new Iterator<Item>(){
					Node current=last;
					@Override
					public boolean hasNext() {
						return current!=null;
					}

					@Override
					public Item next() {
						Item item=current.item;
						current=current.pre;
						return item;
					}
				};
			}
			
		};
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception{
		Dequeue<String> q=new Dequeue<String>();
		
		q.pushLeft("a");
		q.pushLeft("b");
		q.pushLeft("c");
		q.pushRight("c");
		q.pushRight("b");
		q.pushRight("a");
		System.out.println("���");
		q.print();//c  b  a  c  b  a  
		
		q.popLeft();
		q.print();//b  a  c  b  a 
		q.popLeft();
		q.print();//a  c  b  a  
		q.popLeft();
		q.print();//c  b  a  
		q.popLeft();
		q.print();//b  a 
		q.popLeft();
		q.print();//a
		q.popLeft();
		q.print();//��
		//����һ��
		
		q.pushLeft("a");
		q.pushLeft("b");
		q.pushLeft("c");
		q.pushRight("c");
		q.pushRight("b");
		q.pushRight("a");
		System.out.println("�ҳ�");
		q.print();//c  b  a  c  b  a
		
		q.popRight();
		q.print();//c  b  a  c  b 
		q.popRight();
		q.print();//c  b  a  c
		q.popRight();
		q.print();//c  b  a 
		q.popRight();
		q.print();//c  b
		q.popRight();
		q.print();//c
		q.popRight();
		q.print();
		
		
		System.out.println("---------------");
		q.pushLeft("a");
		q.pushLeft("b");
		q.pushLeft("c");
		q.pushLeft("d");
		q.pushLeft("e");
		q.pushLeft("f");
		
		
		System.out.println("��������");
		
		for(String a:q){
			System.out.print(a+"  ");
		}
		System.out.println();
		System.out.println("��������");
		for(String a:q.reverseIterator()){
			System.out.print(a+"  ");
		}
	}
}

