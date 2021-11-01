package baidu;

public class Solution {

    public static String getAns(String number) {
        int n = number.length();
        char[] cs = number.toCharArray();
        char[] res = new char[n];
        boolean preMark = false;
        for (int i = 0; i < n; i++) {
            if (preMark) {
                res[i] = '3';
            } else {
                char c = cs[i];
                if (c > '3') {
                    res[i] = '3';
                    preMark = true;
                } else if (c == '1' || c == '2' || c == '3') {
                    res[i] = c;
                } else {
                    // c == '0'
                    int index = i - 1;
                    while (index >= 0 && res[index] == '1') {
                        // 往前找 '2' 或 '3'
                        index--;
                    }
                    if (index == -1) {
                        // 没找到
                        res[++index] = '0';
                    } else {
                        res[index] -= 1;
                    }
                    for (int j = index + 1; j <= i; j++) {
                        res[j] = '3';
                    }
                    preMark = true;
                }
            }
        }
        int index = res[0] == '0' ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        while (index < n) {
            sb.append(res[index++]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getAns("2157941234").equals("2133333333"));
        System.out.println(getAns("42154").equals("33333"));
        System.out.println(getAns("1254751").equals("1233333"));
        System.out.println(getAns("12121312").equals("12121312"));
        System.out.println(getAns("102").equals("33"));
        System.out.println(getAns("1110").equals("333"));
        System.out.println(getAns("12341111").equals("12333333"));
        System.out.println(getAns("1231230123").equals("1231223333"));

        for (int i = 1; i <= 13; i++) {
            System.out.println(getAns(String.valueOf(i)));
        }
    }
}
