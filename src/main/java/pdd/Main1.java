package pdd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    public static int binarySearch(int[] arr, int target) {
        int n = arr.length;
        int l = 0, r = n - 1, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (target > arr[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        int m = Integer.parseInt(br.readLine());
        String[] queries = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int query = Integer.parseInt(queries[i]);
            System.out.println(binarySearch(prefixSum, query));
        }
    }
}
