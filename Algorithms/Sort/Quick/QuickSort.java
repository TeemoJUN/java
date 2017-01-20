package quick;

import sort_util.Util;
/*
 * 每回将每次分割的第一个值归位，且左值均小于它，右值均大于它
 * 
 * */
class Quick{
	public static void sort(Integer[] a,int lo,int hi){
		if(lo>=hi){
			return;
		}
		int k=partition(a,lo,hi);//将第一个值归位
		sort(a,lo,k-1);//左
		sort(a,k+1,hi);//右
	}
	/*
	 * 分割，找到第一个值得位置；
	 * i和j是两个哨兵，分别站在最外面
	 * 
	 * 
	 * */
	public static int partition(Integer[] a,int lo,int hi){
		int i=lo;int j=hi+1;
		int s=a[lo];
		while(true){
			//从左到右遍历找大于第一个值得
			while(Util.less(a[++i], s) ){
				System.out.println("......................i......."+i+" : "+a[i]+" 我小于 "+lo+" : "+s);
				if(i==hi){
					System.out.println("i==hi:"+i);
					break;
				}
			}
			System.out.println("..........将要交换的是.....i......."+i+" : "+a[i]);
			//从右道左找小于第一个值得
			while(Util.less(s, a[--j])){
				System.out.println("......................j......."+j+" : "+a[j]+" 我大于 "+lo+" : "+s);
				if(j==lo){
					System.out.println("j==lo: "+j);
					break;
				} 
			}
			System.out.println("..........将要交换的是.....j......."+j+" : "+a[j]);
			if(i>=j){
				break;
			}
			Util.exch(a, i, j);
			System.out.println(i+"与"+j+"交换");
			Util.show(a);
		}
		Util.exch(a, lo, j);
		System.out.println(lo+"与"+j+"交换");
		Util.show(a);
		return j;
	}
	
	
	public static void main(String[] args){
		Integer[] array=Util.array(10);
		System.out.println("交换前：...........");
		Util.show(array);
		sort(array,0,array.length-1);
		System.out.println("交换后：...... .....");
		Util.show(array);
	}
	
}




public class QuickSort {
	public static void main(String[] args){
		Quick.main(args);
	}
}
