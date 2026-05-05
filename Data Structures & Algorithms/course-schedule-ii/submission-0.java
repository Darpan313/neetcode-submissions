class Solution {
    Map<Integer, List<Integer>> adjList;
    List<Integer> res;
    Set<Integer> visiting = new HashSet<>();
    boolean[] visited;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adjList = new HashMap<>();
        visited = new boolean[numCourses];
        res = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int[] p : prerequisites){
            adjList.get(p[0]).add(p[1]);
        }

        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                if(dfs(i)){
                    return new int[]{};
                }
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    public boolean dfs(int i){
        if(visiting.contains(i)){
            return true;
        }

        if(visited[i]){
            return false;
        }
    
        if(adjList.get(i).isEmpty()){
            visited[i] = true;
            res.add(i);
            return false;
        }
        visited[i]=true;
        visiting.add(i);
        for(int n:adjList.get(i)){
            if(dfs(n)){
                return true;
            }
        }
        visiting.remove(i);
        res.add(i);
        return false;
    }
}
