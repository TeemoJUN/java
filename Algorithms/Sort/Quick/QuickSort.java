package quick;

import sort_util.Util;
/*
 * ÿ�ؽ�ÿ�ηָ�ĵ�һ��ֵ��λ������ֵ��С��������ֵ��������
 * 
 * */
class Quick{
	public static void sort(Integer[] a,int lo,int hi){
		if(lo>=hi){
			return;
		}
		int k=partition(a,lo,hi);//����һ��ֵ��λ
		sort(a,lo,k-1);//��
		sort(a,k+1,hi);//��
	}
	/*
	 * �ָ�ҵ���һ��ֵ��λ�ã�
	 * i��j�������ڱ����ֱ�վ��������
	 * 
	 * 
	 * */
	public static int partition(Integer[] a,int lo,int hi){
		int i=lo;int j=hi+1;
		int s=a[lo];
		while(true){
			//�����ұ����Ҵ��ڵ�һ��ֵ��
			while(Util.less(a[++i], s) ){
				System.out.println("......................i......."+i+" : "+a[i]+" ��С�� "+lo+" : "+s);
				if(i==hi){
					System.out.println("i==hi:"+i);
					break;
				}
			}
			System.out.println("..........��Ҫ��������.....i......."+i+" : "+a[i]);
			//���ҵ�����С�ڵ�һ��ֵ��
			while(Util.less(s, a[--j])){
				System.out.println("......................j......."+j+" : "+a[j]+" �Ҵ��� "+lo+" : "+s);
				if(j==lo){
					System.out.println("j==lo: "+j);
					break;
				} 
			}
			System.out.println("..........��Ҫ��������.....j......."+j+" : "+a[j]);
			if(i>=j){
				break;
			}
			Util.exch(a, i, j);
			System.out.println(i+"��"+j+"����");
			Util.show(a);
		}
		Util.exch(a, lo, j);
		System.out.println(lo+"��"+j+"����");
		Util.show(a);
		return j;
	}
	
	
	public static void main(String[] args){
		Integer[] array=Util.array(10);
		System.out.println("����ǰ��...........");
		Util.show(array);
		sort(array,0,array.length-1);
		System.out.println("������...... .....");
		Util.show(array);
	}
	
}




public class QuickSort {
	public static void main(String[] args){
		Quick.main(args);
	}
}
