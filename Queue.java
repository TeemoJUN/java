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
	
	//队列是否为空
	public boolean isEmpty(){
		return first==null;
	}
	
	//队列长度
	public int size(){
		return N;
	}
	//进队列
	public void enqueue(Item item){
		Node newNode=new Node();
		newNode.item=item;
		//为空就头节点和尾节点都指向newNode
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
	//从头部出队列
	public Item dequeue(){
		if(isEmpty()){
			throw new NoSuchElementException("队列为空！");
		}
		Item item=first.item;
		first=first.next;
		if(isEmpty()){
			last=null;
		}
		N--;
		return item;
	}
	
	
	//查看第一个元素
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("队列为空！");
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
