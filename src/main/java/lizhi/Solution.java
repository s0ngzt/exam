package lizhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < left) {
                res.add(new int[]{left, right});
            } else {
                int[] tail = res.get(res.size() - 1);
                tail[1] = Math.max(tail[1], right);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
