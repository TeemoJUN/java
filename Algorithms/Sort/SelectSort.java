package a;
import sort_util.*;
public class SelectSort {
	public static void main(String[] args){
		Integer[] arr=Util.array(20);
		System.out.println("交换前：...........");
		Util.show(arr);
		select(arr);
		System.out.println("交换后：...... .....");
		Util.show(arr);
		
	}
	/*
	 * 先默认第一个i最小，然后再用j去找比i还小的的，用min记入最小的的下标，然后再交换min和i
	 */
	private static void select(Integer[] a){
		for(int i=0;i<a.length;i++){
			int min=i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[min]){
					min=j;
				}
			}
			Util.exch(a, min, i);
		}
	}
	
	
}
