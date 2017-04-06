package Search;

import java.util.Iterator;

import a.Queue;

/*
 * ������������ɢ�б�
 * 
 * ��������ʵ�ִ�ȡһ��˳���;
 * ����keyֵhash����-->i---->st[i]---->��ȡ��SequentialSearchST��˳�����
 * 
 * */


public class SeparateChainingHashST<Key,Value> {
	private int N;//��ǰ�����ļ�ֵ��
	private int M;//���ö���ɢ�з�Χ
	
	private SequentialSearchST<Key,Value>[] st;
	
	public SeparateChainingHashST(){
		this(997);
	}
	
	public SeparateChainingHashST(int M){
		this.M=M;
		st=(SequentialSearchST<Key,Value>[]) new SequentialSearchST[M];
		
		for(int i=0;i<M;i++){
			st[i]=new SequentialSearchST();
		}
	}
	
	private int hash(Key key){
		return (key.hashCode()&0x7fffffff)%M;
	}
	
	public void put(Key key,Value value){
		st[hash(key)].put(key, value);
		N++;
	}
	
	public Value get(Key key){
		return (Value) st[hash(key)].get(key);
	}
	
	
	public void delete(Key key){
		if(key==null){
			return;
		}
		int i=hash(key);
		
		if(st[i].contains(key)){
			N--;
			st[i].delete(key);
		}
	}
	
	public Iterable<Key> keys(){
		Queue<Key> q=new Queue<Key>();
		for(int i=0;i<M;i++){
			for(Key key:st[i].keys()){
				q.enqueue(key);
			}
		}
		return q;
	}
	
	
}
