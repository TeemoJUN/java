package graph;

import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths {
	
	private boolean[] marked;//标记所有联通的的节点
	private int[] edgeTo;//记录该节点的来源节点
	private int start;//开始遍历的节点
	
	
	public DepthFirstPaths(Graph g,int start){
		marked=new boolean[g.V()];
		edgeTo=new int[g.V()];
		this.start=start;
		dfs(g,start);
	}
	
	private void dfs(Graph g,int start){
		marked[start]=true;
		for(int w:g.adj(start)){
			if(!marked[w]){
				edgeTo[w]=start;
				dfs(g,w);
			}
		}
	}
	
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)){
			return null;
		}
		
		Stack<Integer> path=new Stack<Integer>();
		
		for(int x=v;x!=start;x=edgeTo[x]){
			path.push(x);
		}
		path.push(start);
		return path;
	}
	
	
	public static void main(String[] args){
		Graph g=new Graph(5);
		g.addEdge(0, 4);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(1, 3);
		
		DepthFirstPaths test=new DepthFirstPaths(g,4);
		
		System.out.println(test.hasPathTo(1));
		for(int x:test.pathTo(1)){
			System.out.print(x+"  ");
		}
		
		
	}
	
}






