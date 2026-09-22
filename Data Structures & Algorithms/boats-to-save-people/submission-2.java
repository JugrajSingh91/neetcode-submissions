class Solution {
    // Greedy appraoch, pack the heaviest and lowest
    // Using two pointers
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0; int r = people.length-1;
        int count = 0;
        while(l<r){
            // Case 1 both fit
            if (people[l] + people[r] <= limit) {
                count++;
                l++;
                r--;
            // Case 2 if both dont fit, then put the heavier on the boat
            } else {
                count++;
                r--;
            }
        }
        // when l == r that's one remaining so add 1 to count
        // if the last boat had two people then l>r and we dont need to add another boat
        return (l == r)? count+1: count;
    }
}