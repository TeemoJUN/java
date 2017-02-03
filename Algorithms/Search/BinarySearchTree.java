package Search;

import java.util.NoSuchElementException;

import a.Queue;

public class BinarySearchTree<Key extends Comparable<Key>,Value> {
	private Node root;
	
	
	private class Node{
		private Key key;//键
		private Value val;//值
		private Node left,right;//左右链接
		private int N;//以该节点为根节点的节点总数
		
		public Node(Key key,Value val,int n){
			this.key=key;
			this.val=val;
			this.N=n;
		}
	}
	
	//统计节点数
	public int size(){
		return size(root);
	}

	private int size(Node x){
		if(x==null){
			return 0;
		}
		else{
			return x.N;
		}
	}
	 public boolean isEmpty() {
	        return size() == 0;
	    }
	
	//按键找值从跟节点开始找起
	public Value get(Key key){
		return get(root,key);
	}
	
	private Value get(Node x,Key key){
		if(x==null){
			return null;
		}
		//和当前节点比较，大于则在右子树找，小于则在左子树找，等于就直接返回当前值
		int cmp=key.compareTo(x.key);
		if(cmp<0){
			return get(x.left,key);
		}
		else if(cmp>0){
			return get(x.right,key);
		}
		else{
			return x.val;
		}
	}
	//从root开始找key键值找到就更新val
	//注意理解这个'root='
	public void put(Key key,Value val){
		root=put(root,key,val);
	}
	private Node put(Node x,Key key,Value val){
		if(x==null){
			return new Node(key,val,1);
		}
		//同get一样理解
		int cmp=key.compareTo(x.key);
		if(cmp<0){
			x.left=put(x.left,key,val);
		}
		else if(cmp>0){
			x.right=put(x.right,key,val);
		}
		else{
			x.val=val;
		}
		
		x.N=size(x.left)+size(x.right)+1;
		
		return x;
	}
	
	//找键值最小
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("树为空");
        return min(root).key;
    } 
	//当左子树为空时，说明已经到达了最左，即返回x，否则一直递归寻找
	private Node min(Node x){
		if(x.left==null){
			return x;
		}
		return min(x.left);
	}
	
	//找最大键
	public Key max(){
		return max(root).key;
	}
	private Node max(Node x){
		if(x.right==null){
			return x;
		}
		return max(x.right);
	}
	
	//找寻恰好小于等于key的key
	public Key floor(Key key){
		Node x=floor(root,key);
		if(x==null){
			return null;
		}
		return x.key;
	}
	//将key与x.key进行比较然后查询
	private Node floor(Node x,Key key){
		if(x==null){
			return null;
		}
		int cmp=key.compareTo(x.key);
		if(cmp==0){
			return x;
		}
		else if(cmp<0){
			return floor(x.left,key);
		}
		//当key大于x.key时，可能x的右子树没有，所以要判断他是否没null，为null则x本身就是最接近key的最小键值
		Node t=floor(x.right,key);
		if(t!=null){
			return t;
		}
		else{
			return x;
		}
	}
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("要查找的键为空");
        if (isEmpty()) throw new NoSuchElementException("当前该树为空");
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) { 
            Node t = ceiling(x.left, key); 
            if (t != null) return t;
            else return x; 
        } 
        return ceiling(x.right, key); 
    }
	
	//查找第k位的key值
	public Key select(int k){
		return select(root,k).key;
	}
	public Node select(Node x,int k){
		if(x==null){
			return null;
		}
		int t=size(x.left);
		if(t>k){
			return select(x.left,k);
		}
		else if(t>k){
			return select(x.right,k);
		}
		else{
			return x;
		}
	}
	
	//查找小于key的个数
	public int rank(Key key){
		return rank(key,root);
	}
	private int rank(Key key,Node x){
		if(x==null){
			return 0;
		}
		int cmp=key.compareTo(x.key);
		
		if(cmp<0){
			return rank(key,x.left);
		}
		else if(cmp>0){
			//当大于时，则要查找x的右字数，且x的左子树全都小于key所以要加上size（x.left）,还有x本身的key也是小于key的所以+1.
			return rank(key,x.right)+size(x.left)+1;
		}
		else{
			return size(x.left);
		}
	}
	
	//删除最小键
	public void deleteMin(){
		root=deleteMin(root);
	}
	//如果x左子树不存在，即x本身就是最小的，就将x的右子树返回，
	//注意返回给的是x的父节点，即将x的父节点与x的右子树连接，跳过了x
	private Node deleteMin(Node x){	
		if(x.left==null){
			return x.right;
		}
		x.left=deleteMin(x.left);
		x.N=size(x.left)+size(x.right)+1;//更新N
		return x;
	}
	
	//删除最大键
	public void deleteMax(){
		root=deleteMax(root);
	}
	private Node deleteMax(Node x){
		if(x.right==null){
			return x.left;
		}
		x.right=deleteMax(x.right);
		x.N=size(x.right)+size(x.left)+1;
		return x;
	}
	//按键删除
	public void delete(Key key){
		root=delete(root,key);
	}
	//重点讲解找到了节点时，看该节点的左子树是否为空，空则将右子树return 即将其与x父节点连接。x.right==null亦如此
	//如果不为空，则保存Node t=x;
	//在t的右子树中寻找最小的节点，取出它。
	//替换原来的x并返回现在的x
	private Node delete(Node x,Key key){
		if(x==null){
			return null;
		}
		int cmp=key.compareTo(x.key);
		if(cmp<0){
			x.left=delete(x.left,key);
		}
		else if(cmp>0){
			x.right=delete(x.right,key);
		}
		else{
			if(x.right==null){
				return x.left;
			}
			if(x.left==null){
				return x.right;
			}
			Node t=x;
			x=min(t.right);
			x.right=deleteMin(t.right);
			x.left=t.left;
		}
		x.N=size(x.left)+size(x.right)+1;//更新小于等于x子树节点数
		return x;
	}
	
	public Iterable<Key> keys(){
		return keys(min(),max());
	}
	public Iterable<Key> keys(Key lo,Key hi){
		Queue<Key> queue=new Queue<Key>();
		keys(root,queue,lo,hi);
		return queue;
	}
	
	private void keys(Node x,Queue<Key> queue,Key lo,Key hi){
		if(x==null){
			return;
		}
		int cmplo=lo.compareTo(x.key);
		int cmphi=hi.compareTo(x.key);
		if(cmplo<0){
			keys(x.left,queue,lo,hi);
		}
		else if(cmplo<=0&&cmphi>=0){
			queue.enqueue(x.key);
		}
		if(cmphi>0){
			keys(x.right,queue,lo,hi);
		}
	}
	
}