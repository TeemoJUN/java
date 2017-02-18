package a;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>{
	private Node first;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	//是否为空
	public boolean isEmpty(){
		return N==0;
	}
	//当前栈的存贮的数量
	public int size(){
		return N;
	}
	
	//进栈
	public void push(Item item){
		
		Node newFirst=new Node();
		newFirst.item=item;
		if(first==null){//栈为空
			first=newFirst;
		}
		else{
			newFirst.next=first;
			first=newFirst;
		}
		N++;
		//好的写法
		/*Node oldFirst=first;
		first=new Node();
		first.item=item;
		first.next=oldFirst;
		N++;*/
		
	}
	//出栈
	public Item pop(){
		if(isEmpty()){
			throw new NoSuchElementException("栈为空！");
		}
		Item item=first.item;
		first=first.next;
		N--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterable();
	}
	private class ListIterable implements Iterator<Item>{
		
		private Node current=first;
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
	public static void main(String[] args){
		Stack<String> stack=new Stack<String>();
		
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		stack.push("E");
		stack.push("F");
		for(String item:stack){
			System.out.println(item+" ");
		}
	}
	
	
	
	
}
