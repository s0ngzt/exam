package h3c;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        int i = 1;
        while (i < s.length()) {
            if (s.length() % i == 0) {
                String temp = s.substring(0, i);
                int j = i, k = j + i;
                while (k <= s.length()) {
                    if (!s.substring(j, k).equals(temp)) {
                        break;
                    }
                    //每次加i位
                    j += i;
                    k += i;
                }
                if (k > s.length()) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int r = 0;
        while (x > r) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        return x == r || x == r / 10;
    }
}
