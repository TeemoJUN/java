package a;

public class Sort_Example{
	/*—°‘Ò≈≈–Ú
	 * public static void sort(int[] a){
		int N=a.length;
		for(int i=0;i<N;i++){
			int min=i;
			for(int j=i+1;j<N;j++){
				if(less(a[j],a[min])){
					min=j;
				}
			}
			exch(a,i,min);
		}
	}*/
	//	≤Â»Î≈≈–Ú
	public static void sort(int[] a){
		int N=a.length;
		for(int i=1;i<N;i++){
			for(int j=i;j>0&&less(a[j],a[j-1]);j--){
				exch(a,j,j-1);
			}
		}
	}
	private static boolean less(Integer v,Integer w){
		return v.compareTo(w)<0;
	}
	private static void exch(int[] a,int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void show(Integer[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"  ");
		}
		System.out.println();
	}
	public static boolean isSort(int[] a){
		for(int i=1;i<a.length;i++){
			if(less(a[i],a[i-1])){
				return false;
			}
		}
		return true;
	}
	
}
