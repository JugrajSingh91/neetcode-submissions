class Solution {
    List<List<Integer>> answer = new ArrayList<>();;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // to club duplicates together so that we can avoid creating duplicate lists
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, 0, new ArrayList<>());
        
        return answer;
    }

    void backtrack(int[] candidates, int target, int index, int sumSoFar, List<Integer> listSoFar) {
        if (sumSoFar == target) {
            answer.add(new ArrayList<>(listSoFar));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int currElement = candidates[i];
            
            // if adding currElement exceeds target, then elements after this will
            // exceed the target too since candidates is sorted
            if (sumSoFar + currElement > target) break;

            // candidates[i] == candidates[i-1] is okay if i == index
            // i.e, the duplicate candidates[i-1] was added by the previous stack frame
            // at a different depth in the recursion

            // candidates[i] == candidates[i-1] is NOT okay if i > index
            // i.e., we already explored the full branch with candidates[i-1]
            // and both candidates[i] and candidates[i-1] are at the same depth
            // i.e., imagine two separate branches being formed to find the list which
            // sums to target, and we dont want both lists to choose the same element 
            // for the same depth as that will lead to creating a duplicate list which
            // leads to the target sum 
            if (i > index && candidates[i] == candidates[i-1]) continue;
            
            // take the element and backtrack
            sumSoFar += currElement;
            listSoFar.add(currElement);
            backtrack(candidates, target, i+1, sumSoFar, listSoFar);
            sumSoFar -= currElement;
            listSoFar.remove(listSoFar.size()-1);
        }
    }
}
