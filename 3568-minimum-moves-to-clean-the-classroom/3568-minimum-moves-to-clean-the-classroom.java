import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startRow = 0;
        int startCol = 0;

        List<int[]> litters = new ArrayList<>();

        // Find starting position and all litter positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (ch == 'L') {
                    litters.add(new int[]{i, j});
                }
            }
        }

        int litterCount = litters.size();

        // If there is no litter
        if (litterCount == 0) {
            return 0;
        }

        // Give each litter cell an index
        int[][] litterId = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);
        }

        for (int i = 0; i < litterCount; i++) {
            int r = litters.get(i)[0];
            int c = litters.get(i)[1];

            litterId[r][c] = i;
        }

        // Mask when all litter is collected
        int allCollected = (1 << litterCount) - 1;

        /*
         * State:
         * row
         * column
         * remaining energy
         * collected litter mask
         */
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{
            startRow,
            startCol,
            energy,
            0
        });

        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << litterCount];

        visited[startRow][startCol][energy][0] = true;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int moves = 0;

        // BFS
        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];
                int remainingEnergy = current[2];
                int mask = current[3];

                // All litter collected
                if (mask == allCollected) {
                    return moves;
                }

                // Try 4 directions
                for (int[] direction : directions) {

                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    // Check boundaries
                    if (newRow < 0 || newRow >= m ||
                        newCol < 0 || newCol >= n) {
                        continue;
                    }

                    // Cannot move through obstacle
                    if (classroom[newRow].charAt(newCol) == 'X') {
                        continue;
                    }

                    // Need energy to make a move
                    if (remainingEnergy == 0) {
                        continue;
                    }

                    // Moving costs 1 energy
                    int newEnergy = remainingEnergy - 1;

                    // Keep same collected litter
                    int newMask = mask;

                    // If we reach litter, collect it
                    if (litterId[newRow][newCol] != -1) {
                        int id = litterId[newRow][newCol];
                        newMask = newMask | (1 << id);
                    }

                    // If we reach reset area, restore energy
                    if (classroom[newRow].charAt(newCol) == 'R') {
                        newEnergy = energy;
                    }

                    // Add new state if not visited
                    if (!visited[newRow][newCol][newEnergy][newMask]) {

                        visited[newRow][newCol][newEnergy][newMask] = true;

                        queue.offer(new int[]{
                            newRow,
                            newCol,
                            newEnergy,
                            newMask
                        });
                    }
                }
            }

            moves++;
        }

        // Impossible to collect all litter
        return -1;
    }
}