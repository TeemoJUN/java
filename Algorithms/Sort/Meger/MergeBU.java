package merge;

import sort_util.Util;
/*
 * 先计算最小分组的,这个免去啦要不断切割数组的步骤
 * 
 * 
 * */
public class MergeBU {
	private static Integer[] aux;
	public static void sort(Integer[] a){
		int N=a.length;
		aux=new Integer[N];
		
		//先是1,1对比,再是2，2对比
		for(int size=1;size<N;size=2*size){
			
			//从零开始,后面的lo是前面的lo加上2*size
			//最后一个lo必须小于N-size
			for(int lo=0;lo<N-size;lo=lo+2*size){
				
				merge(a,lo,lo+size-1,Math.min(lo+2*size-1, N-1));//避免hi越界,越界就选择N-1
				
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
