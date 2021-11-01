package unionpay;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().getRes(1, 4));
    }

    public int getRes(int n, int m) {
        ArrayList<String> rpn = new ArrayList<>();
        rpn.add(String.valueOf(n));
        boolean[] status = new boolean[1];
        dfs(n, m, rpn, 0, status);
        return status[0] ? 1 : 0;
    }

    public void dfs(int n, int m, ArrayList<String> temp, int index, boolean[] status) {
        if (status[0]) return;
        if (index == 3) {
            if (evalRPN(temp) == m) {
                status[0] = true;
                return;
            }
        }

        String[] ops = {"+", "-", "*", "/"};
        for (int i = 0; i < 4; i++) {
            temp.add(String.valueOf(n));
            temp.add(ops[i]);
            dfs(n, m, temp, index + 1, status);
            temp.remove(temp.size() - 1);
            temp.remove(temp.size() - 1);
        }
    }

    public int evalRPN(ArrayList<String> tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
