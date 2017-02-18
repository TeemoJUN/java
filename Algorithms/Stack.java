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
	//�Ƿ�Ϊ��
	public boolean isEmpty(){
		return N==0;
	}
	//��ǰջ�Ĵ���������
	public int size(){
		return N;
	}
	
	//��ջ
	public void push(Item item){
		
		Node newFirst=new Node();
		newFirst.item=item;
		if(first==null){//ջΪ��
			first=newFirst;
		}
		else{
			newFirst.next=first;
			first=newFirst;
		}
		N++;
		//�õ�д��
		/*Node oldFirst=first;
		first=new Node();
		first.item=item;
		first.next=oldFirst;
		N++;*/
		
	}
	//��ջ
	public Item pop(){
		if(isEmpty()){
			throw new NoSuchElementException("ջΪ�գ�");
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
