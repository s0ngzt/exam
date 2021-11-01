package ly;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static ArrayList<Integer> selected_car(ArrayList<ArrayList<Integer>> pre_selected_cars) {
        // write code here
        int n = pre_selected_cars.size();
        Set<Integer> set = new HashSet<>();
        int[] mark = new int[n];
        int count = n;
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        int[] ans = new int[n];
        ArrayList<Integer> res = new ArrayList<>(n);
        if (n == 0) return res;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (mark[i] != -1) {
                    int need = pre_selected_cars.get(i).get(mark[i]);
                    if (set.contains(need)) {
                        mark[i] = -1;
                        set.remove(need);
                        ans[i] = need;
                        count--;
                    } else {
                        mark[i]++;
                        if (mark[i] == pre_selected_cars.get(i).size()) {
                            mark[i] = -1;
                        }
                    }
                }
            }
            if (count == 0) break;
        }
        for (int i = 0; i < n; i++) {
            res.add(ans[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> in = new ArrayList<ArrayList<Integer>>() {
            {
                add(new ArrayList<Integer>() {{
                    add(1);
                    add(2);
                    add(3);
                }});
                add(new ArrayList<Integer>() {{
                    add(3);
                    add(4);
                    add(5);
                }});
                add(new ArrayList<Integer>() {{
                    add(4);
                    add(5);
                    add(6);
                }});
                add(new ArrayList<Integer>() {{
                    add(7);
                    add(8);
                    add(9);
                }});
                add(new ArrayList<Integer>() {{
                    add(8);
                    add(9);
                }});

            }
        };
        System.out.println(selected_car(in));
    }
}
