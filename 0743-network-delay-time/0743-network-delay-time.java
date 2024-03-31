class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        
        for(int[] time: times){
            adj.computeIfAbsent(time[0], key-> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        int time = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k, 0});

        HashSet<Integer> visited= new HashSet<>();
        
        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            
            int u = edge[0];
            int cost = edge[1];
         
            if(visited.contains(u)) continue;
            
            visited.add(u);
            time = Math.max(time, cost);
            
            if(!adj.containsKey(u)){
                continue;
            }
            
            for(int[] neighbour : adj.get(u)){
                
                int v = neighbour[0];          
                int wt = neighbour[1];
                pq.offer(new int[]{v, cost + wt});
            }
        }
        return visited.size() == n ? time : -1;
    }
}