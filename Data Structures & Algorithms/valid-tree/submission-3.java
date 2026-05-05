class Solution {
    public boolean validTree(int n, int[][] edges) {
        // 1. Graph Theory Check
        // A tree with n nodes MUST have exactly n-1 edges.
        if (edges.length != n - 1) {
            return false;
        }

        // Build Adjacency List
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        // 2. Connectivity Check (Simple BFS or DFS)
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        visited.add(0);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjList.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        // 3. If we visited all nodes, it's a valid tree
        return visited.size() == n;
    }
}