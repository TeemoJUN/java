package Search;

import java.util.Scanner;

import edu.princeton.cs.algs4.Queue;


public class SequentialSearchST<Key,Value> {
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
	
	//�ɼ���ֵ
	public Value get(Key key){
		for(Node x=first;x!=null;x=x.next){
			if(key.equals(x.key)){
				return x.value;
			}
		}
		return null;
	}
	
	//���ӽڵ�
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
	
	//���������С
	public int size(){
		return N;
	}
	
	//�������Ƿ�Ϊ��
	public boolean isEmpty(){
		return N==0;
	}
	
	//�Ƿ����ĳ��
	public boolean contains(Key key){
		if(get(key)==null){
			return false;
		}
		return true;
	}
	
	public void delete(Key key){
		if(key==null){
			throw new IllegalArgumentException("��ֵ�����ڣ�"); 
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
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
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
