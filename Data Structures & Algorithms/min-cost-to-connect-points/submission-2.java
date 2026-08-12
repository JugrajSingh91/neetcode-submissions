class Solution {
    //DSU DisJoint Set Union
    class DSU {
        int[] parent, size;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];

            // Each node is their own parent
            for (int i = 0; i < n; i++) parent[i] = i;

            // Size of each node is 1
            // Size here is the height of the tree, 
            Arrays.fill(size, 1);
        }

        //returns the parent of node and does compression
        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            // if both vertices have the the same parent, adding the edge will create a cycle spo we skip it
            if (pu == pv) return false;

            if (size[pu] > size[pv]) {
                parent[pv] = pu; // pu is bigger so u becomes parent of v
            } else if (size[pu] < size[pv]) {
                parent[pu] = pv; // pv is bigger so v becomes parent of u
            } else {
                parent[pu] = pv; // pu and pv are equal size, so randomly pick v as parent of u
                size[pv] += size[pu]; // And increase the size of v as sum of both
            }
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);

        List<int[]> edges = new ArrayList<>(); //{u, v, weight}
        // We need to find edges between all points
        // So we need two for loops
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int[] u = points[i]; // vertice U
                int[] v = points[j]; // vertice V
                edges.add(new int[]{i,j,manhattanDist(u,v)});
            }
        }

        // sort all the edges by weight
        edges.sort((a,b) -> Integer.compare(a[2], b[2]));

        int cost = 0;

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            // for each edge, try to union it
            if (dsu.union(u,v)) cost += weight;
        }
        return cost;
    }

    int manhattanDist(int[] u, int[] v) {
        return Math.abs(u[0] - v[0]) + Math.abs(u[1] - v[1]);
    }
}
