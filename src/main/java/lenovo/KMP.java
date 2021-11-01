package lenovo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMP {

    public static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int kmp(String haystack, String pattern, List<Integer> pos) {
        int[] next = getNext(pattern);
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            pos.add(j);
            if (haystack.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i - j + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pattern = br.readLine();
        String haystack = br.readLine();
        int[] lsp = getNext(pattern);
        System.out.println(Arrays.toString(lsp));
        List<Integer> positions = new ArrayList<>();
        int res = kmp(haystack, pattern, positions);
        for (int position : positions) {
            System.out.println(position);
        }
        if (res == -1) {
            System.out.println("Not found");
        } else {
            System.out.printf("Found at: %d\n", res);
        }
    }
}
