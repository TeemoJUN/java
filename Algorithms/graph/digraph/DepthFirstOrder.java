package digraph;

import a.Queue;
import a.Stack;

public class DepthFirstOrder {
	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	
	public DepthFirstOrder(Digraph G){
		pre=new Queue<Integer>();
		post=new Queue<Integer>();
		reversePost=new Stack<Integer>();
		marked=new boolean[G.V()];
		
		for(int v=0;v<G.V();v++){
			if(!marked[v]){
				dfs(G,v);
			}
		}
	}
	
	private void dfs(Digraph G,int v){
		pre.enqueue(v);
		marked[v]=true;
		for(int w:G.adj(v)){
			if(!marked[w]){
				dfs(G,w);
			}
		}
		post.enqueue(v);
		reversePost.push(v);
	}
	
	public Iterable<Integer> pre(){
		return pre;
	}
	
	public Iterable<Integer> post(){
		return post;
	}
	public Iterable<Integer> reversePost(){
		return reversePost;
	}
	
	public static void main(String[] args){
		Digraph graph=new Digraph(13);
		graph.addEdge(0, 6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 5);
		graph.addEdge(6, 9);
		graph.addEdge(9, 10);
		graph.addEdge(9, 12);
		graph.addEdge(9, 11);
		graph.addEdge(11, 12);
		graph.addEdge(8, 7);
		graph.addEdge(7, 6);
		graph.addEdge(6, 4);
		graph.addEdge(5, 4);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 5);
		DepthFirstOrder g=new DepthFirstOrder(graph);
		System.out.println("Ç°Ðò...........");
		for(int v:g.pre()){
			System.out.print(v+" ");
		}
		System.out.println();
		System.out.println("ºóÐò...........");
		for(int v:g.post()){
			System.out.print(v+" ");
		}
		System.out.println();
		System.out.println("ÄæºóÐò...........");
		for(int v:g.reversePost()){
			System.out.print(v+" ");
		}
		
	}
}
