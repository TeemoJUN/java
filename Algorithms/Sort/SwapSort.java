package a;

import sort_util.Util;

public class SwapSort {
	public static void mian(String[] args){
		Integer[] array=Util.array(10);
		System.out.println("交换前：...........");
		Util.show(array);
		swap(array);
		System.out.println("交换后：...... .....");
		Util.show(array);
	}
	
	/*
	 * 冒泡，两两比较，交换
	 */
	private static void swap(Integer[] a){
		for(int i=0;i<a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]>a[j]){
					Util.exch(a, i, j);
				}
			}
		}
	}
}
