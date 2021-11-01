package me.algo.nowcoder.netease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static int getLength(char c1, char c2) {
        int len1 = Math.abs(c1 - c2);
        int len2 = Math.abs(26 + c1 - c2);
        int len3 = Math.abs(26 + c2 - c1);
        return Math.min(Math.min(len1, len2), len3);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        String s = params[0];
        int m = Integer.parseInt(params[1]);
        int n = s.length();
        long[] dp = new long[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + getLength(s.charAt(i), s.charAt(i - 1));
        }
        long value = dp[n - 1];
        long diff = 0;
        for (int i = m; i < n; i++) {
            if (dp[i] - dp[i - m] > m) {
                diff = Math.max(dp[i] - dp[i - m] - m, diff);
            }
        }
        System.out.println(value - diff + n);
    }
}
