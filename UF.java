package one;

public class UF {
	private int[] id;//��ͨ����
	private int count;//��ͨ��
	
	private int[] size;
	
	public UF(int N){
		this.id=new int[N];
		this.count=N;
		for(int i=0;i<N;i++){
			id[i]=i;
		}
		this.size=new int[N];
		for(int i=0;i<N;i++){
			size[i]=1;
		}
	}
	
	//p�ı�ʶ��
	public int find(int p){
		while(p!=id[p]){
			p=id[p];
		}
		return p;
	}
	//��ͨ��
	public int count(){
		return count;
	}
	
	//����p,q
	public void union(int p,int q){
		int pId=find(p);
		int qId=find(q);
		if(pId==qId){
			return ;
		}
		if(size[pId]>size[qId]){
			id[qId]=id[pId];
			size[pId]+=size[qId];
		}
		else{
			id[pId]=id[qId];
			size[qId]+=size[pId];
		}
		count--;
	}
	//p��q�����Ƿ�����
	public boolean connected(int p,int q){
		int pId=find(p);
		int qId=find(q);
		return pId==qId;
	}	
}
