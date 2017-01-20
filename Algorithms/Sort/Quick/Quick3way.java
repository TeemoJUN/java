package quick;

import sort_util.Util;
/*
 *   三项切分
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
				case -1:System.out.println(lt+" 交换 "+i);
						Util.exch(a, lt++, i++);
						Util.show(a);
						break;
				case 1: System.out.println(i+" 交换 "+gt);
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
		System.out.println("排序前:....................");
		Util.show(arr);
		sort(arr);
		System.out.println("排序后：....................");
		Util.show(arr);
	}
}
/************************************
 *当a[i]小于v 将a[lt]和a[i]交换 ,lt++,i++ *
 *当a[i]大于v 将a[gt]和a[i]交换,gt--;    *
 *当a[i]等于v i++;                    *
 *注意画图理解                                                                                       *
 *************************************/
