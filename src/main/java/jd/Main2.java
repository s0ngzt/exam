package jd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

    static class Service {
        boolean running = false;
        HashSet<Integer> dependencies = new HashSet<>();
        HashSet<Integer> supports = new HashSet<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int q = Integer.parseInt(params[1]);
        List<Service> services = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            services.set(i, new Service());
        }
        for (int i = 0; i < n; i++) {
            String[] numbers = br.readLine().split(" ");
            int c = Integer.parseInt(numbers[0]);
            for (int j = 1; j <= c; j++) {
                int cur = Integer.parseInt(numbers[j]);
                services.get(i).dependencies.add(cur - 1);
                services.get(cur - 1).supports.add(i);
            }
        }
        // query
        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");
            int x = Integer.parseInt(query[0]);
            int y = Integer.parseInt(query[1]);
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(y - 1);
            if (x == 0) {
                // 关闭
                while (!queue.isEmpty()) {
                    int c = queue.poll();
                    services.get(c).running = false;
                    for (int s : services.get(c).supports) {
                        if (services.get(s).running) {
                            queue.add(s);
                        }
                    }
                }
            } else {
                // 开启
                while (!queue.isEmpty()) {
                    int c = queue.poll();
                    services.get(c).running = true;
                    for (int s : services.get(c).dependencies) {
                        if (!services.get(s).running) {
                            queue.add(s);
                        }
                    }
                }
            }
            int ret = 0;
            for (Service service : services) {
                if (service.running) {
                    ret++;
                }
            }
            System.out.println(ret);
        }
    }
}
