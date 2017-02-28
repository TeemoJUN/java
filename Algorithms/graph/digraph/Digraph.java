package digraph;

import a.Bag;

/*
 * 有向图
 * */
public class Digraph {
	private final int V;//定点数
	private int E;//边数
	private Bag<Integer>[] adj;//为每一个定点建立一个Bag来存贮可以到达的邻接定点
	
	
	public Digraph(int V){
		this.V=V;
		this.E=0;
		adj=(Bag<Integer>[])new Bag[V];
		
		for(int v=0;v<V;v++){
			adj[v]=new Bag<Integer>();
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
		E++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public Digraph reverse(){
		Digraph R=new Digraph(V);
		
		for(int v=0;v<V;v++){
			for(int w:adj(v)){
				R.addEdge(w, v);
			}
		}
		return R;
	}
}
