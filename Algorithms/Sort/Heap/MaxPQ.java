package a;

/*
 * 优先对列
 * 
 * 用数组来模拟二叉树，从1开始的
 */


public class MaxPQ {
	private Integer[] pq;//数组
	
	private int N=0;
	
	public MaxPQ(int max){
		pq=new Integer[max+1];//因为存贮是从1开始的

	}
	
	//是否为空
	public boolean isEmpty(){
		return N==0;
	}
	
	//现在存入的个数
	public int size(){
		return N;
	}
	
	//a[i]是否小于a[j]
	private boolean less(int i,int j){
		return pq[i].compareTo(pq[j])<0;
	}
	
	//交换两个数
	private void exch(int i,int j){
		Integer temp=pq[i];
		pq[j]=pq[i];
		pq[i]=temp;
	}
	
	//由下向上浮动
	private void swim(int k){
		while(k>1){
			if(less(k/2,k)){
				exch(k/2,k);
			}
			k=k/2;
		}
	}
	//由上自下下沉
	private void sink(int k){
		if(k>N){
			return ;
		}
		int j=k*2;
		if(j<N&&less(j+1,j)){ 
			j++;
		}
		if(less(j,k)){
			exch(j,k);
		}
		k=j;
		sink(k);
	}
	
	//插入新值
	public void insert(Integer v){
		pq[++N]=v;
		swim(N);
	}
	
	//删除第一个值
	public Integer delMax(){
		Integer max=pq[1];
		exch(1,N);
		sink(1);
		return max;
	}
}
