public class DoubleLink<Item> {
	private Node head=null;
	private Node tail=null;
	private int N=0;
	private class Node{
		Node prior;
		Node next;
		Item item;
	}
	/*
	 * 在后面加入数据
	 */
	public void addTailData(Item data){
		Node newNode=new Node();
		newNode.item=data;
		if(N==0){
			head=newNode;
			tail=newNode;
		}
		else{
			tail.next=newNode;
			newNode.prior=tail;
			tail=newNode;
		}
		N++;
	}
	/*
	 * 在后面加入数据
	 */
	public void addHeadData(Item data){
		Node newNode=new Node();
		newNode.item=data;
		if(N==0){
			head=newNode;
			tail=newNode;
		}
		else{
			newNode.next=head;
			head.prior=newNode;
			head=newNode;
		}
		N++;
	}
	/*
	 * 删除第i个位置的元素（i从0开始算的）并返还该元素
	 */
	public Item deleteData(int i){
		Node reData;//要返回的节点
		if(i<0||i>N-1){
			System.out.println("delete fail!");
			return null;
		}
		else if(i==0){
			head=null;
			tail=null;
			return null;
		}
		else{
			Node p=head;
			int j=0;
			while(j!=i-1){
				p=p.next;
				j++;
			}
			reData=p.next;
			p.next=p.next.next;
			p.next.prior=p;
		}
		N--;
		return reData.item;
	}
	/*
	 * 在第i个节点后面插入data
	 */
	public void innersetData(int i,Item data){
		if(i>=0&&i<N-1){
			Node newNode=new Node();
			newNode.item=data;
			//System.out.println("进来啦");
			Node p=head;
			int j=0;
			while(j!=i){
				p=p.next;
				j++;
			}
			newNode.next=p.next;
			p.next.prior=newNode;
			p.next=newNode;
			newNode.prior=p;
			N++;
		}
		else if(i==N-1){
			addTailData(data);
		}
		else{
			System.out.println("插入为位置不对!");
		}
	}
	/*
	 * 返回链表长度N
	 */
	public int size(){
		return N;
	}
	/*
	 * 从前向后遍历
	 */
	public void printHeadToTail(){
		Node p=head;
		System.out.print("head-->tail:  ");
		while(p!=null){
			System.out.printf("%s->>",p.item);
			p=p.next;
		}
		System.out.println();
	}
	/*
	 * 从后向遍历
	 */
	public void printTailToHead(){
		Node p=tail;
		System.out.print("tail-->head:  ");
		while(p!=null){
			System.out.printf("%s->>",p.item);
			p=p.prior;
		}
		System.out.println();
	}
	public static void main(String[] args){
		DoubleLink<Integer> doubleLink=new DoubleLink<Integer>();
		doubleLink.addHeadData(1);
		doubleLink.addHeadData(2);
		doubleLink.addHeadData(3);
		doubleLink.addTailData(4);
		doubleLink.addTailData(5);
		doubleLink.addTailData(6);
		doubleLink.addTailData(7);
		doubleLink.addTailData(8);
		doubleLink.addTailData(9);
		int linkSize=doubleLink.size();
		System.out.println("链表大小　"+linkSize);
		int deleteIndex=2;
		int data=doubleLink.deleteData(deleteIndex);
		System.out.println("删除的下标是  "+deleteIndex+" 删除的数据是   "+data);
		doubleLink.innersetData(7,10);
		doubleLink.printHeadToTail();
		doubleLink.printTailToHead();
	}
} 
