package prim;

import a.Queue;
import edu.princeton.cs.algs4.MinPQ;

public class LazyPrimMST {
	private boolean[] marked;//��С�������Ķ���
	private Queue<Edge> mst;//��С�������ı�
	private MinPQ<Edge> pq;//���ٽ��ĺ��б�
	private double weight;
	
	public LazyPrimMST(EdgeWeightedGraph G){
		pq=new MinPQ<Edge>();
		marked=new boolean[G.V()];
		mst=new Queue<Edge>();
		
		visit(G,0);//����GΪ��ͨͼ�����Ϊ��ͨͼ,���Բ��ã���������δ��ǵģ��ֱ���ɸ�����ͨͼ
		
		while(!pq.isEmpty()){
			Edge e=pq.delMin();
			int v=e.either();
			int w=e.other(v);
			if(marked[v]&&marked[w]){
				continue;
			}
			weight+=e.weight();
			mst.enqueue(e);
			if(!marked[v]){
				visit(G,v);
			}
			if(!marked[w]){
				visit(G,w);
			}
		}
		
	}
	
	
	
	private void visit(EdgeWeightedGraph G,int v){
		marked[v]=true;
		for(Edge e:G.adj(v)){
			if(!marked[e.other(v)]){
				pq.insert(e);
			}
		}
	}
	
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
	public double weight(){
		return weight;
	}
	
	
	
	
}
