package quick;

import sort_util.Util;
/*
 *   �����з�
 *
 * */
public class Quick3way {
	public static void sort(Integer[] a,int lo,int hi){
		if(hi<=lo){
			return ;
		}
		int lt=lo;int i=lo+1;int gt=hi;
		
		Integer v=a[lo];
		
		while(i<=gt){
			int cop=a[i].compareTo(v);
			switch(cop){
				case -1:System.out.println(lt+" ���� "+i);
						Util.exch(a, lt++, i++);
						Util.show(a);
						break;
				case 1: System.out.println(i+" ���� "+gt);
						Util.exch(a, i, gt--);
						Util.show(a);
						break;
				case 0:i++;
						break;
			}
		}
		sort(a,lo,lt-1);
		sort(a,gt+1,hi);
	}
	public static void sort(Integer[] a){
		sort(a,0,a.length-1);
	}
	
	
	public static void main(String[] args){
		Integer[] arr=Util.array(10);
		System.out.println("����ǰ:....................");
		Util.show(arr);
		sort(arr);
		System.out.println("�����....................");
		Util.show(arr);
	}
}
/************************************
 *��a[i]С��v ��a[lt]��a[i]���� ,lt++,i++ *
 *��a[i]����v ��a[gt]��a[i]����,gt--;    *
 *��a[i]����v i++;                    *
 *ע�⻭ͼ���                                                                                       *
 *************************************/
