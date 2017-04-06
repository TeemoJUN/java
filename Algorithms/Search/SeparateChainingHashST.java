package Search;

import java.util.Iterator;

import a.Queue;

/*
 * 基于拉链法的散列表
 * 
 * 用数组来实现存取一个顺序表;
 * 根据key值hash（）-->i---->st[i]---->存取到SequentialSearchST的顺序表中
 * 
 * */


public class SeparateChainingHashST<Key,Value> {
	private int N;//当前存贮的键值对
	private int M;//采用多大的散列范围
	
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
