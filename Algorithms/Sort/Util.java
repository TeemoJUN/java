package sort_util;

import java.util.Random;

public class Util {

	//��v<wʱΪtrue
	public static boolean less(Integer v,Integer w){
		return v.compareTo(w)<0;
	}
	
	//����������
	private static void exch(int[] a,int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	//�������
	public static void show(Integer[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"  ");
		}
		System.out.println();
	}
	//�ж������Ƿ�ɹ�
	public static boolean isSort(Integer[] a){
		for(int i=1;i<a.length;i++){
			if(less(a[i],a[i-1])){
				return false;
			}
		}
		return true;
	}
	
	private static Random ran=new Random(47);
	
	//�����������
	public static Integer[] array(int n){
		Integer[] arr=new Integer[n];
		for(int i=0;i<arr.length;i++){
			arr[i]=new Integer(ran.nextInt(100));
		}
		return arr;
	}
	
	public static void exch(Integer[] a,int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
}













