package com.pupu.alt.recursion;

/**8皇后问题
 * @author : lipu
 * @since : 2020-02-22 17:32
 */
public class Queen8 {
    int max = 8;//皇后的数量
    int[] array = new int[max];//保存红皇后位置的结果
    int count = 0;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
    }

    //放置皇后
    private void check(int n){
        if (n == max) {//n=8，就是
            count++;
            System.out.print("第 "+count+"的顺序为：");
            print();
            return;
        }
        //一次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后放到该行的第一列
            array[n] = i;
            //放置第n个皇后到i列时，是否冲突
            if (judge(n)){//不冲突
                check(n+1);
            }
            //冲突，就继续执行array[n] = i;将第n个皇后放到本行后移的第一个位置
        }
    }

    /**检查当我们放置第n个皇后，就去检测该皇后时候和前面已经摆放的皇后冲突
     * @author lipu
     * @since  2020/2/22 17:38
     * @param  n 表示第几个皇后
     * @return
    */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            /*
            * 1.array[i] == array[n]表示半段第n个皇后是否和前面的n-1个皇后在同一列
            * 1.Math.abs(n-i) == Math.abs(array[n]-array[i])表示半段第n个皇后是否和前面的n-1个皇后在同一斜线
            */
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])) {
                return false;
            }
        }
        return true;
    }

    //输出皇后拜访的位置
    private void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
