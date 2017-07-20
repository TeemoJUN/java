package digraph;

import a.Queue;
import a.Stack;

/*
 * 广度遍历
 */

public class BreadthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	public BreadthFirstPaths(Digraph G,int s){
		this.s=s;
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		bfs(G,s);
	}
	
	private void bfs(Digraph G,int s){
		Queue<Integer> queue=new Queue<Integer>();
		
		marked[s]=true;
		queue.enqueue(s);
		
		while(!queue.isEmpty()){
			int v=queue.dequeue();
			for(int w:G.adj(v)){
				edgeTo[w]=v;
				marked[w]=true;
				queue.enqueue(w);
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		Stack<Integer> stack=new Stack<Integer>();
		
		for(int end=v;end!=s;end=edgeTo[v]){
			stack.push(v);
		}
		stack.push(s);//放入第一个元素
		return stack;
	}
	
	
}
