package prim;

import a.Bag;

public class EdgeWeightedGraph {
	private final int V;//图中顶点数
	private int E;//边数
	private Bag<Edge>[] adj;//每一个边的的一个bag，存贮他们的可到达的最近点的egde对象
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int V){
		this.V=V;
		this.E=0;
		adj=(Bag<Edge>[]) new Bag[V];
		for(int v=0;v<V;v++){
			adj[v]=new Bag<Edge>();
		}
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return V;
	}
	
	public void addEdge(Edge e){
		int v=e.either();
		int w=e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	
	public Iterable<Edge> edges(){
		Bag<Edge> b=new Bag<Edge>();
		for(int v=0;v<V;v++){
			for(Edge e:adj[v]){
				//避免一条边两次加入到b中。采用从v大到小，避免回头
				if(e.other(v)>v){
					b.add(e);
				}
			}
		}
		return b;
	}
	
}
