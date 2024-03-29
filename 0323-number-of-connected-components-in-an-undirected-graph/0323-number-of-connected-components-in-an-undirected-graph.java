class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i<n;i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int [] edge : edges){
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(visited[i]==false){
                count++;
                dfs(graph, visited, i);
            }
        }
        return count;
    }


    public void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int current){
        
        if(!visited[current]){
            visited[current] = true;

            for(int next : graph.get(current)){
                dfs(graph, visited, next);
                
            }
            
        }
    }
}