package a;

/*
 * ���ȶ���
 * 
 * ��������ģ�����������1��ʼ��
 */


public class MaxPQ {
	private Integer[] pq;//����
	
	private int N=0;
	
	public MaxPQ(int max){
		pq=new Integer[max+1];//��Ϊ�����Ǵ�1��ʼ��

	}
	
	//�Ƿ�Ϊ��
	public boolean isEmpty(){
		return N==0;
	}
	
	//���ڴ���ĸ���
	public int size(){
		return N;
	}
	
	//a[i]�Ƿ�С��a[j]
	private boolean less(int i,int j){
		return pq[i].compareTo(pq[j])<0;
	}
	
	//����������
	private void exch(int i,int j){
		Integer temp=pq[i];
		pq[j]=pq[i];
		pq[i]=temp;
	}
	
	//�������ϸ���
	private void swim(int k){
		while(k>1){
			if(less(k/2,k)){
				exch(k/2,k);
			}
			k=k/2;
		}
	}
	//���������³�
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
	
	//������ֵ
	public void insert(Integer v){
		pq[++N]=v;
		swim(N);
	}
	
	//ɾ����һ��ֵ
	public Integer delMax(){
		Integer max=pq[1];
		exch(1,N);
		sink(1);
		return max;
	}
}
