package pdd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// AC 20%
public class Main4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] params = br.readLine().split(" ");
            int N = Integer.parseInt(params[0]); // N 步操作
            int M = Integer.parseInt(params[1]); // M 个棋子
            int X = Integer.parseInt(params[2]);
            int Y = Integer.parseInt(params[3]);
            int[] ops = new int[N];

            String[] operations = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                ops[j] = Integer.parseInt(operations[j]);
            }
            int[][] positions = new int[M][2];
            for (int j = 0; j < M; j++) {
                String[] position = br.readLine().split(" ");
                positions[j][0] = Integer.parseInt(position[0]); // x
                positions[j][1] = Integer.parseInt(position[1]); // y
            }

            for (int p = 0; p < N; p++) {
                for (int q = 0; q < M; q++) {
                    switch (ops[p]) {
                        case 1: {
                            // up
                            if (positions[q][0] > 1) {
                                positions[q][0] -= 1;
                            }
                        }
                        break;
                        case 2: {
                            // lt
                            if (positions[q][1] > 1) {
                                positions[q][1] -= 1;
                            }
                        }
                        break;
                        case 3: {
                            // dn
                            if (positions[q][0] < Y) {
                                positions[q][0] += 1;
                            }
                        }
                        break;
                        case 4: {
                            // rt
                            if (positions[q][1] < X) {
                                positions[q][1] += 1;
                            }
                        }
                    }
                }
            }
            for (int j = 0; j < M; j++) {
                System.out.println(positions[j][0] + " " + positions[j][1]);
            }
        }
    }
}
