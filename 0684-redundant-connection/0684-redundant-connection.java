class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for(int[] edge: edges){
            if(!uf.union(edge[0], edge[1])){
                return edge;
            }
        }
        return null;
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
                rank[p1] = rank[p2] + 1;
            }
            else{
                parent[p1] = p2;
                rank[p2] = rank[p1] + 1;
            }
            return true;
        }
    }
}