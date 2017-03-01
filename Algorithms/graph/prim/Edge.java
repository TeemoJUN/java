package prim;
//创建无向图的边
public class Edge implements Comparable<Edge>{
	//边v-w,和它的权值
	private final int v;
	private final int w;
	private final double weight;
	
	public Edge(int v,int w,double weight){
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
	
	public double weight(){
		return weight;
	}
	//反回其中一个定点
	public int either(){
		return v;
	}
	//返回另一个定点
	public int other(int vertex){
		if(vertex==v){
			return w;
		}
		else if(vertex==w){
			return v;
		}
		else {
			throw new RuntimeException("没有含此节点的边");
		}
	}
	
	@Override
	public int compareTo(Edge that){
		if(this.weight()<that.weight()){
			return -1;
		}
		else if(this.weight()>that.weight()){
			return 1;
		}
		else{
			return 0;
		}
	}
	@Override
	public String toString(){
		return String.format("%d-%d %.2f", v,w,weight);
	}
	
	
}
