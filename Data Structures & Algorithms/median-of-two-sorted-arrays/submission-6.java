class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] merged = new int[len];
        int n1 = 0;
        int n2 = 0;
        int i = 0;
        while(n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1] < nums2[n2]) {
                merged[i] = nums1[n1];
                n1++;
            } else {
                merged[i] = nums2[n2];
                n2++;
            }
            i++;
        }

        while (n1 < nums1.length) {
            merged[i] = nums1[n1];
            n1++;
            i++;
        }
        while (n2 < nums2.length) {
            merged[i] = nums2[n2];
            n2++;
            i++;
        }

        
        if (merged.length % 2 == 0) return (double) (merged[(len-1)/2] + merged[(len-1)/2+1] )/2;
        return merged[(len-1)/2];
    }
}
