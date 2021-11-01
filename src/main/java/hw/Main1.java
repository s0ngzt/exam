package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    private static int[] calc(int[] pre, int[] cap) {
        int send1 = Math.min(pre[0], cap[0]);
        int send2 = Math.min(Math.min(cap[0], pre[1] + cap[1]), pre[0] + pre[1] - send1);
        return new int[]{send1, send2};
    }

    public static int compute(int n, int[][] cap, int initialPackets) {
        if (n < 1) return initialPackets;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = initialPackets;
        dp[1] = calc(dp[0], cap[0]);
        for (int i = 2; i <= n; i++) {
            int[] res1 = calc(dp[i - 1], cap[i - 1]);
            int[] res2 = calc(dp[i - 2], cap[i - 1]);
            dp[i] = res1[0] + res1[1] <= res2[0] + res2[1] ? res1 : res2;

        }
        return Math.min(dp[n][0] + dp[n][1], dp[n - 1][0] + dp[n - 1][1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] nodesInfo = br.readLine().split(" +");
        int initialPackets = Integer.parseInt(br.readLine());
        int[][] nodes = new int[k][2];
        for (int i = 0; i < k; i++) {
            String[] nodeInfo = nodesInfo[i].split(",");
            nodes[i][0] = Integer.parseInt(nodeInfo[0]);
            nodes[i][1] = Integer.parseInt(nodeInfo[1]);
        }
        System.out.println(compute(k, nodes, initialPackets));
    }
}
