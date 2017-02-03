package a;

import java.util.*;
public class Queue<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	//�����Ƿ�Ϊ��
	public boolean isEmpty(){
		return first==null;
	}
	
	//���г���
	public int size(){
		return N;
	}
	//������
	public void enqueue(Item item){
		Node newNode=new Node();
		newNode.item=item;
		//Ϊ�վ�ͷ�ڵ��β�ڵ㶼ָ��newNode
		if(isEmpty()){
			first=newNode;
			last=newNode;
		}
		else{
			last.next=newNode;
			last=newNode;
		}
		N++;
	}
	//��ͷ��������
	public Item dequeue(){
		if(isEmpty()){
			throw new NoSuchElementException("����Ϊ�գ�");
		}
		Item item=first.item;
		first=first.next;
		if(isEmpty()){
			last=null;
		}
		N--;
		return item;
	}
	
	
	//�鿴��һ��Ԫ��
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("����Ϊ�գ�");
        return first.item;
    }
	
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator(first);
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node current;
		public ListIterator(Node first){
			this.current=first;
		}
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
		
	}
	
	
}
