class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int cost = 0;
        
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i<n;i++){
            for(int j=i+1;j<n;j++){
               int wt = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i,j,wt});
            }
        }
        
        Collections.sort(edges, (a,b)->a[2]-b[2]);
        int processed = 0;
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            if(processed < n && uf.union(edge[0], edge[1])){
                cost+=edge[2];
                processed++;
            }
        }
        return cost;
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