package a;

import sort_util.Util;

public class SwapSort {
	public static void mian(String[] args){
		Integer[] array=Util.array(10);
		System.out.println("����ǰ��...........");
		Util.show(array);
		swap(array);
		System.out.println("������...... .....");
		Util.show(array);
	}
	
	/*
	 * ð�ݣ������Ƚϣ�����
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
