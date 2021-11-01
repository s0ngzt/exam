package jxjk;

public class Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 牛牛品尝的美食编号
     *
     * @param k             int整型 第几份美味程度大于m的美食
     * @param m             int整型 美味程度比较边界
     * @param deliciousness int整型一维数组 美味程度
     * @return int整型
     */
    public int getIndex(int k, int m, int[] deliciousness) {
        int n = deliciousness.length;
        if (k > n) return -1;
        int i = n - 1;
        while (i > 0) {
            if (deliciousness[i] >= m) {
                k--;
            }
            if (k == 0) return i;
            i--;
        }
        return -1;
    }
}
