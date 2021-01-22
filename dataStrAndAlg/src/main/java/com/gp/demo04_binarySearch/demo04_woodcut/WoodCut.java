package com.gp.demo04_binarySearch.demo04_woodcut;


/**
 * 切木头：
 *    有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。当然，我们希望得到的小段越长越好，你需要计算能够得到的小段木头的最大长度。
 *
 * @author lp
 * @since 2021/1/22 17:10
 **/
public class WoodCut {


    /**
     *
     * @param L 每块木头长度的集合
     * @param k 需要得到的小段木头最少数
     * @return 每块木头的最大长度
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }

        int start = 1;
        int end = getMax(L);
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            int pieces = getPieces(L, mid);
            System.out.println("pieces: "+ pieces);
            if (pieces >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println("start:" + start + " end:" + end);
        if (getPieces(L, end) >= k) {
            return end;
        }
        if (getPieces(L, start) >= k) {
            return start;
        }
        return 0;
    }

    /**
     *  获取 长度最大的那块木头
     * @param L 每块木头长度的集合
     * @return 长度最大的那块木头的下标（索引）
     */
    public int getMax(int[] L) {
        int max = L[0];
        for (int i = 1; i < L.length; i++) {
            if (max < L[i]) {
                max = L[i];
            }
        }
        return max;
    }

    /**
     *
     * @param L 每块木头长度的集合
     * @param woodLength  mid 的长度
     * @return 每块木头的长度
     */
    public int getPieces(int[] L, int woodLength) {
        int pieces = 0;
        for (int wood : L) {
            pieces += wood / woodLength;
        }
        return pieces;
    }

    public static void main(String[] args) {
        int[] L = {232, 124, 456};
        System.out.println(new WoodCut().woodCut(L, 7));
    }
}
