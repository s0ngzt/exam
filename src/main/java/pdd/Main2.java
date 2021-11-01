package pdd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main2 {

    static Map<Integer, Integer> colorMap;

    static long ans;

    public static void dfs(int[][] map, boolean[] seen, int curI, int curJ) {
        int n = map.length;
        int m = map[0].length;
        if (curI >= n || curJ >= m) return;
        int color = map[curI][curJ];
        if (seen[colorMap.get(color)]) {
            return;
        }
        if (curI == n - 1 && curJ == m - 1) {
            ans += 1;
            return;
        }
        seen[colorMap.get(color)] = true;
        dfs(map, seen, curI + 1, curJ);
        dfs(map, seen, curI, curJ + 1);
        seen[colorMap.get(color)] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] params = br.readLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int m = Integer.parseInt(params[1]);
            int k = Integer.parseInt(params[2]); // k 种颜色
            int[][] map = new int[n][m];
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                String[] line = br.readLine().split(" ");
                for (int c = 0; c < m; c++) {
                    int color = Integer.parseInt(line[c]);
                    hashSet.add(color);
                    map[j][c] = color;
                }
            }
            int index = 0;
            colorMap = new HashMap<>();
            for (int color : hashSet) {
                colorMap.put(color, index++);
            }
            ans = 0;
            boolean[] visited = new boolean[k];
            dfs(map, visited, 0, 0);
            System.out.println(ans);
        }
    }
}
