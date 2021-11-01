package ctrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] ss = s.split(" "); // n & m
        int len = Integer.parseInt(ss[0]);
        int numRules = Integer.parseInt(ss[1]);
        char[] nums = br.readLine().toCharArray();
        int[][] wvs = new int[len + 1][2];
        for (int i = 0; i < numRules; i++) {
            String[] wv = br.readLine().split(" ");
            wvs[i][0] = Integer.parseInt(wv[0]);
            wvs[i][1] = Integer.parseInt(wv[1]);
        }
        List<Integer> times = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int W = 0;
            while (i < len && nums[i] == 1) {
                W++;
                i++;
            }
            times.add(W);
            i--;
        }
        int res = 0;
        for (Integer t : times) {
            res += maxScore(t, wvs);
        }
        System.out.println(res);
    }

    private static int maxScore(Integer t, int[][] wvs) {
        int N = wvs.length;
        int[] dp = new int[t + 1];
        for (int[] wv : wvs) {
            for (int j = 0; j <= t; j++) {
                if (j >= wv[0]) {
                    dp[j] = Math.max(dp[j - wv[0]] + wv[1], dp[j]);
                }
            }
        }
        return dp[t];
    }
}
