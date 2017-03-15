package String;
/*
 * 
 * �÷����ƿ�������������з֣�����ά��һ��С��,����,����
 * ά��ltʹ��a[lo...lt-1]ΪС��v
 * gtʹ��a[gt+1...hi]Ϊ����v
 * a[lt...i]Ϊ����v
 * a[i....gt]Ϊδȷ��
 * 
 * */
public class Quick3string {
	private static int charAt(String s,int d){
		if(d<s.length()){
			return s.charAt(d);				
		}
		else{
			return -1;
		}
	}
	
	public static void sort(String[] a){
		sort(a,0,a.length-1,0);
	}
	
	
	private static void sort(String[] a,int lo,int hi,int d){
		if(hi<=lo){
			return ;
		}
		int lt=lo,gt=hi;
		int v=charAt(a[lo],d);
		int i=lo+1;
		while(i<=gt){
			int t=charAt(a[i],d);
			if(t<v){
				Insertion.exch(a,lt++,i++);
			}
			else if(t>v){
				Insertion.exch(a, i, gt--);
			}
			else{
				i++;
			}
		}
		//��С��ǰ���ַ�����С��a[lo]�ĵ�,�����ǵ�dλ����û�����ֳ���С;���Լ���dλ�Ƚ�----1
		sort(a,lo,lt-1,d);
		//��dλΪ��ȵ�ֵ����d=d+1�ıȽ�
		if(v>=0){
			sort(a,lt,gt,d+1);
		}
		//��1��ͬ
		sort(a,gt+1,hi,d);
	}
}
