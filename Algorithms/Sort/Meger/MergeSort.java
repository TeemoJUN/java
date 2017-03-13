package merge;

import sort_util.*;
/*
 * 原地归并排序
 * 
 * */
class SortOne{
	private static Integer[] aux;
	public static void merge(Integer[] a,int lo,int mid,int hi){
		int i=lo,j=mid+1;
		//创建另一个数组来接收
		for(int k=lo;k<=hi;k++){
			aux[k]=a[k];
		}
	
		//注意画图理解这
		for(int k=lo;k<=hi;k++){
			if(i>mid){
				a[k]=aux[j++];
			}
			else if(j>hi){
				a[k]=aux[i++];
			}
			else if(Util.less(aux[j],aux[i])){
				a[k]=aux[j++];
			}
			else{
				a[k]=aux[i++];
			}
			
		}
	}
	public static void sort(Integer[] a){
		aux=new Integer[a.length];
		sort(a,0,a.length-1);
	}
	private static void sort(Integer[] a,int lo,int hi){
		if(lo>=hi){
			return;
		}
		int mid=lo+(hi-lo)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	public static void main(String[] args){
		Integer[] a=Util.array(20);
		System.out.println("Sort.....排序前.........");
		Util.show(a);
		sort(a);
		System.out.println("Sort.....排序后.........");
		Util.show(a);
	}
	
}
/*
*归并排序改良版，当小于MIN数的时候启用插入排序
*/
class SortTwo{
	public static final int MIN=4;//设置最小数为	
	public static Integer[] aux;
	public static void merge(Integer[] a,int lo,int mid,int hi){
		int i=lo;
		int j=mid+1;
		
		for(int k=0;k<=hi;k++){
			aux[k]=a[k];
		}
		
		for(int k=lo;k<=hi;k++){
			if(i>mid){
				a[k]=aux[j++];
			}
			else if(j>hi){
				a[k]=aux[i++];
			}
			else if(Util.less(aux[j],aux[i])){
				a[k]=aux[j++];
			}
			else{
				a[k]=aux[i++];
			}
		}
	} 
	
	//插入排序
	public static void insert(Integer[] a,int lo,int hi){
		for(int i=lo;i<hi;i++){
			for(int j=i+1;j>lo&&Util.less(a[j], a[j-1]);j--){	
				Util.exch(a, j, j-1);
			}
		}
	}
	
	
	public static void sort(Integer[] a){
		aux=new Integer[a.length];
		sort(a,0,a.length-1);
	}
	
	
	public static void sort(Integer[] a,int lo,int hi){
		if(lo>=hi){
			return;
		}
		else if(hi-lo<MIN){
			insert(a,lo,hi);//启用插入		
		}
		else{
			int mid=lo+(hi-lo)/2;
			sort(a,lo,mid);
			sort(a,mid+1,hi);
			merge(a,lo,mid,hi);
		}
		
	}
	
	public static void main(String[] args){
		Integer[] arr=Util.array(20);
		System.out.println("SortTwo----排序前-------");
		Util.show(arr);
		sort(arr);
		System.out.println("SortTwo----排序后-------");
		Util.show(arr);
	}
}



public class MergeSort {
	public static void main(String[] args){
		SortOne.main(args);
		SortTwo.main(args);
	}
}
