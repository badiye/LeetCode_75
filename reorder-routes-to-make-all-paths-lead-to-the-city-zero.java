class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];
            graph.get(a).add(new int[] {b, 1});
            graph.get(b).add(new int[] {a, 0});
        }
        
        boolean[] visited = new boolean[n];
        int[] result = new int[1];
        
        dfs(graph, 0, visited, result);
        
        return result[0];
    }
    
    private void dfs(List<List<int[]>> graph, int node, boolean[] visited, int[] result) {
        visited[node] = true;
        
        for (int[] neighbor : graph.get(node)) {
            if (!visited[neighbor[0]]) {
                if (neighbor[1] == 1) {
                    result[0]++;
                }
                dfs(graph, neighbor[0], visited, result);
            }
        }
    }
}
