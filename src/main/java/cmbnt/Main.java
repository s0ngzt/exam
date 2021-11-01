package cmbnt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int getAns(int price, int[] amounts) {
        int[][] coins = new int[2][7];
        coins[0] = new int[]{1, 2, 5, 10, 20, 50, 100};
        coins[1] = amounts;
        int curIndex = 6;
        int res = 0;
        while (curIndex >= 0) {
            if (coins[1][curIndex] == 0 || price < coins[0][curIndex]) {
                curIndex--;
                continue;
            }
            int need = price / coins[0][curIndex];
            int temp = Math.min(need, coins[1][curIndex]);
            price -= coins[0][curIndex] * temp;
            res += temp;
            if (price == 0) {
                return res;
            }
            curIndex--;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        String[] amounts = br.readLine().split(" ");
        int[] amountArr = new int[7];
        for (int i = 0; i < 7; i++) {
            amountArr[i] = Integer.parseInt(amounts[i]);
        }
        System.out.println(getAns(price, amountArr));
    }
}
