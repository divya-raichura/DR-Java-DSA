package com.company.UnionFind;
// questions at end of file
public class WeightedQuickUnion {
    // extra array to store count of number of objects in the tree rooted at i

    private final int[] id;
    private final int[] size;


    public WeightedQuickUnion(int n) {
        this.id = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // 2nd improvement -> make the element to point to grandfather instead of the father
            // with this one line we can keep tree completely flat
            i = id[i];
        };
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // modify union to link root of smaller tree to that of larger
    // update size array
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        int pSize = size[pRoot];
        int qSize = size[qRoot];

        if (pSize < qSize) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }

}

/*
 * Question 2
 * Union-find with specific canonical element. Add a method find() to the union-find data type so that find(i) returns the
 * largest element in the connected component containing i. The operations, union(), connected(), and find() should all
 * take logarithmic time or better.
 *
 * Hint: maintain an extra array to the weighted quick-union data structure that stores for each root i the large
 * element in the connected component containing i.
 */

/*
 * Given a set of nn integers S={0,1,...,n−1} and a sequence of requests of the following form:
 * Remove x from S
 * Find the successor of x: the smallest y in S such that y ≥ x.
 * design a data type so that all operations (except construction)  take logarithmic time or better in the worst case.
 *
 * Hint: use the modification of the union−find data discussed in the previous question.
 */