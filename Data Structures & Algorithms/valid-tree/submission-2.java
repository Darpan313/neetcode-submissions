class Solution {
    Map<Integer, List<Integer>> adjList;
    Set<Integer> visited;
    public boolean validTree(int n, int[][] edges) {
        adjList = new HashMap<>();

        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int[] e: edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        visited = new HashSet<>();
        
        if(dfs(0,-1)){
            return false;
        }
        return visited.size()==n;
    }

    public boolean dfs(int node, int parent){
        visited.add(node);
        for(int n:adjList.get(node)){
            if(!visited.contains(n)){
                if(dfs(n,node)){
                    return true;
                }
            }
            else if(n!=parent){
                return true;
            }
        }
        return false;
    }
}
