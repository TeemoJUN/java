package a;
import sort_util.*;
public class SelectSort {
	public static void main(String[] args){
		Integer[] arr=Util.array(20);
		System.out.println("����ǰ��...........");
		Util.show(arr);
		select(arr);
		System.out.println("������...... .....");
		Util.show(arr);
		
	}
	/*
	 * ��Ĭ�ϵ�һ��i��С��Ȼ������jȥ�ұ�i��С�ĵģ���min������С�ĵ��±꣬Ȼ���ٽ���min��i
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
