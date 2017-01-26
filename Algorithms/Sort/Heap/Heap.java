package heap;

import sort_util.Util;

public class Heap {

    private Heap() { }
    public static void sort(Integer[] pq) {
        int n = pq.length;
        for (int k = n/2; k >= 1; k--)
            sink(pq, k, n);
        while (n > 1) {
           exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

    private static void sink(Integer[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

   
    private static boolean less(Integer[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Integer[] pq, int i, int j) {
        Integer swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    // is v < w ?
    private static boolean less(Integer v, Integer w) {
        return v.compareTo(w) < 0;
    }


    public static void main(String[] args) {
        Integer[] a = Util.array(20);
        Util.show(a);
        Heap.sort(a);
        Util.show(a);
    }
}