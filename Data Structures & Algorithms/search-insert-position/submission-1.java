class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        //[ 0 1 2 3 4] i come to middle and either find it or get an 
        // answer that mid is greater than or less than my target
        // now it gets tricky when my target doesn't exist.
        // if i want my answer to be the position where target would insert
        // then i need to find the position just greater than target
        // so if my target is x, and x is not present in array
        // but there is x-2, a d x+3 present, i need to return position of x+3
        // what does that tell me about how to move around in the array?
        // if i move like r = mid-1, or r = mid+1 without including mid in the search space
        // i risk ignoring the answer when mid is not target but the element which is just greater then target
        // i need to avoid that
        // so if target is less than mid, could mid still be the answer? yes
        // so i move r = mid (keep the mid)
        // in case of [3 5 7 8 9] if i am looking for 6
        // i keep [3 5 7] and l = 0, r  = 7 m = 5 again
        // now target is > mid so i get rid of mid l = 7 r = 7 out, return 7i.e. l



        // if target is greater than mid, could mid still be the answer, no

        // in [3 5 7 9 10] if I am looking for 8
        // mid is 7 8 > 7 so 7 will not be answer, i get rid of 7
        // [9,10] becomes new array l =9 r = 10 mid = l(9)
        // now target < mid so we keep mid r = mid  = l 9 
        while(l < r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}