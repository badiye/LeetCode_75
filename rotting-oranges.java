import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize queue with rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // right, left, down, up
        int time = 0;
        
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                
                // Explore neighbors
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Mark as rotten
                        queue.offer(new int[] {newRow, newCol});
                        freshCount--;
                    }
                }
            }
            
            time++;
        }
        
        return freshCount == 0 ? time : -1;
    }
}
