package UnionFind;

/**
 * can practice this class's algorithms at:
 * "https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem"
 */

public class WeightedQuickUnionUF {
    private int id[];
    private int sz[];

    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    // find root
    public int root(int i) {
        while (i != id[i]) {

            id[i] = id[id[i]]; // Path compression, it helps flatting the structure
            i = id[i]; // original find func
        }
        return i;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
