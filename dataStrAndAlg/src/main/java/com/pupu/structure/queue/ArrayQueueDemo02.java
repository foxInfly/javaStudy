package com.pupu.structure.queue;

import java.util.Scanner;

/**数组模拟队列优化，环形：先进先出的有序列表
 * @author : lipu
 * @since : 2020-02-18 21:33
 */
public class ArrayQueueDemo02 {
    public static void main(String[] args) {
        //1.创建一个队列
        CircleQueue arrayQueue = new CircleQueue(4);
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
class CircleQueue{
    private int maxSize;//数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//存放数据的数组，模拟队列

    //创建队列的构造器
    public CircleQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;//指向队列头部，分析出front是指向队列头第一个位置
        rear = 0;//指向队列尾，指向队列尾的数据的后一个数据
    }

    //判断队列是否满,true满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
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
        //直接将数据加入
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
        System.out.println("添加数据"+n+"到队列成功");
    }

    //取队列中的数据
    public int getQueue(){
        if(isEmpty()){
            //跑出异常,会终止代码return
            throw new RuntimeException("队列空，不能从队列取出数据~~");
        }
        //需要分析出front是指向队里的第一个元素
        //1.先把front对应的值保留到一个历史变量
        //2.将front后移,考虑取模
        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        System.out.println("从队列取数据："+value+"成功");
        return value;
    }

    //显示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列数据为空~~");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    //显示队列的头数据，但不取出来
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空~~");
        }
        //遍历
        return arr[front];
    }

    public int size(){
        return (rear+maxSize - front) % maxSize;
    }
}

