package jd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        int x = Integer.parseInt(params[2]); // 移动耗时
        int y = Integer.parseInt(params[3]); // 转向耗时
        int z = Integer.parseInt(params[4]); // 点击耗时
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
        String input = br.readLine();
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(board[i][j], new int[]{i, j});
            }
        }
        char[] toInput = input.toCharArray();
        char preChar = board[0][0];
        int[] prePos = {0, 0};
        long res = 0;
        for (char c : toInput) {
            if (c != preChar) {
                // 需要移动
                int[] newPos = map.get(c);
                if (newPos[0] == prePos[0] || newPos[1] == prePos[1]) {
                    // 不用转向
                    if (newPos[0] == prePos[0]) {
                        res += (long) x * Math.abs(newPos[1] - prePos[1]);
                    } else {
                        res += (long) x * Math.abs(newPos[0] - prePos[0]);
                    }
                } else {
                    // 需要转向
                    res += (long) x * Math.abs(newPos[0] - prePos[0]);
                    res += y;
                    res += (long) x * Math.abs(newPos[1] - prePos[1]);
                }
                preChar = c;
                prePos = map.get(c);
            }
            res += z;
        }
        System.out.println(res);
    }
}
