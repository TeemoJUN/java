package String;

public class LSD {
	public static void sort(String[] a,int w){
		int N=a.length;
		int R=256;
		String[] aux=new String[N];
		
		for(int d=w-1;d>=0;d--){
			int[] count=new int[R+1];
			//计算频率
			for(int i=0;i<N;i++){
				count[a[i].charAt(d)+1]++;
			}
			//计算相应的索引值得起始位置
			for(int r=0;r<R;r++){
				count[r+1]+=count[r];
			}
			//数据分类 ,在count中找到那个值起始位置,并将起始位置加1
			for(int i=0;i<N;i++){
				aux[count[a[i].charAt(d)]++]=a[i];
			}
			//归位
			for(int i=0;i<N;i++){
				a[i]=aux[i];
			}
		}
	}
	
	public static void main(String[] args){
		String[] string={"a47878","789289","23545u","123456"};
		sort(string,string.length);
		for(int i=0;i<string.length;i++){
			System.out.println(string[i]);
		}
	}
	
}












