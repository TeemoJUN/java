package Search;

import java.util.Scanner;

import edu.princeton.cs.algs4.Queue;


public class Link<Key,Value> {
	private Node first;
	private int N;
	private	class Node{
		Key key;
		Value value;
		Node next;
		
		public Node(Key key,Value value,Node next){
			this.key=key;
			this.value=value;
			this.next=next;
		}
	}
	
	//由键查值
	public Value get(Key key){
		for(Node x=first;x!=null;x=x.next){
			if(key.equals(x.key)){
				return x.value;
			}
		}
		return null;
	}
	
	//增加节点
	public void put(Key key,Value value){
		for(Node x=first;x!=null;x=x.next){
			if(key.equals(x.key)){
				x.value=value;
				return;
			}
		}
		first=new Node(key,value,first);
		N++;
	}
	
	//返回链表大小
	public int size(){
		return N;
	}
	
	//链表是是否为空
	public boolean isEmpty(){
		return N==0;
	}
	
	//是否包含某键
	public boolean contains(Key key){
		if(get(key)==null){
			return false;
		}
		return true;
	}
	
	public void delete(Key key){
		if(key==null){
			throw new IllegalArgumentException("键值不存在！"); 
		}
		first=delete(first,key);
	}
	private Node delete(Node x,Key key){
		if(x==null){
			return null;
		}
		if(key.equals(x.key)){
			N--;
			return x=x.next;
		}
		x.next=delete(x.next,key);
		return x;
		
	}
	
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }
    
    public static void main(String[] args) {
    	Scanner in=new Scanner(System.in);
        Link<String, Integer> st = new Link<String, Integer>();
        String line=in.nextLine();
        String[] value=line.split(" ");
        for(int n=0;n<value.length;n++)
        {
        	st.put(value[n], n);
        }
        for (String s : st.keys())
           System.out.println(s + " " + st.get(s));
    }
	
	
	
}
