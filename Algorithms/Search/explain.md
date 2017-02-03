# explain

## BinarySearchST

```java
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
```

 - rank()是二分查找的典型方法，非递归
 - 返回的是小于它的键的数量，即key要插入的地方


该方法的put（）即向symbol table中插入元素很慢.


##BinarySearchTree


```java
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
```
+	重点讲解找到了节点时，看该节点的左子树是否为空，空则将右子return 即将其与x父节点连接。x.right==null亦如此
+	如果不为空，则保存Node t=x;
+	在t的右子树中寻找最小的节点，取出它。
+	替换原来的x并返回现在的x

**二叉树的优点在因为在用数组存贮键--值对时插入键--值时要挪动数组，这样消耗巨大时间，而二叉树不用移动**

***在子树与根节点之间是单链连接的，所以查询的时候要返回x***
