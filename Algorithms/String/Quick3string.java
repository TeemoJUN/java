package String;
/*
 * 
 * 该方类似快速排序的三项切分，就是维护一个小于,等于,大于
 * 维护lt使得a[lo...lt-1]为小于v
 * gt使得a[gt+1...hi]为大于v
 * a[lt...i]为等于v
 * a[i....gt]为未确定
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
		//当小于前面字符都是小于a[lo]的但,但它们第d位还是没有区分出大小;所以继续d位比较----1
		sort(a,lo,lt-1,d);
		//对d位为相等的值进行d=d+1的比较
		if(v>=0){
			sort(a,lt,gt,d+1);
		}
		//和1相同
		sort(a,gt+1,hi,d);
	}
}
