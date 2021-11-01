package jxjk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int getAnswer(Map<Character, int[]> map, char[][] board, String input) {
        int[] prePos = {0, 0};
        char preChar = board[0][0];
        int ans = 0;
        for (char c : input.toCharArray()) {
            if (c != preChar) {
                int[] newPos = map.get(c);
                // System.out.println(newPos.length);
                ans += Math.abs(newPos[0] - prePos[0]);
                ans += Math.abs(newPos[1] - prePos[1]);
                preChar = c;
                prePos = newPos;
            }
            ans += 1; // press
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        char[][] board = new char[n][m];
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine().toLowerCase();
            board[i] = line.toCharArray();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (c != '_') {
                    map.put(c, new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < T; i++) {
            String test = br.readLine().toLowerCase();
            System.out.println(getAnswer(map, board, test));
        }
    }
}
