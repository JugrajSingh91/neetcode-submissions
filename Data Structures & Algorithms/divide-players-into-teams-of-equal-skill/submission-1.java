class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int l = 1, r = n-2;
        long chemistry = (long) (skill[0] * skill[n-1]);
        int skillSum = skill[0] + skill[n-1];
        while (l < r) {
            if (skill[l] + skill[r] != skillSum) return -1;
            chemistry += skill[l] * skill[r];
            l++; 
            r--;
        }
        return chemistry;
    }
}
