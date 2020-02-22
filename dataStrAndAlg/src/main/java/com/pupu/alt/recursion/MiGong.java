package com.pupu.alt.recursion;

/**迷宫问题,最短路径
 * @author : lipu
 * @since : 2020-02-22 15:29
 */
public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫，地图
        int[][] map = new int[8][7];
        //1表示墙，上下全部为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //1表示墙，左右全部为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[4][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;
        map[5][3] = 1;
        map[4][4] = 1;
        map[5][4] = 1;

        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        //使用递归回溯给小球找路
        setWay(map,1,1);
        //输出小球走过的地图，
        System.out.println("小球走过的如下：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**使用递归来给小球找路
     * 当节点为0表示可以走；2是对的路，3表示探测过，但是走不通
     * 走迷宫的策略 下->右->上->左，如果该点走不通再回溯；改成上->右->下->左，可最短
     * @author lipu
     * @since  2020/2/22 15:56
     * @param  map 地图
     * @param  i 从哪个行位置开始找
     * @param  j 从哪个列位置开始找
     * @return 找到路返回true，否则返回false
    */
    public static boolean setWay(int[][] map, int i, int j){
        if (map[6][5] == 2) {//通路已经找到
            return true;
        }else {
            if (map[i][j] == 0) {//如果当前这个点还没有走过
                //按照策略下->右->上->左 走
                map[i][j] = 2;//假定该点是可以走通话。
                if (setWay(map,i-1,j)) {//向上走
                    return true;
                }else  if (setWay(map,i,j+1)) {//向右走
                    return true;
                }else  if (setWay(map,i+1,j)) {//向上走
//                    map[i-1][j]=3;
                    return true;
                } if (setWay(map,i,j-1)) {//向左走
//                    map[i][j-1]=3;
                    return true;
                }else {
                    map[i][j] = 3;//该点走不通，是死路。
                    return false;
                }
            }else {//如果map[i][j]不是0，可能是1、2、3,
                return false;
            }
        }
    }
}
