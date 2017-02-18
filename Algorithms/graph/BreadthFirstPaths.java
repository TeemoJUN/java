package graph;

import a.Queue;
import edu.princeton.cs.algs4.Stack;

/*
 * 如果0--->1--->2
 *	0--->3--->2
 *这样貌似3--->2的路将会丢失
 *只能证明1---->2是通路，但路径只能是0--->1--->2
 * */

public class BreadthFirstPaths {
	
	private boolean[] marked;//标记已经走过的点
	private int[] edgeTo;//记入来的节点
	private int start;//起点
	
	
	
	public BreadthFirstPaths(Graph g,int start){
		marked=new boolean[g.V()];
		edgeTo=new int[g.V()];
		this.start=start;
		bfs(g,start);
	}
	
	//把每个节点方到队列里，在进行搜索
	private void bfs(Graph g,int start){
		Queue<Integer> queue=new Queue<Integer>();
		marked[start]=true;
		queue.enqueue(start);
		while(!queue.isEmpty()){
			int v=queue.dequeue();
			for(int w:g.adj(v)){
				if(!marked[w]){
					marked[w]=true;
					edgeTo[w]=v;
					queue.enqueue(w);
				}
			}
		}
		
	}
	
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!marked[v]){
			return null;
		}
		
		Stack<Integer> stack=new Stack<Integer>();
		
		for(int s=v;s!=start;s=edgeTo[s]){
			stack.push(s);
		}
		stack.push(start);
		return stack;
	}
	
	public static void main(String[] args){
		Graph g=new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 2);
		
		BreadthFirstPaths test=new BreadthFirstPaths(g,0);
		
		System.out.println(test.hasPathTo(1));
		
		for(int x:test.pathTo(2)){
			System.out.print(x+"  ");
		}
		
	}
	
}





