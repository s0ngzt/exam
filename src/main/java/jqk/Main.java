package jqk;

import java.util.Arrays;

public class Main {

    public static int[] merge(int[] a, int[] b) {
        int len1 = a.length, len2 = b.length;
        int len = len1 + len2;
        int[] res = new int[len];
        int c1 = len1 - 1, c2 = len2 - 1, c = len - 1;
        while (c >= 0) {
            if (c1 == -1) {
                res[c] = b[c2--];
            } else if (c2 == -1) {
                res[c] = a[c1--];
            } else if (a[c1] <= b[c2]) {
                res[c] = b[c2--];
            } else if (a[c1] > b[c2]) {
                res[c] = a[c1--];
            }
            c--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int[] b = {2, 4};
        System.out.println(Arrays.toString(merge(a, b)));
    }
}
