package merge;

import sort_util.Util;
/*
 * �ȼ�����С�����,�����ȥ��Ҫ�����и�����Ĳ���
 * 
 * 
 * */
public class MergeBU {
	private static Integer[] aux;
	public static void sort(Integer[] a){
		int N=a.length;
		aux=new Integer[N];
		
		//����1,1�Ա�,����2��2�Ա�
		for(int size=1;size<N;size=2*size){
			
			//���㿪ʼ,�����lo��ǰ���lo����2*size
			//���һ��lo����С��N-size
			for(int lo=0;lo<N-size;lo=lo+2*size){
				
				merge(a,lo,lo+size-1,Math.min(lo+2*size-1, N-1));//����hiԽ��,Խ���ѡ��N-1
				
			}
			
		}
		
	}
	
	public static void merge(Integer[] a,int lo,int mid,int hi){
		int i=lo;int j=mid+1;
		
		for(int k=lo;k<=hi;k++){
			aux[k]=a[k];
		}
		
		for(int k=lo;k<=hi;k++){
			if(i>mid){
				a[k]=aux[j++];
			}
			else if(j>hi){
				a[k]=aux[i++];
			}
			else if(Util.less(aux[i],aux[j])){
				a[k]=aux[j++];
			}
			else{
				a[k]=aux[i++];
			}
			
		}
	}
}
