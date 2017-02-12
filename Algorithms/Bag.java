package a;
//背包用来存贮数据
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

	private Node first;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return first==null;
	}
	
	public int size(){
		return N;
	}
	
	public void add(Item item){
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		N++;
		
	}
	public Iterator<Item> iterator(){
		return  new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
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
		Bag<String> bag=new Bag<String>();
		bag.add("A");
		bag.add("b");
		bag.add("C");
		bag.add("D");
		
		for(String c:bag){
			System.out.println(c);
		}
	}
	
}















