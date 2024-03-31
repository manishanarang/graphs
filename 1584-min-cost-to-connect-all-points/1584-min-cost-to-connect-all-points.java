class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int cost = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, List<List<Integer>>> adj = new HashMap<>();

        
        
        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                adj.put(i, new ArrayList<>());
                adj.put(j, new ArrayList<>());
            }
        }
        for(int i = 0; i <n; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];

            for(int j = i+1; j <n; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);

                adj.computeIfAbsent(i, 
                k -> new ArrayList<>()).add(List.of(dist, j));
                adj.computeIfAbsent(j, 
                k -> new ArrayList<>()).add(List.of(dist, i));
            }
        }

        minHeap.add(new int[]{0,0});
        
        while(visited.size()!=n){
            int[] costAndVertex = minHeap.poll();
            int vertex = costAndVertex[1];

            if(!visited.contains(vertex)){
                cost+=costAndVertex[0];
                visited.add(vertex);

                for(List<Integer> neighbour: adj.get(vertex)){
                    if(!visited.contains(neighbour.get(1))){
                        minHeap.add(new int[]{
                        neighbour.get(0),
                        neighbour.get(1)});
                    }
                }
            }
        }

        return cost;
    }
}