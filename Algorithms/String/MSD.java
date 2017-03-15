package String;

public class MSD {
	private static int R=256;
	private static final int M=2;
	private static String[] aux;
	
	private static int charAt(String s,int d){
		if(d<s.length()){
			return s.charAt(d);
		}
		else{
			return -1;
		}
	}
	
	public static void sort(String[] a){
		int N=a.length;
		aux=new String[N];
		sort(a,0,N-1,0);
	}
	
	private static void sort(String[] a,int lo,int hi,int d){
		if(hi<=lo+M){
			Insertion.sort(a, lo, hi, d);
			return;
		}
		
		int[] count=new int[R+2];
		//计算频率这里加二是因为ASCII码扩展位有256位，加上在charAt()中匹配为-1的总共257位，集体后移一位		
		for(int i=lo;i<=hi;i++){
			count[charAt(a[i],d)+2]++;
		}
				
		//计算索引值		
		for(int r=0;r<R+1;r++){
			count[r+1]+=count[r];
		}
				
		//数据分类		
		for(int i=lo;i<=hi;i++){
			aux[count[charAt(a[i],d)+1]++]=a[i];
		}
		
		//回写		
		for(int i=lo;i<=hi;i++){
			a[i]=aux[i-lo];
		}
		for(int r=0;r<R;r++){
			sort(a,lo+count[r],lo+count[r+1]-1,d+1);
		}
	}
	
	public static void main(String[] args){
		String[] string={"a","b","as","ax","ad","abg","ascfr","adsjlk","quyei","wqyei","hasfdkl","dhfask","hdsak"};
		
		sort(string);
		
		for(int i=0;i<string.length;i++){
			System.out.println(string[i]);
		}
		
		
	}
	
}
