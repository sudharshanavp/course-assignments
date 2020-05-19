import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[] grid;
    private final int top;
    private final int bottom;
    private final int size;
    private int count = 0;
    private final WeightedQuickUnionUF unionFind;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n)
    {
        if (n <= 0)
            throw new IllegalArgumentException();

        size = n;
        top = size * size;
        bottom = size * size + 1;
        unionFind = new WeightedQuickUnionUF(size * size + 2);
        grid = new boolean[size * size];
    }

    /* 
     * Dimensional Reduction Function
     * Convert 2 dimensional indices to one dimensional indices.
     */
    private int xyToi(int i, int j) {
        return (((i - 1) * size) + j - 1);

    }

    /* 
     * Update Function
     * Function to update the boolean array to keep track of what sites are opened and
     * increment the count varaible to keep track of the number of open sites in the matrix
     */
    private void update(int row, int col) {
        grid[xyToi(row, col)] = true;
        count++;
    }

    /*
     * Validate function
     * To check whether the given indices are out of bounds or not.
     */
    private void isValid(int row, int col) {
        if (row < 1 || row > size || col < 1 || col > size)
            throw new IllegalArgumentException();
    }

    /*
     * Connected function
     * To check whether two nodes are connected or not
     */

    private boolean isConnected(int p, int q)
    {
        return unionFind.find(p) == unionFind.find(q);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        isValid(row, col);

        if (isOpen(row, col))
            return;

        int index = xyToi(row, col);

        update(row, col);

        if (row == 1) {
            unionFind.union(index, top);
        }

        if (row == size) {
            unionFind.union(index, bottom);
        }

        if (row < size && isOpen(row + 1, col)) {
            unionFind.union(index, xyToi(row + 1, col));
        }

        if (col < size && isOpen(row, col + 1)) {
            unionFind.union(index, xyToi(row, col + 1));
        }

        if (row > 1 && isOpen(row - 1, col)) {
            unionFind.union(index, xyToi(row - 1, col));
        }

        if (col > 1 && isOpen(row, col - 1)) {
            unionFind.union(index, xyToi(row, col - 1));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        isValid(row, col);
        return (grid[xyToi(row, col)]);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        isValid(row, col);
        return isConnected(xyToi(row, col), top);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        return isConnected(top, bottom);
    }

    public static void main(String[] args) {
        // Automatically generated Stub
    }

}
