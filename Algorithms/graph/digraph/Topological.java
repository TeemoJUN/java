package digraph;
/*
 * 拓扑排序，先判断图是否有环，无环才可能构成拓扑图
 * 
 * */
public class Topological {
	private Iterable<Integer> order;
	public Topological(Digraph G){
		DirectedCycle cyclefinder=new DirectedCycle(G);
		if(!cyclefinder.hasCycle()){
			DepthFirstOrder dfs=new DepthFirstOrder(G);
			
			order=dfs.reversePost();
		}
	}
	public Iterable<Integer> order(){
		return order;
	}
	
	public boolean isDAG(){
		return order!=null;
	}
}
