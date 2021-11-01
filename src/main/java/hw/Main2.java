package hw;

import java.util.*;

public class Main2 {

    static class Klass {
        Set<String> subClass = new HashSet<>();
        List<String> instances = new ArrayList<>();
    }

    public static String getAnswer(String query, Map<String, Klass> map) {
        Queue<Klass> q = new LinkedList<>();
        q.add(map.get(query));
        ArrayList<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            Klass c = q.poll();
            res.addAll(c.instances);
            for (String sub : c.subClass) {
                q.add(map.get(sub));
            }
        }
        res.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (String ins : res) {
            sb.append(ins).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Klass> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String sub = sc.next();
            String relation = sc.next();
            String proto = sc.next();
            if (!map.containsKey(proto)) {
                map.put(proto, new Klass());
            }
            if (relation.equals("subClassOf")) {
                if (!map.containsKey(sub)) {
                    map.put(sub, new Klass());
                }
                map.get(proto).subClass.add(sub);
            } else if (relation.equals("instanceOf")) {
                map.get(proto).instances.add(sub);
            }
        }
        String query = sc.next();
        if (!map.containsKey(query)) {
            System.out.println("empty");
        } else {
            System.out.println(getAnswer(query, map));
        }
    }
}
