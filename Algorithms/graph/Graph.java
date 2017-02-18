package graph;

import a.Bag;

public class Graph {
	
	private final int V;//顶点数
	private int E;//边数
	private Bag<Integer>[] adj;//为每条边都建立一个bag来存贮相邻的节点
	
	
	@SuppressWarnings("unchecked")
	public Graph(int v){
		this.V=v;
		this.E=0;
		adj=(Bag<Integer>[]) new Bag[V];
		
		for(int i=0;i<V;i++){
			adj[i]=new Bag<Integer>();
		}
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public void addEdge(int v,int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
}
