package insert;

import sort_util.*;

public class InsertSort {
	public static void main(String[] args){
		int arr1[]={6,7,11,10};
		int b=sort(arr1);
		System.out.println(b);
		int[] arr2={6,10,7,11};
		int d=sort(arr2);
		System.out.println(d);
	}
	public static int sort(int[] a){
		int count=0;
		int length=a.length;
		for(int i=0;i<length-1;i++){
			for(int j=i+1;j>0&&Util.less(a[j], a[j-1]);j--){	
				Util.exch(a, j, j-1);
				count++;
			}
		}
		return count;
	}
}
