class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n: nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        Integer[] boxed = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boxed[i] = nums[i];
        }

        Arrays.sort(boxed, (a,b) -> {
            int freqA = freq.get(a);
            int freqB = freq.get(b);
            if ( freqA != freqB) {
                return Integer.compare(freqA, freqB);
            } else {
                return Integer.compare(b, a);
            }
        });

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) res[i] = boxed[i];
        return res;
    }
}