import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        visited[entrance[0]][entrance[1]] = true; // Mark entrance as visited
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {entrance[0], entrance[1], 0}); // (row, col, distance)
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // right, left, down, up
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];
            
            // Check if current cell is an exit
            if ((row == 0 || row == rows - 1 || col == 0 || col == cols - 1) && (row != entrance[0] || col != entrance[1])) {
                return dist;
            }
            
            // Explore neighbors
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && maze[newRow][newCol] == '.' && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[] {newRow, newCol, dist + 1});
                }
            }
        }
        
        return -1; // No path to an exit
    }
}
