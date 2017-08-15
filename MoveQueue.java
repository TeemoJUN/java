package two;

import one.Dequeue;

/*
 * �������� 
 * 
 * 
 * ��˫�����ģ���
 * 
 * �������Ϊ�Ƶף���ֻ�ܽ���pushLeft�������Ʒ����Ƶ�
 * �����Ҳ�Ϊ�ƶѶ�����ֻ�ܽ���popRight()ȡ����
 * */


public class MoveQueue {
	public static void main(String[] args) throws Exception{
		Dequeue<Integer> queue=new Dequeue<Integer>();
		
		//�����ƶ�
		queue.pushLeft(1);
		queue.pushLeft(3);
		queue.pushLeft(5);
		queue.pushLeft(2);
		queue.pushLeft(4);
		queue.pushLeft(7);
		queue.pushLeft(6);
		queue.pushLeft(8);
		queue.pushLeft(10);
		queue.pushLeft(6);
		queue.pushLeft(8);
		queue.pushLeft(10);
		
		System.out.println("û���ź����״̬");
		queue.print();//10  8  6  10  8  6  7  4  2  5  3  1  
		int N=queue.size();
		
		for(int i=N;i>0;i--){
			int j=i-1;//������Ҫ�ȽϵĴ���j�Σ���һ��ΪN-1����i-1���Σ�
			int k=N-i;//����Ҫ��k���Ѿ��ź�����Ƶ��Ƶ�ȥ����ԭ��
			int first=queue.popRight();//��ȡ��һ��
			while(j>0){
				//��Ҫ�Ƚ�j���ҵ�������,��������ͳͳ�Ž��ƶ�
				int second=queue.popRight();
				if(first>second){
					queue.pushLeft(second);
				}
				else{
					queue.pushLeft(first);
					first=second;
				}
				j--;
			}
			while(k>0){
				//��ԭԭ�����ź������
				int p=queue.popRight();
				queue.pushLeft(p);
				k--;
			}
			queue.pushLeft(first);//��ÿ�ֱȽ��������ŷŵ��Ƶ�
		}
		System.out.println("�ź����");
		queue.print();//1  2  3  4  5  6  6  7  8  8  10  10  
	}
	
}
