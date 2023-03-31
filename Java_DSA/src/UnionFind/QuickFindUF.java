package UnionFind;

/**
 * practice:
 * calls out an array
 * DC union elements are indicators (1 joins 7 for example)
 * values stored at the indexes to check if they are unionized or not. */

public class QuickFindUF {
    private int id[];

    /** The constructor touches all the objects.
     */
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /** Operation find_root() takes only a couple of steps
     *  return array value at index p.
     */
    public int root(int p) {
        return id[p];
    }

    /** Operation union() touches all the objects
     *  (at most 2N + 2 array accesses.
     */
    public void union(int p, int q) {
        /*
         *  traverse the array, replacing all values = id [p] with id [q].
         *  attention should take the values in the index q and p from the start
         *  otherwise it will be very easy to be confused because the re-value of p may be changed
         */
        int valueID_P = id[p];
        int valueID_Q = id[q];
        for (int i = 0; i < id.length; i++) {

            if (id[i] == valueID_P)
            {
                id[i] = valueID_Q;
            }
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}

