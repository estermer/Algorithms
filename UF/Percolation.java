/**
 * Author: nitish
 * Date: 2/11/14 7:24 AM
 * Description:
 */

public class Percolation {
    private boolean[][] site;
    private WeightedQuickUnionUF uf;
    private int gridSize;
    private int[] xy;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        gridSize = N;
        site = new boolean[N][N];
        // virtual top node and bottom node plus all other elements
        xy = new int[(N * N) + 2];
        uf = new WeightedQuickUnionUF(xy.length);
    }

    private void checkBoundary(int i, int j) {
        if (i < 1 || i > gridSize || j < 1 || j > gridSize)
            throw new IndexOutOfBoundsException("row index out of bounds");
    }

    private int xyTo1D(int x, int y) {
        int index = (x - 1) * gridSize + y;
        return index;
    }

    private void unionNeighbours(int i, int j) {
        int mid = xyTo1D(i, j);
        int top = xyTo1D(i - 1, j);
        int bottom = xyTo1D(i + 1, j);
        int left = xyTo1D(i, j - 1);
        int right = xyTo1D(i, j + 1);

        if (i != 1 && blockStatus(i - 1, j))
            uf.union(mid, top);
        if (i != gridSize && blockStatus(i + 1, j))
            uf.union(mid, bottom);
        if (j != 1 && blockStatus(i, j - 1))
            uf.union(mid, left);
        if (j != gridSize && blockStatus(i, j + 1))
            uf.union(mid, right);
        if (i == 1)
            uf.union(mid, 0);
    }

    private boolean blockStatus(int i, int j) {
        return site[i - 1][j - 1];
    }

    private void connectLastRow(int i, int j) {
        if (isFull(i, j)) {
            for (int k = 1; k <= gridSize; k++) {
                if (blockStatus(gridSize, k) && isFull(gridSize, k)) {
                    int virtualNNode = xy.length - 1;
                    int lastRowNode = xyTo1D(gridSize, k);
                    uf.union(lastRowNode, virtualNNode);
                }
            }
        }
    }

    private boolean isConnectedToTop(int i, int j) {
        int current = xyTo1D(i, j);
        return uf.connected(0, current);
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        checkBoundary(i, j);
        if (!isOpen(i, j)) {
            site[i - 1][j - 1] = true;
            // Union with top down right left
            unionNeighbours(i, j);
            //Check last row and connect to Nth virtual node
            connectLastRow(i, j);
        }
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        checkBoundary(i, j);
        return site[i - 1][j - 1];
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        checkBoundary(i, j);
        return isOpen(i, j) && isConnectedToTop(i, j);
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(0, xy.length - 1);
    }
}