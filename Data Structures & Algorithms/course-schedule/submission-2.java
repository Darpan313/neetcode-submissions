class Solution {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private boolean[] visited;
    private Set<Integer> visiting = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0; i<numCourses; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int[] preReq:prerequisites){
            adjList.get(preReq[0]).add(preReq[1]);
        }

        visited = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!visited[i] && isCyclic(i)){
                return false;
            }
        }
        return true;
    }

    public boolean isCyclic(int i){
        if(visiting.contains(i)){
            return true;
        }
        if(adjList.get(i).isEmpty()){
            return false;
        }
        visiting.add(i);
        visited[i]=true;
        for(int neighbor:adjList.get(i)){
            if(isCyclic(neighbor)){
                return true;
            }
        }
        visiting.remove(i);
        return false;
    }
}
