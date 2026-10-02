class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        // adj matrix to define the graph
        // find total sets using dsu

        // factor index will keep factor -> index of number we first saw the 
        // factor in. If we find this factor in another number, we join them 
        // in the dsu as they can traverse.
        Map<Integer, Integer> factorIndex = new HashMap<>();
        Dsu dsu = new Dsu(nums.length);
        for (int i = 0 ; i < nums.length; i++) {
            int temp = nums[i];

            for (int factor = 2; factor*factor <= temp; factor++) {

                // if temp is divisible by factor
                if (temp % factor == 0) {
                    // factor already seen in another number
                    if (factorIndex.containsKey(factor)) {
                        dsu.union(i, factorIndex.get(factor));
                    } else {
                        factorIndex.put(factor, i);
                    }
                }
                while(temp % factor == 0) temp /= factor;
            }
            if (temp > 1) {
                 if (factorIndex.containsKey(temp)) {
                    dsu.union(i, factorIndex.get(temp));
                } else {
                    factorIndex.put(temp, i);
                }
            }
        }

        // if total number of components is more than 1, return false;
        return (dsu.getComponents() > 1)? false : true;

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