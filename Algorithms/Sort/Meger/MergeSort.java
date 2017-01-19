package merge;

import sort_util.*;
/*
 * ԭ�ع鲢����
 * 
 * */
class SortOne{
	private static Integer[] aux;
	public static void merge(Integer[] a,int lo,int mid,int hi){
		int i=lo,j=mid+1;
		//������һ������������
		for(int k=0;k<=hi;k++){
			aux[k]=a[k];
		}
	
		//ע�⻭ͼ�����
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
		System.out.println("Sort.....����ǰ.........");
		Util.show(a);
		sort(a);
		System.out.println("Sort.....�����.........");
		Util.show(a);
	}
	
}

class SortTwo{
	public static final int MIN=4;
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
	
	//��������
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
			insert(a,lo,hi);
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
		System.out.println("SortTwo----����ǰ-------");
		Util.show(arr);
		sort(arr);
		System.out.println("SortTwo----�����-------");
		Util.show(arr);
	}
}



public class MergeSort {
	public static void main(String[] args){
		SortOne.main(args);
		SortTwo.main(args);
	}
}
