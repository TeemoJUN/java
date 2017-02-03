package Search;

import java.util.NoSuchElementException;

import a.Queue;

public class BinarySearchTree<Key extends Comparable<Key>,Value> {
	private Node root;
	
	
	private class Node{
		private Key key;//��
		private Value val;//ֵ
		private Node left,right;//��������
		private int N;//�Ըýڵ�Ϊ���ڵ�Ľڵ�����
		
		public Node(Key key,Value val,int n){
			this.key=key;
			this.val=val;
			this.N=n;
		}
	}
	
	//ͳ�ƽڵ���
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
	
	//������ֵ�Ӹ��ڵ㿪ʼ����
	public Value get(Key key){
		return get(root,key);
	}
	
	private Value get(Node x,Key key){
		if(x==null){
			return null;
		}
		//�͵�ǰ�ڵ�Ƚϣ����������������ң�С�������������ң����ھ�ֱ�ӷ��ص�ǰֵ
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
	//��root��ʼ��key��ֵ�ҵ��͸���val
	//ע��������'root='
	public void put(Key key,Value val){
		root=put(root,key,val);
	}
	private Node put(Node x,Key key,Value val){
		if(x==null){
			return new Node(key,val,1);
		}
		//ͬgetһ�����
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
	
	//�Ҽ�ֵ��С
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("��Ϊ��");
        return min(root).key;
    } 
	//��������Ϊ��ʱ��˵���Ѿ����������󣬼�����x������һֱ�ݹ�Ѱ��
	private Node min(Node x){
		if(x.left==null){
			return x;
		}
		return min(x.left);
	}
	
	//������
	public Key max(){
		return max(root).key;
	}
	private Node max(Node x){
		if(x.right==null){
			return x;
		}
		return max(x.right);
	}
	
	//��Ѱǡ��С�ڵ���key��key
	public Key floor(Key key){
		Node x=floor(root,key);
		if(x==null){
			return null;
		}
		return x.key;
	}
	//��key��x.key���бȽ�Ȼ���ѯ
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
		//��key����x.keyʱ������x��������û�У�����Ҫ�ж����Ƿ�ûnull��Ϊnull��x���������ӽ�key����С��ֵ
		Node t=floor(x.right,key);
		if(t!=null){
			return t;
		}
		else{
			return x;
		}
	}
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("Ҫ���ҵļ�Ϊ��");
        if (isEmpty()) throw new NoSuchElementException("��ǰ����Ϊ��");
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
	
	//���ҵ�kλ��keyֵ
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
	
	//����С��key�ĸ���
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
			//������ʱ����Ҫ����x������������x��������ȫ��С��key����Ҫ����size��x.left��,����x�����keyҲ��С��key������+1.
			return rank(key,x.right)+size(x.left)+1;
		}
		else{
			return size(x.left);
		}
	}
	
	//ɾ����С��
	public void deleteMin(){
		root=deleteMin(root);
	}
	//���x�����������ڣ���x���������С�ģ��ͽ�x�����������أ�
	//ע�ⷵ�ظ�����x�ĸ��ڵ㣬����x�ĸ��ڵ���x�����������ӣ�������x
	private Node deleteMin(Node x){	
		if(x.left==null){
			return x.right;
		}
		x.left=deleteMin(x.left);
		x.N=size(x.left)+size(x.right)+1;//����N
		return x;
	}
	
	//ɾ������
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
	//����ɾ��
	public void delete(Key key){
		root=delete(root,key);
	}
	//�ص㽲���ҵ��˽ڵ�ʱ�����ýڵ���������Ƿ�Ϊ�գ�����������return ��������x���ڵ����ӡ�x.right==null�����
	//�����Ϊ�գ��򱣴�Node t=x;
	//��t����������Ѱ����С�Ľڵ㣬ȡ������
	//�滻ԭ����x���������ڵ�x
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
		x.N=size(x.left)+size(x.right)+1;//����С�ڵ���x�����ڵ���
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