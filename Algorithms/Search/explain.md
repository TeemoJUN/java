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
