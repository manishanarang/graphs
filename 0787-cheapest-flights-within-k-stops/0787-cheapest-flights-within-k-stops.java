class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        
        for(int[] flight: flights){
            adj.computeIfAbsent(flight[0], key-> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{src, 0, 0});
        
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            
            int u = edge[0];
            int cost = edge[1];
            int steps = edge[2];
             
            if (steps > stops[u] || steps > k + 1)
                continue;
            stops[u] = steps;
            
            if(u == dst){
                return cost;
            }
            if(!adj.containsKey(u)){
                continue;
            }
            
            for(int[] neighbour : adj.get(u)){
                int v = neighbour[0];
                int wt = neighbour[1];
                pq.offer(new int[]{v, cost + wt, steps+1});
            }
        }
        return -1;
    }
}