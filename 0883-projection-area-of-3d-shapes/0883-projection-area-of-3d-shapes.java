class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xy = 0, yz = 0, zx = 0;

        for (int i = 0; i < n; i++) {
            int rowMax = 0;
            int colMax = 0;

            for (int j = 0; j < n; j++) {
                // XY projection (top view)
                if (grid[i][j] > 0) {
                    xy++;
                }

                // YZ projection (front view)
                rowMax = Math.max(rowMax, grid[i][j]);

                // ZX projection (side view)
                colMax = Math.max(colMax, grid[j][i]);
            }

            yz += rowMax;
            zx += colMax;
        }

        return xy + yz + zx;
    }
}