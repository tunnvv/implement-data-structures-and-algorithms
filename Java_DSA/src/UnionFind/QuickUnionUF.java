package UnionFind;

public class QuickUnionUF {
    private int id[];

    /** The constructor touches all the objects.
     */
    public QuickUnionUF(int N) {
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /** Operation find_root() might touches all objects.
     */
    public int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    /** Operation union() might touches all objects.
     */
    public void union(int p, int q) {
        /* Assigns the root node ID value of p equal to the root node ID value of q.
         */
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}

