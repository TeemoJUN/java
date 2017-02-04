package Search;

import a.Queue;

public class BSTTest {
	public static void main(String[] args) {
		System.out.println("---------------BinarySearchTree---------");
		BinarySearchTree<String, Integer> tree = new BinarySearchTree<String, Integer>();
		String line = "DABECF";
		String[] keys = line.split("");
		System.out.print("输入的为：" + line);
		for (int i = 0; i < keys.length; i++) {
			tree.put(keys[i], i);
		}

		System.out.print("\n");
		System.out.print("中序遍历一：");
		for (String key : tree.keys()) {
			System.out.print(key + ":" + tree.get(key) + "   ");
		}
		System.out.print("\n");
		System.out.print("层次遍历一：");
		Queue<String> queue_1 = tree.leverTravel();
		for (String key : queue_1) {
			System.out.print(key + ":" + tree.get(key) + "   ");
		}

		// Test--one
		System.out.print("\n");
		System.out.println("------------delete-----Key:A------------");
		tree.delete("A");
		System.out.print("中序遍历二：");
		for (String key : tree.keys()) {
			System.out.print(key + ":" + tree.get(key) + "   ");
		}
		System.out.print("\n");
		System.out.print("层次遍历二：");
		Queue<String> queue_2 = tree.leverTravel();
		for (String key : queue_2) {
			System.out.print(key + ":" + tree.get(key) + "   ");
		}

		// Test--two
		System.out.print("\n");
		System.out.println("------------delete-----Put:(X,9)--------");
		tree.put("X", 9);
		System.out.print("中序遍历二：");
		for (String key : tree.keys()) {
			System.out.print(key + ":" + tree.get(key) + "   ");
		}
		System.out.print("\n");
		System.out.print("层次遍历二：");

		Queue<String> queue_3 = tree.leverTravel();
		for (String key : queue_3) {
			System.out.print(key + ":" + tree.get(key) + "   ");
		}

		// Test--three
		System.out.print("\n");
		System.out.println("------------update-----Put:(X,8)--------");
		tree.put("X", 8);
		System.out.print("中序遍历二：");
		for (String key : tree.keys()) {
			System.out.print(key + ":" + tree.get(key) + "   ");
		}
		System.out.print("\n");
		System.out.print("层次遍历二：");

		Queue<String> queue_4 = tree.leverTravel();
		for (String key : queue_4) {
			System.out.print(key + ":" + tree.get(key) + "   ");
		}

		// Test--five
		System.out.print("\n");
		System.out.println("------------get-------get:(B)-----------");
		System.out.print(tree.get("B"));

		// Test--six
		System.out.print("\n");
		System.out.println("------------get-------min()-------------");
		System.out.print(tree.min());
	}
}
