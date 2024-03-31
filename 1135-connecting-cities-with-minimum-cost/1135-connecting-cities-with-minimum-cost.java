class Solution {
    public int minimumCost(int n, int[][] connections) {
        int cost = 0;
        
        PriorityQueue<int[]> edges = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int[] conn : connections)
                edges.add(new int[]{conn[0],conn[1],conn[2]});
            
        
        int processed = 0;
        UnionFind uf = new UnionFind(n);
        while(!edges.isEmpty()){
            int[] edge = edges.poll();
            if(uf.union(edge[0], edge[1])){
                cost+=edge[2];
                processed++;
            }
        }
        return processed == n-1 ? cost : -1;
    }

    class UnionFind{
        int[] parent;
        int[] rank;

        public UnionFind(int n){
            parent = new int[n+1];
            rank = new int[n+1];
            for(int i = 0; i <=n; i++){
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public int find(int x){
            if(x!=parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y){
            int p1 = find(x);
            int p2 = find(y);

            if(p1 == p2) return false;

            if(rank[p1] > rank[p2]){
                parent[p2] = p1;
                rank[p1] = rank[p2] ;
            }
            else{
                parent[p1] = p2;
                rank[p2] = rank[p1] ;
            }
            return true;
        }
    }
}