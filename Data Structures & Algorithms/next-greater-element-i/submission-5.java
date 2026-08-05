class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> stack = new Stack<>();

        int[] nums2GreaterElements = new int[nums2.length];
        Arrays.fill(nums2GreaterElements, -1);

        Map<Integer, Integer> indexFinder = new HashMap<>();

        for (int j = 0; j < nums2.length; j++) {
            indexFinder.put(nums2[j], j);
            while (!stack.empty() && nums2[j] > nums2[stack.peek()]) {
                int indexWhichFoundNextGreaterElement = stack.pop();
                nums2GreaterElements[indexWhichFoundNextGreaterElement] = nums2[j];
            }
            stack.push(j);
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = nums2GreaterElements[indexFinder.get(nums1[i])];
        }

        return result;
    }
}