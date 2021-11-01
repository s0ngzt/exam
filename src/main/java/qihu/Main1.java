package qihu;

import java.util.Scanner;

public class Main1 {

    public static int getAns(int[] arr, int n) {
        int min = 1;
        for (int i = 1; i <= n; i++) {
            int l = i, r = i;
            while (arr[l] > arr[l - 1]) l--;
            while (arr[r] > arr[r + 1]) r++;
            int temp = r - l + 1;
            if (temp > min) min = temp;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        arr[0] = Integer.MAX_VALUE;
        arr[n + 1] = Integer.MAX_VALUE;
        System.out.println(getAns(arr, n));
    }
}
