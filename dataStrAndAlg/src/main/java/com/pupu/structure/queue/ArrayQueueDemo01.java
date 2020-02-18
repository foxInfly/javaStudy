package com.pupu.structure.queue;

import java.util.Scanner;

/**数组模拟队列：先进先出的有序列表
 * @author : lipu
 * @since : 2020-02-18 21:33
 */
public class ArrayQueueDemo01 {
    public static void main(String[] args) {
        //1.创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接受客户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop){
            System.out.println("----------------------------------");
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取数据");
            System.out.println("h(head)：查看队列头的数据");
            System.out.println("----------------------------------");
            System.out.print("请输入您的选择：");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                   loop=false;
                    break;
                case 'a':
                    System.out.print("请输入您要加入的数据：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        System.out.println("您取出的数据为："+arrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("您查看的数据为："+arrayQueue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                    break;
            }
        }
        System.out.println("程序退出。。。");
    }
}

//使用数组模拟队列--编写一个ArrayQueue类
class ArrayQueue{
    private int maxSize;//数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//存放数据的数组，模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1;//指向队列尾，指向队列尾的数据（就是队列最后一个数据）
    }

    //判断队列是否满,true满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空,true空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满，不能加入数据~~");
            return;
        }
        rear++;
        arr[rear] = n;
        System.out.println("添加数据"+n+"到队列成功");
    }

    //取队列中的数据
    public int getQueue(){
        if(isEmpty()){
            //跑出异常,会终止代码return
            throw new RuntimeException("队列空，不能从队列取出数据~~");
        }
        front++;
        System.out.println("从队列取数据："+arr[front]+"成功");
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列数据为空");
            return;
        }
        //遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据，但不取出来
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空~~");
        }
        //遍历
        return arr[front+1];
    }
}

