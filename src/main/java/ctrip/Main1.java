package ctrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] strs = line.split(" ");
            if ("cd".equals(strs[0])) {
                if ("..".equals(strs[1])) {
                    if (!list.isEmpty()) {
                        list.pollLast();
                    }
                } else {
                    list.offerLast("\\" + strs[1]);
                }
            } else if ("pwd".equals(strs[0])) {
                if (list.isEmpty()) {
                    System.out.println("\\");
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (String s : list) {
                        sb.append(s);
                    }
                    System.out.println(sb);
                }
            }
        }
    }
}
