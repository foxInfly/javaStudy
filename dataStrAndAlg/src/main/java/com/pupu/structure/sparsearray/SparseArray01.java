package com.pupu.structure.sparsearray;

/**稀疏数组
 * @author : lipu
 * @since : 2020-02-18 20:16
 */
public class SparseArray01 {

    public static void main(String[] args) {
        //1.创建一个原始的二维数组11*11；0代表没棋子，1代表黑子，2代表蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;

        //2.输出原始的二维数组
        System.out.println("原始的二维数组为：");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t",data);//%d是十进制输出，\t一个tab制表符
            }
            System.out.println();
        }
        //3.将二维数组转为稀疏数组
        //3.1获取非零的个数
        int sum =0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] !=0) {
                    sum++;
                }
            }
        }
        System.out.println("非零的个数为："+sum);
        //3.2创建对应的稀疏数组并赋值第一行
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //3.3将非零值存到非零数组
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] !=0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //4.输出新的稀疏数组
        System.out.println("新的稀疏数组为：");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);//%d是十进制输出，\t一个tab制表符
            }
            System.out.println();
        }

        //5.将稀疏数组还原成二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }

        //6输出还原后的二维数组
        System.out.println("还原后的二维数组为：");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);//%d是十进制输出，\t一个tab制表符
            }
            System.out.println();
        }

    }
}
