package prim;

import a.Queue;
import edu.princeton.cs.algs4.MinPQ;

public class LazyPrimMST {
	private boolean[] marked;//最小生成树的顶点
	private Queue<Edge> mst;//最小生成树的边
	private MinPQ<Edge> pq;//树临近的横切边
	private double weight;
	
	public LazyPrimMST(EdgeWeightedGraph G){
		pq=new MinPQ<Edge>();
		marked=new boolean[G.V()];
		mst=new Queue<Edge>();
		
		visit(G,0);//假设G为连通图如果不为连通图,可以采用，遍历所有未标记的，分别组成各自连通图
		
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
