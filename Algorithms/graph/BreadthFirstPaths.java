package graph;

import a.Queue;
import edu.princeton.cs.algs4.Stack;

/*
 * ���0--->1--->2
 *	0--->3--->2
 *����ò��3--->2��·���ᶪʧ
 *ֻ��֤��1---->2��ͨ·����·��ֻ����0--->1--->2
 * */

public class BreadthFirstPaths {
	
	private boolean[] marked;//����Ѿ��߹��ĵ�
	private int[] edgeTo;//�������Ľڵ�
	private int start;//���
	
	
	
	public BreadthFirstPaths(Graph g,int start){
		marked=new boolean[g.V()];
		edgeTo=new int[g.V()];
		this.start=start;
		bfs(g,start);
	}
	
	//��ÿ���ڵ㷽��������ڽ�������
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





