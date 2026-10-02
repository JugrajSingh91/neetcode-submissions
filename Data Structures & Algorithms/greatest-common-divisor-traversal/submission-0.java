class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        // adj matrix to define the graph
        // find total sets using dsu

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < nums.length; i++) adjList.put(i, new ArrayList<>());
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(gcd(nums[i], nums[j]) > 1) {
                    List<Integer> iNeighbors = adjList.get(i);
                    List<Integer> jNeighbors = adjList.get(j);
                    iNeighbors.add(j);
                    jNeighbors.add(i);
                }
            }
        }
        Dsu dsu = new Dsu(nums.length);
        for (int u = 0; u < nums.length; u++) {
            for (int v: adjList.get(u)) {
                if (u < v) {
                    dsu.union(u,v);
                }
            }
        }

        // if total number of components is more than 1, return false;
        return (dsu.getComponents() > 1)? false : true;

    }

    int gcd(int a, int b) {
        if (b == 0) return Math.abs(a);
        return gcd(b, a%b);
    }

    class Dsu {
        int[] parent, size;
        int components;

        public Dsu(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            Arrays.fill(size, 1);
            components = n;
        }

        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        public boolean union (int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu == pv) return false;
            if (size[pu] > size[pv]) {
                parent[pv] = pu;
            } else if (size[pv] > size[pu]) {
                parent[pu] = pv;
            } else {
                parent[pu] = pv;
                size[pu] += 1;
            }
            components--;
            return true;
        }

        public int getComponents() {
            return components;
        }
    }
}