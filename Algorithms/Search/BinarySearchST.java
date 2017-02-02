package Search;

import java.util.Scanner;

import edu.princeton.cs.algs4.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] values;
	private int N;// ��¼��ǰ���е�Ԫ�صĸ���

	public BinarySearchST(int capacity) {
		this.keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Object[capacity];
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}
	//����Ԫ��
	public void put(Key key, Value value) {
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			values[i] = value;
			return;
		}
		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[i] = key;
		values[i] = value;
		N++;
		if(N==N-1){
			resize(2*N);
		}
	}
	private void resize(int n){
		Key[] keysTemp=(Key[])new Comparable[n];
		Value[] valuesTemp=(Value[]) new Object[n];
		for(int i=0;i<N;i++){
			keysTemp[i]=keys[i];
			valuesTemp[i]=values[i];
		}
		values=valuesTemp;
		keys=keysTemp;
	}

	// ���Ҽ���λ�ã��ҵ�����λ�ã��Ҳ��������Ǹ���С��λ��
	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) {
				hi = mid - 1;
			} else if (cmp > 0) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return lo;
	}
	//����ֵɾ��Ԫ��
	public void delete(Key key) {
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			if (i == N - 1) {
				keys[i] = null;
				values[i] = null;
				N--;
				return;
			}
			for (int j = i; j < N - 1; j++) {
				keys[j] = keys[j + 1];
				values[j] = values[j + 1];
			}
			N--;
			keys[N] = null;
			values[N] = null;
		}
	}
	//������С��Ԫ��
	public Key min() {
		return keys[0];
	}
	//���ؼ�ֵ����Ԫ��
	public Key max() {
		return keys[N - 1];
	}
	
	public Key select(int k) {
		return keys[k];
	}
	//ǡ�ô��ڵ���key
	public Key ceiling(Key key) {
		int i = rank(key);
		return keys[i];
	}
	//С�ڵ���key
	public Key floor(Key key) {
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			return keys[i];
		}
		if (i == 0) {
			return null;
		}
		return keys[i - 1];
	}

	public boolean contains(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	public Value get(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to get() is null");
		if (isEmpty())
			return null;
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0)
			return values[i];
		return null;
	}

	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		if (lo == null)
			throw new IllegalArgumentException("first argument to keys() is null");
		if (hi == null)
			throw new IllegalArgumentException("second argument to keys() is null");

		Queue<Key> queue = new Queue<Key>();
		if (lo.compareTo(hi) > 0)
			return queue;
		for (int i = rank(lo); i < rank(hi); i++)
			queue.enqueue(keys[i]);
		if (contains(hi))
			queue.enqueue(keys[rank(hi)]);
		return queue;
	}

	public static void main(String[] args) {
		System.out.println("�����룺");//S E A R C H E X A M P L E
		Scanner in = new Scanner(System.in);
		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(12);

		String line = in.nextLine();
		String[] keys = line.split(" ");
		for (int n = 0; n < keys.length; n++) {
			st.put(keys[n], n);
		}
		for (String s : st.keys()) {
			System.out.println(s + " " + st.get(s));
		}
		System.out.println(".......................");
		st.delete("A");
		for (String s : st.keys()) {
			System.out.println(s + " " + st.get(s));
		}
		System.out.println(".......................");
		st.put("B", 5);
		for (String s : st.keys()) {
			System.out.println(s + " " + st.get(s));
		}
		System.out.println("........................");
		st.delete("X");
		for (String s : st.keys()) {
			System.out.println(s + " " + st.get(s));
		}

	}

}
