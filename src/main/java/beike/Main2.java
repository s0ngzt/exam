package beike;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main2 {

    public static int getAns(String quotes) {
        char[] cs = quotes.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char c : cs) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size() / 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String quotes = br.readLine();
            System.out.println(getAns(quotes));
        }
    }
}
